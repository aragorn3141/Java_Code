package ict4315.assignment10.Views;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddressBookListView extends ViewTemplate implements ListSelectionListener{

	private JPanel listPanel;
	
	private JLabel lblFullName, lblStreet, lblCity, lblState, lblZipCode, lblPhone, lblEmail;
	private JTextField txtFullName, txtStreet, txtCity, txtState, txtZipCode, txtPhone, txtEmail;
	
	
	
	public AddressBookListView()
	{
		listPanel = new JPanel();
		//listPanel.setLayout(new BorderLayout());
		listPanel.setLayout(new GridLayout(8, 2));
		
		
		//Full Name
				lblFullName = new JLabel("Full Name: ");
				txtFullName = new JTextField(36);
				
				listPanel.add(lblFullName);
				listPanel.add(txtFullName);
	}
	
	public JPanel getPanel()
	{
		return listPanel;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
