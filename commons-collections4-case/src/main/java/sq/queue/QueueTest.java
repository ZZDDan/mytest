package sq.queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

/**
 * @Author: sq
 * @Description:
 * @Date: Created in 2018/3/29
 **/
public class QueueTest {

    private CircularFifoQueue<String> que = null;
    @Before
    public void before(){
        que = new CircularFifoQueue<>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        que.add("d");
    }

    /**
     * 循环队列
     */
    @Test
    public void circullar()
    {
        //长度是2，因此只能保留两个，循环着走。
        //查看
        que.forEach(System.out::println);
    }

    /**
     * 只读队列
     */
    @Test
    public void readOnly()
    {
        Queue<String> readOnlyOne = UnmodifiableQueue.unmodifiableQueue(que);
        //java.lang.UnsupportedOperationException
        readOnlyOne.add("e");
    }


    /**
     * 断言队列
     */
    @Test
    public void predicate()
    {
        Predicate notNull = NotNullPredicate.INSTANCE;
        //包装成对应的队列
        Queue<String> que2 = PredicatedQueue.predicatedQueue(que,notNull);
        //java.lang.IllegalArgumentException
        que2.add(null);
    }
}
