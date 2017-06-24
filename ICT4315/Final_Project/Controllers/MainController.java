package ict4315.finalproject.Controllers;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ict4315.finalproject.Models.MainModel;

public class MainController extends JFrame{
	
	//Private member variables
	private static MainController controller = null;
	private MainModel model;
	private JFileChooser fileChooser;
	
	//Constructors
	private MainController() 
	{
		model = MainModel.getInstance();
	}
	
	public static MainController getInstance() {
		if (controller == null) {
			controller = new MainController();
		}
		return controller;
	}

	//Public methods called from MainView
	public void openFileDialog() 
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(
				JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			File openFile = fileChooser.getSelectedFile();
			if(openFile.getAbsolutePath().endsWith(".txt"))
			{
				model.openContacts(openFile);
			}
			else
			{
			JOptionPane.showMessageDialog(null, 
					"Application currently onlu supports reading" +
					" of file with an extension of .txt");
			}
		}
	}
	
	public void saveFileDialog() {model.saveContacts();}

	public void saveAllFormatsFileDialog() {
		{model.saveContactsAllFormats();}
	}

	public void saveAsTxtFileDialog() {
		File saveFile = menuFileSave();
		model.saveContactsAsTxt(saveFile);
	}

	public void saveAsHTMLFileDialog() {
		File saveFile = menuFileSave();
		model.saveContactsAsHTML(saveFile);
	}

	public void saveAsXMLFileDialog() {
		File saveFile = menuFileSave();
		model.saveContactsAsXML(saveFile);
	}

	public void addContact() 
	{
		model.showAddGUI();
	}

	public void editContact() 
	{
		model.showEditGUI();
	}

	public void deleteContact() 
	{
		model.deleteContact();
	}

	public void closeApplication() {
		System.exit(1);
	}


	//Private methods
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

}
