package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Month;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class EnumSourceEx {

	
	@ParameterizedTest
	@EnumSource(Month.class) // passing all 12 months
	void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
	    int monthNumber = month.getValue();
	    assertTrue(monthNumber >= 1 && monthNumber <= 12);
	}
	
	@ParameterizedTest
	@EnumSource(value = Month.class, names = {"FEBRUARY"})
	void someMonths_Are30DaysLong(Month month) {
	    assertEquals(28, month.length(false));
	}
}
