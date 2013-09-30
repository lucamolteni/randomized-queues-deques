import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class RandomizedQueueTest {

    @Test
    public void addFirstTest() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();
        dq.enqueue(2);
        dq.enqueue(3);
        dq.enqueue(5);
        dq.enqueue(6);
        dq.enqueue(7);
        dq.enqueue(8);
        dq.enqueue(9);
        dq.enqueue(13);
        Assert.assertEquals(dq.size(), 8);
    }

    @Test
    public void allElementPopped() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();
        dq.enqueue(2);
        dq.enqueue(3);
        final List<Integer> res = new ArrayList<Integer>(2);
        res.add(dq.dequeue());
        res.add(dq.dequeue());
        for(Integer i : new Integer[] {2, 3}) {
            Assert.assertTrue(res.contains(i));
        }
    }

    @Test
    public void enqueDeque() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();
        dq.enqueue(2);
        dq.dequeue();
        dq.enqueue(4);
        dq.enqueue(5);
        dq.dequeue();
        dq.dequeue();
        Assert.assertEquals(dq.size(), 0);
    }

    @Test
    public void dequeSample() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();
        dq.enqueue(2);
        dq.dequeue();
        dq.enqueue(4);
        dq.sample();
        dq.dequeue();
        Assert.assertEquals(dq.size(), 0);
    }

    @Test
    public void addTwoTimes() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();
        dq.enqueue(2);
        dq.enqueue(4);
        dq.dequeue();
        dq.dequeue();
        dq.enqueue(3);
        dq.enqueue(5);
    }

    @Test
    public void randomCallToEnqueue() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();

        final int N = 12000000;
        for(int i = 0; i < N; i++) {
            dq.enqueue(StdRandom.uniform(100000));
        }

        Assert.assertEquals(dq.size(), N);
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeSampleemptyrandomizedqueue() {
        RandomizedQueue<Integer> dq = new RandomizedQueue<Integer>();

        final int N = 5;
        for(int i = 0; i < N; i++) {
            dq.enqueue(StdRandom.uniform(100000));
        }

        dq.dequeue();
        dq.dequeue();
        dq.dequeue();
        dq.dequeue();
        dq.dequeue();

        dq.sample();
    }
}