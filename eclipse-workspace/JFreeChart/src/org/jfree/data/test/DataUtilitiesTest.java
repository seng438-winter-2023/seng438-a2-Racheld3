package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	@Test
	public void calculateColumnTotalForTwoValues() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 10.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	//CreateNumberArray(double[]) tests
	
	@Test
	public void createNumberArrayForEmptyArray() {
		//setup
		double[] testArray = {};
		
		Number[] result = DataUtilities.createNumberArray(testArray);
		
		Number[] expectedResult = {};
		
		//verify
		assertEquals(result, expectedResult);
		
		// tear-down: NONE in this test method
	}
	
	@Test
	public void createNumberArrayForNominalArray() {
		//setup
		double[] testArray = {1.0, 5600, 32.009, 4};
		
		Number[] result = DataUtilities.createNumberArray(testArray);
		
		Number[] expectedResult = {1.0, 5600.0, 32.009, 4.0};
		
		//verify
		assertEquals(result, expectedResult);
		
		// tear-down: NONE in this test method
	}
	
	@Test
	public void createNumberArrayForNullArray() {
		//setup
		double[] testArray = null;
		
		//test
		//verify
		//assertThrows(DataUtilites.class, () -> {DataUtilities.createNumberArray(testArray); });
		
		// tear-down: NONE in this test method
	}
	
//	@Test(expected = InvalidParameterException.class)
//	public void testCreateNumberArray2D(){
//		double[][] testArray;
//		createNumberArray2D(testArray);
//	}
	
	@Test
	public void testCreateNumberArray2DPositiveValues() {
		double[][] testArray = {{5.0, 7.75, 9333.51}, {523.6, 9.999, 2.0}, {11.0, 1234.1234, 72.0}};
		
		Number[][] result = createNumberArray2D(testArray);
		
		Number[][] expectedResult = {{5.0, 7.75, 9333.51}, {523.6, 9.999, 2.0}, {11.0, 1234.1234, 72.0}};
		
		assertArrayEquals(result, expectedResult);
	}
	
	//tests for getCumulative Percentages
	@Test
	public void getCumulativePercentagesTest() {
		Mockery mockingContext = new Mockery();
		final KeyedValues inputValues = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(inputValues).getItemCount();
				will(returnValue(3));
				
				//value of 5 giving key 0
				one(inputValues).getKey(5);
				will(returnValue(0));
				
				//key of 0 giving value 5
				one(inputValues).getValue(0);
				will(returnValue(5));
				
				//value of 9 giving key 1
//				one(inputValues).getKey(9);
//				will(returnValue(1));
				
				//key of 1 giving value 9
				one(inputValues).getValue(1);
				will(returnValue(9));
			
				//value of 2 giving key 2
				one(inputValues).getValue(2);
				will(returnValue(2));
				
				//key of 2 giving value 2
//				one(inputValues).getKey(2);
//				will(returnValue(2));
				
			}	
		});
		Mockery mockingContext1 = new Mockery();
		final KeyedValues expectedValues = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() {
			{
				allowing(expectedValues).getItemCount();
				will(returnValue(3));
				
				//value of 5/16 giving key 0
				one(inputValues).getKey(5/16);
				will(returnValue(0));
				
				//key of 0 giving value 5/16
				one(expectedValues).getValue(0);
				will(returnValue(5/16));
				
				//value of 14/16 giving key 1
				one(inputValues).getKey(14/16);
				will(returnValue(1));
				
				//key of 1 giving value 14/16
				one(expectedValues).getValue(1);
				will(returnValue(14/16));
				
				//value of 16/16 giving key 2
				one(inputValues).getKey(16/16);
				will(returnValue(2));
				
				//key of 2 giving value 16/16
				one(expectedValues).getValue(2);
				will(returnValue(16/16));
				
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(inputValues);
		assertEquals(expectedValues, result);
		
	}
	
	

}
