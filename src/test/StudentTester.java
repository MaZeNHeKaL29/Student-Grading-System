package test;

import studentGradingSystem.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class StudentTester {

	private Student student1;
	private Student  student2;
	private Student student3;
	private Student student4;
	private Student student5;
	private Student student6;
	private Student student7;
	private Student student8;
	private Student student9;
	@BeforeClass
	public static void InitAll()
	{
		System.out.println("Before Init All...");
	}
	
    @Before
    public void setUp() {
        // Initialize a Student object before each test
        student1 = new Student("Mazen Ehab", "1901120s", 10, 10, 15, 55);
      
        student2 = new Student("Andrew Samir", "19002422", 9, 9, 18, 58);

    	student3 = new Student("AbdAllah Mostafa", "1900779s", 8, 9, 15, 53);
    	student4 = new Student("Mostafa Mohamed", "1803093s", 9, 8, 13, 55);
    	student5 = null;
    	student7 = new Student("Ahmed Mahmoud", "1901143s", 10, 10, 20, 60);
    	student8 = new Student("Mohamed Mostafa", "1901650",10, 10, 18, 56);
    	student9 =  new Student("Mazen Ehab", "1901280s", 9, 9, 17, 55);
    }

    //test student1
    @Test
    public void testGetStudentName_student1() {
        Assert.assertEquals("Mazen Ehab", student1.GetStudentName());
    }

    @Test
    public void testGetStudentNumber_student1() {
        Assert.assertEquals("1901120s", student1.GetStudentNumber());
    }
    @Test
    public void testInvalidRangeActivitesMark_student1() {
       
        Assert.assertFalse(student1.GetStudentActivitiesMark() > 10);
    }
    @Test
    public void testInvalidRangeOral_PracticalMark_student1() {
       
        Assert.assertFalse(student1.GetOral_PracticalMark() > 10);
    }
    @Test
    public void testInvalidRangeMidtermExamMark_student1() {
       
        Assert.assertFalse(student1.GetMidtermExamMark() > 20);
    }
    @Test
    public void testInvalidRangeFinalExamMark_student1() {
       
        Assert.assertFalse(student1.GetFinalExamMark() > 60);
    }
//    @Test
//    public void testStudentNumberSize_student1() {
//        Assert.assertEquals(8, student1.GetLengthStudentNumber());
//    }


    @Test
    public void testGetStudentActivitiesMark_student1() {
        Assert.assertEquals(10, student1.GetStudentActivitiesMark());
    }

    @Test
    public void testGetOral_PracticalMark_student1() {
        Assert.assertEquals(10, student1.GetOral_PracticalMark());
    }

    @Test
    public void testGetMidtermExamMark_student1() {
        Assert.assertEquals(15, student1.GetMidtermExamMark());
    }

    @Test
    public void testGetFinalExamMark_student1() {
        Assert.assertEquals(55, student1.GetFinalExamMark());
    }

    @Test
    public void testGetTotalMarks_student1() {
        Assert.assertEquals(90, student1.GetTotalMarks());
    }

    @Test
    public void testGetGPA_student1() {
    	try (MockedStatic<GPACalculator> studentGradingManager = Mockito.mockStatic(GPACalculator.class))
		 {
			 studentGradingManager.when(() -> GPACalculator.calculateGPA(student1.GetTotalMarks()))
			 	.thenReturn(3.7);
			 System.out.println(student1.GetGPA());
			 Assert.assertEquals(3.7, student1.GetGPA(), 0.01);
		 }
 
        
    }

    @Test
    public void testGetGrade_student1() {
    	try (MockedStatic<GradeCalculator> studentGradingManager = Mockito.mockStatic(GradeCalculator.class))
		 {
			 studentGradingManager.when(() -> GradeCalculator.calculateGrade(student1.GetTotalMarks()))
			 	.thenReturn("A-");
			 System.out.println(student1.GetGrade());
			 Assert.assertEquals("A-", student1.GetGrade());
		 }
       
    }
    
    
    
    
    //test student2
    @Test
    public void testGetStudentName_student2() {
        Assert.assertEquals("Andrew Samir", student2.GetStudentName());
    }

    @Test
    public void testGetStudentNumber_student2() {
        Assert.assertEquals("19002422", student2.GetStudentNumber());
    }
    
    @Test
    public void testInvalidRangeActivitesMark_student2() {
       
        Assert.assertFalse(student2.GetStudentActivitiesMark() > 10);
    }
    @Test
    public void testInvalidRangeOral_PracticalMark_student2() {
       
        Assert.assertFalse(student2.GetOral_PracticalMark() > 10);
    }
    @Test
    public void testInvalidRangeMidtermExamMark_student2() {
       
        Assert.assertFalse(student2.GetMidtermExamMark() > 20);
    }
    @Test
    public void testInvalidRangeFinalExamMark_student2() {
       
        Assert.assertFalse(student2.GetFinalExamMark() > 60);
    }
//    @Test
//    public void testStudentNumberSize_student2() {
//        Assert.assertEquals(8, student2.GetLengthStudentNumber());
//    }

    @Test 
    public void testGetStudentActivitiesMark_student2() {
        Assert.assertEquals(9, student2.GetStudentActivitiesMark());
    }

    @Test
    public void testGetOral_PracticalMark_student2() {
        Assert.assertEquals(9, student2.GetOral_PracticalMark());
    }

    @Test
    public void testGetMidtermExamMark_student2() {
        Assert.assertEquals(18, student2.GetMidtermExamMark());
    }

    @Test
    public void testGetFinalExamMark_student2() {
        Assert.assertEquals(58, student2.GetFinalExamMark());
    }

    @Test
    public void testGetTotalMarks_student2() {
        Assert.assertEquals(94, student2.GetTotalMarks());
    }

    @Test
    public void testGetGPA_student2() {
    	try (MockedStatic<GPACalculator> studentGradingManager = Mockito.mockStatic(GPACalculator.class))
		 {
			 studentGradingManager.when(() -> GPACalculator.calculateGPA(student2.GetTotalMarks()))
			 	.thenReturn(4.0);
			 System.out.println(student2.GetGPA());
			 Assert.assertEquals(4.0, student2.GetGPA(), 0.01);
		 }
 
        
    }

    @Test
    public void testGetGrade_student2() {
    	try (MockedStatic<GradeCalculator> studentGradingManager = Mockito.mockStatic(GradeCalculator.class))
		 {
			 studentGradingManager.when(() -> GradeCalculator.calculateGrade(student2.GetTotalMarks()))
			 	.thenReturn("A");
			 System.out.println(student2.GetGrade());
			 Assert.assertEquals("A", student2.GetGrade());
		 }
       
    }
    
    
    //test student3
    @Test
    public void testGetStudentName_student3() {
        Assert.assertEquals("AbdAllah Mostafa", student3.GetStudentName());
    }

    @Test
    public void testGetStudentNumber_student3() {
        Assert.assertEquals("1900779s", student3.GetStudentNumber());
    }
    @Test
    public void testInvalidRangeActivitesMark_student3() {
       
        Assert.assertFalse(student3.GetStudentActivitiesMark() > 10);
    }
    @Test
    public void testInvalidRangeOral_PracticalMark_student3() {
       
        Assert.assertFalse(student3.GetOral_PracticalMark() > 10);
    }
    @Test
    public void testInvalidRangeMidtermExamMark_student3() {
       
        Assert.assertFalse(student3.GetMidtermExamMark() > 20);
    }
    @Test
    public void testInvalidRangeFinalExamMark_student3() {
       
        Assert.assertFalse(student3.GetFinalExamMark() > 60);
    }

//    @Test
//    public void testStudentNumberSize_student3() {
//        Assert.assertEquals(8, student3.GetLengthStudentNumber());
//    }

    @Test 
    public void testGetStudentActivitiesMark_student3() {
        Assert.assertEquals(8, student3.GetStudentActivitiesMark());
    }

    @Test
    public void testGetOral_PracticalMark_student3() {
        Assert.assertEquals(9, student3.GetOral_PracticalMark());
    }

    @Test
    public void testGetMidtermExamMark_student3() {
        Assert.assertEquals(15, student3.GetMidtermExamMark());
    }

    @Test
    public void testGetFinalExamMark_student3() {
        Assert.assertEquals(53, student3.GetFinalExamMark());
    }

    @Test
    public void testGetTotalMarks_student3() {
        Assert.assertEquals(85, student3.GetTotalMarks());
    }

    @Test
    public void testGetGPA_student3() {
    	try (MockedStatic<GPACalculator> studentGradingManager = Mockito.mockStatic(GPACalculator.class))
		 {
			 studentGradingManager.when(() -> GPACalculator.calculateGPA(student3.GetTotalMarks()))
			 	.thenReturn(3.3);
			 System.out.println(student3.GetGPA());
			 Assert.assertEquals(3.3, student3.GetGPA(), 0.01);
		 }
 
        
    }

    @Test
    public void testGetGrade_student3() {
    	try (MockedStatic<GradeCalculator> studentGradingManager = Mockito.mockStatic(GradeCalculator.class))
		 {
			 studentGradingManager.when(() -> GradeCalculator.calculateGrade(student3.GetTotalMarks()))
			 	.thenReturn("B+");
			 System.out.println(student3.GetGrade());
			 Assert.assertEquals("B+", student3.GetGrade());
		 }
       
    }
    
    
    
    // Tests for student4
    @Test
    public void testGetStudentName_student4() {
        Assert.assertEquals("Mostafa Mohamed", student4.GetStudentName());
    }

    @Test
    public void testGetStudentNumber_student4() {
        Assert.assertEquals("1803093s", student4.GetStudentNumber());
    }
    
//    @Test
//    public void testStudentNumberSize_student4() {
//        Assert.assertEquals(8, student4.GetLengthStudentNumber());
//    }

    @Test
    public void testGetStudentActivitiesMark_student4() {
        Assert.assertEquals(9, student4.GetStudentActivitiesMark());
    }

    @Test
    public void testGetOral_PracticalMark_student4() {
        Assert.assertEquals(8, student4.GetOral_PracticalMark());
    }

    @Test
    public void testGetMidtermExamMark_student4() {
        Assert.assertEquals(13, student4.GetMidtermExamMark());
    }

    @Test
    public void testGetFinalExamMark_student4() {
        Assert.assertEquals(55, student4.GetFinalExamMark());
    }

    @Test
    public void testGetTotalMarks_student4() {
        Assert.assertEquals(85, student4.GetTotalMarks());
    }
    @Test
    public void testGetGPA_student4() {
    	try (MockedStatic<GPACalculator> studentGradingManager = Mockito.mockStatic(GPACalculator.class))
		 {
			 studentGradingManager.when(() -> GPACalculator.calculateGPA(student4.GetTotalMarks()))
			 	.thenReturn(3.3);
			 System.out.println(student4.GetGPA());
			 Assert.assertEquals(3.3, student4.GetGPA(), 0.01);
		 }
 
        
    }

    @Test
    public void testGetGrade_student4() {
    	try (MockedStatic<GradeCalculator> studentGradingManager = Mockito.mockStatic(GradeCalculator.class))
		 {
			 studentGradingManager.when(() -> GradeCalculator.calculateGrade(student4.GetTotalMarks()))
			 	.thenReturn("B+");
			 System.out.println(student4.GetGrade());
			 Assert.assertEquals("B+", student4.GetGrade());
		 }
       
    }
    
    // Tests for student7
    //name start with space
    @Test
    public void testGetStudentName_student7() {
        Assert.assertEquals("Ahmed Mahmoud", student7.GetStudentName());
    }

    @Test
    public void testGetStudentNumber_student7() {
        Assert.assertEquals("1901143s", student7.GetStudentNumber());
    }

//    @Test
//    public void testStudentNumberSize_student7() {
//        Assert.assertEquals(8, student7.GetLengthStudentNumber());
//    }

    @Test
    public void testGetStudentActivitiesMark_student7() {
        Assert.assertEquals(10, student7.GetStudentActivitiesMark());
    }

    @Test
    public void testGetOral_PracticalMark_student7() {
        Assert.assertEquals(10, student7.GetOral_PracticalMark());
    }

    @Test
    public void testGetMidtermExamMark_student7() {
        Assert.assertEquals(20, student7.GetMidtermExamMark());
    }

    @Test
    public void testGetFinalExamMark_student7() {
        Assert.assertEquals(60, student7.GetFinalExamMark());
    }

    @Test
    public void testGetTotalMarks_student7() {
        Assert.assertEquals(100, student7.GetTotalMarks());
    }

    @Test
    public void testGetGPA_student7() {
    	try (MockedStatic<GPACalculator> studentGradingManager = Mockito.mockStatic(GPACalculator.class))
		 {
			 studentGradingManager.when(() -> GPACalculator.calculateGPA(student7.GetTotalMarks()))
			 	.thenReturn(4.0);
			 System.out.println(student7.GetGPA());
			 Assert.assertEquals(4.0, student7.GetGPA(), 0.01);
		 }
    }

    @Test
    public void testGetGrade_student7() {
    	try (MockedStatic<GradeCalculator> studentGradingManager = Mockito.mockStatic(GradeCalculator.class))
		 {
			 studentGradingManager.when(() -> GradeCalculator.calculateGrade(student7.GetTotalMarks()))
			 	.thenReturn("A+");
			 System.out.println(student7.GetGrade());
			 Assert.assertEquals("A+", student7.GetGrade());
		 }
    }

    
    // Tests for student8
    @Test
    public void testGetStudentName_student8() {
        Assert.assertEquals("Mohamed Mostafa", student8.GetStudentName());
    }

    @Test
    public void testGetStudentNumber_student8() {
        Assert.assertEquals("1901650", student8.GetStudentNumber());
    }
    //code or number must be 8 
//    @Test
//    public void testStudentNumberSize_student8() {
//        Assert.assertEquals(8, student8.GetLengthStudentNumber()); // Assuming the length includes the trailing 's'
//    }

    @Test
    public void testGetStudentActivitiesMark_student8() {
        Assert.assertEquals(10, student8.GetStudentActivitiesMark());
    }

    @Test
    public void testGetOral_PracticalMark_student8() {
        Assert.assertEquals(10, student8.GetOral_PracticalMark());
    }

    @Test
    public void testGetMidtermExamMark_student8() {
        Assert.assertEquals(18, student8.GetMidtermExamMark());
    }

    @Test
    public void testGetFinalExamMark_student8() {
        Assert.assertEquals(56, student8.GetFinalExamMark());
    }

    @Test
    public void testGetTotalMarks_student8() {
        Assert.assertEquals(94, student8.GetTotalMarks());
    }


    @Test
    public void testGetGPA_student8() {
    	try (MockedStatic<GPACalculator> studentGradingManager = Mockito.mockStatic(GPACalculator.class))
		 {
			 studentGradingManager.when(() -> GPACalculator.calculateGPA(student8.GetTotalMarks()))
			 	.thenReturn(4.0);
			 System.out.println(student8.GetGPA());
			 Assert.assertEquals(4.0, student8.GetGPA(), 0.01);
		 }
    }

    @Test
    public void testGetGrade_student8() {
    	try (MockedStatic<GradeCalculator> studentGradingManager = Mockito.mockStatic(GradeCalculator.class))
		 {
			 studentGradingManager.when(() -> GradeCalculator.calculateGrade(student8.GetTotalMarks()))
			 	.thenReturn("A");
			 System.out.println(student8.GetGrade());
			 Assert.assertEquals("A", student8.GetGrade());
		 }
    }
 
    
    @Test
    public void testInvalidRangeActivitesMark() {
        Student s =  new Student("Jon Doe", "19002422", 15, 9, 18, 58);
        Assert.assertFalse(s.GetStudentActivitiesMark() > 10);
    }
    @Test
    public void testEqualStudents() {
        // Testing whether two references point to the same object
        Assert.assertEquals(student1, student9);
    }
   
    @Test
    public void testNotEqualStudents() {
        // Testing whether two references point to different objects
        Assert.assertNotEquals(student1, student2);
    }
    
    @Test
    public void testSameStudents() {
        // Testing whether two references point to the same object
    	student5 = student1;
        Assert.assertSame(student1, student5);
    }
   
    @Test
    public void testDifferentStudents() {
    	
        Assert.assertNotSame(student1, student4);
    }
    
	@Test
	public void StudentNotExist()
	{
		
		assertNull(student6);
	}
	
 
	@Test
	public void StudentIsExist()
	{
		
		assertNotNull(student1);
	}
	
	 @Test
    public void testIsStudentNameValid() {
        // Check if the student name is not null or empty
        assertTrue(student1.GetStudentName() != null && !student1.GetStudentName().isEmpty());
    }

    @Test
    public void testTotalMarksInRange() {
        // Check if the total marks are within a valid range (e.g., between 0 and 100)
        assertTrue(student1.GetTotalMarks() >= 0 && student1.GetTotalMarks() <= 100);
    }
    @Test
    public void testEquals_sameStudentWithAssertTrue() {
        Student s = student1;
        assertTrue(student1.equals(s)); // Same object reference, should return true
    }
  
    
}
