public class Student {

    private static final double GPA_MIN = 0.0;
    private static final double GPA_MAX = 4.0;
    private static final double PASSING_GPA = 2.0;
    private static final double GRADE_A = 3.5;
    private static final double GRADE_B = 3.0;
    private static final double GRADE_C = 2.0;
    private static final double GRADE_D = 1.0;

    private final String studentId;
    private final String name;
    private double gpa;

    public Student(String studentId, String name, double gpa) {
        if (studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        validateGpaOrThrow(gpa);
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean updateGpa(double newGpa) {
        if (isGpaOutOfRange(newGpa)) {
            return false;
        }
        this.gpa = newGpa;
        return true;
    }

    public String getGradeLetter() {
        if (gpa >= GRADE_A) {
            return "A";
        }
        if (gpa >= GRADE_B) {
            return "B";
        }
        if (gpa >= GRADE_C) {
            return "C";
        }
        if (gpa >= GRADE_D) {
            return "D";
        }
        return "F";
    }

    public boolean isPassed() {
        return gpa >= PASSING_GPA;
    }

    private void validateGpaOrThrow(double value) {
        if (isGpaOutOfRange(value)) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
    }

    private boolean isGpaOutOfRange(double value) {
        return value < GPA_MIN || value > GPA_MAX;
    }
}
