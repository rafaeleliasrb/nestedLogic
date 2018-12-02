package com.hackerrank.nestedlogic.model;

public class BookRental {

	private final LibraryDate expectedDate;
	private final LibraryDate returnedDate;
	
	public BookRental(LibraryDate expectedDate, LibraryDate returnedDate) {
		this.expectedDate = expectedDate;
		this.returnedDate = returnedDate;
	}

	public boolean isReturnedDateLessThanExpectedDate() {
		boolean isExpectedYearAfter = expectedDate.getYear() > returnedDate.getYear();
		boolean isSameYearAndExpectedDateAfter = isSameYear() && 
				expectedDate.getMonth() > returnedDate.getMonth();
		boolean isSameYearAndSameMonthAndExpectedDayAfter = isSameYear() && isSameMonth() && 
				expectedDate.getDay() >= returnedDate.getDay();
				
		return isExpectedYearAfter || isSameYearAndExpectedDateAfter || 
				isSameYearAndSameMonthAndExpectedDayAfter;
	}
	
	public boolean isSameMonth() {
		return expectedDate.getMonth() == returnedDate.getMonth();
	}

	public boolean isSameYear() {
		return expectedDate.getYear() == returnedDate.getYear();
	}
	
	public LibraryDate getReturnedDate() {
		return returnedDate;
	}
	
	public LibraryDate getExpectedDate() {
		return expectedDate;
	}
}
