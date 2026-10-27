package src;
import java.util.Scanner;

/**
 * Week 4 OOP In-Class Lab (Starter)
 *
 * Run:
 *   javac OOPLabWeek5.java
 *   java OOPLabWeek5
 *
 * Implement Parts 1–7 on separate branches and open PRs.
 */
public class OOPLabWeek4 {

    public static void main(String[] args) {
        System.out.println("=== Week 5 OOP Lab: Student Analytics Mini-App ===");

        // Create objects (baseline)
        Student s1 = new Student("S1001", "Amina", 3.6);
        Student s2 = new Student("S1002", "Diego", 2.9);

        // Basic output
        System.out.println(s1.summary());
        System.out.println(s2.summary());

        // Interactive update (baseline)
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a new GPA for " + s2.getName() + ": ");
        if (sc.hasNextDouble()) {
            double newGpa = sc.nextDouble();
            // This setter will be enhanced by Part 2
            s2.setGpa(newGpa);
        } else {
            System.out.println("Invalid input (expected a number).");
        }
        System.out.println("\nUpdated:");
        System.out.println(s2.summary());

        sc.close();
    }
}

/**
 * Starter Student class.
 * Parts will gradually improve encapsulation & access control.
 */
class Student {

    private String studentId;

    // Good: already private
    private String name;

    // PART 2 will improve encapsulation/validation for gpa
    private double gpa;

    // PART 4 will add: private String email;

    // PART 5 will add: static counter

    // PART 6 will add: Transcript transcript (composition)

    // Constructor
    public Student(String studentId, String name, double gpa) {
        // Part 1: validate/set studentId via setter
        setStudentId(studentId);
        this.name = name;
        this.gpa = gpa;
        // Part 5: increment counter
        // Part 6: create transcript
    }

    // PART 3: add overloaded constructor(s) with chaining
    // e.g., Student(String studentId, String name)

    // Getters/setters
    // PART 1: studentId getter/setter should be public, field private
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if (studentId == null || !studentId.matches("S[0-9]{4}")) {
            throw new IllegalArgumentException(
                "Student ID must be S followed by four digits."
            );
        }

        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    // Keep name read-only for now (access control)
    // (You can optionally allow setName with validation later.)

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        // Part 2: validate 0.0 <= gpa <= 4.0; reject invalid
        this.gpa = gpa;
    }

    // PART 4: add getEmail/setEmail with validation

    // Summary output
    public String summary() {
        // PART 7: improve formatting to match the class’s output expectations
        return "Student[" + studentId + "] " + name + " GPA=" + gpa;
    }
}

/**
 * PART 6: Add Transcript class here.
 * Transcript should store course count + total points, compute GPA contribution, etc.
 * Keep it simple.
 */