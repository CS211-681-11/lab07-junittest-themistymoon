package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบอ่านข้อมูล")
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList studentList = datasource.readData();

        assertNotNull(studentList);
        assertEquals(4, studentList.getStudents().size());

        assertNotNull(studentList.findStudentById("6710400001"));
        assertEquals("First", studentList.findStudentById("6710400001").getName());
    }
}
