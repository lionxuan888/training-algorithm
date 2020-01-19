package twenty.Jan;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by logan on 2020/1/19.
 */
public class TestSync {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
             Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            countDownLatch.countDown();
        };

        Runnable runnable2 = () -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
            countDownLatch.countDown();
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        countDownLatch.await();
        System.out.println("全部执行完成!");
        Uninterruptibles.sleepUninterruptibly(100000, TimeUnit.SECONDS);
    }
}
