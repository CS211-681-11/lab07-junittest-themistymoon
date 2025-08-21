package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนักเรียน")
    void testAddNewStudent() {
        studentList.addNewStudent("6710404574", "John Doe");
        assertEquals(1, studentList.getStudents().size());
        Student student = studentList.findStudentById("6710404574");
        assertNotNull(student);
        assertEquals("John Doe", student.getName());
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนักเรียนซ้ำ")
    void testAddDuplicateStudent() {
        studentList.addNewStudent("6710404574", "John Doe");
        studentList.addNewStudent("6710404574", "Jane Doe");

        assertEquals(1, studentList.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบค้นหานักเรียน")
    void testFindStudentById() {
        studentList.addNewStudent("6710404574", "John Doe");

        Student found = studentList.findStudentById("6710404574");
        assertNotNull(found);

        Student notFound = studentList.findStudentById("6710404575");
        assertNull(notFound);
    }

    @Test
    @DisplayName("ทดสอบกรองตามชื่อ")
    void testFilterByName() {
        studentList.addNewStudent("6710404574", "John Smith");
        studentList.addNewStudent("6710404575", "Jane Doe");
        studentList.addNewStudent("6710404576", "John Johnson");

        StudentList filtered = studentList.filterByName("John");
        assertEquals(2, filtered.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบให้คะแนน")
    void testGiveScore() {
        studentList.addNewStudent("6710404574", "John Doe");
        studentList.giveScoreToId("6710404574", 85.5);

        Student student = studentList.findStudentById("6710404574");
        assertEquals(85.5, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบดูเกรด")
    void testViewGrade() {
        studentList.addNewStudent("6710404574", "John Doe");
        studentList.giveScoreToId("6710404574", 85.5);

        String grade = studentList.viewGradeOfId("6710404574");
        assertEquals("A", grade);
    }
}
