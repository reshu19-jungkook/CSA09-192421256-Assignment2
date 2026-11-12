
import java.util.*;

public class ListComparison {

    static final int RUNS = 5;
    static final int ACCESS_REPEATS = 1000;
    static final int ITERATION_REPEATS = 100;

    static long addEnd(List<Integer> list, int n) {
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        return System.nanoTime() - start;
    }

    static long insertFront(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        list.add(0, -1);

        return System.nanoTime() - start;
    }

    static long insertMiddle(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        list.add(n / 2, -1);

        return System.nanoTime() - start;
    }

    static long removeFront(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        list.remove(0);

        return System.nanoTime() - start;
    }

    static long removeMiddle(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        list.remove(n / 2);

        return System.nanoTime() - start;
    }

    static long accessKth(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long sum = 0;
        int k = n / 2;

        long start = System.nanoTime();

        for (int i = 0; i < ACCESS_REPEATS; i++) {
            sum += list.get(k);
        }

        long end = System.nanoTime();

        if (sum < 0) System.out.println(sum);

        return end - start;
    }

    static long iterate(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long sum = 0;
        long start = System.nanoTime();

        for (int r = 0; r < ITERATION_REPEATS; r++) {
            for (int value : list) {
                sum += value;
            }
        }

        long end = System.nanoTime();

        if (sum < 0) System.out.println(sum);

        return end - start;
    }

    static double average(String operation, boolean arrayList, int n) {

        long total = 0;

        for (int i = 0; i < RUNS; i++) {

            List<Integer> list = arrayList
                    ? new ArrayList<>()
                    : new LinkedList<>();

            long time = 0;

            switch (operation) {
                case "Add End":
                    time = addEnd(list, n);
                    break;

                case "Insert Front":
                    time = insertFront(list, n);
                    break;

                case "Insert Middle":
                    time = insertMiddle(list, n);
                    break;

                case "Remove Front":
                    time = removeFront(list, n);
                    break;

                case "Remove Middle":
                    time = removeMiddle(list, n);
                    break;

                case "Access Kth":
                    time = accessKth(list, n);
                    break;

                case "Iteration":
                    time = iterate(list, n);
                    break;
            }

            total += time;
        }

        return total / (double) RUNS / 1_000_000.0;
    }

    static void compare(int n) {

        String[] operations = {
            "Add End",
            "Insert Front",
            "Insert Middle",
            "Remove Front",
            "Remove Middle",
            "Access Kth",
            "Iteration"
        };

        System.out.println("\n==============================================");
        System.out.println("PLAYLIST SIZE: " + n);
        System.out.println("==============================================");

        System.out.printf("%-16s %-16s %-16s%n",
                "Operation", "ArrayList(ms)", "LinkedList(ms)");

        for (String operation : operations) {

            double a = average(operation, true, n);
            double l = average(operation, false, n);

            System.out.printf("%-16s %-16.4f %-16.4f%n",
                    operation, a, l);
        }
    }

    static void upNextDemo() {

        System.out.println("\n===== ARRAYDEQUE UP NEXT QUEUE =====");

        Deque<String> upNext = new ArrayDeque<>();

        upNext.addLast("Song A");
        upNext.addLast("Song B");
        upNext.addFirst("Priority Song");

        System.out.println("Up Next: " + upNext);
        System.out.println("Now Playing: " + upNext.removeFirst());
        System.out.println("Remaining Queue: " + upNext);
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 50000};

        for (int size : sizes) {
            compare(size);
        }

        upNextDemo();
    }
}
