package twenty.Feb;

/**
 * 斐波那契数列是数学领域内一个非常经典的算法问题，斐波那契数列也叫黄金分割数列，也叫兔子数列
 * 1，1，2，3，5，8，13，21......
 * 斐波那契数列从第2项开始，每一项都等于前两项之和。
 * 斐波那契数列是由数学家 Leonardoda Fibonacci 以兔子繁殖为例子而提出的，所以也叫做“兔子数列”
 * Created by logan on 2020/2/6.
 */
public class TestFibonacci {


    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        int n = 7;
        int fibonacci = fibonacci2(n);
        System.out.printf("第%d项的值是:%d", n, fibonacci);
    }
}
