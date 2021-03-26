package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.avro.Operation;
import com.dycn.airportconsumer.faceplate.avro.Person;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class UpdateRepo {
    private static final Logger mLogger = LoggerFactory.getLogger(UpdateRepo.class);

    private Http2ClientHandler mHttp2ClientHandler;



    public void setRepoFull(List<Person> personList, boolean sorted) throws SGHttp2Exceptions.NetworkException, InterruptedException, SGHttp2Exceptions.OperationException {
        mLogger.info("setRepoFull, persons size: %s" + personList.size());
        if (mHttp2ClientHandler == null) {
            return;
        }
        if (personList == null) {
            throw new SGHttp2Exceptions.OperationException("传入参数有误！");
        }

    }

    public static Person createPerson(String Id, String imagePath, String cardNo, String name) throws NoSuchAlgorithmException {
        String otherInfo = cardNo + "_" + name;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(otherInfo.getBytes());
        byte[] otherInfoChecksumBytes = messageDigest.digest();
        String otherInfoChecksum = Base64.getEncoder().encodeToString(otherInfoChecksumBytes);

        Person personInfo = new Person();
        personInfo.setId(Id);
        personInfo.setDisplayInfo(name);
        ByteBuffer displayImage = convertFileToByteBuffer(imagePath);
        personInfo.setDisplayPic(displayImage);
        personInfo.setCardNo(cardNo);
        personInfo.setOtherInfoChecksum(otherInfoChecksum);
        return personInfo;
    }

    public static Person createPerson(String id, InputStream inputStream, String cardNo, String name) throws NoSuchAlgorithmException {
        String otherInfo = cardNo + "_" + name;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(otherInfo.getBytes());
        byte[] otherInfoChecksumBytes = messageDigest.digest();
        String otherInfoChecksum = Base64.getEncoder().encodeToString(otherInfoChecksumBytes);

        Person personInfo = new Person();
        personInfo.setId(id);
        personInfo.setDisplayInfo(name);
        ByteBuffer displayImage = convertInputStreamToByteBuffer(inputStream);
        personInfo.setDisplayPic(displayImage);
        personInfo.setCardNo(cardNo);
        personInfo.setOtherInfoChecksum(otherInfoChecksum);
        return personInfo;
    }


    public static ByteBuffer convertInputStreamToByteBuffer(InputStream inputStream) {
        if(inputStream == null) {
            return null;
        }
        ByteBuffer byteBuffer = null;
        try {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            byteBuffer = ByteBuffer.wrap(bytes);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return byteBuffer;
    }


    /**
     * 读入文件，转换成ByteBuffer
     *
     * @param filePath 文件路径
     */
    public static ByteBuffer convertFileToByteBuffer(String filePath) {
        ByteBuffer byteBuffer = null;
        try {
            File file = new File(filePath);
            byte[] bytesArray = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
            fileInputStream.close();

            byteBuffer = ByteBuffer.wrap(bytesArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteBuffer;
    }

    public static List<GenericRecord> buildOperationList(OperationType operationType, File[] fileArray, String cardNo) throws Exception {
        List<GenericRecord> OperationList = new ArrayList<>();
        long id = System.currentTimeMillis(); //personId, 这里使用时间戳，实际使用中应该使用唯一id
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].isFile()) {
                String name = fileArray[i].getName();
                String imagePath = String.valueOf(fileArray[i]);
                Operation operation = Operation.newBuilder()
                        .setOperationType(operationType)
                        .setPerson(createPerson(String.valueOf(id + i), imagePath, cardNo, name.substring(0, name.indexOf("."))))
                        .build();
                mLogger.info(String.format("person info: %s", imagePath));
                OperationList.add(operation);
            }

        }
        return OperationList;
    }


    public static List<GenericRecord> buildOperationList(OperationType operationType, List<String> list)  throws Exception{
        List<GenericRecord> operationList = new ArrayList<>();
        list.forEach(delModel -> {
            Operation operation = Operation.newBuilder()
                    .setOperationType(operationType)
                    .setPerson(createPerson(delModel))
                    .build();
            operationList.add(operation);
        });
        return operationList;
    }

    private static Person createPerson(String idCard){
        Person personInfo = new Person();
        personInfo.setId(idCard);
        return personInfo;
    }


    public static List<GenericRecord> buildOperationList(OperationType operationType, InputStream inputStream, String cardNo, String name) throws Exception {
        List<GenericRecord> operationList = new ArrayList<>();
        Operation operation = Operation.newBuilder()
                .setOperationType(operationType)
                .setPerson(createPerson(cardNo, inputStream, cardNo, name))
                .build();
        operationList.add(operation);
        return operationList;
    }
}
