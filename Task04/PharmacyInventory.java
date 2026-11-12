
import java.util.*;

public class PharmacyInventory {
    public static void main(String[] args) {

        int n = 100000;

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> linkedMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String medicine = "Medicine" + i;
            hashMap.put(i, medicine);
            treeMap.put(i, medicine);
            linkedMap.put(i, medicine);
        }

        int searchKey = 75000;
        int repetitions = 10000;

        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            hashMap.get(searchKey);
        }
        end = System.nanoTime();
        System.out.println("HashMap lookup: " +
                (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            treeMap.get(searchKey);
        }
        end = System.nanoTime();
        System.out.println("TreeMap lookup: " +
                (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            linkedMap.get(searchKey);
        }
        end = System.nanoTime();
        System.out.println("LinkedHashMap lookup: " +
                (end - start) / 1_000_000.0 + " ms");

        System.out.println("\nHashMap order: " + hashMap.keySet());
        System.out.println("TreeMap order: " + treeMap.keySet());
        System.out.println("LinkedHashMap order: " + linkedMap.keySet());

        System.out.println("\nInventory counts:");
System.out.println("\nFirst 10 HashMap keys: " +
        hashMap.keySet().stream().limit(10).toList());

System.out.println("First 10 TreeMap keys: " +
        treeMap.keySet().stream().limit(10).toList());

System.out.println("First 10 LinkedHashMap keys: " +
        linkedMap.keySet().stream().limit(10).toList());
    }
}
