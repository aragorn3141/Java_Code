package ict4315.assignment10.Views;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddressBookDetailView implements ActionListener{
	
	protected GridBagLayout gridBag;
	protected GridBagConstraints c;
	
	
	private JPanel detailPanel;	
	private JPanel fillerPanel;
	
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
	private static JLabel lblSpace;
	
	private static JButton btnPrevious;
	private static JButton btnNext;
	private static JButton btnEdit;
	
	public AddressBookDetailView()
	{	
		initializeDetailPanel();
	}
	
	
	public void initializeDetailPanel()
	{	
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
		
		btnPrevious = new JButton ("  Previous  ");
		btnPrevious.setActionCommand("Previous");
		btnPrevious.addActionListener(this);
		btnPrevious.setToolTipText("Move to previous contact");
		positionAndAddComponent(btnPrevious, 		1, 9, 1, 1);
		
		btnEdit = new JButton ("       Edit       ");
		btnEdit.setActionCommand("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setToolTipText("Edit this contact");
		positionAndAddComponent(btnEdit, 			2, 9, 1, 1);
		
		btnNext = new JButton ("       Next       ");
		btnNext.setActionCommand("Next");
		btnNext.addActionListener(this);
		btnNext.setToolTipText("Move to next contact");
		positionAndAddComponent(btnNext, 			3, 9, 1, 1);	
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
		
		if((comp.equals(btnPrevious)) || (comp.equals(btnNext)) ||(comp.equals(btnEdit)))
		{c.insets = new Insets(40,0,0,0);}
		
		gridBag.setConstraints(comp, c);		
		detailPanel.add(comp);
	}
	
	
	public JPanel getPanel()
	{
		return detailPanel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
