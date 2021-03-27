package com.dycn.airportconsumer.mq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dycn.airportconsumer.common.Base64Util;
import com.dycn.airportconsumer.entity.AirportPassway;
import com.dycn.airportconsumer.entity.AirportWorker;
import com.dycn.airportconsumer.faceplate.Http2DeviceController;
import com.dycn.airportconsumer.faceplate.HttpConnection;
import com.dycn.airportconsumer.faceplate.HttpConnectionManager;
import com.dycn.airportconsumer.faceplate.avro.OperationType;
import com.dycn.airportconsumer.faceplate.common.HttpParameters;
import com.dycn.airportconsumer.service.IAirportPasswayService;
import com.dycn.airportconsumer.service.IAirportWorkerService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liq
 * @date 2021/3/26
 */
@Component
@Slf4j
public class RabbitmqConfig {



    @Autowired
    IAirportPasswayService passwayService;


    @Autowired
    IAirportWorkerService workerService;

    /**
     * 消费者 执行下发计划
     * @param obj
     * @param channel
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues={"person_queue_01"})
    public void processPassPerson(String obj, Channel channel, Message message) throws IOException {
        try {
            log.info("receiver:topic.message:{}",obj);

            // 处理逻辑


            List<AirportPassway> list = passwayService.listOnline();
            List<String> ipLists = list.stream().map(AirportPassway::getIp).collect(Collectors.toList());


            AirportWorker worker = workerService.getOne(new QueryWrapper<AirportWorker>().eq("id_card", obj));

            String idCard = worker.getIdCard();
            String name = worker.getName();


            ipLists.forEach(ip -> {
                //log.info("test为0执行插入或更新人像：{}:{}", idCard, ip);
                try {
                    HttpConnection httpConnection = HttpConnectionManager.getInstance().connectServer(ip, 8443, 10);
                    if (httpConnection == null || !httpConnection.isChannelActive()) {
                        return;
                    }
                    Http2DeviceController http2DeviceController = new Http2DeviceController(httpConnection);
                    // 后续可能会升级图片服务器
                    String singlePerson = http2DeviceController.getSinglePerson(idCard, HttpParameters.USERNAME, HttpParameters.PASSWORD);

                    if (StringUtils.isNotEmpty(singlePerson)) {
                        InputStream inputStream = Base64Util.httpImageToInputStream(worker.getImgUrl());
                        http2DeviceController.updateRepoSettings(HttpParameters.PERSONS, HttpParameters.USERNAME, HttpParameters.PASSWORD, 123, OperationType.MODIFY, inputStream, idCard, name);
                    } else {
                        InputStream inputStream = Base64Util.httpImageToInputStream(worker.getImgUrl());
                        http2DeviceController.updateRepoSettings(HttpParameters.PERSONS, HttpParameters.USERNAME, HttpParameters.PASSWORD, 123, OperationType.ADD, inputStream, idCard, name);
                    }


                } catch (Exception e) {
                    log.error("【==>连接面板机服务器失败:{},{},{}】", e.getCause(), e.getStackTrace(), ip);

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("【===> ack 确认】");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        }
    }

}
