package ict4315.finalproject.OutputStrategies;


import ict4315.finalproject.BaseClasses.Contact;

import java.io.BufferedWriter;
import java.io.IOException;

/**
* @author Frederick McGovern
* @version 1.3
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
		BufferedWriter bw = openWriter(dropFileExtension(fileLoc) + ".xml");
		
		try
		{
			bw.write("<Contact Book>\r\n");
			bw.write("  <Contact>\r\n");
			bw.write("    <Full Name>" + c.getFullName() + "</Full Name>\r\n");
			bw.write("    <Street>" + c.getStreet() + "</Street>\r\n");
			bw.write("    <City>" + c.getCity() + "</City>\r\n");
			bw.write("    <State>" + c.getState() + "</State>\r\n");
			bw.write("    <Zip Code>" + c.getZipCode() + "</Zip Code>\r\n");
			bw.write("    <Phone Number>" + c.getPhone().getPhoneNumber() + "</Phone Number>\r\n");
			bw.write("    <Phone Type>" + c.getPhone().getPhoneType() + "</Phone Type>\r\n");
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



