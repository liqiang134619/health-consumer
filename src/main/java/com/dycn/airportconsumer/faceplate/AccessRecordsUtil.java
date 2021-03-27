//package com.dycn.airportconsumer.faceplate;
//
//import com.dycn.airportconsumer.faceplate.avro.AccessRecordResult;
//import com.dycn.airportconsumer.faceplate.avro.AccessRecordResultV2;
//import com.dycn.airportconsumer.faceplate.avro.AccessRecordV2;
//import com.dycn.airportconsumer.faceplate.avro.NewAccessRecordResult;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.avro.specific.SpecificRecord;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//
///**
// * @author Liq
// * @date 2021/1/27
// */
//@Slf4j
//@Component
//public class AccessRecordsUtil implements ApplicationContextAware {
//
//
//    private static ApplicationContext applicationContext;
//
//
//
//    public static void saveAccessRecords(SpecificRecord accessRecordResult,String ip) {
//        if (accessRecordResult == null) {
//            log.error("save null access record to file");
//            return;
//        }
////        IAirportWorkerService workerService = getApplicationContext().getBean(IAirportWorkerService.class);
////        IAirportPassService passService = getApplicationContext().getBean(IAirportPassService.class);
////        IAirportPasswayService passwayService = getApplicationContext().getBean(IAirportPasswayService.class);
//
//        AccessRecordPublisher recordPublisher = getApplicationContext().getBean(AccessRecordPublisher.class);
//
//        String timestamp = getRecordTimeStamp(accessRecordResult);
//        String subDir = utc2Date(timestamp);
//        AccessRecordResultV2 accessRecordResultV2 = (AccessRecordResultV2) accessRecordResult;
//        AccessRecordV2 accessRecord = accessRecordResultV2.getAccessRecord();
//        Boolean passed = accessRecord.getPassed();
//        String cardNumber = accessRecord.getCardNumber();
//        if(passed) {
//            recordPublisher.asyncPublish(new AccessRecordEvent(cardNumber,ip));
//
////            AirportWorker one = workerService.getOne(new QueryWrapper<AirportWorker>().eq("id_card", cardNumber));
////            AirportPass airportPass = new AirportPass();
////            airportPass.setIdCard(one.getIdCard())
////                    .setInTime(LocalDateTime.now())
////                    .setName(one.getName())
////                    .setOrgName(one.getDept())
////                    .setTemperature(one.getTemperature())
////                    .setAreaId(passwayService.getArea(ip))
////                    .setEntranceModel(0);
////            passService.save(airportPass);
//
//
//
//        }
//
//    }
//
//
//    private static String getRecordTimeStamp(SpecificRecord record){
//        if(record instanceof AccessRecordResult){
//            return ((AccessRecordResult)record).getAccessRecord().getTimestamp();
//        }else if(record instanceof AccessRecordResultV2){
//            return ((AccessRecordResultV2)record).getAccessRecord().getTimestamp();
//        }else if (record instanceof NewAccessRecordResult){
//            return ((NewAccessRecordResult)record).getAccessRecord().getTimestamp();
//        }
//        return String.valueOf(System.currentTimeMillis());
//
//    }
//
//
//
//    /**
//     * utc时间转化为日期时间
//     *
//     * @param utc
//     * @return
//     */
//    public static String utc2Date(String utc) {
//
//        System.out.println(utc);
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = dateformat.format(Long.parseLong(utc));
//        return dateStr.toString();
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        if(AccessRecordsUtil.applicationContext == null) {
//            AccessRecordsUtil.applicationContext = applicationContext;
//        }
//    }
//
//    /**
//     * get applicationContext
//     * @return
//     */
//    public static ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//
//
//}
