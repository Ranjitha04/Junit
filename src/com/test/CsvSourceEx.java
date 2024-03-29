package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceEx {
	
	@ParameterizedTest
	@CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
	    String actualValue = input.toUpperCase();
	    assertEquals(expected, actualValue);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
	    String actualValue = input.toLowerCase();
	    
	    assertEquals(expected, actualValue);
	}   
}
