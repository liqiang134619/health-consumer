package com.dycn.airportconsumer.faceplate.sream.handler;

import com.dycn.airportconsumer.faceplate.AvroUtil;
import com.dycn.airportconsumer.faceplate.Http2PullAccessRecord;
import com.dycn.airportconsumer.faceplate.IRecordsEventManager;
import com.dycn.airportconsumer.faceplate.avro.*;
import io.netty.buffer.ByteBuf;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 过人日志可执行类
 * @author 123
 */
public class AccessRecordStreamHandler extends StreamRecordHandler {
    private static final Logger mLogger = LoggerFactory.getLogger(AccessRecordStreamHandler.class);
    public static boolean isFetchApi = false;
    public static volatile String schemaString;

    public AccessRecordStreamHandler(IRecordsEventManager.IRecordEventHandler accessRecordEventHandler, String host, BlockingQueue<ByteBuf> recordQueue) {
        super(accessRecordEventHandler, host, recordQueue);
    }

    @Override
    protected SpecificRecord parseRecord(byte[] data) throws Exception{
        SpecificRecord accessRecordResult;
        if(Http2PullAccessRecord.mApiVersion.equals("1.0")){
            if(!isFetchApi) {
                accessRecordResult = getAccessRecordV1(data);
            }else{
                accessRecordResult = getAccessRecordFetch(data);
            }
        }else{//2.0
            accessRecordResult = getAccessRecordV2(data);
        }
        return accessRecordResult;
    }

    public AccessRecordResultV2 getAccessRecordV2(byte[] data) throws Exception {
        AccessRecordResultV2 accessRecordResult = new AccessRecordResultV2();
        AccessRecordV2 record = new AccessRecordV2();
        List<GenericRecord> newRecords = AvroUtil.decodeCompatibility(AccessRecordResultV2.getClassSchema().toString(), accessRecordResult.getSchema(), data);
        mLogger.info("getAccessRecord newRecords {} ", newRecords == null ? null : newRecords.hashCode());

        if (newRecords != null && newRecords.size() > 0) {
            GenericRecord genericRecord = (GenericRecord) newRecords.get(0).get("accessRecord");
            record.setDevId(genericRecord.get("devId").toString());
            record.setTimestamp(genericRecord.get("timestamp").toString());
            record.setPersonId(getString(genericRecord.get("personId")));
            record.setFeatureIndex(getString(genericRecord.get("featureIndex")));
            record.setFeatureMd5(getString(genericRecord.get("featureMd5")));
            record.setSimilarity(getString(genericRecord.get("similarity")));
            record.setImagesList((List<ImageStructV2>) genericRecord.get("imagesList"));
            record.setFeaturesList((List<FaceFeatureStructV2>) genericRecord.get("featuresList"));
            record.setCardNumber(getString(genericRecord.get("cardNumber")));
            record.setPassed(getBoolean(genericRecord.get("passed")));
            record.setPassword(getString(genericRecord.get("password")));
            record.setVerificationType(getString(genericRecord.get("verificationType")));
            record.setQRCode(getString(genericRecord.get("QRCode")));
            record.setMeta(genericRecord.get("meta").toString());
            mLogger.info(record.getMeta());

//            mLogger.info(String.format("Received Record is %s", genericRecord.toString()));
            mLogger.info(String.format("timestamp: %s", genericRecord.get("timestamp").toString()));
            String checkpoint = newRecords.get(0).get("checkpoint").toString();
//            mLogger.info(String.format("checkpoint: %s", checkpoint));
            accessRecordResult.setCheckpoint(checkpoint);
            accessRecordResult.setAccessRecord(record);
        }
        return accessRecordResult;
    }

    private static String getString(Object o) {
        return o == null ? null : o.toString();
    }

    private static Boolean getBoolean(Object o) {

        return Boolean.valueOf(o == null ? "false" : o.toString());
    }


    /**
     * 过人日志处理接口，解析数据
     */
    public AccessRecordResult getAccessRecordV1(byte[] data) throws Exception {
        AccessRecordResult accessRecordResult = new AccessRecordResult();
        AccessRecord record = new AccessRecord();
        List<GenericRecord> newRecords = AvroUtil.decode(accessRecordResult.getSchema(), data);
//        mLogger.info("getAccessRecord newRecords {} ", newRecords == null ? null : newRecords.hashCode());

        if (newRecords != null && newRecords.size() > 0) {
            GenericRecord genericRecord = (GenericRecord) newRecords.get(0).get("accessRecord");
            record.put(0, genericRecord.get("devId"));
            record.put(1, genericRecord.get("timestamp"));
            record.put(2, genericRecord.get("personId"));
            record.put(3, genericRecord.get("featureIndex"));
            record.put(4, genericRecord.get("featureMd5"));
            record.put(5, genericRecord.get("similarity"));
            record.put(6, genericRecord.get("imagesList"));
            record.put(7, genericRecord.get("featuresList"));
            record.put(8, genericRecord.get("cardNumber"));
            record.put(9, genericRecord.get("passed"));
            mLogger.info(String.format("Received Record is %s", genericRecord.toString()));
            String checkpoint = newRecords.get(0).get("checkpoint").toString();
            mLogger.info(String.format("checkpoint: %s", checkpoint));
            accessRecordResult.setCheckpoint(checkpoint);
            accessRecordResult.setAccessRecord(record);
        }
        return accessRecordResult;
    }


    /**
     * 过人日志处理接口，解析数据
     */
    public NewAccessRecordResult getAccessRecordFetch(byte[] data) throws Exception {
        NewAccessRecordResult accessRecordResult = new NewAccessRecordResult();
        NewAccessRecord record = new NewAccessRecord();
        List<GenericRecord> newRecords = AvroUtil.decode(accessRecordResult.getSchema(), data);
        mLogger.info("getAccessRecord newRecords {} ", newRecords == null ? null : newRecords.hashCode());

        if (newRecords != null && newRecords.size() > 0) {
            GenericRecord genericRecord = (GenericRecord) newRecords.get(0).get("accessRecord");
            record.put(0, genericRecord.get("devId"));
            record.put(1, genericRecord.get("timestamp"));
            record.put(2, genericRecord.get("personId"));
            record.put(3, genericRecord.get("featureIndex"));
            record.put(4, genericRecord.get("featureMd5"));
            record.put(5, genericRecord.get("similarity"));
            record.put(6, genericRecord.get("imagesList"));
            record.put(7, genericRecord.get("featuresList"));
            record.put(8, genericRecord.get("cardNumber"));
            record.put(9, genericRecord.get("passed"));
            record.put(10, genericRecord.get("password"));
            record.put(11, genericRecord.get("verificationType"));
            record.put(12, genericRecord.get("QRCode"));
            mLogger.info(String.format("Received Record is %s", genericRecord.toString()));
            String checkpoint = newRecords.get(0).get("checkpoint").toString();
            mLogger.info(String.format("checkpoint: %s", checkpoint));
            accessRecordResult.setCheckpoint(checkpoint);
            accessRecordResult.setAccessRecord(record);
        }
        return accessRecordResult;
    }
}
