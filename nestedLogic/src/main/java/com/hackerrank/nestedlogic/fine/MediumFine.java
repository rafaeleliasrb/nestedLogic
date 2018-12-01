package com.hackerrank.nestedlogic.fine;

public class MediumFine implements Fine {

	private int returnedMonth;
	private int expectedMonth;

	public MediumFine(int returnedMonth, int expectedMonth) {
		this.returnedMonth = returnedMonth;
		this.expectedMonth = expectedMonth;
	}

	@Override
	public int calcule() {
		return 500*(returnedMonth - expectedMonth);
	}
}
