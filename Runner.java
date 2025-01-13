package ie.gmit.dip;

/**
 * 
 * @author PJ
 * Class contains the main method.
 */
public class Runner {
	public static void main(String[] args) {
		
		Insurance insure = new Insurance();
		
		// Store the value of the final quote in the variable final quote
		int finalQuote = insure.calculateQuote();
		
		}

}
