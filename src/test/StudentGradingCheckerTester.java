package studentGradingSystem;

import org.junit.*;
import org.mockito.*;
import static org.junit.Assert.*;

/*
	notes
	------------------
		1. Alphabetic characters are the letters A-Z  (both uppercase and lowercase)
		2. Numeric characters are the numbers 0-9
		3. Alphanumeric characters are the numbers 0-9 and letters A-Z (both uppercase and lowercase)
	
	Requirements
	------------------
		 1. Subject name: It must be Alphabetic characters and Spaces. the name should not start with space
		 
		 2. Subject-code: It must be 6-7 Alphanumeric characters. The first 3 are Alphabetic
		    followed by 3 numeric characters. The sevens should be s if exists.
		 
		 3. Full mark: It is a numeric number of the value: 100
		
		 4. Student name: It must be Alphabetic characters and Spaces. the name should not start with space.
		
		 5. Student number: 8 Alphanumeric characters. It should start with numbers and might End with only one Alphabetic character
		
		 6. Student Activities mark: It is an integer of a value from 0 up to 10 of the full mark
		
		 7. Oral/Practical mark: It is an integer of a value from 0 up to 10 of the full mark
		
		 8. Midterm exam mark: It is an integer of a value from 0 up to 20 of the full mark
		
		 9. Final exam mark: It is an integer of a value from 0 up to 60 of the full mark
	
	 Classes and its member Functions
	 ------------------------------------------
		SubjectChecker class
			public static boolean checkSubjectName(String subjectName)                    requirement 1  done   
			public static boolean checkSubjectCode(String subjectCode)                    requirement 2  done
			public static boolean checkSubjectFullMark(int fullMark)                      requirement 3  done
		
		StudentChecker class
			public static boolean checkStudentName(String studentName)                    requirement 4  done
			public static boolean checkStudentNumber(String studentNumber)                requirement 5  done
		    public static boolean checkStudentActivitiesMark(int activitiesMark)          requirement 6  done
		    public static boolean checkStudentOralPracticalMark(int oralPracticalMark)    requirement 7  done
		    public static boolean checkStudentMidtermExamMark(int midtermExamMark)        requirement 8  done
		    public static boolean checkStudentFinalExamMark(int finalExamMark)            requirement 9  done
		
		StudentGradingChecker class 
			public static boolean checkFileContent(String fileContent)                    requirement 1-9 done  

*/


public class StudentGradingCheckerTester 
{
	private MockedStatic<SubjectChecker> staticClassMockedStatic1;
	private MockedStatic<StudentChecker> staticClassMockedStatic2;
	
	@Before
	public void setup()
	{
		staticClassMockedStatic1 = Mockito.mockStatic(SubjectChecker.class);
    	staticClassMockedStatic2 = Mockito.mockStatic(StudentChecker.class);
    	
    	staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectName("Modern Physics")).thenReturn(true);
    	staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectName("Quantum Computing")).thenReturn(true);
    	staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectName("Linear Algera")).thenReturn(true);

        staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectCode("CSE123")).thenReturn(true);
        staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectCode("CSE512")).thenReturn(true);
        staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectCode("PHM104s")).thenReturn(true);
        staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectCode("ASU123")).thenReturn(true);
        
        staticClassMockedStatic1.when(() -> SubjectChecker.checkSubjectFullMark(100)).thenReturn(true);
        
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentName("Ahmed Mahmoud")).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentName("Mazen Ehab")).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentName("Mohamed Mostafa")).thenReturn(true);
        
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentNumber("1901143a")).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentNumber("1901120a")).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentNumber("1900169a")).thenReturn(true);
        
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentActivitiesMark(0)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentActivitiesMark(5)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentActivitiesMark(10)).thenReturn(true);
        
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentOralPracticalMark(0)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentOralPracticalMark(5)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentOralPracticalMark(10)).thenReturn(true);
        
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentMidtermExamMark(5)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentMidtermExamMark(10)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentMidtermExamMark(15)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentMidtermExamMark(20)).thenReturn(true);
        
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentFinalExamMark(50)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentFinalExamMark(55)).thenReturn(true);
        staticClassMockedStatic2.when(() -> StudentChecker.checkStudentFinalExamMark(60)).thenReturn(true);
	}
	
	@After
	public void tearDown()
	{
        staticClassMockedStatic1.close();
        staticClassMockedStatic2.close();    
	}
	
	
	/******************************** Testing checkFileContent (requirement 1-9) **********************

	test  1:  testing invalid input -->  empty input
	
	test  2:  testing invalid input -->  containing one line only
	
    test  3:  testing valid input   -->  Modern Physics,CSE512,100\r\n
							             Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							         
	test  4:  testing invalid input -->  student name starting with space
										 Modern Physics,CSE512,100\r\n
							              Mahmoud,1901143a,0,10,15,55\r\n
	
 	test  5:  testing invalid input -->  student code starting with space
 										 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud, 1901143a,0,10,15,55\r\n
     									 
    test  6:  testing invalid input -->  activities mark is below the lower boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,-2,10,15,55\r\n
     									 
    test  7:  testing invalid input -->  activities mark is above the upper boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,11,10,15,55\r\n
     									 	
    test  8:  testing invalid input -->  oral/pactical mark is below the lower boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,-2,15,55\r\n 									 									 									
     									 									 									
    test  9:  testing invalid input -->  activities mark is above the upper boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,15,15,55\r\n 		
     									 
    test 10:  testing invalid input -->  midterm mark is below the lower boundary
    								     Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,10,-2,55\r\n 

    test 11:  testing invalid input -->  midterm mark is above the upper boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,10,22,55\r\n 
    
    test 12:  testing invalid input -->  final mark is below the lower boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,10,15,-2\r\n 
   
    test 13:  testing invalid input -->  final mark is above the upper boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,10,22,60\r\n 
         								      			     									      									  									   									 									 									   
    test 14:  testing invalid input -->  final mark is above the upper boundary
    									 Modern Physics,CSE512,100\r\n
     									 Ahmed Mahmoud,1901143a,0,10,15,65\r\n 
     									 
    test 15:  testing valid input   -->  Modern Physics,CSE512,100\r\n
							             Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
							           
    test 16:  testing valid input   -->  Linear Algera,PHM104s,100\r\n
										 Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
							             Mohamed Mostafa,1900169a,10,0,5,55\r\n
				
	test 17:  testing valid input   -->  Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,10,0,5,55\r\n   
	
	test 18:  testing invalid input -->  student name starting with space in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                  Mohamed Mostafa,1900169a,10,0,5,55\r\n   						                          
 
	test 19:  testing invalid input -->  student code starting with space in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa, 1900169a,10,0,5,55\r\n 

	test 20:  testing invalid input -->  activities mark is below the lower boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,-2,0,5,55\r\n 	

	test 21:  testing invalid input -->  activities mark is above the upper boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,12,0,5,55\r\n 

	test 22:  testing invalid input -->  oral/practical mark is below the lower boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,10,-2,5,55\r\n 	

	test 23:  testing invalid input -->  oral/practical mark is above the upper boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,10,12,5,55\r\n 

	test 24:  testing invalid input -->  midterm mark is below the lower boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,10,0,-2,55\r\n 	

	test 25:  testing invalid input -->  midterm mark is above the upper boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa,1900169a,10,0,22,55\r\n 

	test 26:  testing invalid input -->  midterm mark is below the lower boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa, 1900169a,10,0,5,-2\r\n 	

	test 27:  testing invalid input -->  final mark is above the upper boundary in line of last student
										 Quantum Computing,CSE123,100\r\n
									     Ahmed Mahmoud,1901143a,0,10,15,55\r\n
							             Mazen Ehab,1901120a,5,5,20,55\r\n
						                 Mohamed Mostafa, 1900169a,10,0,5,65\r\n 
						                 
	**************************************************************************************************/
	
	@Test
    public void checkFileContent_Test1() 
	{                   
		String content = "";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test2() 
	{
		String content = "Quantum Computing,CSE123,100\r\n";

		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test3() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertTrue(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test4() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + " Mahmoud,1901143a,0,10,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test5() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud, 1901143a,0,10,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test6() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,-2,10,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test7() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,11,10,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test8() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,-2,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test9() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,15,15,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test10() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,-2,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test11() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,22,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test12() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,15,-2\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test13() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,15,65\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test14() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
                       + "Mazen Ehab,1901120a,5,5,20,55\r\n";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertTrue(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test15() 
	{                   
		String content = "Modern Physics,CSE512,100\r\n"
                       + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
                       + "Mazen Ehab,1901120a,5,5,20,55\r\n"
                       + "Mohamed Mostafa,1900169a,10,0,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertTrue(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test16() 
	{
		String content = "Linear Algera,PHM104s,100\r\n"
					   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
		               + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,0,5,55";
	 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertTrue(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test17() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,0,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertTrue(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test18() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + " Mohamed Mostafa,1900169a,10,0,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test19() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				       + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
	                   + "Mazen Ehab,1901120a,5,5,20,55\r\n"
                       + "Mohamed Mostafa, 1900169a,10,0,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test20() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,-2,0,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test21() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,12,0,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test22() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,-2,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test23() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,12,5,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test24() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,0,-2,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test25() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,0,22,55";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test26() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,0,5,-2";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
	
	@Test
    public void checkFileContent_Test27() 
	{
		String content = "Quantum Computing,CSE123,100\r\n"
				   	   + "Ahmed Mahmoud,1901143a,0,10,15,55\r\n"
			           + "Mazen Ehab,1901120a,5,5,20,55\r\n"
		               + "Mohamed Mostafa,1900169a,10,0,5,65";
 
		 boolean actual = StudentGradingChecker.checkFileContent(content);
		 assertFalse(actual);    	 
	}
}