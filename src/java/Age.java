package ie.gmit.dip;

/**
 * 
 * @author PJ 
 * Class implements methods to calculate the age surcharge based on the user's input.
 *
 */

public class Age {
	private static final int AGESURCHARGE = 100; // value of surcharge for users age <25 && >=17

	/**
	 * Method calculates a quote based on a user age input and a base quote value.
	 * Returns the calculate quote and a surcharge message is also displayed to the
	 * console depending on the input.
	 * 
	 * @param age 			User's age used to calculate the age surcharge
	 * @param baseQuote 	The initial quote before calculating age surcharge
	 * @return 				The quote int value based on a user inputs and base quote value
	 */
	public int applyAge(int age, int baseQuote) {
		baseQuote = getSurcharge(age, baseQuote); // Calculate the quote
		System.out.println(displaySurcharge(age)); // Display the relevant console message
		return baseQuote;
	}

	/**
	 * Method returns a String based on the user's input age. 
	 * Three possible output messages depending on the user's age.
	 * 
	 * @param age 			User's age used to determine the output message
	 * @return 				String used to display a relevant message to the console.
	 */

	private String displaySurcharge(int age) {
		String outputMsg; // Variable will be used to display console message

		// Checks user's age input to determine surchage
		if (age < 17) {
			outputMsg = "User Underage. No insurance.";
		} else if (age < 25) {
			outputMsg = "Additional age surcharge: " + AGESURCHARGE;
		} else {
			outputMsg = "No additional surcharge.";
		}
		return outputMsg;
	}

	/**
	 * Method calculates and returns the total quote depending on the user's age input. 
	 * An age <17 returns 0 which will result in no final quote or an age
	 * =>17 && <25 will incur an additional surcharge.
	 * 
	 * @param age 			User's age used to calculate the age surcharge
	 * @param baseQuote 	The initial quote before calculating age surcharge
	 * @return 				The quote int value based on a user inputs and base quote value
	 */
	private int getSurcharge(int age, int baseQuote) {
		if (age < 17) {
			baseQuote = 0; // Set baseQuote to 0, will result in no insurance quote
			return baseQuote;
		} else if (age < 25) {
			return baseQuote + AGESURCHARGE; // Add age surcharge to the base quote
		}

		return baseQuote; // If age >25 then no surcharge
	}

}
