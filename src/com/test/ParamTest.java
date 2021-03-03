package com.test;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamTest {

static class NestedClass {
		
		@Test
		public void empty_method() {		
		}
		
		@ParameterizedTest(name = "Parameterised Test cases {0}")
		@ValueSource(strings = {"apple", "orange", "grapes"})
		public void readData(String input) {
			System.out.println("Input read from value source is" + input );
		}
		
		@ParameterizedTest
		@CsvSource({"a,1", "b,2", "foo,3"})
		public void testParameters(String name, int value) {
		    System.out.println("csv data " + name + " value " + value);
		}

		@ParameterizedTest
		@MethodSource("provideParameters")
		public void testParametersFromMethod(@ConvertWith(StringArrayConverter.class)String[] name, int value) {
		    System.out.println("method data " + name[0]+" "+name[1] + " value " + value);
		}

		private static Stream<Arguments> provideParameters() {
		    return Stream.of(
		            Arguments.of("'anu,bav'", 1),
		            Arguments.of("'cat,dog'", 2),
		            Arguments.of("'foo, tee'", 3)
		    );
		}
}	
}
