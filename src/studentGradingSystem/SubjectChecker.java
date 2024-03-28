package studentGradingSystem;

public class SubjectChecker 
{
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
}
