package studentGradingSystem;

public class GPACalculator
{
	
	public static double calculateGPA(int mark)
	{
		if (mark >= 97 && mark < 100) 
		{
		    return 4.0;
		} else if (mark >= 93 && mark < 97) 
		{
		    return 4.0;
		} else if (mark >= 89 && mark < 93) 
		{
		    return 3.7;
		} else if (mark >= 84 && mark < 89) 
		{
		    return 3.3;
		} else if (mark >= 80 && mark < 84) 
		{
		    return 3.0;
		} else if (mark >= 76 && mark < 80) 
		{
		    return 2.7;
		} else if (mark >= 73 && mark < 76) 
		{
		    return 2.3;
		} else if (mark >= 70 && mark < 73) 
		{
		    return 2.0;
		} else if (mark >= 67 && mark < 70) 
		{
		    return 1.7;
		} else if (mark >= 64 && mark < 67) 
		{
		    return 1.3;
		} else if (mark >= 60 && mark < 64) 
		{
		    return 1.0;
		} else 
		{
		    return 0.0;
		}

	}
	
}
