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

	//calculateColumnTotal(Values2D, int) tests
	
	@Test
	public void calculateColumnTotalForTwoValuesFirstColumn() //From the examples in the assignment instructions
	{
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
	    assertEquals(10.0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForThreeValuesLastColumn()
	{
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 2);
	            will(returnValue(-7.5));
	            one(values).getValue(1, 2);
	            will(returnValue(2.5));
	            one(values).getValue(2, 2);
	            will(returnValue(5.0));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 2);
	    // verify
	    assertEquals(0.0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForOneValue()
	{
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(-7.5));
	          
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(-7.5, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForNoValues()
	{
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));    
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForInvalidColumn()
	{
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1)); 
	            one(values).getValue(0, -1);
	            will(returnValue(0));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, -1);
	    // verify
	    assertEquals(0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	//calculateRowTotal(Values2D, int)
	
	@Test
	public void calculateRowTotalForTwoValuesFirstRow() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(10.0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForThreeValuesLastRow() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(2, 1);
	            will(returnValue(2.5));
	            one(values).getValue(2, 2);
	            will(returnValue(5.0));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 2);
	    // verify
	    assertEquals(0.0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForOneValue() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(38));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(38.0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForNoValues()
	{
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(0));    
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForInvalidColumn()
	{
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(1)); 
	            one(values).getValue(-1, 0);
	            will(returnValue(0));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, -1);
	    // verify
	    assertEquals(0, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	//CreateNumberArray(double[]) tests
	
	@Test(expected = InvalidParameterException.class)
	public void testCreateNumberArrayWithNullInput(){
		double[] testArray = null;
		createNumberArray(testArray);
	}
	
	
	@Test
	public void createNumberArrayForEmptyArray() {
		//setup
		double[] testArray = {};
		
		Number[] result = DataUtilities.createNumberArray(testArray);
		
		Number[] expectedResult = {};
		
		//verify
		assertArrayEquals(result, expectedResult);
		
		// tear-down: NONE in this test method
	}
	
	@Test
	public void createNumberArrayForArrayOfLengthOne() {
		//setup
		double[] testArray = {-98};
		
		Number[] result = DataUtilities.createNumberArray(testArray);
		
		Number[] expectedResult = {-98.0};
		
		//verify
		assertArrayEquals(expectedResult, result);
		
		// tear-down: NONE in this test method
	}
	
	@Test
	public void createNumberArrayForNominalArray() {
		//setup
		double[] testArray = {1.0, 5600, -32.009, 4};
		
		Number[] result = DataUtilities.createNumberArray(testArray);
		
		Number[] expectedResult = {1.0, 5600.0, -32.009, 4.0};
		
		//verify
		assertArrayEquals(expectedResult, result);
		
		// tear-down: NONE in this test method
	}

	
	//CreateNumberArray2D tests
	
	@Test(expected = InvalidParameterException.class)
	public void testCreateNumberArray2D(){
		double[][] testArray = null;
		createNumberArray2D(testArray);
	}
	
	@Test
	public void testCreateNumberArray2DPositiveValues() {
		double[][] testArray = {{5.0, 7.75, 9333.51}, {523.6, 9.999, 2.0}, {11.0, 1234.1234, 72.0}};
		
		Number[][] result = createNumberArray2D(testArray);
		
		Number[][] expectedResult = {{5.0, 7.75, 9333.51}, {523.6, 9.999, 2.0}, {11.0, 1234.1234, 72.0}};
		
		assertArrayEquals(result, expectedResult);
	}
	
	@Test
	public void testCreateNumberArray2DNegativeValuesOneArray() {
		double[][] testArray = {{-5.0, -7.75, -9333.51}};
		
		Number[][] result = createNumberArray2D(testArray);
		
		Number[][] expectedResult = {{-5.0, -7.75, -9333.51}};
		
		assertArrayEquals(result, expectedResult);
	}
	
	@Test
	public void testCreateNumberArray2DEmptyArray() {
		double[][] testArray = {{}, {}};
		
		Number[][] result = createNumberArray2D(testArray);
		
		Number[][] expectedResult = {{}, {}};
		
		assertArrayEquals(result, expectedResult);
		
	}
	
	@Test
	public void testCreateNumberArray2DPositiveValuesAndEmptyArray() {
		double[][] testArray = {{}, {11.0, 1234.1234, 72.0}};
		
		Number[][] result = createNumberArray2D(testArray);
		
		Number[][] expectedResult = {{}, {11.0, 1234.1234, 72.0}};
		
		assertArrayEquals(result, expectedResult);
		
	}
	
	//tests for getCumulative Percentages
	
	@Test
	public void getCumulativePercentagesTestForValidValues() {
		Mockery mockingContext = new Mockery();
		final KeyedValues inputValues = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(inputValues).getItemCount();
				will(returnValue(3));
				
				allowing(inputValues).getKey(0);
				will(returnValue(0));
				
				allowing(inputValues).getKey(1);
				will(returnValue(1));
				
				allowing(inputValues).getKey(2);
				will(returnValue(2));
				
				
				//key of 0 giving value 5
				allowing(inputValues).getValue(0);
				will(returnValue(5.0));
				
				//key of 1 giving value 9
				allowing(inputValues).getValue(1);
				will(returnValue(9.0));
			
				//value of 2 giving key 2
				allowing(inputValues).getValue(2);
				will(returnValue(2.0));
				
				
			}	
		});
		
		Number expectedResult[] = {5.0/16.0, 14.0/16.0, 16.0/16.0};
		
		KeyedValues result = DataUtilities.getCumulativePercentages(inputValues);

		Number actualResult[] = {result.getValue(0), result.getValue(1), result.getValue(2)};
		
		assertArrayEquals(expectedResult, actualResult);
		
	}
	
	//looks like method is not taking into account the first value in the table when calculating the sum, 
	//therefore, the sum becomes 11, and so the percentages are thrown off in the results. For example instead
	//of 5/16 = 0.3125 it is 5/11 = 0.4545.
	
	//so testing with only one value in the table that is not accounted for in the sum calculation
	//should result in a division by 0 = infinity
	
	@Test
	public void getCumulativePercentagesTestForOneValue() {
		Mockery mockingContext = new Mockery();
		final KeyedValues inputValues = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(inputValues).getItemCount();
				will(returnValue(1));
				
				allowing(inputValues).getKey(0);
				will(returnValue(0));
							
				
				//key of 0 giving value 5
				allowing(inputValues).getValue(0);
				will(returnValue(5.0));
				
			}	
		});
		
		Number expectedResult[] = {5.0/5.0};
		
		KeyedValues result = DataUtilities.getCumulativePercentages(inputValues);

		Number actualResult[] = {result.getValue(0)};
		
		assertArrayEquals(expectedResult, actualResult);
		
	}
	
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesTestForException(){
		getCumulativePercentages(null);
	}
	
	@Test
	public void getCumulativePercentagesTestForNegativeValue() {
		Mockery mockingContext = new Mockery();
		final KeyedValues inputValues = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(inputValues).getItemCount();
				will(returnValue(3));
				
				allowing(inputValues).getKey(0);
				will(returnValue(0));
				
				allowing(inputValues).getKey(1);
				will(returnValue(1));
				
				allowing(inputValues).getKey(2);
				will(returnValue(2));
				
				
				//key of 0 giving value 5
				allowing(inputValues).getValue(0);
				will(returnValue(5.0));
				
				//key of 1 giving value 9
				allowing(inputValues).getValue(1);
				will(returnValue(9.0));
			
				//value of -2 giving key 2
				allowing(inputValues).getValue(2);
				will(returnValue(-2.0));
				
				
			}	
		});
		
		Number expectedResult[] = {5.0/12.0, 14.0/12.0, 12.0/12.0};
		
		KeyedValues result = DataUtilities.getCumulativePercentages(inputValues);

		Number actualResult[] = {result.getValue(0), result.getValue(1), result.getValue(2)};
		
		assertArrayEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void getCumulativePercentagesTestForOneNegativeValue() {
		Mockery mockingContext = new Mockery();
		final KeyedValues inputValues = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(inputValues).getItemCount();
				will(returnValue(1));
				
				allowing(inputValues).getKey(0);
				will(returnValue(0));
							
				
				//key of 0 giving value -5
				allowing(inputValues).getValue(0);
				will(returnValue(-5.0));
				
			}	
		});
		
		Number expectedResult[] = {-5.0/-5.0};
		
		KeyedValues result = DataUtilities.getCumulativePercentages(inputValues);

		Number actualResult[] = {result.getValue(0)};
		
		assertArrayEquals(expectedResult, actualResult);
		
	}
}
