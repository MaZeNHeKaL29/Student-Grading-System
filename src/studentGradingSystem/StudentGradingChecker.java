package studentGradingSystem;

public class StudentGradingChecker 
{
	public static boolean checkFileContent(String fileContent)
	{
		String[] lines = fileContent.split("\n");
		
		//check first line
		int i = 0;
		
		
		//check subject name
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
        if(!checkSubjectName(subjectName))
        {
        	System.out.println("Error in Input File. Subject Name is Invalid");
        	return false;
        }
        
        
        //check Subject Code
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
        if(!checkSubjectCode(subjectCode))
        {
        	System.out.println("Error in Input File. Subject Code is Invalid");
        	return false;
        }
        
        //check Subject Full Mark
        String SubjectFullMark = "";
        for (; i < lines[0].length(); i++)
        {
            char c = lines[0].charAt(i);
            if(c == ',')
            {
            	System.out.println("Error in Input File. First Line has more than 3 inputs");
            	return false;
            }
            else if(c == ' ')
            {
            	System.out.println("Error in Input File. Subject Full Mark has invalid spaces");
            	return false;
            }
            else if(!(c >= '0' && c <= '9'))
            {
            	System.out.println("Error in Input File. Subject Full Mark has invalid characters");
            	return false;
            }
            else
            {
            	SubjectFullMark = SubjectFullMark + c;
            }
        }
        int SubjectFullMarkInt = Integer.parseInt(SubjectFullMark);
        if(!checkSubjectFullMark(SubjectFullMarkInt))
        {
        	System.out.println("Error in Input File. Subject Full Mark is Invalid");
        	return false;
        }
        
        for(int j = 1; j < lines.length; j++)
        {
        	//check line
    		i = 0;
    		
    		
    		//check student name
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
            if(!checkStudentName(studentName))
            {
            	System.out.println("Error in Input File. Student Name is Invalid");
            	return false;
            }
            
            
            //check Student Number
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
            if(!checkStudentNumber(studentNumber))
            {
            	System.out.println("Error in Input File. Student Number is Invalid");
            	return false;
            }
            
            //check Student Activities Mark
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
            if(!checkStudentActivitiesMark(StudentActivitiesMarkInt))
            {
            	System.out.println("Error in Input File. Student Activities Mark is Invalid");
            	return false;
            }
            
            
            //check Student Oral/Practical Mark
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
            if(!checkStudentOralPracticalMark(StudentOralPracticalMarkInt))
            {
            	System.out.println("Error in Input File. Student Oral/Practical Mark is Invalid");
            	return false;
            }
            
            //check Student Midterm Exam Mark
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
            if(!checkStudentMidtermExamMark(StudentMidtermExamMarkInt))
            {
            	System.out.println("Error in Input File. Student Midterm Exam Mark is Invalid");
            	return false;
            }
            
          //check Student Final Exam Mark
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
            if(!checkStudentFinalExamMark(StudentFinalExamMarkInt))
            {
            	System.out.println("Error in Input File. Student Final Exam Mark is Invalid");
            	return false;
            }
            
        }
		
		
		return true;
	}
	
	public static boolean checkSubjectName(String subjectName)
    {
        // Check if the subject name is not null or empty
        if (subjectName == null || subjectName.isEmpty()) 
        {
        	System.out.println("Subject Name is empty");
            return false;
        }
        
        // Check if the subject name starts with a space
        if (subjectName.startsWith(" ")) 
        {
        	System.out.println("Subject Name starts with space");
            return false;
        }
        
        // Check if the subject name contains only alphabetic characters and spaces
        for (char c : subjectName.toCharArray()) 
        {
            if (!Character.isLetter(c) && c != ' ')
            {
            	System.out.println("Subject Name contains invalid characters");
                return false;
            }
        }
        
        // Subject name meets all criteria
        return true;
    }
	
	public static boolean checkSubjectCode(String subjectCode)
    {
        // Check if the subject code is not null and has correct length
        if (subjectCode == null || subjectCode.length() < 6 || subjectCode.length() > 7) 
        {
        	System.out.println("Subject Code Length is Invalid");
            return false;
        }
        
        // Check the first 3 characters are alphabetic
        for (int i = 0; i < 3; i++) 
        {
            if (!Character.isLetter(subjectCode.charAt(i))) 
            {
            	System.out.println("First 3 characters of Subject Code are not alphabetic");
                return false;
            }
        }
        
        // Check the next 3 characters are numeric
        for (int i = 3; i < 6; i++) 
        {
            if (!Character.isDigit(subjectCode.charAt(i))) 
            {
            	System.out.println("Next 3 characters of Subject Code are not numeric");
                return false;
            }
        }
        
        // If the subject code has 7 characters, the last one should be 's'
        if (subjectCode.length() == 7 && subjectCode.charAt(6) != 's') 
        {
        	System.out.println("Subject Code has length of 7 but does not end with \'s\'");
            return false;
        }
        
        // Subject code meets all criteria
        return true;
    }
	
	// Function to validate Subject Full Mark
    public static boolean checkSubjectFullMark(int fullMark)
    {
        return fullMark == 100;
    }
	
	
	public static boolean checkStudentName(String studentName)
    {
        // Check if the student name is not null or empty
        if (studentName == null || studentName.isEmpty()) 
        {
        	System.out.println("Student Name is empty");
            return false;
        }
        
        // Check if the student name starts with a space
        if (studentName.startsWith(" ")) 
        {
        	System.out.println("Student Name starts with space");
            return false;
        }
        
        // Check if the student name contains only alphabetic characters and spaces
        for (char c : studentName.toCharArray()) 
        {
            if (!Character.isLetter(c) && c != ' ') 
            {
            	System.out.println("Student Name contains invalid characters");
                return false;
            }
        }
        
        // Student name meets all criteria
        return true;
    }
	
	public static boolean checkStudentNumber(String studentNumber)
    {
        // Check if the student number is not null and has correct length
        if (studentNumber == null || studentNumber.length() != 8) 
        {
        	System.out.println("Student Number Length is Invalid");
            return false;
        }
        
        // Check if the first character is numeric
        if (!Character.isDigit(studentNumber.charAt(0))) 
        {
        	System.out.println("Student Number does not start with a number");
            return false;
        }
        
        // Check if the rest of the characters are numeric except last one
        for (int i = 1; i < 7; i++) {
            if (!Character.isDigit(studentNumber.charAt(i))) 
            {
            	System.out.println("Student Number has invalid characters");
                return false;
            }
        }
        
        // If the length is 8, check if the last character is alphabetic or number
        if (studentNumber.length() == 8 && !Character.isLetterOrDigit(studentNumber.charAt(7))) 
        {
        	System.out.println("Student Number does not end with an alphabet or a number");
            return false;
        }
        
        // Student number meets all criteria
        return true;
    }
	
	// Function to validate Student Activities mark
    public static boolean checkStudentActivitiesMark(int activitiesMark)
    {
        return activitiesMark >= 0 && activitiesMark <= 10;
    }
    
    // Function to validate Oral/Practical mark
    public static boolean checkStudentOralPracticalMark(int oralPracticalMark)
    {
        return oralPracticalMark >= 0 && oralPracticalMark <= 10;
    }
    
    // Function to validate Midterm exam mark
    public static boolean checkStudentMidtermExamMark(int midtermExamMark)
    {
        return midtermExamMark >= 0 && midtermExamMark <= 20;
    }
    
    // Function to validate Final exam mark
    public static boolean checkStudentFinalExamMark(int finalExamMark)
    {
        return finalExamMark >= 0 && finalExamMark <= 60;
    }
	
}
