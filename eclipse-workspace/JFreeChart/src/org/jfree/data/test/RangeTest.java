package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.jmock.Mockery;
import org.junit.Test;

public class RangeTest{

	@Test
	public void getLowerBound() {
		
		//setup
		Mockery mockingContext = new Mockery();
	    final Range testRange = mockingContext.mock(Range.class);
	    
		//Range testRange = new Range(1, 2);
		double result = testRange.getUpperBound();
		double expectedResult = 1;
		
		//verify
		assertEquals(result, expectedResult, 0.00001); //dunno how precise it needs to be
		
	}

}
