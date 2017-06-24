package ict4315.assignment10;

import ict4315.assignment10.Views.ViewTemplate;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressBookAddEditViewOrig extends ViewTemplate{
	
	private JButton btnAddContact, btnCancel;
	private JLabel lblFullName, lblStreet, lblCity, lblState, lblZipCode, lblPhone, lblEmail;
	private JPanel panel;
	private JTextField txtFullName, txtStreet, txtCity, txtState, txtZipCode, txtPhone, txtEmail;
	
	public AddressBookAddEditViewOrig()
	{
		initializePanel();
	}

	private void initializePanel() 
	{
		
		//Create panel
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(8, 2));
		
		//Full Name
		lblFullName = new JLabel("Full Name: ");
		txtFullName = new JTextField(36);
		
		panel.add(lblFullName);
		panel.add(txtFullName);
		
		//Street
		lblStreet = new JLabel("Street: ");
		txtStreet = new JTextField(36);
		
		panel.add(lblStreet);
		panel.add(txtStreet);
		
		lblCity = new JLabel("City: ");
		txtCity = new JTextField(20);
		
		panel.add(lblCity);
		panel.add(txtCity);
		
		//State
		lblState = new JLabel("State: ");
		txtState = new JTextField(2);
		
		panel.add(lblState);
		panel.add(txtState);
				
		//Zip Code
		lblZipCode = new JLabel("Zip Code: ");
		txtZipCode = new JTextField(5);
		
		panel.add(lblZipCode);
		panel.add(txtZipCode);
		
		//Phone
		lblPhone = new JLabel("Phone: ");
		txtPhone = new JTextField(12);
		
		panel.add(lblPhone);
		panel.add(txtPhone);
		
		//E-mail
		lblEmail = new JLabel("E-Mail: ");
		txtEmail = new JTextField(30);
		
		panel.add(lblEmail);
		panel.add(txtEmail);
		
		//Add new panel for buttons		
		JPanel control = new JPanel();
		
		
		//AddContact Button
		btnAddContact = new JButton("Add Contact");
		control.add(btnAddContact);
		
		btnAddContact.setEnabled(false);

		//Cancel Button
		btnCancel = new JButton("Cancel");
		control.add(btnCancel);
		
		panel.add(control, BorderLayout.SOUTH);
		
		//add(control, BorderLayout.SOUTH);	
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
}
