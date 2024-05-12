package studentGradingSystem;

public class StudentChecker 
{

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
        if (!Character.isLetterOrDigit(studentNumber.charAt(7))) 
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
