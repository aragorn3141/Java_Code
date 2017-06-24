package ict4315.assignment7;

public class ContactTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Contact c1 = new Contact("James Cochoran", "46 Robin Drive", "Mattapan", "MA", "02366", "617-855-2431", "JCochoran14@yahoo.com");
		Contact c2 = new Contact("Barbara Snow", "135 Old School House Rd", "Colcester", "RI", "04235", "339-933-6405", null);
		
		//Create a strategy - initial set to PlainTextFileStrategy
		CreateFileOutput strategy1 = new PlainTextFileStrategy();
		CreateFileOutput strategy2 = new HTMLFileStrategy();
		CreateFileOutput strategy3 = new XMLFileStrategy();
		
		//Set the strategy
		c1.setOutputFileStrategy(strategy1);
		c2.setOutputFileStrategy(strategy1);
		
		//Set the file location
		String fileLoc = "C:\\Users\\Public\\";
		
		//Write to file
		c1.writeContactToFile(fileLoc);
		c2.writeContactToFile(fileLoc);
		
		//Set the strategy
		c1.setOutputFileStrategy(strategy2);
		c2.setOutputFileStrategy(strategy2);
		
		//Write to file
		c1.writeContactToFile(fileLoc);
		c2.writeContactToFile(fileLoc);
		
		//Set the strategy
		c1.setOutputFileStrategy(strategy3);
		
		
		//Write to file
		c1.writeContactToFile(fileLoc);
	}

}
