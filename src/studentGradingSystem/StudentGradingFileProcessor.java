package studentGradingSystem;

public class StudentGradingFileProcessor
{
	
	private FileReaderHandler fileReaderHandler;
	
	private FileWriterHandler fileWriterHandler;
	
	private StudentGradingManager studentGradingManager;
	
	
	public StudentGradingFileProcessor(String filePath)
	{
		fileReaderHandler = new FileReaderHandler(filePath);
		
		fileWriterHandler = new FileWriterHandler("Student Grading Output.txt");
		
		studentGradingManager = new StudentGradingManager();
	}
	
	
	public StudentGradingFileProcessor(FileReaderHandler fileReaderHandler)
	{
		this.fileReaderHandler = fileReaderHandler;
		
		fileWriterHandler = new FileWriterHandler("Student Grading Output.txt");
		
		studentGradingManager = new StudentGradingManager();
	}
	
	public StudentGradingFileProcessor(String filePath, String fileOutputName)
	{
		fileReaderHandler = new FileReaderHandler(filePath);
		
		fileWriterHandler = new FileWriterHandler(fileOutputName);
		
		studentGradingManager = new StudentGradingManager();
	}
	
	public StudentGradingFileProcessor(FileReaderHandler fileReaderHandler, FileWriterHandler fileWriterHandler)
	{
		this.fileReaderHandler = fileReaderHandler;
		
		this.fileWriterHandler = fileWriterHandler;
		
		studentGradingManager = new StudentGradingManager();
	}
	
	public void changeFilePath(String filePath)
	{
		fileReaderHandler = new FileReaderHandler(filePath);
	}
	
	public boolean readFile()
	{
		String fileContent = fileReaderHandler.readFile();
		
		return studentGradingManager.manageStudentGrading(fileContent);
	}
	
	public void writeFile()
	{
		fileWriterHandler.writeFile(studentGradingManager.GetStudentGradingOutput());
	}

}
