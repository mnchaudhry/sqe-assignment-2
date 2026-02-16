public class Student {
    private final String studentId;
    private final String name;
    private double gpa;

    public Student(String studentId, String name, double gpa) {
        if (studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
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
        if (newGpa < 0.0 || newGpa > 4.0) {
            return false;
        }
        this.gpa = newGpa;
        return true;
    }

    public String getGradeLetter() {
        if (gpa >= 3.5) return "A";
        if (gpa >= 3.0) return "B";
        if (gpa >= 2.0) return "C";
        if (gpa >= 1.0) return "D";
        return "F";
    }

    public boolean isPassed() {
        return gpa >= 2.0;
    }
}
