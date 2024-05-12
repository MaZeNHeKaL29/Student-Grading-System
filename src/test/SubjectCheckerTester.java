package test;

import studentGradingSystem.*;

import static org.junit.Assert.*;
import org.junit.*;

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
		public static boolean checkSubjectName(String subjectName)   requirement 1   done
		public static boolean checkSubjectCode(String subjectCode)   requirement 2   done
		public static boolean checkSubjectFullMark(int fullMark)     requirement 3   done
*/



public class SubjectCheckerTester
{

	/******************************** Testing checkSubjectName (requirement 1) *************************************
	
	test 1 :  testing invalid input --> empty input
    test 2 :  testing valid input   --> containg only Alphabetic characters and space and not starting with space 
    test 3 :  testing invalid input --> containing numbers
    test 4 :  testing invalid input --> starting with space
    test 5 :  testing invalid input --> containing special characters at the middle
    test 6 :  testing invalid input --> containing special characters at the middle
    test 7 :  testing invalid input --> containing special characters at the middle
    test 8 :  testing invalid input --> containing special characters at the middle
    test 9 :  testing invalid input --> not containing at least one space after first character
    
	****************************************************************************************************************/
	
	@Test
	public void checkSubjectName_Test1() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectName_Test2() 
	{
		boolean actual = SubjectChecker.checkSubjectName("Mathematics");
		//boolean actual = SubjectChecker.checkSubjectName("linear algebra");
	    assertTrue(actual);
	}
	
	
	@Test
	public void checkSubjectName_Test3() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("math 123");
	    assertFalse(actual);
	}

	@Test
	public void checkSubjectName_Test4() 
	{
	    boolean actual = SubjectChecker.checkSubjectName(" linear algebra");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectName_Test5() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("@linear algebra");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectName_Test6() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("linear@algebra");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectName_Test7() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("linear algebra@");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectName_Test8() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("     ");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectName_Test9() 
	{
	    boolean actual = SubjectChecker.checkSubjectName("Mathematics");
	    //assertFalse(actual);
	}	
	
	@Test
	public void checkSubjectName_Test10() 
	{
	    boolean actual = SubjectChecker.checkSubjectName(null);
	    //assertFalse(actual);
	}	
	
	
	/************************************** Testing checkSubjectCode (requirement 2) ******************************************
	
	test 1  :  testing invalid input --> empty input
	test 2  :  testing valid input   --> 3 Alphabetic characters followed by 3 numeric characters 
    test 3  :  testing valid input   --> 3 Alphabetic characters followed by 3 numeric characters  followed by 's'
    test 4  :  testing invalid input --> 3 numeric characters followed by 3 Alphabetic characters 
    test 5  :  testing invalid input --> less than 3 Alphabetic characters followed by 3 numeric characters 
    test 6  :  testing invalid input --> 3 Alphabetic characters followed by less than 3 numeric characters 
    test 7  :  testing invalid input --> more than 3 Alphabetic characters followed by 3 numeric characters 
    test 8  :  testing invalid input --> 3 Alphabetic characters followed by more than 3 numeric characters 
    test 9  :  testing invalid input --> all characters are numeric
    test 10 :  testing invalid input --> all characters are Alphabetic
    test 11 :  testing invalid input --> 3 Alphabetic characters followed by less than 3 numeric characters followed by 's'
    test 12 :  testing invalid input --> less than 3 Alphabetic characters followed by 3 numeric characters followed by 's'
    test 12 :  testing invalid input --> containing special character in the last 3 characters
    test 13 :  testing invalid input --> containing special character in the first 3 characters
    
	**************************************************************************************************************************/
	
	@Test
	public void checkSubjectCode_Test1() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test2() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABC123");
	    assertTrue(actual);
	}
	
	@Test
	public void checkSubjectCode_Test3() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("XYZ456s");
	    assertTrue(actual);
	}
	
	@Test
	public void checkSubjectCode_Test4() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("123ABC");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test5() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("AB123");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test6() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABC12");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test7() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABCD123");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test8() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABC1234");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test9() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("123456");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test10() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABCDEF");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test11() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABC12s");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test12() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("AB123s");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test13() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("ABC$12");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test14() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("AB$123");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test15() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode("AB$123sssss");
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectCode_Test16() 
	{
	    boolean actual = SubjectChecker.checkSubjectCode(null);
	    //assertFalse(actual);
	}	
	
	
	
	/************** Testing checkSubjectFullMark (requirement 3) ******************
	 
	test 1 :  testing invalid input --> less than 100
    test 2 :  testing valid input   --> 100
    test 3 :  testing invalid input --> less than 100
	
	*******************************************************************************/
	
	@Test
	public void checkSubjectFullMark_Test1() 
	{
	    boolean actual = SubjectChecker.checkSubjectFullMark(50);
	    assertFalse(actual);
	}
	
	@Test
	public void checkSubjectFullMark_Test2() 
	{
	    boolean actual = SubjectChecker.checkSubjectFullMark(100);
	    assertTrue(actual);
	}
	
	@Test
	public void checkSubjectFullMark_Test3() 
	{
	    boolean actual = SubjectChecker.checkSubjectFullMark(150);
	    assertFalse(actual);
	}
}
