package studentGradingSystem;

import java.io.*;

public class FileReaderHandler
{

	
	private String filePath;

	public FileReaderHandler(String filePath)
	{
	    this.filePath = filePath;
	}

    public String readFile()
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
	
	public String GetFilePath()
	{
		return filePath;
	}
	
}
