package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.avro.Person;
import io.netty.channel.ChannelHandlerContext;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liq
 * @date 2021/1/23
 */
public class PersonRepoExecutor {



    private static final Logger mLogger = LoggerFactory.getLogger(PersonRepoExecutor.class);
    private Http2ClientHandler mHttp2ClientHandler = null;




    public PersonRepoExecutor(Http2ClientHandler http2ClientHandler) {
        mHttp2ClientHandler = http2ClientHandler;
    }



    /**
     * 人像库查询接口，处理获取库的整体hash
     */
    public void handleSingPersonQuery(ChannelHandlerContext ctx, int streamId, byte[] data) throws IOException, SGHttp2Exceptions.NetworkException {
        List<GenericRecord> records = new ArrayList<>();
        if (data != null) {
            records = AvroUtil.decode(Person.getClassSchema(), data);
        }
        if (records != null && records.size() > 0) {
            Person person = (Person) records.get(0);
            mLogger.info(String.valueOf(person));
        } else {
             // mLogger.info("get person info is null means  everything is ok");
        }
    }

//
//    /**
//     * 人像库查询接口，处理获取库的整体hash
//     */
//    public void handleSingPersonQuery(ChannelHandlerContext ctx, int streamId, byte[] data,sysf) throws IOException, SGHttp2Exceptions.NetworkException {
//        List<GenericRecord> records = new ArrayList<>();
//        if (data != null) {
//            records = AvroUtil.decode(Person.getClassSchema(), data);
//        }
//        if (records != null && records.size() > 0) {
//            Person person = (Person) records.get(0);
//            mLogger.info(String.valueOf(person));
//        } else {
//            mLogger.info("get person info is null");
//        }
//    }

}
