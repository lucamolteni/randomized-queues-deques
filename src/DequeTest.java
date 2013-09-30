import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class DequeTest {
    Integer[] arr5 = {1, 2, 3, 4, 5};
    Integer[] arr4 = {1, 2, 3, 4};
    Integer[] arr3 = {1, 2, 3};
    Integer[] arr2 = {1, 2};
    Integer[] arr1 = {1};

    @Test
    public void addFirstTest() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addFirst(2);
        dq.addFirst(1);
        Assert.assertEquals(2, dq.size());
    }

    @Test
    public void addLastTest() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.addLast(5);
        Assert.assertEquals(5, dq.size());
    }

    @Test
    public void orderPreservedLast() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.addLast(5);
        testArr5(dq);
    }

    @Test
    public void orderPreservedFirst() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addFirst(5);
        dq.addFirst(4);
        dq.addFirst(3);
        dq.addFirst(2);
        dq.addFirst(1);
        testArr5(dq);
    }

    @Test
    public void popFirst() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.removeLast();
        testArr2(dq);
    }

    @Test
    public void removeEverything() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.removeLast();
        dq.removeLast();
        dq.removeLast();
        Assert.assertTrue(dq.isEmpty());
    }


    @Test
    public void addFirstLast() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addFirst(1);
        dq.addLast(2);
        testArr2(dq);
    }

    @Test
    public void addLastFirst() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(2);
        dq.addFirst(1);
        testArr2(dq);
    }

    @Test
    public void addLastFirstWithRemoval() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(2);
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(5);
        dq.removeFirst();
        dq.removeFirst();
        testArr2(dq);
    }

    @Test
    public void addLastFirstWithRemovalBoth() {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(2);
        dq.addFirst(1);
        dq.addFirst(3);
        dq.addLast(6);
        dq.removeLast();
        dq.removeLast();
        dq.removeLast();
        dq.removeFirst();
        dq.addLast(1);
        testArr1(dq);
    }

    private void testArr1(Deque<Integer> dq) {
        testArr(dq, 1, arr1);
    }

    private void testArr2(Deque<Integer> dq) {
        testArr(dq, 2, arr2);
    }

    private void testArr3(Deque<Integer> dq) {
        testArr(dq, 3, arr3);
    }

    private void testArr4(Deque<Integer> dq) {
        testArr(dq, 4, arr4);
    }

    private void testArr5(Deque<Integer> dq) {
        testArr(dq, 5, arr5);
    }

    private void testArr(Deque<Integer> dq, int initialCapacity, Integer[] arr) {
        final ArrayList<Integer> res = new ArrayList<Integer>(initialCapacity);
        for(Integer i : dq) {
            res.add(i);
        }
        Assert.assertTrue(Arrays.equals(res.toArray(new Integer[initialCapacity]), arr));
    }


}