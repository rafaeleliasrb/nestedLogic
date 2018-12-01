package com.hackerrank.nestedlogic.fine;

public class SmallFine implements Fine {

	private int returnedDay;
	private int expectedDay;
	
	public SmallFine(int returnedDay, int expectedDay) {
		this.returnedDay = returnedDay;
		this.expectedDay = expectedDay;
	}

	@Override
	public int calcule() {
		return 15*(returnedDay - expectedDay);
	}

}
