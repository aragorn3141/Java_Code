import java.util.Scanner;

public class ReverseString
{

	/**
	* @author Frederick McGovern
	* @version 1.4
	* @since 2014-03-28
	* 
	* This program continuously gets an input from the user.  If the input is equal to "tiuq'
	* then the program will terminate.  If the input is something else then the reverse
	* of the input will be displayed to the user.
	* */
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		System.out.println("Program will print the reverse of users input.");
		
		do
		{
			System.out.println("Please enter some input.  To terminate program type 'tiuq'");
			String text = scanner.next();
			
			if (text.equals("tiuq"))
			{
				break;//Force exit from the do loop
			}
			else
			{
				sb.append(text);
				System.out.printf("%s\n", sb.reverse());
				sb.setLength(0);
			}
		}while (true); //Per java documentation this would create an infinite loop hence requiring the need for a break in the loop.
		
		//Close the scanner object to prevent a resource leak.
		scanner.close();
	}
}
