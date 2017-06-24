package ict4315.assignment9;

public interface ContactView 
{
	public void refreshContactView(String fullName, String street, String city, String state, 
			String zipCode, String phone, String email);

	public void resetViewFullName();
	
	public void resetViewStreet();
	
	public void resetViewCity();
	
	public void resetViewState();
	
	public void resetViewZipCode();
	
	public void resetViewPhone();
	
	public void resetViewEmail();

}
