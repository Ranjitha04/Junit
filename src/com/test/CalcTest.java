package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.java.Calculator;

@DisplayNameGeneration(CalcTest.MyDisplayNameGenerator.class)
public class CalcTest {
	 
     Calculator calc;
	
	 @BeforeEach
	 public void setUp() {
		calc = new Calculator();
	 }
	
	  @Test
	  void test_Add() {
	    assertEquals(5, calc.add(3, 2));
	  }
	  
	  @Test
	  void test_Multiply() {
	    assertEquals(15, calc.multi(3, 5));
	  }

	  @Test
	  void test_Devide() {
	    assertEquals(5, calc.div(25, 5));
	  }
	  
	  
	  static class MyDisplayNameGenerator extends DisplayNameGenerator.Standard {

	        @Override
	        public String generateDisplayNameForClass(Class<?> testClass) {
	            return super.generateDisplayNameForClass(testClass);
	        }

	        @Override
	        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
	            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
	        }

	        @Override
	        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
	            String name = testMethod.getName().replace('_', ' ').replace("test", "");
	            return name+" "+testClass.getSimpleName();
	        }
	  }
	  
	  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	  @Nested
	  public class Junit5_Diplay_Name_Generator_Test {
	    
	    @Test
	    void test_empty() {
	      
	    }
	  }
	    
}
