package ict4315.finalproject.Views;

import ict4315.finalproject.BaseClasses.Contact;
import ict4315.finalproject.BaseClasses.ContactList;
import ict4315.finalproject.Models.MainModel;
import ict4315.finalproject.Templates.ViewTemplate;

import java.awt.BorderLayout;


import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListView  extends ViewTemplate implements
	ListSelectionListener {
	
	private static ListView view = null;
	private MainModel model;
	private JPanel listPanel;
	private DefaultListModel listModel;
	private JList list;
	private boolean listUpdating;
	
	//Constructors
	private ListView() 
	{
		model = MainModel.getInstance();
		model.addView(this);
		initializeList();
	}

	public static ListView getInstance() {
		if (view == null) {
			view = new ListView();
		}
		return view;
	}
	
	//Public methods
	public JPanel getPanel() {return listPanel;}
	
	@Override
	public void valueChanged(ListSelectionEvent le) {
		JList newList = (JList)le.getSource();
		
		//Have to check that all contacts haven't been deleted
		if(newList.isSelectionEmpty() == false)
		{
			int index = newList.getSelectedIndex();
			if(listUpdating == false)
			{
				model.setCurrentContactIndex(index);
			}
		}
	}

	public void updateView()
	{
		listUpdating = true;
		if(model.isAddedContact())
		{
			listModel.ensureCapacity(model.getList().Size() + 5);
			listModel.clear();
			
			for(Contact c : model.getList())
		    {
				listModel.addElement(c.getFullName());
		    }
		}
		
		list.setSelectedIndex(model.getCurrentContactIndex());
		listUpdating = false;
	}
	
	//Private methods
	private void initializeList() {
		
		listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		
		listModel = new DefaultListModel();
		
		for(Contact c : model.getList())
	    {
			listModel.addElement(c.getFullName());
	    }
		
		list = new JList(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		listPanel.add(list, BorderLayout.CENTER);
	}





}
