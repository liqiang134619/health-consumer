package com.dycn.airportconsumer.faceplate.sream;

import java.util.concurrent.*;

/**
 * @author Liq
 * @date 2021/2/2
 */
public class SyncFuture<T> implements Future<T> {



    private CountDownLatch latch = new CountDownLatch(1);


    private T response;

    private long beginTime = System.currentTimeMillis();


    public SyncFuture() {
    }



    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        if (response != null) {
            return true;
        }
        return false;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
        latch.await();
        return this.response;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (latch.await(timeout, unit)) {
            return this.response;
        }
        return null;
    }

    // 用于设置响应结果，并且做countDown操作，通知请求线程
    public void setResponse(T response) {
        this.response = response;
        //将count值减1
        latch.countDown();
    }

    public long getBeginTime() {
        return beginTime;
    }
}
