package studentGradingSystem;

public class Student
{
	private String StudentName;
	
	private String StudentNumber;
	
	private int    StudentActivitiesMark;
	
	private int    Oral_PracticalMark;
	
	private int    MidtermExamMark;
	
	private int    FinalExamMark;
	
	private int    TotalMarks;
	
	
	public Student(String StudentName, String StudentNumber, int StudentActivitiesMark, int Oral_PracticalMark, int MidtermExamMark, int FinalExamMark)
	{
        this.StudentName = StudentName;
        this.StudentNumber = StudentNumber;
        this.StudentActivitiesMark = StudentActivitiesMark;
        this.Oral_PracticalMark = Oral_PracticalMark;
        this.MidtermExamMark = MidtermExamMark;
        this.FinalExamMark = FinalExamMark;
        this.TotalMarks = StudentActivitiesMark + Oral_PracticalMark + MidtermExamMark + FinalExamMark;
    }
	
	public String GetStudentName()
	{
		return this.StudentName;
	}
	
	public String GetStudentNumber()
	{
		return this.StudentNumber;
	}
	
	public int GetStudentActivitiesMark()
	{
        return this.StudentActivitiesMark;
    }

    public int GetOral_PracticalMark()
    {
        return this.Oral_PracticalMark;
    }

    public int GetMidtermExamMark()
    {
        return this.MidtermExamMark;
    }

    public int GetFinalExamMark()
    {
        return this.FinalExamMark;
    }
    
    public int GetTotalMarks()
    {
    	return this.TotalMarks;
    }
    
    public double GetGPA()
    {
    	return GPACalculator.calculateGPA(this.TotalMarks);
    }
    
    public String GetGrade()
    {
    	return GradeCalculator.calculateGrade(this.TotalMarks);
    }
}

