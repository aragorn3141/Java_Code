package ict4315.assignment9;

/**
* @author Frederick McGovern
* @version 1.7
* @since 2014-05-30
* 
* This is a class that represents the controller between the AddressBook model and view
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class AddressBookController implements ActionListener{
	
	//private member variables
	private AddressBookModel model;
	private AddressBookAddContactView view;
    
	//Constructors
    public AddressBookController(AddressBookModel model, AddressBookAddContactView view){
        this.model = model;
        this.view = view;
    }
    
    //private method which is used to make a call the the models updateModel method
    private void updateModel()
    {
    	model.updateModel(view.getFullName(), view.getStreet(), view.getCity(), view.getState(), 
        			         view.getZipCode(), view.getPhone(), view.getEmail());
    }
    
    /**
	 * A method used to determine what actions to take based on the event triggered
	 */
    public void actionPerformed(ActionEvent evt){
        Object source = evt.getSource();
        if (source == view.getAddClick())
        {
        	model.addContact(view.getFullName(), view.getStreet(), view.getCity(), view.getState(), 
        			         view.getZipCode(), view.getPhone(), view.getEmail());
        	
        	view.resetContactView();
        }
        else if (source == view.getCancelClick())
        {
        	model.outputAllContactsToConsole();
        	System.exit(0);
        }
        else if (source == view.getFullNameEnter())
        {

        	if(model.validateFullName(view.getFullName()))
			{
        		view.setControlFocus(view.getStreetEnter());
			}
        	else
        	{
        		view.setControlFocus(source);
        	}
        }
    	else if (source == view.getStreetEnter())
        {

        	if(model.validateStreet(view.getStreet()))
			{
        		view.setControlFocus(view.getCityEnter());
			}
        	else
        	{
        		view.setControlFocus(source);
        	}	
        }
    	else if (source == view.getCityEnter())
        {

        	if(model.validateCity(view.getCity()))
			{
        		view.setControlFocus(view.getStateEnter());
			}
        	else
        	{
        		view.setControlFocus(source);
        	}	
        }
    	else if (source == view.getStateEnter())
        {

        	if(model.validateState(view.getState()))
			{
        		view.setControlFocus(view.getZipCodeEnter());
			}
        	else
        	{
        		view.resetViewState();
        		view.setControlFocus(source);
        	}	
        }
    	else if (source == view.getZipCodeEnter())
        {

        	if(model.validateZipCode(view.getZipCode()))
			{
        		view.setControlFocus(view.getPhoneEnter());
			}
        	else
        	{
        		view.resetViewZipCode();
        		view.setControlFocus(source);
        	}	
        }
    	else if (source == view.getPhoneEnter())
        {

        	if(model.validatePhone(view.getPhone()))
			{
        		view.setControlFocus(view.getEmailEnter());
			}
        	else
        	{
        		view.resetViewPhone();
        		view.setControlFocus(source);
        	}	
        }
    	else
    	{
    		if(model.validateEmail(view.getEmail()))
    		{
    			updateModel();
    		}
    		else
    		{
    			view.resetViewEmail();
    			view.setControlFocus(source);
    		}
    	}  
    }
}
