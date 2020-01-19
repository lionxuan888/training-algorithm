package twenty.Jan;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 快排算法
 * Created by logan on 2020/1/17.
 */
public class TestQuickSort {

    @Test
    public void quickSort() {
        int a[] = new int[]{7, 8, 30, 6, 5, 9, 10, 1, 3};

        int size = a.length;
        System.out.println("数组大小:" + size);

        int privoit = size/2;
        System.out.println("数组基准位置数据:" + a[privoit]);


    }

    public void sort(int[] aa) {

    }

    @Test
    public void testTreeMap() throws Exception {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(5, 1);
        treeMap.put(4, 2);
        treeMap.put(3, 3);
        treeMap.put(2, 4);
        treeMap.put(2, 5);
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println("key:=" + entry.getKey());
        }
    }

    private static ReentrantLock lock = new ReentrantLock(true);
    public static void fairLock(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()  + "正在持有锁");
            Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
        }finally {
//            System.out.println(Thread.currentThread().getName()  + "释放了锁");
            lock.unlock();
        }
    }

    public static void fairLockFirst(){
        try {
            lock.lock();
            Uninterruptibles.sleepUninterruptibly(6000, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName()  + "正在持有锁");
        }finally {
            System.out.println(Thread.currentThread().getName()  + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairLock();
        };
        Runnable runnable2 = () -> {
            System.out.println("Thread启动");
            fairLockFirst();
        };
        new Thread(runnable2).start();
        for(int i = 0;i < 2; i++){
            Thread thread = new Thread(runnable);
            thread.start();
            Uninterruptibles.sleepUninterruptibly(6000, TimeUnit.MILLISECONDS);
        }
        Uninterruptibles.sleepUninterruptibly(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }

}
