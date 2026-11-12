
public class StringOptimization {

    static String usingString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "Ticket" + i + " ";
        }
        return result;
    }

    static String usingStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("Ticket").append(i).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000};
        int repetitions = 5;

        System.out.println("STRING OPTIMIZATION RESULTS");

        for (int n : sizes) {

            long stringTotal = 0;
            long builderTotal = 0;

            for (int r = 0; r < repetitions; r++) {

                long start = System.nanoTime();
                String a = usingString(n);
                stringTotal += System.nanoTime() - start;

                start = System.nanoTime();
                String b = usingStringBuilder(n);
                builderTotal += System.nanoTime() - start;

                // Verify both implementations produce equal output
                if (!a.equals(b)) {
                    System.out.println("Output mismatch!");
                }
            }

            System.out.println("\nRecords: " + n);
            System.out.println("String Average: " +
                (stringTotal / repetitions) / 1_000_000.0 + " ms");

            System.out.println("StringBuilder Average: " +
                (builderTotal / repetitions) / 1_000_000.0 + " ms");
        }
    }
}
