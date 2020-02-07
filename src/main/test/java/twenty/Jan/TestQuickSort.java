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
    public void quickSort( int[] array, int left, int right) {
        int mid = partition(array, left, right);
        quickSort(array, left, mid-1);
        quickSort(array, mid + 1, right);

    }

    /**
     * 关键解题点,
     * 快排核心算法,关键思想, 挖坑,
     * 顺序是首先左侧挖坑, 右侧哨兵走位right--, 右侧数据补坑(left++), 左侧哨兵走位left++, 左侧哨兵补位right--
     * 然后开始轮询
     * 1 . 双层while判断的编写模式,
     *     外层用于调节和循环判断,
     *     内层用于两侧哨兵走位
     * 2. 内层的判断条件很关键, left<right贯穿始终
     *    尤其是单独的if (left < right) 这个判断语句, 很巧妙, 利用了排他模式,
     *    走到这个语句有几个条件,
     *     1). 要么  left<right  , 则肯定 temp > arr[right]  (大于就要交换)
     *     2). 要么 left = right(不存在>, 因为是逐一递减的,先等于后大于)  , 则 temp = arr[right]
     *         这种情况应该就直接跳出了,
     *         巧妙在这里: 不需要进行left=right哨兵相遇的判断, 用排斥方法排除了....
     * @param aa
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
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
