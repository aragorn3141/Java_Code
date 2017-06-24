package ict4315.assignment9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
* @author Frederick McGovern
* @version 1.0
* @since 2014-05-16
* 
* This is the abstract class to determine the output to use when printing a contact
* utilizing the strategy pattern
*/

public class CreateFileOutput 
{
	//Variable is used to output text to a file
	//protected static Formatter output;
	
	private static File file;
	private static FileWriter fileWriter;
	
	/**
     * Method to open an output file or create the output file if in fact it hasn't been created 
	 * @return 
     */
	protected static final BufferedWriter openWriter(String fileName)
	{
		try
		{
			File file = new File(fileName);
			
		    if(!file.exists())
		    {
		    	file.createNewFile();
		    }
			
			FileWriter fileWriter = new FileWriter(file, true);
			
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			// but let's print to console while debugging
		    //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		    
			return bufferedWriter;
		}
		catch(IOException e)
		{
			System.err.println("An error has occurred while attempting to open the file");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
     * Method to add a contact to a file based on a specific file type 
	 * @return 
     */
	public void writeContact(Contact contact, String fileLoc){};
	
	/**
     * Method to close an output if the output has in fact been created 
	 * @return 
     */
	protected static final void closeWriter(BufferedWriter bw)
	{
		if(bw != null)
		{
			try 
			{
				bw.close();
			} catch (IOException e) 
			{
				System.out.println("An error has occurred when attempting to close the file");
				e.printStackTrace();
			}
		}
	}
}




