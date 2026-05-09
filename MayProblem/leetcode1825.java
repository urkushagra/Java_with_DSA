import java.util.*;

class MKAverage {

    private int m, k;
    private Queue<Integer> queue = new LinkedList<>();

    private TreeMap<Integer, Integer> low = new TreeMap<>();
    private TreeMap<Integer, Integer> mid = new TreeMap<>();
    private TreeMap<Integer, Integer> high = new TreeMap<>();

    private int lowSize = 0, midSize = 0, highSize = 0;

    private long midSum = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {

        queue.offer(num);

        // insert into proper set
        if (lowSize == 0 || num <= low.lastKey()) {
            add(low, num);
            lowSize++;
        }
        else if (highSize > 0 && num >= high.firstKey()) {
            add(high, num);
            highSize++;
        }
        else {
            add(mid, num);
            midSize++;
            midSum += num;
        }

        balance();

        // remove oldest if window exceeds m
        if (queue.size() > m) {

            int old = queue.poll();

            if (low.containsKey(old)) {
                remove(low, old);
                lowSize--;
            }
            else if (high.containsKey(old)) {
                remove(high, old);
                highSize--;
            }
            else {
                remove(mid, old);
                midSize--;
                midSum -= old;
            }

            balance();
        }
    }

    public int calculateMKAverage() {

        if (queue.size() < m) {
            return -1;
        }

        return (int)(midSum / (m - 2 * k));
    }

    private void balance() {

        // low should contain exactly k smallest
        while (lowSize > k) {

            int x = low.lastKey();

            remove(low, x);
            lowSize--;

            add(mid, x);
            midSize++;
            midSum += x;
        }

        while (lowSize < k && midSize > 0) {

            int x = mid.firstKey();

            remove(mid, x);
            midSize--;
            midSum -= x;

            add(low, x);
            lowSize++;
        }

        // high should contain exactly k largest
        while (highSize > k) {

            int x = high.firstKey();

            remove(high, x);
            highSize--;

            add(mid, x);
            midSize++;
            midSum += x;
        }

        while (highSize < k && midSize > 0) {

            int x = mid.lastKey();

            remove(mid, x);
            midSize--;
            midSum -= x;

            add(high, x);
            highSize++;
        }

        // ordering corrections
        while (!low.isEmpty() && !mid.isEmpty()
                && low.lastKey() > mid.firstKey()) {

            int a = low.lastKey();
            int b = mid.firstKey();

            remove(low, a);
            remove(mid, b);

            add(low, b);
            add(mid, a);

            midSum += (a - b);
        }

        while (!mid.isEmpty() && !high.isEmpty()
                && mid.lastKey() > high.firstKey()) {

            int a = mid.lastKey();
            int b = high.firstKey();

            remove(mid, a);
            remove(high, b);

            add(mid, b);
            add(high, a);

            midSum += (b - a);
        }
    }

    private void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {

        map.put(x, map.get(x) - 1);

        if (map.get(x) == 0) {
            map.remove(x);
        }
    }
}
