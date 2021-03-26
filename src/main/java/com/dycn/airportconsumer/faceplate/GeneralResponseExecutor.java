package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.common.ResponseUtil;
import com.dycn.airportconsumer.common.Status;
import io.netty.channel.ChannelHandlerContext;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liq
 * @date 2021/1/23
 */

public class GeneralResponseExecutor {

    private static final Logger mLogger = LoggerFactory.getLogger(GeneralResponseExecutor.class);




    public static void handleResponse(ChannelHandlerContext ctx, int streamId, Schema schema, byte[] data) {
        List<GenericRecord> records = new ArrayList<>();
        if (data != null) {
            try {
                records = AvroUtil.decode(schema, data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mLogger.info("record length: " + (records == null ? 0 : records.size()));

        for (GenericRecord record : records) {
            mLogger.info("record: " + String.valueOf(record));
        }
    }

    public static void handleResponse(ChannelHandlerContext ctx, int streamId, Schema schema, byte[] data, HttpServletResponse response) {

        List<GenericRecord> records = new ArrayList<>();
        if (data != null) {
            try {
                records = AvroUtil.decode(schema, data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mLogger.info("record length: " + (records == null ? 0 : records.size()));

        GenericRecord genericRecord = records.get(0);
        mLogger.info("resp record ");
        ResponseUtil.renderJson(response, Status.NO_RESOURCE);
    }
}
