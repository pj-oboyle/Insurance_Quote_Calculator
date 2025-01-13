package ie.gmit.dip;

import java.util.Scanner;

/**
 * 
 * @author PJ
 * Insurance class calculates an insurance quote and surcharges using methods from the Age
 * and Accidents classes.
 *
 */

public class Insurance {
	private final static int BASEQUOTE = 500; // Base value of the quote 

	/**
	 * Calculates an insurance quote from a base quote using two user inputs of
	 * user's age and number of accidents to determine applicable surcharges.
	 * A quote of 0 is returned if user age is <17 or accidents >5.
	 * 
	 * @param baseQuote 	The initial quote before calculating surcharges
	 * @return 				The quote based on a user inputs and base quote value 
	 */
	public int calculateQuote() {
		Scanner input = new Scanner(System.in);
		Age age1 = new Age();
		Accident acc = new Accident();

		// User input prompt # 1 (age)
		int age = integerPrompt("Enter your age: ", input);

		// Applys an age surcharge if age <25 && >16
		int quote = age1.applyAge(age, BASEQUOTE);

		
		// Calculate the accident surcharge only if age >16
		if (age > 16) {
			// User input prompt # 2 (# of accidents)
			int accidents = integerPrompt("\nHow many previous accidents did you have? ", input);
			// Apply the accident surcharge depending on # of accidents
			quote = acc.applyAccident(accidents, quote);
		}
		
		input.close(); // Close resource
		return quote;
	}
 
	/***
	 * Prompts user to input an integer until a valid input is returned.
	 * Must return a positive integer
	 * 
	 * @param prompt 		The String message used to prompt input from user
	 * @param scanner 		Scanner class object
	 * @return 				The user input of type int that is >= 0
	 */
	private int integerPrompt(String prompt, Scanner scanner) {
		int number;
		
		// Prompts user for input until returns a valid integer
		do {
			System.out.println(prompt);
			while (!scanner.hasNextInt()) {			// Loops while input is not an int
				String input = scanner.next();
				System.out.printf("\"%s\" Please Enter valid Integer!\n", input);
			}
			number = scanner.nextInt();
		} while (number < 0);						// Loops until integer is >=0

		return number;
	}

}
