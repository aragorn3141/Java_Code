package ict4315.finalproject.Views;

import ict4315.finalproject.BaseClasses.Contact;
import ict4315.finalproject.BaseClasses.HelperClasses.PhoneType;
import ict4315.finalproject.BaseClasses.HelperClasses.USStates;
import ict4315.finalproject.Controllers.AddEditController;
import ict4315.finalproject.Models.MainModel;
import ict4315.finalproject.Templates.ViewTemplate;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class AddEditView extends ViewTemplate implements ActionListener {

	private static AddEditView view = null;
	private MainModel model;
	private AddEditController controller;
	private static JPanel addEditPanel;
	private static GridBagLayout gridBag;
	private static GridBagConstraints c;
	private static JLabel lblFullName;
	private static JTextField fldFullName;
	private static JLabel lblStreet;
	private static JTextField fldStreet;
	private static JLabel lblCity;
	private static JTextField fldCity;
	private static JLabel lblState;
	private static JComboBox fldState;
	private static JLabel lblZipCode;
	private static JTextField fldZipCode;
	private static JLabel lblPhone;
	private static JTextField fldPhone;
	private static JLabel lblPhoneType;
	private static JComboBox fldPhoneType;
	private static JLabel lblEmail;
	private static JTextField fldEmail;
	private static JButton btnAddContact;
	private static JLabel fldSpacer;
	private static JButton btnCommit;
	private static JButton btnCancel;
	
	//Object used by Listeners
	public Object getFullNameEnter() {return fldFullName;}
	public Object getStreetEnter() {return fldStreet;}
	public Object getCityEnter() {return fldCity;}
	public Object getStateEnter() {return fldState;}
	public Object getZipCodeEnter() {return fldZipCode;}
	public Object getPhoneEnter() {return fldPhone;}
	public Object getPhoneTypeEnter() {return fldPhoneType;}
	public Object getEmailEnter() {return fldEmail;}
	public Object getAddClick(){ return btnAddContact;}
	public Object getCommitClick(){ return btnCommit;}
	public Object getCancelClick(){ return btnCancel;}
	
	//Constructors
	private AddEditView() {
		
		model = MainModel.getInstance();
		model.addView(this);
		
		controller = AddEditController.getInstance(this);
		initializePanel();
		createListeners();
	}

	public static AddEditView getInstance() {
		if (view == null) 
		{			
			view = new AddEditView();
		}

		return view;
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
    

    //Public Methods
    public JPanel getPanel() {return addEditPanel;}
    
    public void updateView()
	{
    	displayButtons(model.isAddedContact());
    	
    	if(model.isAddedContact())
    	{
    		resetContactView();
    	}
    	else
    	{
			Contact c = model.getContactFromContactList();
			
			if(c != null)
			{
				fldFullName.setText(c.getFullName());
				fldStreet.setText(c.getStreet());
				fldCity.setText(c.getCity());
				fldState.setSelectedIndex(USStates.indexOf(c.getState()));
				fldZipCode.setText(c.getZipCode());
				fldPhone.setText(c.getPhone().getPhoneNumber());
				fldPhoneType.setSelectedIndex(PhoneType.indexOf(c.getPhone().getPhoneType()));
				fldEmail.setText(c.getEmail());
			}
    	}
	}
    
	private static void displayButtons(boolean addView)
	{
		btnAddContact.setVisible(addView);
		btnCommit.setVisible(!addView);
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	//Private methods
	private void initializePanel() {

		addEditPanel = new JPanel();
		gridBag = new GridBagLayout();
		c = new GridBagConstraints();

		addEditPanel.setLayout(gridBag);
		addEditPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		lblFullName = new JLabel("Full Name: ");
		positionAndAddComponent(lblFullName, 0, 0, 1, 1);

		fldFullName = new JTextField(20);
		positionAndAddComponent(fldFullName, 1, 0, 1, c.REMAINDER);

		lblStreet = new JLabel("Street: ");
		positionAndAddComponent(lblStreet, 0, 1, 1, 1);

		fldStreet = new JTextField(20);
		positionAndAddComponent(fldStreet, 1, 1, 1, c.REMAINDER);

		lblCity = new JLabel("City: ");
		positionAndAddComponent(lblCity, 0, 2, 1, 1);

		fldCity = new JTextField(20);
		positionAndAddComponent(fldCity, 1, 2, 1, 1);

		lblState = new JLabel("State: ");
		positionAndAddComponent(lblState, 2, 2, 1, c.RELATIVE);

		fldState = new JComboBox(USStates.getValues());
		positionAndAddComponent(fldState, 3, 2, 1, c.REMAINDER);

		lblZipCode = new JLabel("ZipCode: ");
		positionAndAddComponent(lblZipCode, 0, 3, 1, 1);

		fldZipCode = new JTextField(5);
		positionAndAddComponent(fldZipCode, 1, 3, 1, c.REMAINDER);

		lblPhone = new JLabel("Phone: ");
		positionAndAddComponent(lblPhone, 0, 4, 1, 1);

		fldPhone = new JTextField(10);
		positionAndAddComponent(fldPhone, 1, 4, 1, 1);

		lblPhoneType = new JLabel("Phone Type: ");
		positionAndAddComponent(lblPhoneType, 2, 4, 1, c.RELATIVE);

		fldPhoneType = new JComboBox(PhoneType.getValues());
		positionAndAddComponent(fldPhoneType, 3, 4, 1, c.REMAINDER);

		lblEmail = new JLabel("Email: ");
		positionAndAddComponent(lblEmail, 0, 5, 1, 1);

		fldEmail = new JTextField(20);
		positionAndAddComponent(fldEmail, 1, 5, 1, 1);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		
		fldSpacer = new JLabel(" ");
		buttonPanel.add(fldSpacer, BorderLayout.NORTH);
		
		btnAddContact = new JButton("     Add Contact    ");
		btnAddContact.setActionCommand("Add Contact");
		btnAddContact.addActionListener(this);
		btnAddContact.setToolTipText("Add a contact to the contact list.");
		buttonPanel.add(btnAddContact , BorderLayout.WEST);
		
		btnCommit = new JButton("      Commit      ");
		btnCommit.setActionCommand("Commit Changes");
		btnCommit.addActionListener(this);
		btnCommit.setToolTipText("Commit an edited contact to the contact list.");
		buttonPanel.add(btnCommit , BorderLayout.CENTER);

		btnCancel = new JButton("         Cancel          ");
		btnCancel.setActionCommand("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setToolTipText("Close the Add Contact Dialog Box");
		buttonPanel.add(btnCancel , BorderLayout.EAST);
		
		positionAndAddComponent(buttonPanel, 1, 9, 1, 1);
	}
	
	private void positionAndAddComponent(JComponent comp, int gridx, int gridy,
			int gridheight, int gridwidth) {
		c.anchor = c.WEST;
		c.ipady = 10;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridheight = gridheight;
		c.gridwidth = gridwidth;
		c.weightx = 1;
		c.insets = new Insets(10, 0, 0, 0);

		if ((comp.equals(btnAddContact)) || (comp.equals(btnCancel))|| 
				(comp.equals(btnCommit))) {
			c.insets = new Insets(40, 0, 0, 0);
		}

		gridBag.setConstraints(comp, c);

		addEditPanel.add(comp);
	}
	
	private void createListeners() {
		fldFullName.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validateFullName();
			}
		});
		
		fldStreet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validateStreet();
			}
		});
		
		fldCity.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validateCity();
			}
		});
		
		fldState.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validateState();
			}
		});
		
		fldZipCode.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validateZipCode();
			}
		});
		
		fldPhone.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validatePhone();
			}
		});
		
		fldPhoneType.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validatePhoneType();
			}
		});
		
		fldEmail.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.validateEmail();
			}
		});
		
		btnAddContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.addContact();
			}
		});
		
		btnCommit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.commitChanges();
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.hideAddEditFrame();
			}
		});
		
	}
	
    /**
	 * A method used to force the focus onto a specified JComponent
	 */
	public void setControlFocus(Object source) 
	{
		((JComponent) source).requestFocus();
	}
	
	//Methods to reset values as value 
	public void resetViewFullName(){fldFullName.setText(null);}
	public void resetViewStreet(){fldStreet.setText(null);}
	public void resetViewCity(){fldCity.setText(null);}
	public void resetViewState(){fldState.setSelectedIndex(0);}
	public void resetViewZipCode(){fldZipCode.setText(null);}
	public void resetViewPhone(){fldPhone.setText(null);}
	public void resetViewPhoneType(){fldPhoneType.setSelectedIndex(0);}
	public void resetViewEmail(){fldEmail.setText(null);}
	
	/**
	 * A method used to reset the private member variables
	 * following adding of contact
	 */
	public void resetContactView()
	{
		resetViewFullName();
		resetViewStreet();
		resetViewCity();
		resetViewState();
		resetViewZipCode();
		resetViewPhone();
		resetViewPhoneType();
		resetViewEmail();
		fldFullName.requestFocus();
		btnAddContact.setEnabled(false);
	}
	
	public void enableAddButton()
	{
		btnAddContact.setEnabled(true);
	}
	
	public void disableAddButton()
	{
		btnAddContact.setEnabled(false);
	}
	

}
