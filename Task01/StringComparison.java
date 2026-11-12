
public class StringComparison {

    static long buildUsingString(int tickets, int fields) {
        long checksum = 0;

        for (int i = 0; i < tickets; i++) {
            String ticket = "";

            for (int j = 0; j < fields; j++) {
                ticket = ticket + "Field" + j + " = Value" + j + "\n";
            }

            checksum += ticket.length();
        }
        return checksum;
    }

    static long buildUsingStringBuilder(int tickets, int fields) {
        long checksum = 0;

        for (int i = 0; i < tickets; i++) {
            StringBuilder ticket = new StringBuilder();

            for (int j = 0; j < fields; j++) {
                ticket.append("Field").append(j)
                      .append(" = Value").append(j).append("\n");
            }

            checksum += ticket.length();
        }
        return checksum;
    }

    static long buildUsingStringBuffer(int tickets, int fields) {
        long checksum = 0;

        for (int i = 0; i < tickets; i++) {
            StringBuffer ticket = new StringBuffer();

            for (int j = 0; j < fields; j++) {
                ticket.append("Field").append(j)
                      .append(" = Value").append(j).append("\n");
            }

            checksum += ticket.length();
        }
        return checksum;
    }

    static void test(String name, int tickets, int fields) {

        long[] times = new long[5];
        long checksum = 0;

        // Warm-up
        for (int i = 0; i < 3; i++) {
            buildUsingStringBuilder(10, 10);
        }

        for (int i = 0; i < 5; i++) {

            long start = System.nanoTime();

            if (name.equals("String")) {
                checksum = buildUsingString(tickets, fields);
            } else if (name.equals("StringBuilder")) {
                checksum = buildUsingStringBuilder(tickets, fields);
            } else {
                checksum = buildUsingStringBuffer(tickets, fields);
            }

            long end = System.nanoTime();
            times[i] = end - start;
        }

        long total = 0;

        for (long time : times) {
            total += time;
        }

        double averageMs = total / 5.0 / 1_000_000.0;

        System.out.printf(
            "%-15s | %10.4f ms | Checksum: %d%n",
            name, averageMs, checksum
        );
    }

    public static void main(String[] args) {

        int[][] workloads = {
            {1, 6},
            {1000, 50},
            {10000, 50}
        };

        for (int i = 0; i < workloads.length; i++) {

            int tickets = workloads[i][0];
            int fields = workloads[i][1];

            System.out.println("\n==================================");
            System.out.println("WORKLOAD " + (i + 1));
            System.out.println("Tickets: " + tickets);
            System.out.println("Fields per ticket: " + fields);
            System.out.println("==================================");

            System.out.printf("%-15s | %15s | %s%n",
                    "Method", "Average Time", "Result");

            test("String", tickets, fields);
            test("StringBuilder", tickets, fields);
            test("StringBuffer", tickets, fields);
        }
    }
}
