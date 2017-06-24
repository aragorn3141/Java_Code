import java.util.InputMismatchException;
import java.util.Scanner;

public class TestAddress
{

	/**
	 * @author Frederick McGovern
	 * @version 1.2
	 * @since 2014-03-28
	 * 
	 * This program inputs from the user five values representing the variables
	 * contactName, streetAddr, city, state, and zipCode.  Once all data is
	 * entered the program will execute the Address.toString method to output
	 * the values back to the user.
	 */
	public static void main(String[] args) 
	{
		String contactName, streetAddr, city, state;
		int zipCode;
		
		Scanner scanner = new Scanner(System.in);
		
		try
		{
			System.out.println("Please enter a contact name:");
			contactName = scanner.nextLine();
		
			System.out.println("Please enter a street address:");
			streetAddr = scanner.nextLine();
		
			System.out.println("Please enter a city:");
			city = scanner.nextLine();
		
			System.out.println("Please enter a state:");
			state = scanner.nextLine();

			System.out.println("Please enter a five digit zip code:");
			zipCode = scanner.nextInt();

			//Call the Address constructor passing in the five variables determined by the user
			Address addr1 = new Address(contactName, streetAddr, city, state, String.valueOf(zipCode));
		
			System.out.println(addr1.toString());
		}
		//These will catch issues with ip code
		catch(InputMismatchException | StringIndexOutOfBoundsException e)
		{
			System.out.printf("\nException has occurred: %s\n", e);
			scanner.nextLine();//Throws out existing value so that we can get another value from user
			System.out.println("Your entry was invalid.\n");
		}
		
		/*Option 2 default constructor and then use getter and setter methods.  This checks that these methods are working
		Address addr2 = new Address();
				
		System.out.println("Please enter a contact name:");
		addr2.setContactName(scanner.nextLine());
		System.out.println(addr2.getContactName());
		
		System.out.println("Please enter a street address:");
		addr2.setStreetAddr(scanner.nextLine());
		System.out.println(addr2.getStreetAddr());
		
		System.out.println("Please enter a city:");
		addr2.setCity(scanner.nextLine());
		System.out.println(addr2.getCity());
		
		System.out.println("Please enter a state:");
		addr2.setState(scanner.nextLine());
		System.out.println(addr2.getState());
		
		System.out.println("Please enter a zip code:");
		addr2.setZipCode(scanner.nextLine());
		System.out.println(addr2.getZipCode());*/
		
		//Close the scanner object to prevent a resource leak.
		scanner.close();
	}
}
