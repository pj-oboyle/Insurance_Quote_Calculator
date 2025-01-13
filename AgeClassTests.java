package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AgeClassTests {

	
	public static Age ag;
	
	
	@BeforeAll
	public static void intro() {
		System.out.println("*************    Age Class Tests   *************\n");
	}

	@AfterAll
	public static void outro() {
		System.out.println("*************    Age Class Tests Ends   *************\n");
	}

	@BeforeEach
	void setup() {
		ag = new Age();
		System.out.println("------------      Test Start     ------------\n");
	}
	
	@AfterEach
	public void tearDown() {
		ag = null;
		System.out.println("\n------------    Test Completed   ------------\n");
	}
	
	
	@DisplayName("applyAge(int, int): Outputs for when input baseQuote is zero")
	@ParameterizedTest
	@CsvSource({ "24, 0, 100", "25, 0, 0", "16, 0, 0", "17, 0, 100" })
	public void Accident_baseQuote_Zero_Returns_Quote(int accidents, int baseQuote, int expected) {
		int actual = ag.applyAge(accidents, baseQuote);
		assertEquals(actual, expected);
	}
	
	@DisplayName("applyAge(int, int): Outputs for age inputs")
	@ParameterizedTest
	@CsvSource({ "50, 500, 500", "25, 500, 500", "24, 500, 600", "17, 500, 600" })
	public void Age_Inputs_Returns_Quote(int age, int baseQuote, int result) {
		int actualResult = ag.applyAge(age, baseQuote);
		assertEquals(actualResult, result);
	}
	
	@DisplayName("applyAges(int, int): Invalid Age Inputs Tests")
	@ParameterizedTest
	@CsvSource({ "-1, 500, 0", "0, 500, 0", "16, 500, 0" })
	public void Invalid_Ages_Returns_Zero(int age, int baseQuote, int result) {
		int actualResult = ag.applyAge(age, baseQuote);
		assertEquals(actualResult, result);
	}

	@DisplayName("applyAge(null, int): Null Pointer Exception")
	@Test
	public void Age_Input_Null_ThrowsException() throws NullPointerException {
		String output = "Cannot invoke \"java.lang.Integer.intValue()\" because \"null\" is null";
		Throwable exp = assertThrows(NullPointerException.class, () -> {
			ag.applyAge((Integer) null, 500);
		});
		assertEquals(exp.getMessage(), output);
	}
	
	@DisplayName("applyAge(int, null): Null Pointer Exception")
	@Test
	public void Quote_Input__Null_ThrowsException() throws NullPointerException {
		String output = "Cannot invoke \"java.lang.Integer.intValue()\" because \"null\" is null";
		Throwable exp = assertThrows(NullPointerException.class, () -> {
			ag.applyAge(25, (Integer) null);
		});
		assertEquals(exp.getMessage(), output);
	}

	
}
