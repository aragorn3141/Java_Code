package ict4315.assignment10.Views;


import ict4315.assignment10.BaseClasses.Contact;
import ict4315.assignment10.HelperClasses.PhoneType;
import ict4315.assignment10.HelperClasses.USStates;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressBookAddEditView implements ActionListener{
	
	private AddressBookAddEditView view = null;;
	private Contact contact = null;
	private Contact newContact;
	
	private GridBagLayout gridBag;
	private GridBagConstraints c;
	
	private JPanel addEditPanel;
	
	private static JLabel lblFullName;
	private static JLabel lblStreet;
	private static JLabel lblCity;
	private static JLabel lblState;
	private static JLabel lblZipCode;
	private static JLabel lblPhone;
	private static JLabel lblPhoneType;
	private static JLabel lblEmail;
	
	private static JTextField fldFullName;
	private static JTextField fldStreet;
	private static JTextField fldCity;
	private static JTextField fldZipCode;
	private static JTextField fldPhone;
	private static JTextField fldEmail;
	
	private static JComboBox fldState;
	private static JComboBox fldPhoneType;
	
	private static JButton btnAddContact;
	private static JButton btnCancel;
	
	
	
	
	public AddressBookAddEditView()
	{	
		initializePanel();
	}
	
	//Getters
    public String getFullName(){ return fldFullName.getText();}
    public String getStreet(){ return fldStreet.getText();}
    public String getCity(){ return fldCity.getText();}
    public String getState(){ return  USStates.stringAtIndex(fldState.getSelectedIndex());} 
    public String getZipCode(){ return fldZipCode.getText();}
    public String getPhone(){ return fldPhone.getText();}
    public String getPhoneType(){ return  PhoneType.stringAtIndex(fldPhoneType.getSelectedIndex());} 
    public String getEmail(){ return fldEmail.getText();}
    
    
	public void resetViewFullName(){fldFullName.setText(null);}
	public void resetViewStreet(){fldStreet.setText(null);}
	public void resetViewCity(){fldCity.setText(null);}
	public void resetViewState(){fldState.setSelectedIndex(0);}
	public void resetViewZipCode(){fldZipCode.setText(null);}
	public void resetViewPhone(){fldPhone.setText(null);}
	public void resetViewPhoneType(){fldPhoneType.setSelectedIndex(0);}
	public void resetViewEmail(){fldEmail.setText(null);}
	
	public AddressBookAddEditView getInstance()
	{
		if(view == null)
		{
			view = new AddressBookAddEditView();
		}
		
		return view;
	}

	private void initializePanel() 
	{
		addEditPanel = new JPanel();
		gridBag = new GridBagLayout();
		c = new GridBagConstraints();
		
		addEditPanel.setLayout(gridBag);
		addEditPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		lblFullName = new JLabel("Full Name: ");
		positionAndAddComponent(lblFullName, 		0, 0, 1, 1);
		
		fldFullName = new JTextField(20);
		positionAndAddComponent(fldFullName, 		1, 0, 1, c.REMAINDER);
		
		lblStreet = new JLabel("Street: ");
		positionAndAddComponent(lblStreet, 			0, 1, 1, 1);
		
		fldStreet = new JTextField(20);
		positionAndAddComponent(fldStreet, 			1, 1, 1, c.REMAINDER);
		
		lblCity = new JLabel("City: ");
		positionAndAddComponent(lblCity, 			0, 2, 1, 1);
		
		fldCity = new JTextField(20);
		positionAndAddComponent(fldCity, 			1, 2, 1, 1);
		
		lblState = new JLabel("State: ");
		positionAndAddComponent(lblState, 			2, 2, 1, c.RELATIVE);
		
		fldState = new JComboBox(USStates.getValues());
		positionAndAddComponent(fldState, 			3, 2, 1, c.REMAINDER);
		
		lblZipCode = new JLabel("ZipCode: ");
		positionAndAddComponent(lblZipCode, 		0, 3, 1, 1);
		
		fldZipCode = new JTextField(5);
		positionAndAddComponent(fldZipCode, 		1, 3, 1, c.REMAINDER);
		
		lblPhone = new JLabel("Phone: ");
		positionAndAddComponent(lblPhone, 			0, 4, 1, 1);
		
		fldPhone = new JTextField(10);
		positionAndAddComponent(fldPhone, 			1, 4, 1, 1);
		
		lblPhoneType = new JLabel("Phone Type: ");
		positionAndAddComponent(lblPhoneType, 		2, 4, 1, c.RELATIVE);
		
		fldPhoneType = new JComboBox(PhoneType.getValues());
		positionAndAddComponent(fldPhoneType, 		3, 4, 1, c.REMAINDER);
		
		lblEmail = new JLabel("Email: ");
		positionAndAddComponent(lblEmail, 			0, 5, 1, 1);
		
		fldEmail = new JTextField(20);
		positionAndAddComponent(fldEmail, 			1, 5, 1, 1);
		
		btnAddContact = new JButton ("     Add Contact    ");
		btnAddContact.setActionCommand("Add Contact");
		btnAddContact.addActionListener(this);
		btnAddContact.setToolTipText("Add a contact to the contact list.");
		positionAndAddComponent(btnAddContact, 		1, 9, 1, 1);
		                        
		btnCancel = new JButton ("         Cancel          ");
		btnCancel.setActionCommand("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setToolTipText("Close the Add Contact Dialog Box");
		positionAndAddComponent(btnCancel, 			2, 9, 1, 1);
		
	}

	public void positionAndAddComponent(JComponent comp, int gridx, int gridy, 
			int gridheight, int gridwidth)
	{
		c.anchor = c.WEST;
		c.ipady = 10;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridheight = gridheight;
		c.gridwidth = gridwidth;
		c.weightx = 1;
		c.insets = new Insets(10,0,0,0);
		
		if((comp.equals(btnAddContact)) || (comp.equals(btnCancel)))
		{c.insets = new Insets(40,0,0,0);}

		gridBag.setConstraints(comp, c);
		
		addEditPanel.add(comp);
	}
	
	public JPanel getPanel()
	{
		return addEditPanel;
	}
	
    /**
	 * A method used to force the focus onto a specified JComponent
	 */
	public void setControlFocus(Object source) 
	{
		((JComponent) source).requestFocus();
	}
	


	
	

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
