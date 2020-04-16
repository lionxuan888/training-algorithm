package twenty.Jan;

import com.google.common.collect.*;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by logan on 2020/1/15.
 */
public class TestSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        List list = Lists.newArrayList();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry<Integer, Integer> next = iterator.next();
        }
        return null;
    }

    @Test
    public void testLock() throws Exception {
        final ReentrantLock reentrantLock = new ReentrantLock();
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantLock.tryLock(3, TimeUnit.SECONDS);
                    System.out.println("threadA 获取到锁 start executing");
                    Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.SECONDS);
                    System.out.println("threadA 执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                try {
                    reentrantLock.tryLock(1001, TimeUnit.SECONDS);
                    System.out.println("threadB 获取到锁 start executing");
                    Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
                    System.out.println("threadB 执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        threadA.start();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.SECONDS);
        threadB.start();
        Uninterruptibles.sleepUninterruptibly(86400, TimeUnit.SECONDS);

    }
}
