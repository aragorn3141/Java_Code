package ict4315.finalproject.Controllers;

import ict4315.finalproject.BaseClasses.Contact;
import ict4315.finalproject.BaseClasses.Phone;
import ict4315.finalproject.BaseClasses.HelperClasses.PhoneType;
import ict4315.finalproject.BaseClasses.HelperClasses.USStates;
import ict4315.finalproject.Models.MainModel;
import ict4315.finalproject.Views.AddEditView;

public class AddEditController {
	
	private static AddEditController controller = null;
	private MainModel model;
	private AddEditView view;
	private boolean contactAdded;

	//Constructors
	private AddEditController(AddEditView view)
	{
		model = MainModel.getInstance();
		this.view = view;
		contactAdded = false;
	}
	
	public static AddEditController getInstance(AddEditView view) {
		if (controller == null) {
			controller = new AddEditController(view);
		}
		return controller;
	}

	public void hideAddEditFrame() 
	{
		model.showMainGUI();
	}

	public void validateFullName() 
	{
    	if(model.validateFullName(view.getFullName()))
		{
    		view.setControlFocus(view.getStreetEnter());
		}
    	else
    	{
    		view.resetViewFullName();
    		view.setControlFocus(view.getFullNameEnter());
    	}
	}

	public void validateStreet() 
	{
		if(model.validateStreet(view.getStreet()))
		{
    		view.setControlFocus(view.getCityEnter());
		}
    	else
    	{
    		view.resetViewStreet();
    		view.setControlFocus(view.getStreetEnter());
    	}	
	}

	public void validateCity() 
	{
		if(model.validateCity(view.getCity()))
		{
    		view.setControlFocus(view.getStateEnter());
		}
    	else
    	{
    		view.resetViewCity();
    		view.setControlFocus(view.getCityEnter());
    	}	
	}

	public void validateState() 
	{
		if(USStates.indexOf(view.getState()) >= 0)
		{
    		view.setControlFocus(view.getZipCodeEnter());
		}
    	else
    	{
    		view.resetViewState();
    		view.setControlFocus(view.getStateEnter());
    	}	
	}

	public void validateZipCode() 
	{
    	if(model.validateZipCode(view.getZipCode()))
		{
    		view.setControlFocus(view.getPhoneEnter());
		}
    	else
    	{
    		view.resetViewZipCode();
    		view.setControlFocus(view.getZipCodeEnter());
    	}	
	}

	public void validatePhone() 
	{
    	if(model.validatePhone(view.getPhone()))
		{
    		view.setControlFocus(view.getPhoneTypeEnter());
		}
    	else
    	{
    		view.resetViewPhone();
    		view.setControlFocus(view.getPhoneEnter());
    	}	
	}
	
	public void validatePhoneType() 
	{
		if(PhoneType.indexOf(view.getPhoneType()) >= 0)
		{
    		view.setControlFocus(view.getEmailEnter());
		}
    	else
    	{
    		view.resetViewPhoneType();
    		view.setControlFocus(view.getPhoneTypeEnter());
    	}	
	}

	public void validateEmail() 
	{	
    	if(model.validateEmail(view.getEmail()))
		{
    		if(model.isAddedContact())
    		{
    			view.enableAddButton();
    		}
    		else
    		{
    			commitChanges();
    		}
		}
    	else
    	{
    		view.resetViewEmail();
    		view.setControlFocus(view.getEmailEnter());
    	}	
	}

	public void commitChanges() 
	{
		if(!hasDataChanged())
		{
			model.commitEdit(createContact());
		}
		else
		{
			model.showMainGUI();
		}
	}

	public void addContact() 
	{
		if(model.checkIfAllDataEntered())
		{
			model.addContactToContactList(createContact());
			contactAdded = true;
			
			//Reset everything so we can add another contact
			view.resetContactView();
		}	
	}
	
	public Contact createContact()
	{
		String emailFix = null;
		
		if(view.getEmail().length() > 0)
		{
			emailFix = view.getEmail();
		}
		
		
		Phone p = new Phone(view.getPhone(), view.getPhoneType());
		
		

		Contact c = new Contact(view.getFullName(), view.getStreet(),view.getCity(),
					view.getState(), view.getZipCode(), p, emailFix);
		return c;
	}
	
	public boolean hasDataChanged()
	{
		String fixEmail;
		
		if(model.getContactFromContactList().getEmail() == null)
		{
			fixEmail = "";
		}
		else
		{
			fixEmail = model.getContactFromContactList().getEmail();
		}
		
		return (model.getContactFromContactList().getFullName().equals(view.getFullName())) &&
				(model.getContactFromContactList().getStreet().equals(view.getStreet())) &&
				(model.getContactFromContactList().getCity().equals(view.getCity())) &&
				(model.getContactFromContactList().getState().equals(view.getState())) &&
				(model.getContactFromContactList().getZipCode().equals(view.getZipCode())) &&
				(model.getContactFromContactList().getPhone().getPhoneNumber().equals(view.getPhone())) &&
				(model.getContactFromContactList().getPhone().getPhoneType().equals(view.getPhoneType())) &&
				(fixEmail.equals(view.getEmail()));
	}
}
