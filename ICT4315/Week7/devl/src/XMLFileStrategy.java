package ict4315.assignment7;

import java.io.BufferedWriter;
import java.io.IOException;

/**
* @author Frederick McGovern
* @version 1.2
* @since 2014-05-17
* 
* This is the concrete implementation of the CreateFileOutput abstract class.
* This class provides a concrete implementation of the writeContact method
* which is used to write a contact to a xml file.
*/


public class XMLFileStrategy extends CreateFileOutput
{

	/**
     * Method to add a contact to an XML file using XML formatting 
	 * @return 
     */
	public void writeContact(Contact c, String fileLoc)
	{
		BufferedWriter bw = openWriter(fileLoc + "contact.xml");
		
		try
		{
			bw.write("<Contact Book>\r\n");
			bw.write("  <Contact>\r\n");
			bw.write("    <FullName>" + c.getFullName() + "</FullName>\r\n");
			bw.write("    <Address>" + c.Address_To_String() + "</Address>\r\n");
			bw.write("    <Phone>" + c.getPhone() + "</Phone>\r\n");
			bw.write("    <EMail>" + c.getEmail() + "</EMail>\r\n");
			bw.write("  </Contact>\r\n");
			bw.write("</Contact Book>\r\n");
		}
		catch(IOException e)
		{
			System.out.println("An error has occurred while attempting to write to the file");
			e.printStackTrace();
		}
		
		closeWriter(bw);
	}
}
