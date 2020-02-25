package twenty.Feb;

/**
 * 生产者消费者问题
 * 该问题的资料来源:
 * 1. 现代操作系统
 * 2. https://en.wikipedia.org/wiki/Semaphore_(programming)
 *    https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem
 * Created by logan on 2020/2/25.
 */
public class TestProducerConsumer {

    // 生产者消费者问题, 也称之为有界缓冲队列问题, 接下来按照常规思考方式解决
    // 首先能想到如下伪代码,使用sleep和wait唤醒机制
    // produce :
    //         while(true) {
    //             if(count == N) sleep;
    //              insertItem();
    //              count ++;
    //              if (count==1) notify;
    //          }
    // consume :
    //         while(true) {
    //             if(count == 0) sleep;
    //              pollItem();
    //              count --;
    //              if (count==N-1) notify;
    //          }
    // 这种方式虽然漏洞百出, 比如count变量不是原子的, 但是思路是常规想法,
    // 但是他的主要问题是 the problem of lost wakeup calls  就是唤醒丢失问题
    // 假如 consume 端, 当count=0, 在执行判断count== 0之后, 由于线程调度发生了切换执行produce, produce端产生了一个item,
    // 然后执行到notify代码之后, 由于consume还没有sleep, 这时候wak就丢失了.
    //

    // 下面使用信号量的伪代码, 解决wake丢失的问题,
    // 首先定义两个信号量, 一个是empty代表当前队列的空槽有多少, 一个是full代表当前队列使用了多少槽
    // 由于操作系统信号量的底层是cas也就是原子操作,down和up操作是原子的
    // produce :
    //         while(true) {
    //              down(empty);  // 减少一个empty槽
    //              insertItem();
    //              up(full);
    //          }
    // consume :
    //         while(true) {
    //              down(full);  // 减少一个full槽
    //              pollItem();
    //              up(empty);
    //          }
    // 这种写法,大体结构没有问题,但是仔细分析还是有问题的, 直接看wiki里的解释
    //    The solution above works fine when there is only one producer and consumer. With multiple producers sharing the same memory space for the item buffer, or multiple consumers sharing the same memory space, this solution contains a serious race condition that could result in two or more processes reading or writing into the same slot at the same time. To understand how this is possible, imagine how the procedure putItemIntoBuffer() can be implemented. It could contain two actions, one determining the next available slot and the other writing into it. If the procedure can be executed concurrently by multiple producers, then the following scenario is possible:
    //
    //    1.Two producers decrement emptyCount
    //    2.One of the producers determines the next empty slot in the buffer
    //    3.Second producer determines the next empty slot and gets the same result as the first producer
    //    4.Both producers write into the same slot

    // 这个wiki里也指出了互斥锁和信号量的区别, ownership的概念
    //    It is important to note here that though mutex seems to work
    //    as a semaphore with value of 1 (binary semaphore),
    //    but there is difference in the fact that mutex has ownership concept.
    //    Ownership means that mutex can only be "incremented" back (set to 1)
    //    by the same process that "decremented" it (set to 0),
    //    and all other tasks wait until mutex is available
    //    for decrement (effectively meaning that resource is available),
    //    which ensures mutual exclusivity and avoids deadlock

    //

}
