package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MethodSourceEx {
	
	static class MethodSourceUtil {
		
		@ParameterizedTest(name = "test {0}")
		@MethodSource("provideStringsForIsBlank")
		@DisplayName(value = "Method source")
		@EnabledIf("customCondition")
		void method_source_input_method(String input, boolean expected) {
		    assertEquals(expected, MethodSourceUtil.isBlank(input));
		}
		
		private static Stream<Arguments> provideStringsForIsBlank() {
		    return Stream.of(
		      Arguments.of(null, true),
		      Arguments.of("", true),
		      Arguments.of("  ", true),
		      Arguments.of("not blank", false)
		    );
		}
		
		public static boolean isBlank(String input) {
	        return input == null || input.trim().isEmpty();
	    }
		
		public static boolean customCondition() {
			///logic
			return true;
		}
	}
}
