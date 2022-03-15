package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.java.Calculator;
import com.test.metaannotation.TestDisplayName;

@DisplayNameGeneration(CustomeDisplayNameGenerator.MyDisplayNameGenerator.class)
@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	Calculator calculator;
	
	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}
	
	@RepeatedTest(5)
	@Order(1)
	public void addition_test_() {
		System.out.println("  add   " + this);
		
		int result = calculator.add(5, 6);
		assertEquals(11, result);
	}
	
	@Test
	@Order(2)
	public void subtraction_test() {
		System.out.println("  sub   " + this);
		
		int result = calculator.sub(5, 2);
		assertEquals(3, result);
	}
	
	@Test
	@Order(5)
	public void multiplication_test() {
		System.out.println("  multi   " + this);
		
		int result = calculator.multiply(5, 8);
		assertEquals(40, result);
	}
	
	@Test
	@Order(3)
	public void division_test() {
		System.out.println("  div   " + this);
		
		int result = calculator.divide(4, 2);
		assertEquals(2, result);
	}
	
	@Test
	@Order(4)
	public void division_test_Negative() {
		System.out.println("  div negative  " + this);
		
		assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
	}
	
}
