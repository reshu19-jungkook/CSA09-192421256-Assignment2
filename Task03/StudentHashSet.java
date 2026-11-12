
import java.util.HashSet;
import java.util.Set;

class Student {

    private final String regNo;
    private final String name;

    Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Student)) return false;

        Student other = (Student) o;

        return regNo.equals(other.regNo);
    }

    // TODO 1: Override hashCode() using regNo

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }

}

public class StudentHashSet {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        // Test 1: Same student scanned twice
        students.add(new Student("101", "Arun"));
        students.add(new Student("101", "Arun"));

        System.out.println("Test 1 - Repeated Scan");
        System.out.println("Unique students: " + students.size());

        // Test 2: Same register number, different name
        students.clear();

        students.add(new Student("102", "Priya"));
        students.add(new Student("102", "Priya Sharma"));

        System.out.println("\nTest 2 - Same Register Number");
        System.out.println("Unique students: " + students.size());

        // Test 3: Different students
        students.clear();

        students.add(new Student("103", "Kumar"));
        students.add(new Student("104", "Divya"));
        students.add(new Student("105", "Rahul"));

        System.out.println("\nTest 3 - Different Students");
        System.out.println("Unique students: " + students.size());

    }
}
