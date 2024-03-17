package studentGradingSystem;

import java.util.*;

public class Subject
{
	
	private String SubjectName;
	
	private String SubjectCode;
	
	private Vector<Student> students;
	
	public Subject(String SubjectName, String SubjectCode)
	{
		this.SubjectName = SubjectName;
		
		this.SubjectCode = SubjectCode;
		
		students = new Vector<Student>();
	}
	
	public String GetSubjectName()
	{
		return this.SubjectName;
	}
	
	public String GetSubjectCode()
	{
		return this.SubjectCode;
	}
	
	public void AddStudent(Student student)
	{
		students.add(student);
	}
	
	public Vector<Student> GetStudents()
	{
		return this.students;
	}
}
