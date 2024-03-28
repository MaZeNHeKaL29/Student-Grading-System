package studentGradingSystem;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterHandler
{
    
    private String fileName;

    public FileWriterHandler(String fileName) 
    {
		 if (!fileName.endsWith(".txt"))
		 {
			 fileName = fileName + ".txt";
		 }
        this.fileName = fileName;
    }

    public void writeFile(String content)
    {
        try
        {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            
            bw.write(content);
            
            bw.close();
            System.out.println("Content has been written to the file successfully.");
        } catch (IOException e)
        {
            System.out.println("Exception: " + e);
        }
    }
    
    public String GetFileName()
    {
    	return fileName;
    }
    
}