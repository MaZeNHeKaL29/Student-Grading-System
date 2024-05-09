package test;

import studentGradingSystem.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

public class ApplicationTester {
	
	StudentGradingFileProcessor studentGradingFileProcessor;
	
	private static String readFile(String filePath)
    {        
        try
        {
            File file = new File(filePath);
        	
        	FileReader fileReader = new FileReader(file);
            
            BufferedReader br = new BufferedReader(fileReader);
            
            String fileContent = "";
            
            String line;
            while ((line = br.readLine()) != null)
            {
                fileContent = fileContent + line + "\n";
            }
            
            System.out.println(fileContent);
            return fileContent;
        }
        catch(IOException e)
        {
           System.out.println("Exception: " + e);
           
           return "Exception: " + e;
        }
    }

	@Test
	public void ApplicationTest1()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest2()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest3()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest4()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest5()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest6()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest7()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest8()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest9()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest10()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest11()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest12()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "Student Grading Output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	
	@Test
	public void ApplicationTest13()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest14()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest115()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest16()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest17()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest18()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest19()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest20()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest21()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest22()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void ApplicationTest23()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void ApplicationTest24()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = "output.txt";
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
}
