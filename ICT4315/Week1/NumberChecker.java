

import java.util.InputMismatchException;
import java.util.Scanner;

	/**
	* @author Frederick McGovern
	* @version 1.1
	* @since 2014-03-26
	* 
	* This program gets five integers from the user and then dispays an indicator
	* showing the number of values greater than zero, equal to zero and less than zero.
	* */

public class NumberChecker
{

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		final int MAX_INPUTS = 5;//Create a constant to indicte how many numbers the user should enter
		
		Scanner scanner = new Scanner(System.in);
		
		int counter = 0;
		int positive = 0;
		int negative = 0;
		int zero = 0;
		
		System.out.println("Program requires the input of five integers");
		
		//Utilize do loop to retrieve a number from the user.  Utilizing try/catch in case value is not a number
		do
		{
			try
			{
				System.out.print("Please enter an integer:");
				int number = scanner.nextInt();
				
				if (number > 0) 
				{
					positive++;
				}
				else
				{
					if (number < 0)
					{
						negative++;
					}
					else
					{
						zero++;
					}
				}
				counter++;
				
			}
			catch(InputMismatchException e)
			{
				System.out.printf("\nException has occurred: %s\n", e);
				scanner.nextLine();//Throws out existing value so that we can get another value from user
				System.out.println("Your entry was invalid.\n");
			}
		} while (counter < MAX_INPUTS);
		
		//Output to user
		System.out.println();
		System.out.printf("The number of positive integers was: %s\n", positive);
		System.out.printf("The number of negative integers was: %s\n", negative);
		System.out.printf("The number of zero's was: %s\n", zero);
		
		//Close the scanner object to prevent a resource leak.
		scanner.close();
	}

}
