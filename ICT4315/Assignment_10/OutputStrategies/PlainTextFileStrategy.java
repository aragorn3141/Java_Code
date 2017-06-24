package ict4315.assignment10.OutputStrategies;


import ict4315.assignment10.BaseClasses.Contact;

import java.io.BufferedWriter;
import java.io.IOException;

/**
* @author Frederick McGovern
* @version 1.1
* @since 2014-05-17
* 
* This is the concrete implementation of the CreateFileOutput abstract class.
* This class provides a concrete implementation of the writeContact method
* which is used to write a contact to a txt file.
*/

public class PlainTextFileStrategy extends CreateFileOutput
{

	/**
    * Method to add a contact to a text file.  
	 * @return 
     */
	public void writeContact(Contact c, String fileLoc)
	{
		
		BufferedWriter bw = openWriter(fileLoc + ".txt");
		
		try
		{
			bw.write(c.getFullName() + "\t" + c.getStreet() + "\t" + c.getCity() + "\t" +
					c.getState() + "\t" + c.getZipCode() + "\t" + c.getPhone().getPhoneNumber() + 
					"\t" + c.getPhone().getPhoneType() + "\t" + c.getEmail()+ "\r\n");
		}
		catch(IOException e)
		{
			System.out.println("An error has occurred while attempting to write to the file");
			e.printStackTrace();
		}
		
		closeWriter(bw);
	}
}
