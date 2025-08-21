package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6710404574", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6710404574", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบเพิ่มคะแนนติดลบ")
    void testAddNegativeScore() {
        Student s = new Student("6710404574", "Test Student", 50.0);
        s.addScore(-10.0);
        assertEquals(50.0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบสร้าง Student")
    void testStudentConstructor() {
        Student s = new Student("6710404574", "JubJib JibJub");
        assertEquals("6710404574", s.getId());
        assertEquals("JubJib JibJub", s.getName());
        assertEquals(0.0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบเปลี่ยนชื่อ")
    void testChangeName() {
        Student s = new Student("6710404574", "Old Name");
        s.changeName("New Name");
        assertEquals("New Name", s.getName());
    }

    @Test
    @DisplayName("ทดสอบเปลี่ยนชื่อเป็น Empty String")
    void testChangeNameEmpty() {
        Student s = new Student("6710404574", "Original Name");
        s.changeName("");
        assertEquals("Original Name", s.getName());
    }

    @Test
    @DisplayName("ทดสอบตรวจสอบ ID")
    void testIsId() {
        Student s = new Student("6710404574", "Test Student");
        assertTrue(s.isId("6710404574"));
        assertFalse(s.isId("6710404575"));
    }

    @Test
    @DisplayName("ทดสอบค้นหาชื่อ")
    void testIsNameContains() {
        Student s = new Student("6710404574", "John Smith");
        assertTrue(s.isNameContains("john"));
        assertFalse(s.isNameContains("Jane"));
    }
}