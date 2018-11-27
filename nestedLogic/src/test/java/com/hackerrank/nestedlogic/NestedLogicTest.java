package com.hackerrank.nestedlogic;

import static org.junit.Assert.*;
import org.junit.Test;


public class NestedLogicTest {

	@Test
	public void ifReturnedYearBeforeExpectedYearNoFine() {
		int calculatedFine =  NestedLogic.calculeFine(1, 1, 2000, 1, 1, 2001);
		int noFine = 0;
		assertEquals(noFine, calculatedFine);
	}
	
	@Test
	public void ifSameYearAndReturnedMonthBeforeExpectedMonthNoFine() {
		int calculatedFine =  NestedLogic.calculeFine(1, 1, 2000, 1, 2, 2000);
		int noFine = 0;
		assertEquals(noFine, calculatedFine);
	}
	
	@Test
	public void ifSameYearAndSameMonthAndReturnedDayBeforeExpectedDayNoFine() {
		int calculatedFine =  NestedLogic.calculeFine(1, 1, 2000, 2, 1, 2000);
		int noFine = 0;
		assertEquals(noFine, calculatedFine);
	}
	
	@Test
	public void ifSameYearAndSameMonthAndSameDayNoFine() {
		int calculatedFine =  NestedLogic.calculeFine(1, 1, 2000, 1, 1, 2000);
		int noFine = 0;
		assertEquals(noFine, calculatedFine);
	}
	
	@Test
	public void ifSameYearAndSameMonthAndReturnedDayAfterExpectedDaySmallFine() {
		int calculatedFine =  NestedLogic.calculeFine(2, 1, 2000, 1, 1, 2000);
		int noFine = 15;
		assertEquals(noFine, calculatedFine);
	}
	
	@Test
	public void ifSameYearAndReturnedMonthAfterExpectedMonthMediumFine() {
		int calculatedFine =  NestedLogic.calculeFine(1, 2, 2000, 1, 1, 2000);
		int noFine = 500;
		assertEquals(noFine, calculatedFine);
	}
	
	@Test
	public void ifReturnedYearAfterExpectedYearBigFine() {
		int calculatedFine =  NestedLogic.calculeFine(1, 1, 2001, 1, 1, 2000);
		int noFine = 10000;
		assertEquals(noFine, calculatedFine);
	}
}
