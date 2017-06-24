package ict4315.assignment10.OutputStrategies;


import ict4315.assignment10.BaseClasses.Contact;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

	private static File file;
	private static FileWriter fileWriter;
	private static BufferedWriter bufferedWriter;
	
	/**
     * Method to open an output file or create the output file if in fact it hasn't been created 
	 * @return 
     */
	protected static final BufferedWriter openWriter(String fileName)
	{
		try
		{
			file = new File(fileName);
			
		    if(!file.exists()){file.createNewFile();}
			
			fileWriter = new FileWriter(file, true);
			
			bufferedWriter = new BufferedWriter(fileWriter);
				    
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
