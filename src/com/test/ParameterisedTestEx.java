package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterisedTestEx {

	@DisplayName("Fruits Test")
	@ParameterizedTest(name = "taking fruit {0}")
	@ValueSource(strings = {"apple", "orange", "grapes"})
	public void displayInput(String fruitName) {
		System.out.println(fruitName);
	}
	
	@ParameterizedTest
	@NullSource
	void isBlank_ShouldReturnTrueForNullInputs(String input) {
	    assertTrue(StringsUtil.isBlank(input));
	}
	
	static public class StringsUtil {
	    public static boolean isBlank(String input) {
	        return input == null || input.trim().isEmpty();
	    }
	}
}
