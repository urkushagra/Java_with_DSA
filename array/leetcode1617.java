import java.util.*;

class FrontMiddleBackQueue {
    
    Deque<Integer> left;
    Deque<Integer> right;
    
    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    
    // Balance both halves
    private void balance() {
        if (left.size() > right.size() + 1) {
            right.offerFirst(left.pollLast());
        } else if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
    }
    
    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
        left.offerLast(val);
    }
    
    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }
    
    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return val;
    }
    
    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        
        int val = left.pollLast(); // always from left
        balance();
        return val;
    }
    
    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        
        int val = right.isEmpty() ? left.pollLast() : right.pollLast();
        balance();
        return val;
    }
}
