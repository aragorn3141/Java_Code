package ict4315.assignment9;


import java.io.BufferedWriter;
import java.io.IOException;

/**
* @author Frederick McGovern
* @version 1.1
* @since 2014-05-17
* 
* This is the concrete implementation of the CreateFileOutput abstract class.
* This class provides a concrete implementation of the writeContact method
* which is used to write a contact to a html file.
*/

public class HTMLFileStrategy extends CreateFileOutput
{

	/**
     * Method to add a contact to an HTML file using HTML formatting  
	 * @return 
     */
	public void writeContact(Contact c, String fileLoc)
	{
		BufferedWriter bw = openWriter(fileLoc + "contact.html");
		
		try
		{
			bw.write("<!DOCTYPE html>\r\n");
			bw.write("<html>\r\n");
			bw.write("<body>\r\n");
			bw.newLine();
			bw.write("<p><b>Full Name: " + c.getFullName() + "</b></p>\r\n");
			bw.write("<p><b>Address: " + c.Address_To_String() + "</b></p>\r\n");
			bw.write("<p><b>Phone: " + c.getPhone() + "</b></p>\r\n");
			bw.write("<p><b>Email: <a href=\"" + c.getEmail() + "\"> " + c.getEmail() + "</a></b></p>\r\n");
			bw.newLine();
			bw.write("</body>\r\n");
			bw.write("</html>\r\n");
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



