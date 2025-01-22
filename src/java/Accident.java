package ie.gmit.dip;

/**
 * 
 * @author PJ 
 * Class implements methods to calculate the accident surcharge based on the user's input.
 */

public class Accident {
	private static final int[] SURCHARGES = { 0, 50, 125, 225, 375, 575 }; // Surcharge increments for 0 to 5 accidents

	/**
	 * Method calculates a quote based on the number of previous accidents input by
	 * the user added to a base quote value. Returns the calculate quote and a surcharge
	 * message is also displayed to the console relevant on the input.
	 * 
	 * @param accidents		Input from user for their number of previous accidents
	 * @param baseQuote     The initial quote before calculating age surcharge
	 * @return 				The quote int value based on a user inputs and base quote value
	 */
	public int applyAccident(int accidents, int baseQuote) {
		int quote = getSurcharge(accidents, baseQuote); 					// Calculate the quote
		System.out.println(displaySurcharge(accidents, quote)); 			// Display the relevant console message
		return quote;
	}

	/**
	 * Method returns a String based on the number of previous accidents user
	 * inputs. Three possible output messages depending on the user's input.
	 * 
	 * @param accidents 	Number of accidents used to determine the output message
	 * @param baseQuote 	The initial quote before calculating age surcharge used in message output
	 * @return 				String used to display a relevant message to the console.
	 */
	private String displaySurcharge(int accidents, int baseQuote) {
		String outputMsg;
		// Check if the number of accidents exceeds six
		if (accidents >= 6) {
			outputMsg = "Too many accidents. No insurance.";
		} else if (accidents == 0) {
			outputMsg = "No surcharge.\nTotal amount to pay: " + baseQuote;
		} else {
			outputMsg = "Additional surcharge for accident: " + SURCHARGES[accidents] + " \nTotal amount to pay: "
					+ baseQuote;
		}
		return outputMsg;
	}

	/**
	 * Method calculates and returns the total quote depending on the user's input
	 * for the number of previous accidents. 
	 * The number of accidents will increase the incurred surcharge based on the 
	 * values stored in the constant SURCHARGES array.
	 * If the number of accidents exceeds 5 then 0 is returned, resulting in no final quote.
	 * 
	 * @param accidents 	Input from user for their number of previous accidents
	 * @param baseQuote 	The initial quote before calculating age surcharge
	 * @return 				The quote int value based on a user inputs and base quote value
	 */
	private int getSurcharge(int accidents, int baseQuote) {
		if (accidents >= 6) {
			baseQuote = 0;
			return baseQuote;
		}
		return baseQuote + SURCHARGES[accidents];
	}

}
