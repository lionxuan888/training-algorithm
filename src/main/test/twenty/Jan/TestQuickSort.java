package twenty.Jan;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;
import org.junit.Test;

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
        int size = aa.length;
        System.out.println("数组大小:" + size);
        int privoit = size/2;
        System.out.println("数组基准位置数据:" + a[privoit]);
        for (int i = 0; i < aa.length; i++) {
            int data = aa[i];
        }
    }
}
