package studentGradingSystem;

public class GradeCalculator
{
	
	public static String calculateGrade(int mark)
	{
		if (mark >= 97 && mark < 100)
		{
		    return "A+";
		} else if (mark >= 93 && mark < 97)
		{
		    return "A";
		} else if (mark >= 89 && mark < 93)
		{
		    return "A-";
		} else if (mark >= 84 && mark < 89) 
		{
		    return "B+";
		} else if (mark >= 80 && mark < 84) 
		{
		    return "B";
		} else if (mark >= 76 && mark < 80) 
		{
		    return "B-";
		} else if (mark >= 73 && mark < 76) 
		{
		    return "C+";
		} else if (mark >= 70 && mark < 73) 
		{
		    return "C";
		} else if (mark >= 67 && mark < 70) 
		{
		    return "C-";
		} else if (mark >= 64 && mark < 67) 
		{
		    return "D+";
		} else if (mark >= 60 && mark < 64) 
		{
		    return "D";
		} else 
		{
		    return "F";
		}

	}

}
