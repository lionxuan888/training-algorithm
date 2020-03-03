package twenty.Feb;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by logan on 2020/3/2.
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {

        int N = 3;

        CyclicBarrier barrier = new CyclicBarrier(N + 1);

        for (int i = 0; i < 3; i++) {

            new Writer(barrier).start();
        }

        new Writer2(barrier).start();

    }

    static class Writer extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                //以睡眠来模拟线程需要预定写入数据操作
                System.out.println(" 线程 " + Thread.currentThread().getName() + " 写 入数 据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }



    static class Writer2 extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Writer2(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(8000);
                //以睡眠来模拟线程需要预定写入数据操作
                System.out.println(" 线程 " + Thread.currentThread().getName() + " 写 入数 据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }
}
