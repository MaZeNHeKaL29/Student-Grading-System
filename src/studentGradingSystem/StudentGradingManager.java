package studentGradingSystem;

import java.util.*;

public class StudentGradingManager 
{
	
	private String StudentGradingOutput;
	
	StudentGradingManager()
	{
		StudentGradingOutput = "";
	}

	
	public boolean manageStudentGrading(String fileContent)
	{
		if(!StudentGradingChecker.checkFileContent(fileContent))
		{
			return false;
		}
		
		String[] lines = fileContent.split("\n");
		
		int i = 0;
		
		String subjectName = "";
        for (i = 0; i < lines[0].length(); i++)
        {
            char c = lines[0].charAt(i);
            if(c == ',')
            {
            	i++;
            	break;
            }
            else
            {
            	subjectName = subjectName + c;
            }
        }
        
        String subjectCode = "";
        for (; i < lines[0].length(); i++)
        {
            char c = lines[0].charAt(i);
            if(c == ',')
            {
            	i++;
            	break;
            }
            else
            {
            	subjectCode = subjectCode + c;
            }
        }
        
        Subject subject = new Subject(subjectName,subjectCode);
        
        
        for(int j = 1; j < lines.length; j++)
        {
    		i = 0;
    		
    		//Student Name
    		String studentName = "";
            for (i = 0; i < lines[j].length(); i++)
            {
                char c = lines[j].charAt(i);
                if(c == ',')
                {
                	i++;
                	break;
                }
                else
                {
                	studentName = studentName + c;
                }
            }
            
            
            //Student Number
            String studentNumber = "";
            for (; i < lines[j].length(); i++)
            {
                char c = lines[j].charAt(i);
                if(c == ',')
                {
                	i++;
                	break;
                }
                else
                {
                	studentNumber = studentNumber + c;
                }
            }
            
            //Student Activities Mark
            String StudentActivitiesMark = "";
            for (; i < lines[j].length(); i++)
            {
                char c = lines[j].charAt(i);
                if(c == ',')
                {
                	i++;
                	break;
                }
                else if(c == ' ')
                {
                	System.out.println("Error in Input File. Student Activities Mark has invalid spaces");
                	return false;
                }
                else if(!(c >= '0' && c <= '9'))
                {
                	System.out.println("Error in Input File. Student Activities Mark has invalid characters");
                	return false;
                }
                else
                {
                	StudentActivitiesMark = StudentActivitiesMark + c;
                }
            }
            int StudentActivitiesMarkInt = Integer.parseInt(StudentActivitiesMark);
            
            
            
            //Student Oral/Practical Mark
            String StudentOralPracticalMark = "";
            for (; i < lines[j].length(); i++)
            {
                char c = lines[j].charAt(i);
                if(c == ',')
                {
                	i++;
                	break;
                }
                else if(c == ' ')
                {
                	System.out.println("Error in Input File. Student Oral/Practical Mark has invalid spaces");
                	return false;
                }
                else if(!(c >= '0' && c <= '9'))
                {
                	System.out.println("Error in Input File. Student Oral/Practical Mark has invalid characters");
                	return false;
                }
                else
                {
                	StudentOralPracticalMark = StudentOralPracticalMark + c;
                }
            }
            int StudentOralPracticalMarkInt = Integer.parseInt(StudentOralPracticalMark);
            
            
            //Student Midterm Exam Mark
            String StudentMidtermExamMark = "";
            for (; i < lines[j].length(); i++)
            {
                char c = lines[j].charAt(i);
                if(c == ',')
                {
                	i++;
                	break;
                }
                else if(c == ' ')
                {
                	System.out.println("Error in Input File. Student Midterm Exam Mark has invalid spaces");
                	return false;
                }
                else if(!(c >= '0' && c <= '9'))
                {
                	System.out.println("Error in Input File. Student Midterm Exam Mark has invalid characters");
                	return false;
                }
                else
                {
                	StudentMidtermExamMark = StudentMidtermExamMark + c;
                }
            }
            int StudentMidtermExamMarkInt = Integer.parseInt(StudentMidtermExamMark);
            
            
            //Student Final Exam Mark
            String StudentFinalExamMark = "";
            for (; i < lines[j].length(); i++)
            {
                char c = lines[j].charAt(i);
                if(c == ',')
                {
                	System.out.println("Error in Input File. Line has more than inputs than expected");
                	return false;
                }
                else if(c == ' ')
                {
                	System.out.println("Error in Input File. Student Final Exam Mark has invalid spaces");
                	return false;
                }
                else if(!(c >= '0' && c <= '9'))
                {
                	System.out.println("Error in Input File. Student Final Exam Mark has invalid characters");
                	return false;
                }
                else
                {
                	StudentFinalExamMark = StudentFinalExamMark + c;
                }
            }
            int StudentFinalExamMarkInt = Integer.parseInt(StudentFinalExamMark);
            
            
            subject.AddStudent(new Student(studentName,studentNumber,StudentActivitiesMarkInt, StudentOralPracticalMarkInt, StudentMidtermExamMarkInt, StudentFinalExamMarkInt));
            
        }
		
        StudentGradingOutput = "Subject Name: " + subject.GetSubjectName() + " Max Mark: 100\n";
        
        StudentGradingOutput += "Student Name\t" + "Student Number\t" + "GPA\t" + "Grade\t\n";
        
        Vector<Student> students = subject.GetStudents();
        
        for(int j = 0; j < students.size(); j++)
        {
        	Student s = students.elementAt(j);
        	
        	StudentGradingOutput += s.GetStudentName() + "\t" + s.GetStudentNumber() + "\t" + s.GetGPA() + "\t" + s.GetGrade() + "\n";
        }
        
        System.out.println(StudentGradingOutput);
        
		
		return true;
	}
	
	
	public String GetStudentGradingOutput()
	{
		return StudentGradingOutput;
	}
	
	
}
