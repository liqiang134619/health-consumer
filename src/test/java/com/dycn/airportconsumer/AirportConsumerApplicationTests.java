package com.dycn.airportconsumer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dycn.airportconsumer.common.Base64Util;
import com.dycn.airportconsumer.common.NoModel;
import com.dycn.airportconsumer.entity.AirportPassway;
import com.dycn.airportconsumer.entity.AirportWorker;
import com.dycn.airportconsumer.faceplate.Http2DeviceController;
import com.dycn.airportconsumer.faceplate.HttpConnection;
import com.dycn.airportconsumer.faceplate.HttpConnectionManager;
import com.dycn.airportconsumer.faceplate.avro.OperationType;
import com.dycn.airportconsumer.faceplate.common.HttpParameters;
import com.dycn.airportconsumer.service.IAirportWorkerService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class AirportConsumerApplicationTests {


    @Autowired
    private AmqpTemplate template;


    @Autowired
    IAirportWorkerService workerService;


    @Test
    public void test() {


        List<String> list = Lists.newArrayList("10.31.255.54");

//        List<NoModel> idCards = workerService.listfs();


        List<AirportWorker> one = workerService.list(new QueryWrapper<AirportWorker>().eq("account_id", "b5874f5f887e469eb49937db23ca2293"));
        NoModel noModel = new NoModel();
        noModel.setIdCard(one.get(0).getIdCard());
        noModel.setImgUrl(one.get(0).getImgUrl());
        noModel.setName(one.get(0).getName());
        List<NoModel> idCards = Collections.singletonList(noModel);


        log.info("idcard:{}",idCards.size());
        for (NoModel test1 : idCards) {
            log.info("【==============================================> 下发：{}】",test1.getIdCard());

            String idCard = test1.getIdCard();
            String name = test1.getName();

            try {
                HttpConnection httpConnection = HttpConnectionManager.getInstance().connectServer("10.31.255.27", 8443, 10);
                if (httpConnection == null || !httpConnection.isChannelActive()) {
                    return;
                }
                Http2DeviceController http2DeviceController = new Http2DeviceController(httpConnection);

                // 后续可能会升级图片服务器
                String singlePerson = http2DeviceController.getSinglePerson(idCard, HttpParameters.USERNAME, HttpParameters.PASSWORD);

                if (StringUtils.isNotEmpty(singlePerson)) {
                    InputStream inputStream = Base64Util.httpImageToInputStream(test1.getImgUrl());
                    http2DeviceController.updateRepoSettings(HttpParameters.PERSONS, HttpParameters.USERNAME, HttpParameters.PASSWORD, 123, OperationType.MODIFY, inputStream, idCard, name);
                } else {
                    InputStream inputStream = Base64Util.httpImageToInputStream(test1.getImgUrl());
                    http2DeviceController.updateRepoSettings(HttpParameters.PERSONS, HttpParameters.USERNAME, HttpParameters.PASSWORD, 123, OperationType.ADD, inputStream, idCard, name);
                }


            } catch (Exception e) {
                log.error("【==>连接面板机服务器失败:{},{},{}】", e.getCause(), e.getStackTrace(), "zz");

            }
        }


    }

}
