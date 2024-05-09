package test;

import studentGradingSystem.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

public class StudentGradingManagerTester {
	@Test
	public void StudentGradingManagerTest1() 
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mazen,1999999p,10,10,0,5");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mazen\t1999999p\t0.0\tF\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest2()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Ahmed,1999999a,10,10,20,55");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Ahmed\t1999999a\t4.0\tA\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest3()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mohamed,1999999b,10,10,20,60");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mohamed\t1999999b\t4.0\tA+\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest4()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Andrew,1999999v,10,10,10,55");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Andrew\t1999999v\t3.3\tB+\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest5()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Abdullah,1999999d,10,10,10,50");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Abdullah\t1999999d\t3.0\tB\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest6()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mostafa,1999999e,5,10,10,54");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mostafa\t1999999e\t2.7\tB-\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest7()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mostafa,1999999p,5,10,10,50");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mostafa\t1999999p\t2.3\tC+\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest8()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mohamed,1999999p,5,10,10,45");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mohamed\t1999999p\t2.0\tC\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest9()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mohamed,1999999p,5,10,10,40");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mohamed\t1999999p\t1.3\tD+\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest10()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mohamed,1999999p,5,10,5,40");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mohamed\t1999999p\t1.0\tD\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest11()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Mazen,1999999p,10,10,0,5\r\n"
				+ "Ahmed,1999999a,10,10,20,55\r\n"
				+ "Mohamed,1999999b,10,10,20,60\r\n"
				+ "Andrew,1999999c,10,10,10,55\r\n"
				+ "Abdullah,1999999d,10,10,10,50\r\n"
				+ "Mostafa,1999999e,5,10,10,54\r\n");
		
		String Expected = "Subject Name: Math Max Mark: 100\n"
				+ "Student Name\tStudent Number\tGPA\tGrade\t\n"
				+ "Mazen\t1999999p\t0.0\tF\n"
				+ "Ahmed\t1999999a\t4.0\tA\n"
				+ "Mohamed\t1999999b\t4.0\tA+\n"
				+ "Andrew\t1999999c\t3.3\tB+\n"
				+ "Abdullah\t1999999d\t3.0\tB\n"
				+ "Mostafa\t1999999e\t2.7\tB-\n";
		
		assertEquals(Expected.trim(),SGM.GetStudentGradingOutput().trim());
	}
	
	@Test
	public void StudentGradingManagerTest12()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		boolean Actual = SGM.manageStudentGrading("Math,,100\r\n"
				+ "Andrew,1999999p,10,10,0,5\r\n");
		
		boolean Expected = false;
		
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void StudentGradingManagerTest13()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		boolean Actual = SGM.manageStudentGrading("Math,PHM333,10\r\n"
				+ "Andrew,1999999p,10,10,0,5\r\n");
		
		boolean Expected = false;
		
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void StudentGradingManagerTest14()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		boolean Actual = SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Andrew,,10,10,0,5\r\n");
		
		boolean Expected = false;
		
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void StudentGradingManagerTest15()
	{
		StudentGradingManager SGM = new StudentGradingManager();
		
		boolean Actual = SGM.manageStudentGrading("Math,PHM333,100\r\n"
				+ "Andrew,1999999p,10,10,0,5\r\n");
		
		boolean Expected = true;
		
		assertEquals(Expected,Actual);
	}
}
