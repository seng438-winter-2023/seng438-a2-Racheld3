package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

public class RangeTest{

	//getLowerBound tests
	
	@Test
	public void getLowerBoundForValidRange() 
	{
		
		//setup
		Mockery mockingContext = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
	    
	    final Range testRange = mockingContext.mock(org.jfree.data.Range.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(testRange).getLowerBound();
	            will(returnValue(2));
	            one(testRange).getUpperBound();
	            will(returnValue(3));
	        }
	    });
	    
		double result = testRange.getLowerBound();
		double expectedResult = 2;
		
		//verify
		assertEquals(result, expectedResult, 0.00001); //dunno how precise it needs to be
		
	}
	
	@Test
	public void getLowerBoundForInvalidRange() 
	{
		
		//setup
		Mockery mockingContext = new Mockery() {{
	        setImposteriser(ClassImposteriser.INSTANCE);
	    }};
	    
	    final Range testRange = mockingContext.mock(org.jfree.data.Range.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(testRange).getLowerBound();
	            will(returnValue(3));
	            one(testRange).getUpperBound();
	            will(returnValue(2));
	        }
	    });
	    
		double result = testRange.getLowerBound();
		double expectedResult = 2; //is this the expected???
		
		//verify
		assertEquals(result, expectedResult, 0.00001); //dunno how precise it needs to be
		
	}
}
