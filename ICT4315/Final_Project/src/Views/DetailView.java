package ict4315.finalproject.Views;

import ict4315.finalproject.BaseClasses.Contact;
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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailView extends ViewTemplate  
implements ActionListener{
	
	private static DetailView view = null;
	private MainModel model;
	private static JPanel detailPanel;
	private static GridBagLayout gridBag;
	private static GridBagConstraints c;
	private static JLabel lblFullName;
	private static JLabel fldFullName;
	private static JLabel lblStreet;
	private static JLabel fldStreet;
	private static JLabel lblCity;
	private static JLabel fldCity;
	private static JLabel lblState;
	private static JLabel fldState;
	private static JLabel lblZipCode;
	private static JLabel fldZipCode;
	private static JLabel lblPhone;
	private static JLabel fldPhone;
	private static JLabel lblPhoneType;
	private static JLabel fldPhoneType;
	private static JLabel lblEmail;
	private static JLabel fldEmail;
	private static JLabel fldSpacer;
	private static JButton btnPrevious;
	private static JButton btnEdit;
	private static JButton btnNext;
	
	
	//Constructors
	private DetailView() 
	{
		model = MainModel.getInstance();
		model.addView(this);
		
		initializeDetailPanel();
		updateView();
	}

	public static DetailView getInstance() {
		if (view == null) {
			view = new DetailView();
		}
		return view;
	}

	//Public methods
	public JPanel getPanel() {return detailPanel;}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int currIndex = model.getCurrentContactIndex();
		int currMaxIndex = model.getContactListSize()-1;
		
		if(ae.getActionCommand().equals("Previous"))
		{
			if(currIndex > 0)
			{			
				model.setCurrentContactIndex(currIndex-1);
			}
			else
			{
				model.setCurrentContactIndex(currMaxIndex);
			}
		}
		else if(ae.getActionCommand().equals("Next"))
		{
			if(currIndex < currMaxIndex)
			{			
				model.setCurrentContactIndex(currIndex + 1);
			}
			else
			{
				model.setCurrentContactIndex(0);
			}
		}
		else if(ae.getActionCommand().equals("Edit"))
		{
			model.showEditGUI();
		}
	}
	
	public void updateView()
	{

		Contact c = model.getContactFromContactList();
		
		if(c != null)
		{
			fldFullName.setText(c.getFullName());
			fldStreet.setText(c.getStreet());
			fldCity.setText(c.getCity());
			fldState.setText(c.getState());
			fldZipCode.setText(c.getZipCode());
			fldPhone.setText(c.getPhone().getPhoneNumber());
			fldPhoneType.setText(c.getPhone().getPhoneType());
			fldEmail.setText(c.getEmail());
		}
		else
		{
			fldFullName.setText(" ");
			fldStreet.setText(" ");
			fldCity.setText(" ");
			fldState.setText(" ");
			fldZipCode.setText(" ");
			fldPhone.setText(" ");
			fldPhoneType.setText(" ");
			fldEmail.setText(" ");
		}
	}
	
	//Private methods
	private void initializeDetailPanel() {
		detailPanel = new JPanel();
		
		gridBag = new GridBagLayout();
		c = new GridBagConstraints();
		
		detailPanel.setLayout(gridBag);
		detailPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		lblFullName = new JLabel("Full Name: ");
		positionAndAddComponent(lblFullName, 		0, 0, 1, 1);
		
		fldFullName = new JLabel(" ");
		positionAndAddComponent(fldFullName, 		1, 0, 1, c.REMAINDER);
		
		lblStreet = new JLabel("Street: ");
		positionAndAddComponent(lblStreet, 			0, 1, 1, 1);
		
		fldStreet = new JLabel(" ");
		positionAndAddComponent(fldStreet, 			1, 1, 1, c.REMAINDER);
		
		lblCity = new JLabel("City: ");
		positionAndAddComponent(lblCity, 			0, 2, 1, 1);
		
		fldCity = new JLabel(" ");
		positionAndAddComponent(fldCity, 			1, 2, 1, 1);
		
		lblState = new JLabel("State: ");
		positionAndAddComponent(lblState, 			2, 2, 1, c.RELATIVE);
		
		fldState = new JLabel(" ");
		positionAndAddComponent(fldState, 			3, 2, 1, c.REMAINDER);
		
		lblZipCode = new JLabel("ZipCode: ");
		positionAndAddComponent(lblZipCode, 		0, 3, 1, 1);
		
		fldZipCode = new JLabel(" ");
		positionAndAddComponent(fldZipCode, 		1, 3, 1, c.REMAINDER);
		
		lblPhone = new JLabel("Phone: ");
		positionAndAddComponent(lblPhone, 			0, 4, 1, 1);
		
		fldPhone = new JLabel(" ");
		positionAndAddComponent(fldPhone, 			1, 4, 1, 1);
		
		lblPhoneType = new JLabel("Phone Type: ");
		positionAndAddComponent(lblPhoneType, 		2, 4, 1, c.RELATIVE);
		
		fldPhoneType = new JLabel(" ");
		positionAndAddComponent(fldPhoneType, 		3, 4, 1, c.REMAINDER);
		
		lblEmail = new JLabel("Email: ");
		positionAndAddComponent(lblEmail, 			0, 5, 1, 1);
		
		fldEmail = new JLabel(" ");
		positionAndAddComponent(fldEmail, 			1, 5, 1, 1);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		
		fldSpacer = new JLabel(" ");
		buttonPanel.add(fldSpacer, BorderLayout.NORTH);
		
		btnPrevious = new JButton ("  Previous  ");
		btnPrevious.setActionCommand("Previous");
		btnPrevious.addActionListener(this);
		btnPrevious.setToolTipText("Move to previous contact");
		buttonPanel.add(btnPrevious , BorderLayout.WEST);
		
		btnEdit = new JButton ("       Edit       ");
		btnEdit.setActionCommand("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setToolTipText("Edit this contact");
		buttonPanel.add(btnEdit , BorderLayout.CENTER);
		
		btnNext = new JButton ("       Next       ");
		btnNext.setActionCommand("Next");
		btnNext.addActionListener(this);
		btnNext.setToolTipText("Move to next contact");
		buttonPanel.add(btnNext , BorderLayout.EAST);
		
		positionAndAddComponent(buttonPanel, 			1, 9, 1, 1);	
	}

	private void positionAndAddComponent(JComponent comp, int gridx, int gridy, 
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
		
		if((comp.equals(btnPrevious)) || (comp.equals(btnNext)) ||(comp.equals(btnEdit)))
		{c.insets = new Insets(40,0,0,0);}
		
		gridBag.setConstraints(comp, c);		
		detailPanel.add(comp);
	}




}
