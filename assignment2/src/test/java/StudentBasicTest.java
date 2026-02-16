import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentBasicTest {

    @Test
    void constructorCreatesStudent() {
        Student student = new Student("S001", "Alice", 3.2);

        assertNotNull(student);
        assertEquals("S001", student.getStudentId());
        assertEquals("Alice", student.getName());
        assertEquals(3.2, student.getGpa());
    }

    @Test
    void constructorThrowsForEmptyId() {
        assertThrows(IllegalArgumentException.class, () -> new Student("", "Bob", 3.0));
    }

    @Test
    void constructorThrowsForInvalidGpa() {
        assertThrows(IllegalArgumentException.class, () -> new Student("S002", "Cara", 4.5));
    }

    @Test
    void getGradeLetterReturnsA() {
        Student student = new Student("S003", "Dan", 3.8);

        assertEquals("A", student.getGradeLetter());
    }

    @Test
    void getGradeLetterReturnsVariousGrades() {
        assertEquals("B", new Student("S004", "Eve", 3.1).getGradeLetter());
        assertEquals("C", new Student("S005", "Finn", 2.4).getGradeLetter());
        assertEquals("D", new Student("S006", "Gail", 1.3).getGradeLetter());
        assertEquals("F", new Student("S007", "Hank", 0.7).getGradeLetter());
    }

    @Test
    void isPassedReturnsTrue() {
        Student student = new Student("S008", "Ivy", 2.5);

        assertTrue(student.isPassed());
    }

    @Test
    void isPassedReturnsFalse() {
        Student student = new Student("S009", "Jack", 1.9);

        assertFalse(student.isPassed());
    }

    @Test
    void updateGpaSucceeds() {
        Student student = new Student("S010", "Kara", 3.0);

        boolean updated = student.updateGpa(3.9);

        assertTrue(updated);
        assertEquals(3.9, student.getGpa());
    }

    @Test
    void updateGpaFails() {
        Student student = new Student("S011", "Liam", 2.5);

        boolean updated = student.updateGpa(-0.1);

        assertFalse(updated);
        assertEquals(2.5, student.getGpa());
    }

    @Test
    void updateGpaBoundaryValues() {
        Student student = new Student("S012", "Mia", 2.0);

        assertTrue(student.updateGpa(0.0));
        assertEquals(0.0, student.getGpa());

        assertTrue(student.updateGpa(4.0));
        assertEquals(4.0, student.getGpa());
    }
}
