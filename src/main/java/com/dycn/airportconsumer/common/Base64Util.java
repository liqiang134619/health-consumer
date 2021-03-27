package com.dycn.airportconsumer.common;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Liq
 * @date 2020/8/19
 */
public class Base64Util {



    /**
     * 把网络文件转换为 Base64 编码的字符串
     */
    public static String httpImageToBase64String(String url) throws Exception {
        URL imgUrl = new URL(url);
        // 打开图片路径
        HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
        // 设置请求方式为GET
        conn.setRequestMethod("GET");
        // 设置超时响应时间为5秒
        conn.setConnectTimeout(10000);
        // 通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();

        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        // 对字节数组Base64编码
        return Base64.encodeBase64String(outStream.toByteArray());
    }

    /**
     * 把网络文件转换为 inputStream
     */
    public static InputStream httpImageToInputStream(String url) throws IOException {
        URL imgUrl = new URL(url);
        // 打开图片路径
        HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
        // 设置请求方式为GET
        conn.setRequestMethod("GET");
        // 设置超时响应时间为5秒
        conn.setConnectTimeout(3000);

        //每次读取的字符串长度，如果为-1，代表全部读取完毕

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        IOUtils.copy(conn.getInputStream(),outStream);
        return new ByteArrayInputStream(outStream.toByteArray());
    }




    public static InputStream inputStream2InputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outStream = null;
        try {
            outStream = new ByteArrayOutputStream();
            IOUtils.copy(inputStream,outStream);
            return new ByteArrayInputStream(outStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outStream);
            IOUtils.closeQuietly(inputStream);
        }
        return  null;
    }




    /**
     * 下载网络文件
     */
    public static void downloadImg(String url, File destFile) {
        if (StrUtil.isBlank(url)) {
            throw new NullPointerException("[url] is null!");
        }
        if (null == destFile) {
            throw new NullPointerException("[destFile] is null!");
        }
        InputStream inStream = null;
        try {
            URL imgUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10000);
            inStream = conn.getInputStream();

            byte[] buffer = new byte[2048];
            int len = 0;

            while( (len=inStream.read(buffer)) != -1 ){
               FileUtils.writeByteArrayToFile(destFile,buffer,0,len,true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inStream);

        }
    }
}
