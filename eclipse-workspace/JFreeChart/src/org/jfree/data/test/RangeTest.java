package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

public class RangeTest{

	/**
	 * getLowerBound() tests
	 */
	
	@Test
	public void testGetLowerBoundForLowerBoundPositive() 
	{
		//setup
		final Range testRange = new Range(185, 2003);
		double result = testRange.getLowerBound();
		double expectedResult = 185;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void testGetLowerBoundForLowerBoundAboveZero() 
	{
		//setup
		final Range testRange = new Range(1, 3);
		double result = testRange.getLowerBound();
		double expectedResult = 1;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void testGetLowerBoundForLowerBoundZero() 
	{
		//setup
		final Range testRange = new Range(0, 3);
		double result = testRange.getLowerBound();
		double expectedResult = 0;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void testGetLowerBoundForLowerBoundBelowZero() 
	{
		//setup
		final Range testRange = new Range(-1, 5);
		double result = testRange.getLowerBound();
		double expectedResult = -1;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void testGetLowerBoundForLowerBoundNegative()
	{
		//setup
		final Range testRange = new Range(-8, 3);
		double result = testRange.getLowerBound();
		double expectedResult = -8;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void testGetLowerBoundForSameLowerAndUpperBounds() 
	{
		//setup
		final Range testRange = new Range(0, 0);
		double result = testRange.getLowerBound();
		double expectedResult = 0;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	/**
	 * getUpperBound() tests
	 */
	
	@Test
	public void getUpperBoundForUpperBoundPositive() 
	{
		//setup
		final Range testRange = new Range(89.76, 93.295);
		double result = testRange.getUpperBound();
		double expectedResult = 93.295;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void getUpperBoundForUpperBoundAboveZero() 
	{
		//setup
		final Range testRange = new Range(-6.01, 0.65);
		double result = testRange.getUpperBound();
		double expectedResult = 0.65;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void getUpperBoundForUpperBoundZero() 
	{
		//setup
		final Range testRange = new Range(-8, 0);
		double result = testRange.getUpperBound();
		double expectedResult = 0;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void getUpperBoundForUpperBoundBelowZero() 
	{
		//setup
		final Range testRange = new Range(-4.7, -0.959);
		double result = testRange.getUpperBound();
		double expectedResult = -0.959;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void getUpperBoundForUpperBoundNegative() 
	{
		//setup
		final Range testRange = new Range(-67, -14);
		double result = testRange.getUpperBound();
		double expectedResult = -14;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	@Test
	public void testGetUpperBoundForSameLowerAndUpperBounds() 
	{
		//setup
		final Range testRange = new Range(0, 0);
		double result = testRange.getUpperBound();
		double expectedResult = 0;
		
		//verify
		assertEquals(expectedResult, result, .000000001d);
		
	}
	
	/**
	 * getLength() tests
	 */
	
	@Test
	public void getLengthForValidRange() 
	{
		final Range testRange = new Range(1, 11);
		double result = testRange.getLength();
		double expectedResult = 10;
		
		//verify
		assertEquals(expectedResult, result, 0.00001);
	}
	
	@Test
	public void getLengthForZeroLowerPositiveUpper() 
	{
		final Range testRange = new Range(0, 10);
		double result = testRange.getLength();
		double expectedResult = 10;
		
		//verify
		assertEquals(expectedResult, result, 0.00001);
	}
	
	@Test
	public void getLengthForNegativeLowerPositiveUpper() 
	{
		final Range testRange = new Range(-5, 10);
		double result = testRange.getLength();
		double expectedResult = 15;
		
		//verify
		assertEquals(expectedResult, result, 0.00001);
	}
	
	@Test
	public void getLengthForNegativeLowerZeroUpper() 
	{
		final Range testRange = new Range(-5, 0);
		double result = testRange.getLength();
		double expectedResult = 5;
		
		//verify
		assertEquals(expectedResult, result, 0.00001);
	}
	
	@Test
	public void getLengthForNegativeLowerNegativeUpper() 
	{
		final Range testRange = new Range(-10, -5);
		double result = testRange.getLength();
		double expectedResult = 5;
		
		//verify
		assertEquals(expectedResult, result, 0.00001);
	}

	/**
	 * Tests for getCentralValue()
	 */
	
	@Test
	public void testGetCentralValueForLowerBoundPositiveUpperBoundPositive() {
		//setup
		final Range testRange = new Range(5, 18.5);
		double result = testRange.getCentralValue();
		double expectedResult = 11.75;
		
		//verify
		assertEquals(expectedResult, result, 0.001);
	}
	
	@Test
	public void testGetCentralValueForLowerBoundZeroUpperBoundPositive() {
		//setup
		final Range testRange = new Range(0, 12);
		double result = testRange.getCentralValue();
		double expectedResult = 6;
		
		//verify
		assertEquals(expectedResult, result, 0.001);
	}
	
	@Test
	public void testGetCentralValueForLowerBoundNegativeUpperBoundPositive() {
		//setup
		final Range testRange = new Range(-7.5, 4);
		double result = testRange.getCentralValue();
		double expectedResult = -1.75;
		
		//verify
		assertEquals(expectedResult, result, 0.001);
	}
	
	@Test
	public void testGetCentralValueForLowerBoundNegativeUpperBoundZero() {
		//setup
		final Range testRange = new Range(-16, 0);
		double result = testRange.getCentralValue();
		double expectedResult = -8;
		
		//verify
		assertEquals(expectedResult, result, 0.001);
	}
	
	@Test
	public void testGetCentralValueForLowerBoundNegativeUpperBoundNegative() {
		//setup
		final Range testRange = new Range(-23.12, -22.45);
		double result = testRange.getCentralValue();
		double expectedResult = -22.785;
		
		//verify
		assertEquals(expectedResult, result, 0.001);
	}
	
	@Test
	public void testGetCentralValueForRangeOfLengthZero() {
		//setup
		final Range testRange = new Range(9, 9);
		double result = testRange.getCentralValue();
		double expectedResult = 9;
		
		//verify
		assertEquals(expectedResult, result, 0.001);
	}
	
	/**
	 * Tests for contains()
	 */
	
	@Test
	public void testContainsAboveUpperBoundOfRange() {
		//setup
		final Range testRange = new Range(-6.80, 12.895);
		boolean result = testRange.contains(13);
		boolean expectedResult = false;
		
		//verify
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testContainsAtUpperBoundOfRange() {
		//setup
		final Range testRange = new Range(0, 98.9234);
		boolean result = testRange.contains(98.9234);
		boolean expectedResult = true;
		
		//verify
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testContainsBelowUpperBoundOfRange() {
		//setup
		final Range testRange = new Range(-72.55, -23);
		boolean result = testRange.contains(-23.778);
		boolean expectedResult = true;
		
		//verify
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testContainsForNominalValue() {
		//setup
		final Range testRange = new Range(10.5, 24.68);
		boolean result = testRange.contains(17.9);
		boolean expectedResult = true;
		
		//verify
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testContainsAboveLowerBoundOfRange() {
		//setup
		final Range testRange = new Range(-54.5, 0);
		boolean result = testRange.contains(-53.9);
		boolean expectedResult = true;
		
		//verify
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testContainsAtLowerBoundOfRange() {
		//setup
		final Range testRange = new Range(67, 123);
		boolean result = testRange.contains(67);
		boolean expectedResult = true;
		
		//verify
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testContainsBelowLowerBoundOfRange() {
		//setup
		final Range testRange = new Range(-5.006, -1.11);
		boolean result = testRange.contains(-6.123);
		boolean expectedResult = false;
		
		//verify
		assertEquals(expectedResult, result);
	}
}
