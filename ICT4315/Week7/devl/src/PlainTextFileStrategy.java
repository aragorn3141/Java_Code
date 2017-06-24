package ict4315.assignment7;

import java.io.BufferedWriter;
import java.io.IOException;

/**
* @author Frederick McGovern
* @version 1.0
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
		BufferedWriter bw = openWriter(fileLoc + "contact.txt");
		
		try
		{
			bw.write("Full Name: " + c.getFullName() + "\r\n");
			bw.write("Address: " + c.Address_To_String() + "\r\n");
			bw.write("Phone: " + c.getPhone() + "\r\n");
			bw.write("EMail: " + c.getEmail() + "\r\n");
			bw.write("-----------------------------------\r\n");
		}
		catch(IOException e)
		{
			System.out.println("An error has occurred while attempting to write to the file");
			e.printStackTrace();
		}
		
		closeWriter(bw);
	}
}
