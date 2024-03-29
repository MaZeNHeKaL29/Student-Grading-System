package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;
import java.util.Vector;

import studentGradingSystem.Subject;
import studentGradingSystem.Student;

public class SubjectTester {

    private Subject subject1;
    private Subject subject2;
    private Subject subject3;
    private Subject subject4;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;
    private Student student6;
    private Vector<Student> mockStudentsMath;
    private Vector<Student> mockStudentsSoftwareTesting;

    @Before
    public void setUp() {
        subject1 = new Subject("Mathematics", "MATH101");
        subject2 = new Subject(" Software Testing", "CSE337s");
        subject3 = new Subject("Real-Time and Embedded Systems Design", "CSE411s");
        subject4 = new Subject("Fundamentals of Big-Data Analytics", "CSE476s");
        student1 = mock(Student.class);
        student2 = mock(Student.class);
        student3 = mock(Student.class);
        student4 = mock(Student.class);
        student5 = mock(Student.class);
        student6 = mock(Student.class);
        
        
        
        mockStudentsMath = new Vector<Student>();
        mockStudentsSoftwareTesting = new Vector<Student>();
        
        // Mock the behavior of the students if necessary
        when(student1.GetStudentName()).thenReturn("Mazen Ehab");
        when(student2.GetStudentName()).thenReturn("Andrew Samir");
        when(student3.GetStudentName()).thenReturn("AbdAllah Mostafa");
        when(student4.GetStudentName()).thenReturn("Mostafa Mohamed");
        when(student5.GetStudentName()).thenReturn("Ahmed Mahmoud");
        when(student6.GetStudentName()).thenReturn("Mohamed Mostafa");
        
        
        // Add mock students to the mock list for Math course
        mockStudentsMath.add(student1);
        mockStudentsMath.add(student2);
        mockStudentsMath.add(student3);
        mockStudentsMath.add(student4);
        mockStudentsMath.add(student5);
        mockStudentsMath.add(student6);
        // Add mock students to the mock list for Testing course
        mockStudentsSoftwareTesting.add(student1);
        mockStudentsSoftwareTesting.add(student2);
        mockStudentsSoftwareTesting.add(student3);
        mockStudentsSoftwareTesting.add(student4);
    }

    /*** Test cases for GetSubjectName ***/
    @Test
    public void testGetSubjectName_ShouldReturnCorrectName_subject1() {
        assertEquals("Mathematics", subject1.GetSubjectName());
    }
    
    //for test begin with space
    @Test
    public void testGetSubjectName_ShouldReturnCorrectName_subject2() {
    	assertEquals("Software Testing", subject2.GetSubjectName());
    }
   
    //for test begin with space
    @Test
    public void testGetSubjectName_ShouldReturnCorrectName_subject3() {
    	assertEquals("Real-Time and Embedded Systems Design", subject3.GetSubjectName());
    }
   
    //for test begin with space
    @Test
    public void testGetSubjectName_ShouldReturnCorrectName_subject4() {
    	assertEquals("Fundamentals of Big-Data Analytics", subject4.GetSubjectName());
    }
   
   

    /*** Test cases for GetSubjectCode ***/
    @Test
    public void testGetSubjectCode_ShouldReturnCorrectCode_subject1() {
        assertEquals("MATH101", subject1.GetSubjectCode());
    }
    //may be end with alphabetic like s
    @Test
    public void testGetSubjectCode_ShouldReturnCorrectCode_subject2() {
        assertEquals("CSE337s", subject2.GetSubjectCode());
    }
    @Test
    public void testGetSubjectCode_ShouldReturnCorrectCode_subject3() {
        assertEquals("CSE411s", subject3.GetSubjectCode());
    }
    @Test
    public void testGetSubjectCode_ShouldReturnCorrectCode_subject4() {
        assertEquals("CSE476s", subject4.GetSubjectCode());
    }
  

    /*** Test cases for AddStudent and GetStudents ***/
    @Test
    public void testAddAndGetStudents_ShouldContainAddedStudents_subject1() {
    	subject1.AddStudent(student1);
        subject1.AddStudent(student2);
        subject1.AddStudent(student3);
        subject1.AddStudent(student4);
        subject1.AddStudent(student5);
        subject1.AddStudent(student6);
        Vector<Student> students = subject1.GetStudents();
        assertTrue(students.containsAll(mockStudentsMath));
    }
    
    /*** Test cases for AddStudent and GetStudents ***/
    @Test
    public void testAddAndGetStudents_ShouldContainAddedStudents_subject2() {
    	subject2.AddStudent(student1);
        subject2.AddStudent(student2);
        subject2.AddStudent(student3);
        subject2.AddStudent(student4);
        Vector<Student> students = subject2.GetStudents();
        assertTrue(students.containsAll(mockStudentsSoftwareTesting));
    }

    @Test
    public void testAddAndGetStudents_ShouldReturnCorrectNumberOfStudentsInMathCourse() {
        assertEquals(6, mockStudentsMath.size());
    }
    @Test
    public void testAddAndGetStudents_ShouldReturnCorrectNumberOfStudentsInTestingCourse() {
        assertEquals(4, mockStudentsSoftwareTesting.size());
    }
   

    @Test
    public void testAddStudent_ShouldNotAddNullStudent() {
        subject1.AddStudent(null);
        Vector<Student> students = subject1.GetStudents();
        assertTrue(students.contains(null));
    }

   
    @Test
    public void testGetStudents_ShouldReturnEmptyVectorIfNoStudentsAdded_subject1() {
        Vector<Student> students = subject1.GetStudents();
        assertTrue(students.isEmpty());
    }

    
    @Test
    public void testGetStudents_ShouldReturnEmptyVectorIfNoStudentsAdded_subject2() {
        Vector<Student> students = subject2.GetStudents();
        assertTrue(students.isEmpty());
    }
    
    @Test
    public void testGetStudents_ShouldReturnEmptyVectorIfNoStudentsAdded_subject3() {
        Vector<Student> students = subject3.GetStudents();
        assertTrue(students.isEmpty());
    }
    
    @Test
    public void testGetStudents_ShouldReturnEmptyVectorIfNoStudentsAdded_subjec4() {
        Vector<Student> students = subject3.GetStudents();
        assertTrue(students.isEmpty());
    }
    
    @Test
    public void testGetStudents_ShouldReturnSameVector() {
    	subject1.AddStudent(student1);
        subject1.AddStudent(student2);
        subject1.AddStudent(student3);
        subject1.AddStudent(student4);
        subject1.AddStudent(student5);
        subject1.AddStudent(student6);
        Vector<Student> students1 = subject1.GetStudents();
        Vector<Student> students2 = subject1.GetStudents();
        assertSame(students1, students2); // Ensure that a copy of the vector is returned
    }

    
    // Mocking behavior for student objects
    @Test
    public void testMockedStudentBehavior_subject1() {
    

        subject1.AddStudent(student1);
        subject1.AddStudent(student2);
        subject1.AddStudent(student3);
        subject1.AddStudent(student4);
        subject1.AddStudent(student5);
        subject1.AddStudent(student6);

        Vector<Student> students = subject1.GetStudents();
        assertEquals("Mazen Ehab", students.get(0).GetStudentName());
        assertEquals("Andrew Samir", students.get(1).GetStudentName());
        assertEquals("AbdAllah Mostafa", students.get(2).GetStudentName());
        assertEquals("Mostafa Mohamed", students.get(3).GetStudentName());
        assertEquals("Ahmed Mahmoud", students.get(4).GetStudentName());
        assertEquals("Mohamed Mostafa", students.get(5).GetStudentName());
    }
    
    @Test
    public void testMockedStudentBehavior_subject2() {
    

        subject2.AddStudent(student1);
        subject2.AddStudent(student2);
        subject2.AddStudent(student3);
        subject2.AddStudent(student4);
   

        Vector<Student> students = subject2.GetStudents();
        assertEquals("Mazen Ehab", students.get(0).GetStudentName());
        assertEquals("Andrew Samir", students.get(1).GetStudentName());
        assertEquals("AbdAllah Mostafa", students.get(2).GetStudentName());
        assertEquals("Mostafa Mohamed", students.get(3).GetStudentName());
    
    }

 

    // ... [additional test cases as needed] ...
    

}
