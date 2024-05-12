package test;

// Import necessary classes and packages
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import studentGradingSystem.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

// Class to test the FileWriterHandler class
public class FileWriterHandlerTest {
    private FileWriterHandler fileWriterHandler; // Instance of FileWriterHandler class
    private File testFile; // File object for testing

    // Method to set up the test environment
    @Before
    public void setUp() throws IOException {
        // Create a temporary file for testing and instantiate FileWriterHandler
        testFile = File.createTempFile("test", ".txt");
        fileWriterHandler = new FileWriterHandler(testFile.getAbsolutePath());
    }

    // Method to clean up after each test
    @After
    public void tearDown() {
        // Delete the temporary test file
        testFile.delete();
    }

    // Test method to ensure content is correctly written to the file
    @Test
    public void testWriteFile() throws Exception {
        String content = "Test content"; // Content to be written to the file
        fileWriterHandler.writeFile(content); // Write content to the file

        // Read the content of the file and compare it with the expected content
        BufferedReader reader = new BufferedReader(new FileReader(testFile));
        String line = reader.readLine(); // Read the first line of the file
        reader.close();
        assertEquals("Content written to file should match", content, line);
    }

    // Test method to check if the file name matches the expected value
    @Test
    public void testGetFileName() {
        assertEquals("File name should match", testFile.getAbsolutePath(), fileWriterHandler.GetFileName());
    }

    // Test method to verify that writing empty content results in an empty file
    @Test
    public void testWriteEmptyContent() throws Exception {
        String content = ""; // Empty content to be written to the file
        fileWriterHandler.writeFile(content); // Write empty content to the file

        // Read the content of the file and check if it is empty
        BufferedReader reader = new BufferedReader(new FileReader(testFile));
        String line = reader.readLine(); // Read the first line of the file
        reader.close();
        assertTrue("File content should be empty", line == null || line.isEmpty());
    }

    // Test method to ensure that the file name ends with ".txt"
    @Test
    public void testFileNameEndsWithTxt() {
        FileWriterHandler handler = new FileWriterHandler("testFile"); // Create FileWriterHandler with a file name
        assertEquals("File name should end with .txt", "testFile.txt", handler.GetFileName());
    }

    // Test method to verify that if the file name already ends with ".txt", it remains unchanged
    @Test
    public void testFileNameAlreadyEndsWithTxt() {
        FileWriterHandler handler = new FileWriterHandler("testFile.txt"); // Create FileWriterHandler with a file name
        assertEquals("File name should remain unchanged", "testFile.txt", handler.GetFileName());
    }
    

}
