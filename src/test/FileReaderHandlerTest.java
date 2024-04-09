package test;

// Importing necessary classes and packages
import studentGradingSystem.*; // Importing classes from studentGradingSystem package

// Importing static methods for assertions and file handling
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Class to test the FileReaderHandler class
public class FileReaderHandlerTest {
    private FileReaderHandler fileReaderHandler; // Instance of FileReaderHandler class
    private File testFile; // Test file to be created

    // Method to set up the test environment before each test case
    @Before
    public void setUp() throws IOException {
        // Creating a temporary test file
        testFile = File.createTempFile("test", ".txt");
        FileWriter writer = new FileWriter(testFile);
        writer.write("Test content line 1\n"); // Writing test content to the file
        writer.write("Test content line 2\n");
        writer.write("Test content line 3\n");
        writer.close(); // Closing the writer
        // Creating an instance of FileReaderHandler with the path of the test file
        fileReaderHandler = new FileReaderHandler(testFile.getAbsolutePath());
    }

    // Method to clean up after each test case
    @After
    public void tearDown() {
        testFile.delete(); // Deleting the test file
    }

    // Test method to check if readFile() method reads the file content correctly
    @Test
    public void testReadFile() {
        String fileContent = fileReaderHandler.readFile(); // Reading the file content
        assertNotNull("File content should not be null", fileContent); // Asserting file content is not null
        assertTrue("File content should contain line 1", fileContent.contains("Test content line 1")); // Asserting file content contains line 1
        assertTrue("File content should contain line 2", fileContent.contains("Test content line 2")); // Asserting file content contains line 2
        assertTrue("File content should contain line 3", fileContent.contains("Test content line 3")); // Asserting file content contains line 3
    }

    // Test method to check if GetFilePath() method returns the correct file path
    @Test
    public void testGetFilePath() {
        assertEquals("File path should match", testFile.getAbsolutePath(), fileReaderHandler.GetFilePath()); // Asserting file path matches
    }

    // Test method to check behavior when trying to read from a nonexistent file
    @Test
    public void testReadNonexistentFile() {
        // Creating an instance of FileReaderHandler with a nonexistent file path
        FileReaderHandler nonExistentFileReaderHandler = new FileReaderHandler("nonexistent.txt");
        // Attempting to read from the nonexistent file
        String fileContent = nonExistentFileReaderHandler.readFile();
        // Asserting that an exception message is returned
        assertEquals("Exception: java.io.FileNotFoundException: nonexistent.txt (The system cannot find the file specified)", fileContent);
    }

    // Test method to check behavior when trying to read from an empty file
    @Test
    public void testReadEmptyFile() throws IOException {
        // Creating an empty temporary file
        File emptyFile = File.createTempFile("empty", ".txt");
        // Creating an instance of FileReaderHandler with the path of the empty file
        FileReaderHandler emptyFileReaderHandler = new FileReaderHandler(emptyFile.getAbsolutePath());
        // Attempting to read from the empty file
        String fileContent = emptyFileReaderHandler.readFile();
        // Asserting that an empty string is returned
        assertEquals("Reading empty file should return empty string", "", fileContent);
        emptyFile.delete(); // Deleting the empty file
    }
}
