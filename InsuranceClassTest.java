package ie.gmit.dip;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InsuranceClassTest {

	public static Insurance in;

	@BeforeAll
	public static void intro() {
		System.out.println("*************    Insurance Class Tests   *************\n");
	}

	@AfterAll
	public static void outro() {
		System.out.println("*************    Insurance Class Tests Ends   *************\n");
	}

	@BeforeEach
	public void setup() {
		in = new Insurance();
		System.out.println("------------      Test Start     ------------\n");
	}

	@AfterEach
	public void tearDown() {
		in = null;
		System.out.println("\n------------    Test Completed   ------------\n");
	}

	@DisplayName("calculateQuote(int): Testing user input")
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
	@ParameterizedTest
	@CsvSource({ "25%s5, 1075", "24%s6, 0", "17%s0, 600", "16%s, 0", "20%s2, 725", "50%s2, 625" })
	public void insurance_wait_for_user_input(String input, int expected) {
		String userInput = String.format(input, System.lineSeparator(), System.lineSeparator());
		ByteArrayInputStream byt = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(byt);

		int actual = in.calculateQuote();
		assertEquals(actual, expected);
	}

	@DisplayName("calculateQuote(int): Testing user input errors")
	@ParameterizedTest
	@CsvSource({ "aa%s25%s5, 1075", "24%saa%s6, 0", "-11%s24%s0, 600", "aa%s24%s0, 600", "aa%s16%s1, 0", "0%s4, 0" })
	public void insurance_incorrect_user_input_return_output(String input, int expected) {
		String userInput = String.format(input, System.lineSeparator(), System.lineSeparator());
		ByteArrayInputStream byt = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(byt);

		int actual = in.calculateQuote();
		assertEquals(actual, expected);
	}

}
