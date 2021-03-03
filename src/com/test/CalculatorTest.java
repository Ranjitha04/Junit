package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.java.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

    Calculator calc;
	
	@BeforeAll
	public void setUp() {
		calc = new Calculator();
	}
	
	 
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
		public void testParametersFromMethod(String[] name, int value) {
		    System.out.println("method data " + name[0]+" "+name[1] + " value " + value);
		}

		private static Stream<Arguments> provideParameters() {
		    return Stream.of(
		            Arguments.of("'anu,bav'", 1),
		            Arguments.of("'cat,dog'", 2),
		            Arguments.of("'foo, tee'", 3)
		    );
		}
		
		@Test
		@Timeout(5)
		public void gmpty_method() {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	@Order(1)
	@Test
	@EnabledOnOs(OS.MAC)
	public void addTest() {
		int result = calc.add(4, 5);
		assertEquals(9, result);
		System.out.println("Current object 1: " + this);
	}
	
	@Test
	@DisplayName("Sub Func")
	@Order(2)
	@Disabled
	public void subTest() {
		int result = calc.sub(4, 5);
		assertEquals(-1, result);
		System.out.println("Current object 2: " + this);
	}
	
	@RepeatedTest(2)
	@DisplayName("Multi Func")
	@Order(3)
	public void multiTest() {
		int result = calc.multi(4, 5);
		assertEquals(20, result);
		System.out.println("Current object 3: " + this);
	}
	
	@Test
	@DisplayName("Division Func")
	@Order(5)
	public void divTest() {
		int result = calc.div(4, 5);
		assertEquals(0, result);
		System.out.println("Current object 4: " + this);
	}
	
	@Test
	@DisplayName("Division Func Expection Test")
	@Order(4)
	public void divTest1() {
		assertThrows(ArithmeticException.class, () -> calc.div(4, 0));
		System.out.println("Current object 5: " + this);
	}
	
	
}
