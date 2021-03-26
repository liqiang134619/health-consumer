package com.dycn.airportconsumer.faceplate;

import com.dycn.airportconsumer.faceplate.common.HttpDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * 阻塞线程，异步在执行人像同步
 */
public class WaitRunnable implements Runnable {
    private static final Logger mLogger = LoggerFactory.getLogger(WaitRunnable.class);

    private CompletableFuture mCompletableFuture;
    private int mTimeout;
    private volatile boolean running = true;
    private volatile boolean exception = false;
    private volatile boolean deviceException = false;
    private volatile boolean methodException = false;
    private int time = 0;

    // 终止线程
    public void terminate() {
        running = false;
        mCompletableFuture.complete(HttpDefine.WAIT_SUCCESS);
    }

    // 需要抛出异常
    public void setException() {
        exception = true;
    }

    // 需要抛出异常
    public void setDeviceException() {
        deviceException = true;
    }

    // 需要抛出异常
    public void setMethodException() {
        methodException = true;
    }

    public WaitRunnable(CompletableFuture completableFuture, int mTimeout) {
        this.mCompletableFuture = completableFuture;
        this.mTimeout = mTimeout;
    }

    @Override
    public void run() {
        while (running && time < mTimeout) {
            try {
                Thread.sleep(100);
                time += 100;
            } catch (Exception e) {
                mLogger.error("WaitRunnable run exception: {}", e.getMessage());
            }
            // HTTP异常
            if (exception) {
                running = false;
                mCompletableFuture.complete(HttpDefine.WAIT_HTTP_EXCEPTION);
            }
            // 设备异常
            if (deviceException) {
                running = false;
                mCompletableFuture.complete(HttpDefine.WAIT_DEVICE_EXCEPTION);
            }

            if (methodException) {
                running = false;
                //TODO
                mCompletableFuture.complete(HttpDefine.WAIT_HTTP_EXCEPTION);
            }
        }

        mLogger.info("WaitRunnable 正常结束");
    }
}
