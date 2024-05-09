package test;

import studentGradingSystem.*;

import org.junit.*;
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

    Functions to test
    ------------------
    public static boolean checkStudentName(String studentName)                    requirement 4  done
	public static boolean checkStudentNumber(String studentNumber)                requirement 5  done
    public static boolean checkStudentActivitiesMark(int activitiesMark)          requirement 6  done
    public static boolean checkStudentOralPracticalMark(int oralPracticalMark)    requirement 7  done
    public static boolean checkStudentMidtermExamMark(int midtermExamMark)        requirement 8  done
    public static boolean checkStudentFinalExamMark(int finalExamMark)            requirement 9  done
*/


public class StudentCheckerTester 
{
	/******************************** Testing checkStudentName (requirement 4) **********************************

	test 1 :  testing invalid input --> empty input
    test 2 :  testing valid input   --> 8 Alphabetic characters
    test 3 :  testing invalid input --> containing numbers
    test 4 :  testing invalid input --> starting with space
    test 5 :  testing invalid input --> containing special characters at the middle
    test 6 :  testing invalid input --> containing special characters at the middle
    test 7 :  testing invalid input --> containing special characters at the middle
    test 8 :  testing invalid input --> containing special characters at the middle
    test 9 :  testing invalid input --> not containing at least one space after first character
    
	*************************************************************************************************************/

	@Test
	public void checkStudentName_Test1() 
	{
	    boolean actual = StudentChecker.checkStudentName("");
	    assertFalse(actual);
	}
	
	@Test
	public void checkStudentName_Test2() 
	{
	    boolean actual = StudentChecker.checkStudentName("John Doe");
	    assertTrue(actual);
	}

	@Test
	public void checkStudentName_Test3() 
	{
	    boolean actual = StudentChecker.checkStudentName("Jane123a");
	    assertFalse(actual);
	}

	@Test
	public void checkStudentName_Test4() 
	{
	    boolean actual = StudentChecker.checkStudentName(" Jane Doe");
	    assertFalse(actual);
	}
	
	@Test
	public void checkStudentName_Test5() 
	{
	    boolean actual = StudentChecker.checkStudentName("@JohnDoe");
	    assertFalse(actual);
	}
	
	@Test
	public void checkStudentName_Test6() 
	{
	    boolean actual = StudentChecker.checkStudentName("John@Doe");
	    assertFalse(actual);
	}
	
	@Test
	public void checkStudentName_Test7() 
	{
	    boolean actual = StudentChecker.checkStudentName("JohnDoe@");
	    assertFalse(actual);
	}
	
	@Test
	public void checkStudentName_Test8() 
	{
	    boolean actual = StudentChecker.checkStudentName("     ");
	    assertFalse(actual);
	}
	
	@Test
	public void checkStudentName_Test9() 
	{
	    boolean actual = StudentChecker.checkStudentName("JohnDoe");
	    assertTrue(actual);
	}
	
	
	/******************************** Testing checkStudentNumber (requirement 5) *********************************
	
    test 1 :  testing invalid input --> empty input
    test 2 :  testing invalid input --> containing special character which is empty space at the start
    test 3 :  testing invalid input --> testing containing special character which is empty space at the middle
    test 4 :  testing invalid input --> testing containing special character which is empty space at the end
    test 5 :  testing valid input   --> 8 numbers
    test 6 :  testing valid input   --> 7 numbers followed by  alphabetic character
    test 7 :  testing invalid input --> testing starting with character
    test 8 :  testing invalid input --> testing containing more that 8 characters
    test 9 :  testing invalid input --> testing starting and ending with character
    test10 :  testing invalid input --> testing ending with two alphabetic character
    test11 :  testing invalid input --> testing containing more that 8 characters
    test12 :  testing invalid input --> testing containing alphabetic character before the end

	*************************************************************************************************************/
	
	@Test
	public void checkStudentNumber_Test1()
	{
		boolean actual = StudentChecker.checkStudentNumber("");
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test2()
	{
		boolean actual = StudentChecker.checkStudentNumber(" 190113");
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test3()
	{
		boolean actual = StudentChecker.checkStudentNumber("19 01114");
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test4()
	{
		boolean actual = StudentChecker.checkStudentNumber("1901113 ");
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test5()
	{
		boolean actual = StudentChecker.checkStudentNumber("19011143");
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test6()
	{
		boolean actual = StudentChecker.checkStudentNumber("1901113a");
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test7()
	{
		boolean actual = StudentChecker.checkStudentNumber("A1901114");
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentNumber_Test8()
	{
		boolean actual = StudentChecker.checkStudentNumber("19041113a");
		assertFalse(actual); 		
	}
	
	@Test public void checkStudentNumber_Test9() 
	{
		boolean actual = StudentChecker.checkStudentNumber("A2345678A");
		assertFalse(actual); 
	}

	@Test public void checkStudentNumber_Test10() 
	{
	 	boolean actual = StudentChecker.checkStudentNumber("1234678AB"); 
	 	assertFalse(actual); 
	}

	@Test public void checkStudentNumber_Test11() 
	{
	 	boolean actual = StudentChecker.checkStudentNumber("12345678!"); 
	 	assertFalse(actual); 
	}

	@Test public void checkStudentNumber_Test12() 
	{
	 	boolean actual = StudentChecker.checkStudentNumber("123456A1"); 
	 	assertFalse(actual); 
	}
	
	
	/*********** Testing checkStudentActivitiesMark (requirement 6) *********************
	
    test 1 :  testing valid input   --> lower boundary 
    test 2 :  testing valid input   --> from 0 to 10
    test 3 :  testing valid input   --> from 0 to 10
    test 4 :  testing valid input   --> from 0 to 10
    test 5 :  testing valid input   --> upper boundary
    test 6 :  testing invalid input --> less than lower boundary
    test 7 :  testing invalid input --> greater than upper boundary
	
	*************************************************************************************/
	
	@Test
	public void checkStudentActivitiesMark_Test1()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(0);
		assertTrue(actual); 		
	}
	
	
	@Test
	public void checkStudentActivitiesMark_Test2()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(3);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentActivitiesMark_Test3()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(6);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentActivitiesMark_Test4()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(8);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentActivitiesMark_Test5()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(10);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentActivitiesMark_Test6()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(-2);
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentActivitiesMark_Test7()
	{
		boolean actual = StudentChecker.checkStudentActivitiesMark(11);
		assertFalse(actual); 		
	}
	
	
	/*********** Testing checkStudentOralPracticalMark (requirement 7) ***************
	
    test 1 :  testing valid input   --> lower boundary 
    test 2 :  testing valid input   --> from 0 to 10
    test 3 :  testing valid input   --> from 0 to 10
    test 4 :  testing valid input   --> from 0 to 10
    test 5 :  testing valid input   --> upper boundary
    test 6 :  testing invalid input --> less than lower boundary
    test 7 :  testing invalid input --> greater than upper boundary

    **********************************************************************************/
	@Test
	public void checkStudentOralPracticalMark_Test1()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(0);
		assertTrue(actual); 		
	}
	
	
	@Test
	public void checkStudentOralPracticalMark_Test2()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(3);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentOralPracticalMark_Test3()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(6);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentOralPracticalMark_Test4()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(8);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentOralPracticalMark_Test5()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(10);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentOralPracticalMark_Test6()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(-2);
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentOralPracticalMark_Test7()
	{
		boolean actual = StudentChecker.checkStudentOralPracticalMark(11);
		assertFalse(actual); 		
	}
	
	
	/************* Testing checkStudentMidtermExamMarK (requirement 8) ****************
	
    test 1 :  testing valid input   --> lower boundary 
    test 2 :  testing valid input   --> from 0 to 20
    test 3 :  testing valid input   --> from 0 to 20
    test 4 :  testing valid input   --> from 0 to 20
    test 5 :  testing valid input   --> upper boundary
    test 6 :  testing invalid input --> less than lower boundary
    test 7 :  testing invalid input --> greater than upper boundary
    
	************************************************************************************/
	
	@Test
	public void checkStudentMidtermExamMark_Test1()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(0);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentMidtermExamMark_Test2()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(6);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentMidtermExamMark_Test3()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(10);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentMidtermExamMark_Test4()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(15);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentMidtermExamMark_Test5()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(20);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentOralPracticalMark_Test8()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(-2);
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentMidtermExamMark_Test9()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(21);
		assertFalse(actual); 		
	}
	
	
	/************* Testing checkStudentFinalExamMark (requirement 9) ******************
	
    test 1 :  testing valid input   --> lower boundary which is 0
    test 2 :  testing valid input   --> from 0 to 60
    test 3 :  testing valid input   --> from 0 to 60
    test 4 :  testing valid input   --> from 0 to 60
    test 5 :  testing valid input   --> upper boundary which is 60
    test 6 :  testing invalid input --> less than lower boundary
    test 7 :  testing invalid input --> greater than upper boundary
    
    ***********************************************************************************/
	
	@Test
	public void checkStudentFinalExamMark_Test1()
	{
		boolean actual = StudentChecker.checkStudentFinalExamMark(0);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentFinalExamMark_Test2()
	{
		boolean actual = StudentChecker.checkStudentFinalExamMark(10);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentFinalExamMark_Test3()
	{
		boolean actual = StudentChecker.checkStudentFinalExamMark(30);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentFinalExamMark_Test4()
	{
		boolean actual = StudentChecker.checkStudentFinalExamMark(50);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentFinalExamMark_Test5()
	{
		boolean actual = StudentChecker.checkStudentFinalExamMark(60);
		assertTrue(actual); 		
	}
	
	@Test
	public void checkStudentFinalExamMark_Test6()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(-2);
		assertFalse(actual); 		
	}
	
	@Test
	public void checkStudentFinalExamMark_Test7()
	{
		boolean actual = StudentChecker.checkStudentMidtermExamMark(70);
		assertFalse(actual); 		
	}
}
