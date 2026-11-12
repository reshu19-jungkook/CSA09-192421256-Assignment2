
import java.util.*;

class Patient {
    String name;
    int severity;
    int arrivalOrder;

    Patient(String name, int severity, int arrivalOrder) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = arrivalOrder;
    }

    public String toString() {
        return name + " - Severity: " + severity;
    }
}

public class EmergencyTriage {
    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>(
            Comparator.comparingInt((Patient p) -> p.severity)
                      .thenComparingInt(p -> p.arrivalOrder)
        );

        queue.add(new Patient("Arun", 3, 1));
        queue.add(new Patient("Bala", 1, 2));
        queue.add(new Patient("Charan", 2, 3));
        queue.add(new Patient("Divya", 1, 4));
        queue.add(new Patient("Esha", 4, 5));
        queue.add(new Patient("Farah", 2, 6));
        queue.add(new Patient("Gokul", 3, 7));
        queue.add(new Patient("Hari", 1, 8));

        System.out.println("EMERGENCY PATIENT TRIAGE");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
