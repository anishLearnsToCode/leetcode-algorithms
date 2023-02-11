// https://leetcode.com/problems/peeking-iterator
// T: O(N)
// S: O(N)

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    final private Iterator<Integer> iterator;
    int next;
    boolean hasNext;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        hasNext = iterator.hasNext();
        next = iterator.hasNext() ? iterator.next() : 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = next;
        hasNext = iterator.hasNext();
        next = iterator.hasNext() ? iterator.next() : 0;
        return result;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}