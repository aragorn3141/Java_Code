package ict4315.assignment9;

/**
* @author Frederick McGovern
* @version 1.9
* @since 2014-05-30
* 
* This is a class that represents a view to allow the user to add contacts
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressBookAddContactView extends JPanel implements ContactView{
	
	private AddressBookController controller;
	
	private JButton btnAddContact, btnCancel;
	private JLabel lblFullName, lblStreet, lblCity, lblState, lblZipCode, lblPhone, lblEmail;
	private JPanel panel;
	private JTextField txtFullName, txtStreet, txtCity, txtState, txtZipCode, txtPhone, txtEmail;
	
	
	//Constructors
	public AddressBookAddContactView(AddressBookModel model) 
	{
		controller = new AddressBookController(model, this);
		initializeGui();
	}
	
	public AddressBookAddContactView(AddressBookModel model, AddressBookController controller) 
	{
		this.controller = controller;
		initializeGui();
	}
	
	//Method to create all the swing component and add them into a panel for display to the user
	private void initializeGui() 
	{
		setLayout(new BorderLayout());
		
		//Create panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));
		
		//Full Name
		lblFullName = new JLabel("Full Name: ");
		txtFullName = new JTextField(36);
		
		panel.add(lblFullName);
		panel.add(txtFullName);
		
		txtFullName.addActionListener(controller);
		
		//Street
		lblStreet = new JLabel("Street: ");
		txtStreet = new JTextField(36);
		
		panel.add(lblStreet);
		panel.add(txtStreet);
		
		txtStreet.addActionListener(controller);
		
		//City
		lblCity = new JLabel("City: ");
		txtCity = new JTextField(20);
		
		panel.add(lblCity);
		panel.add(txtCity);
		
		txtCity.addActionListener(controller);
		
		//State
		lblState = new JLabel("State: ");
		txtState = new JTextField(2);
		
		panel.add(lblState);
		panel.add(txtState);
		
		txtState.addActionListener(controller);
		
		//Zip Code
		lblZipCode = new JLabel("Zip Code: ");
		txtZipCode = new JTextField(5);
		
		panel.add(lblZipCode);
		panel.add(txtZipCode);
		
		txtZipCode.addActionListener(controller);
		
		//Phone
		lblPhone = new JLabel("Phone: ");
		txtPhone = new JTextField(12);
		
		panel.add(lblPhone);
		panel.add(txtPhone);
		
		txtPhone.addActionListener(controller);
		
		//E-mail
		lblEmail = new JLabel("E-Mail: ");
		txtEmail = new JTextField(30);
		
		panel.add(lblEmail);
		panel.add(txtEmail);
		
		txtEmail.addActionListener(controller);
		
		//Add new panel for buttons		
		add(panel, BorderLayout.CENTER);
		JPanel control = new JPanel();
		
		//AddContact Button
		btnAddContact = new JButton("Add Contact");
		control.add(btnAddContact);
		btnAddContact.addActionListener(controller);
		btnAddContact.setEnabled(false);

		//Cancel Button
		btnCancel = new JButton("Cancel");
		control.add(btnCancel);
		btnCancel.addActionListener(controller);
		
		
		add(control, BorderLayout.SOUTH);
	}
	
	public void refreshContactView(String fullName, String street, String city, String state, 
		String zipCode, String phone, String email)
	{
		txtFullName.setText(fullName);
		txtStreet.setText(street);
		txtCity.setText(city);
		txtState.setText(state);
		txtZipCode.setText(zipCode);
		txtPhone.setText(phone);
		txtEmail.setText(email);
		
		btnAddContact.setEnabled(true);
		btnAddContact.requestFocus();
	}
	/**
	 * A method used to reset the private member variables
	 */
	public void resetContactView()
	{
		resetViewFullName();
		resetViewStreet();
		resetViewCity();
		resetViewState();
		resetViewZipCode();
		resetViewPhone();
		resetViewEmail();
		txtFullName.requestFocus();
	}
	
	//Methods to reset values as value 
	public void resetViewFullName(){txtFullName.setText(null);}
	public void resetViewStreet(){txtStreet.setText(null);}
	public void resetViewCity(){txtCity.setText(null);}
	public void resetViewState(){txtState.setText(null);}
	public void resetViewZipCode(){txtZipCode.setText(null);}
	public void resetViewPhone(){txtPhone.setText(null);}
	public void resetViewEmail(){txtEmail.setText(null);}
	
	//Object used by Listeners
	public Object getFullNameEnter() {return txtFullName;}
	public Object getStreetEnter() {return txtStreet;}
	public Object getCityEnter() {return txtCity;}
	public Object getStateEnter() {return txtState;}
	public Object getZipCodeEnter() {return txtZipCode;}
	public Object getPhoneEnter() {return txtPhone;}
	public Object getEmailEnter() {return txtEmail;}
	public Object getAddClick(){ return btnAddContact;}
	public Object getCancelClick(){ return btnCancel;}
	
	//Getters
    public String getFullName(){ return txtFullName.getText();}
    public String getStreet(){ return txtStreet.getText();}
    public String getCity(){ return txtCity.getText();}
    public String getState(){ return txtState.getText();}
    public String getZipCode(){ return txtZipCode.getText();}
    public String getPhone(){ return txtPhone.getText();}
    public String getEmail(){ return txtEmail.getText();}

    /**
	 * A method used to force the focus onto a specified JComponent
	 */
	public void setControlFocus(Object source) 
	{
		((JComponent) source).requestFocus();
	}
	
}
