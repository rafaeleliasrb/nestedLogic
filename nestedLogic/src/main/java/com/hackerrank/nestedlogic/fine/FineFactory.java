package com.hackerrank.nestedlogic.fine;

import com.hackerrank.nestedlogic.model.BookRental;

public class FineFactory {

	private FineFactory() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Fine getFine(BookRental bookRental) {
		if(bookRental.isReturnedDateLessThanExpectedDate()) {
	        return new NoFine();
	    }
		else if(bookRental.isSameYear() && bookRental.isSameMonth()) {
			return new SmallFine(bookRental.getReturnedDate().getDay(), 
					bookRental.getExpectedDate().getDay());
		}
		else if(bookRental.isSameYear()) {
			return new MediumFine(bookRental.getReturnedDate().getMonth(), 
					bookRental.getExpectedDate().getMonth());
		}
		return new BigFine();
	}
}
