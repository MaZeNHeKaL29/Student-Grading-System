package studentGradingSystem;


public class StudentGradingChecker 
{
	public static boolean checkFileContent(String fileContent)
	{
		String[] lines = fileContent.split("\n");
				
		// check file length
		if (lines.length == 1) 
		{
			if(lines[0] != "")  // file contain one file
			{
				System.out.println("The file content contains only one line.");
			}
			else	// file is empty 
			{
				System.out.println("The file is empty.");
			}
			return false;
		}

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
        
        if(!SubjectChecker.checkSubjectName(subjectName))
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
        if(!SubjectChecker.checkSubjectCode(subjectCode))
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
            else if(c == 13 || c == 10) break;
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
        if(!SubjectChecker.checkSubjectFullMark(SubjectFullMarkInt))
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
            if(!StudentChecker.checkStudentName(studentName))
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
            if(!StudentChecker.checkStudentNumber(studentNumber))
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
            if(!StudentChecker.checkStudentActivitiesMark(StudentActivitiesMarkInt))
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
            
            if(!StudentChecker.checkStudentOralPracticalMark(StudentOralPracticalMarkInt))
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
            if(!StudentChecker.checkStudentMidtermExamMark(StudentMidtermExamMarkInt))
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
                else if(c == 13 || c == 10) break;
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
            if(!StudentChecker.checkStudentFinalExamMark(StudentFinalExamMarkInt))
            {
            	System.out.println("Error in Input File. Student Final Exam Mark is Invalid");
            	return false;
            }    
        }
		
		
		return true;
	}

}
