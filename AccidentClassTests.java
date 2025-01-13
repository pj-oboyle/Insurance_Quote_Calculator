package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AccidentClassTests {

	public static Accident ac;
	
	@BeforeAll
	public static void intro() {
		System.out.println("*************    Accident Class Tests   *************\n");
	}

	@AfterAll
	public static void outro() {
		System.out.println("*************    Accident Class Tests Ends   *************\n");
	}
	
	@BeforeEach
	void Setup() {
		ac = new Accident();
		System.out.println("------------      Test Start     ------------\n");
	}
	
	@AfterEach
	public void tearDown() {
		ac = null;
		System.out.println("\n------------    Test Completed   ------------\n");
	}

	
	@DisplayName("applyAccident(int, int): Outputs for when input baseQuote is zero")
	@ParameterizedTest
	@CsvSource({ "0, 0, 0", "1, 0, 50", "2, 0, 125", "6, 0, 0" })
	public void Accident_baseQuote_Zero_Return_Quote(int accidents, int baseQuote, int expected) {
		int actual = ac.applyAccident(accidents, baseQuote);
		assertEquals(actual, expected);
	}
	
	@DisplayName("applyAccident(int, int): Accident inputs for each possible output")
	@ParameterizedTest
	@CsvSource({ "0, 500, 500", "1, 500, 550", "2, 500, 625", "3, 500, 725", "4, 500, 875", "5, 500, 1075",
			"6, 500, 0" })
	public void Accident_Inputs_Returns_Quote(int accidents, int baseQuote, int expected) {
		int actual = ac.applyAccident(accidents, baseQuote);
		assertEquals(actual, expected);
	}
	
	@DisplayName("applyAccident(int, int): Out of Bounds Exception")
	@ParameterizedTest
	@CsvSource({ "-7, 500", "-1, 500" })
	public void Accidents_Input_OutOfBounds_ThrowsException(int accidents, int baseQuote) throws ArrayIndexOutOfBoundsException {
		String output = "Index " + accidents + " out of bounds for length 6";
		Throwable exp = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ac.applyAccident(accidents, baseQuote);
		});
		assertEquals(exp.getMessage(), output);
	}
	
	@DisplayName("applyAccident(null, int): Null Pointer Exception")
	@Test
	public void Accidents_Input_Null_ThrowsException() throws NullPointerException {
		String output = "Cannot invoke \"java.lang.Integer.intValue()\" because \"null\" is null";
		Throwable exp = assertThrows(NullPointerException.class, () -> {
			ac.applyAccident((Integer) null, 500);
		});
		assertEquals(exp.getMessage(), output);
	}
	
	@DisplayName("applyAccident(int, null): Null Pointer Exception")
	@Test
	public void Quote_Input_Null_ThrowsException() throws NullPointerException {
		String output = "Cannot invoke \"java.lang.Integer.intValue()\" because \"null\" is null";
		Throwable exp = assertThrows(NullPointerException.class, () -> {
			ac.applyAccident(0, (Integer) null);
		});
		assertEquals(exp.getMessage(), output);
	}
}
