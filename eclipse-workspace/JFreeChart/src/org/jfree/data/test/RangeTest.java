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
		final Range testRange = new Range(2, 3);
		double result = testRange.getLowerBound();
		double expectedResult = 2;
		
		//verify
		assertEquals(result, expectedResult, 0.00001); //dunno how precise it needs to be
		
	}
}
