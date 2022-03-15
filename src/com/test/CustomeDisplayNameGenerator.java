package com.test;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(CustomeDisplayNameGenerator.MyDisplayNameGenerator.class)
public class CustomeDisplayNameGenerator {

	  @Test
	  void some_test_method() {
	 
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
	
}
