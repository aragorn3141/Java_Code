package ict4315.assignment10;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class AddressBookMenuFileController extends JFrame{
	
	private JFileChooser fileChooser;
	
	private AddressBookModel model;
	
	public AddressBookMenuFileController()
	{
		model = new AddressBookModel();
	}
	
	public void openFileDialog() 
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(
				JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			File openFile = fileChooser.getSelectedFile();
			model.openContacts(openFile);
		}
	}

	public void saveFileDialog() 
	{
		if(model.getFile() == null){model.saveContacts();}
	}

	public void saveAllFormatsFileDialog() 
	{
		if(model.getFile() == null){model.saveContactsAllFormats();}
	}
	
	public void saveAsTxtFileDialog() 
	{
		File saveFile = menuFileSave();
		model.saveContactsAsTxt(saveFile);
	}

	public void saveAsHTMLFileDialog() 
	{
		File saveFile = menuFileSave();
		model.saveContactsAsHTML(saveFile);
	}

	public void saveAsXMLFileDialog() 
	{
		File saveFile = menuFileSave();
		model.saveContactsAsXML(saveFile);
	}
	
	private File menuFileSave() 
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(
				JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showSaveDialog(this);
         
        if (result == JFileChooser.APPROVE_OPTION) 
 		{
 			return fileChooser.getSelectedFile();
 		}
         
		return null;
	}


	public void addContact() {
		// TODO Auto-generated method stub
		
	}


	public void editContact() {
		// TODO Auto-generated method stub
		
	}


	public void deleteContact() {
		// TODO Auto-generated method stub
		
	}


	public void closeApplication() 
	{
		System.exit(1);
		
	}








	



}
