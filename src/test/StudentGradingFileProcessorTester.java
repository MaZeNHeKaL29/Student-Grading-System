package test;

import studentGradingSystem.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentGradingFileProcessorTester 
{
	
	@Mock
	private FileReaderHandler fileReaderHandler;
	
	@Mock
	private FileWriterHandler fileWriterHandler;
	
	@Mock
	private StudentGradingManager studentGradingManager;
	
	
	@InjectMocks
	private StudentGradingFileProcessor studentGradingFileProcessor;
	
	AutoCloseable openMocks;
	
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
	
	@Before
	public void InitBefore()
	{
		fileReaderHandler = mock(FileReaderHandler.class);
		
		fileWriterHandler = mock(FileWriterHandler.class);
		
		studentGradingManager = mock(StudentGradingManager.class);
		
		openMocks = MockitoAnnotations.openMocks(this);
	}
	
	
	@After
	public void CloseAfter()
	{
		
		try 
		{
			openMocks.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectCreation1()
	{		
		assertNotNull(studentGradingFileProcessor);
	}

	@Test
	public void StudentGradingFileProcessorTestObjectCreation2()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("input.txt");
		
		assertNotNull(studentGradingFileProcessor);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectCreation3()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor(fileReaderHandler);
		
		assertNotNull(studentGradingFileProcessor);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectCreation4()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor(fileReaderHandler, fileWriterHandler);
		
		assertNotNull(studentGradingFileProcessor);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectCreation5()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		assertNotNull(studentGradingFileProcessor);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectCreation6()
	{
		studentGradingFileProcessor = null;
		
		assertNull(studentGradingFileProcessor);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual1()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor("input.txt");
		
		assertEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual2()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor(fileReaderHandler);
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor(fileReaderHandler);
		
		assertEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual3()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor(fileReaderHandler, fileWriterHandler);
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor(fileReaderHandler, fileWriterHandler);
		
		assertEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual4()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		assertEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual5()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input1.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor("input.txt");
		
		assertNotEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual6()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input.txt", "output1.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		assertNotEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectEqual7()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input1.txt", "output1.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		assertNotEquals(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	
	@Test
	public void StudentGradingFileProcessorTestObjectSame1()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = studentGradingFileProcessor1;
		
		assertSame(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectSame2()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor(fileReaderHandler);
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = studentGradingFileProcessor1;
		
		assertSame(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectSame3()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor(fileReaderHandler, fileWriterHandler);
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = studentGradingFileProcessor1;
		
		assertSame(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	@Test
	public void StudentGradingFileProcessorTestObjectSame4()
	{
		StudentGradingFileProcessor studentGradingFileProcessor1 = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		StudentGradingFileProcessor studentGradingFileProcessor2 = studentGradingFileProcessor1;
		
		assertSame(studentGradingFileProcessor1, studentGradingFileProcessor2);
	}
	
	
	@Test
	public void StudentGradingFileProcessorTestGetFilePath1()
	{
		Mockito.when(fileReaderHandler.GetFilePath()).thenReturn("input.txt");
		
		String expected = "input.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFilePath());
	}
	
	
	@Test
	public void StudentGradingFileProcessorTestGetFilePath2()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("input.txt");
		
		String expected = "input.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFilePath());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFilePath3()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("input.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		String expected = "input.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFilePath());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFilePath4()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("input.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		String expected = "input.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFilePath());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFilePath5()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		String expected = "input.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFilePath());
	}
	
	
	
	@Test
	public void StudentGradingFileProcessorTestGetFileName1()
	{
		Mockito.when(fileWriterHandler.GetFileName()).thenReturn("output.txt");
		
		String expected = "output.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFileOutputName());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFileName2()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("input.txt");
		
		String expected = "Student Grading Output.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFileOutputName());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFileName3()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("input.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		String expected = "Student Grading Output.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFileOutputName());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFileName4()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("input.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		String expected = "output.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFileOutputName());
	}
	
	@Test
	public void StudentGradingFileProcessorTestGetFileName5()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("input.txt", "output.txt");
		
		String expected = "output.txt";
		
		assertEquals(expected, studentGradingFileProcessor.GetFileOutputName());
	}
	

	
	@Test
	public void StudentGradingFileProcessorTestReadFile1()
	{
		String fileContent = "Math,PHM312,100\r\n" + "Eren,1999999p,10,10,10,55";
		
		Mockito.when(fileReaderHandler.readFile()).thenReturn(fileContent);
		
		Mockito.when(studentGradingManager.manageStudentGrading(Mockito.anyString())).thenReturn(true);
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile2()
	{
		String fileContent = "Math,PHM312,100\r\n" + "Eren,1999999p,10,10,10,55";
		
		Mockito.when(fileReaderHandler.readFile()).thenReturn(fileContent);
		
		Mockito.when(studentGradingManager.manageStudentGrading(fileContent)).thenReturn(false);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile3()
	{
		String fileContent = "Any Content";
		
		Mockito.when(fileReaderHandler.readFile()).thenReturn(fileContent);
		
		Mockito.when(studentGradingManager.manageStudentGrading(fileContent)).thenReturn(true);
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile4()
	{
		String fileContent = "Any Content";
		
		Mockito.when(fileReaderHandler.readFile()).thenReturn(fileContent);
		
		Mockito.when(studentGradingManager.manageStudentGrading(fileContent)).thenReturn(false);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile5()
	{
		String fileContent = "";
		
		Mockito.when(fileReaderHandler.readFile()).thenReturn(fileContent);
		
		Mockito.when(studentGradingManager.manageStudentGrading(fileContent)).thenReturn(true);
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile6()
	{
		String fileContent = "";
		
		Mockito.when(fileReaderHandler.readFile()).thenReturn(fileContent);
		
		Mockito.when(studentGradingManager.manageStudentGrading(fileContent)).thenReturn(false);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile7()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt");
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile8()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt");
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile9()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("");
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile10()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile11()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile12()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile13()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile14()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile15()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile16()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt", "output.txt");
		
		boolean expected = true;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile17()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt", "output.txt");
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestReadFile18()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("", "output.txt");
		
		boolean expected = false;
		
		assertEquals(expected, studentGradingFileProcessor.readFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile1()
	{	
		doNothing().when(fileWriterHandler).writeFile(Mockito.anyString());
		
		String studentGradingOutput = "Subject Name: Math Max Mark: 100\r\n"
				+ "Student Name	Student Number	GPA	Grade	\r\n"
				+ "Mazen	1999999p	3.3	B+";
		
		Mockito.when(studentGradingManager.GetStudentGradingOutput()).thenReturn(studentGradingOutput);
		
		String expected = studentGradingOutput;
		
		assertEquals(expected, studentGradingFileProcessor.writeFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile2()
	{	
		doNothing().when(fileWriterHandler).writeFile(Mockito.anyString());
		
		String studentGradingOutput = "Any Content";
		
		Mockito.when(studentGradingManager.GetStudentGradingOutput()).thenReturn(studentGradingOutput);
		
		String expected = studentGradingOutput;
		
		assertEquals(expected, studentGradingFileProcessor.writeFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile3()
	{	
		doNothing().when(fileWriterHandler).writeFile(Mockito.anyString());
		
		String studentGradingOutput = "";
		
		Mockito.when(studentGradingManager.GetStudentGradingOutput()).thenReturn(studentGradingOutput);
		
		String expected = studentGradingOutput;
		
		assertEquals(expected, studentGradingFileProcessor.writeFile());
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile4()
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
	public void StudentGradingFileProcessorTestWriteFile5()
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
	public void StudentGradingFileProcessorTestWriteFile6()
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
	public void StudentGradingFileProcessorTestWriteFile7()
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
	public void StudentGradingFileProcessorTestWriteFile8()
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
	public void StudentGradingFileProcessorTestWriteFile9()
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
	public void StudentGradingFileProcessorTestWriteFile10()
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
	public void StudentGradingFileProcessorTestWriteFile11()
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
	public void StudentGradingFileProcessorTestWriteFile12()
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
	public void StudentGradingFileProcessorTestWriteFile13()
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
	public void StudentGradingFileProcessorTestWriteFile14()
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
	public void StudentGradingFileProcessorTestWriteFile15()
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
	public void StudentGradingFileProcessorTestWriteFile16()
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
	public void StudentGradingFileProcessorTestWriteFile17()
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
	public void StudentGradingFileProcessorTestWriteFile18()
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
	public void StudentGradingFileProcessorTestWriteFile19()
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
	public void StudentGradingFileProcessorTestWriteFile20()
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
	public void StudentGradingFileProcessorTestWriteFile21()
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
	public void StudentGradingFileProcessorTestWriteFile22()
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
	public void StudentGradingFileProcessorTestWriteFile23()
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
	public void StudentGradingFileProcessorTestWriteFile24()
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
	public void StudentGradingFileProcessorTestWriteFile25()
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
	public void StudentGradingFileProcessorTestWriteFile26()
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
	public void StudentGradingFileProcessorTestWriteFile27()
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
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile28()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile29()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile30()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile31()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile32()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile33()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile34()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile35()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile36()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile37()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile38()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile39()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile40()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile41()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile42()
	{
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile43()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("test_fail.txt");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile44()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile45()
	{
		
		FileReaderHandler _fileReaderHandler = new FileReaderHandler("");
		
		FileWriterHandler _fileWriterHandler = new FileWriterHandler("output.txt");
		
		studentGradingFileProcessor = new StudentGradingFileProcessor(_fileReaderHandler, _fileWriterHandler);
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile46()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile47()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile48()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile49()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("test_fail.txt", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile50()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{
			studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			File f = new File(fileName);
			
			assertTrue(f.exists() && !f.isDirectory());
		}
	}
	
	@Test
	public void StudentGradingFileProcessorTestWriteFile51()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
	@Test
	public void StudentGradingFileProcessorChangeFilePath1()
	{
		studentGradingFileProcessor = new StudentGradingFileProcessor("", "output.txt");
		
		studentGradingFileProcessor.changeFilePath("test29.txt");
		
		assertEquals("test29.txt", studentGradingFileProcessor.GetFilePath());
	}
	
	@Test
	public void StudentGradingFileProcessorTestEquals1()
	{
		
		studentGradingFileProcessor = new StudentGradingFileProcessor("ttes", "output.txt");
		
		if(studentGradingFileProcessor.readFile())
		{	
			String expectedOutputContent = studentGradingFileProcessor.writeFile();
			
			String fileName = studentGradingFileProcessor.GetFileOutputName();
			
			String content = readFile(fileName);
			
			assertEquals(expectedOutputContent, content);
		}
	}
	
}
