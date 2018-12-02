package com.hackerrank.nestedlogic;

import java.util.Scanner;

import com.hackerrank.nestedlogic.fine.Fine;
import com.hackerrank.nestedlogic.fine.FineFactory;
import com.hackerrank.nestedlogic.model.BookRental;
import com.hackerrank.nestedlogic.model.LibraryDate;

public class NestedLogic {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int returnedDay = scanner.nextInt();
        int returnedMonth = scanner.nextInt();
        int returnedYear = scanner.nextInt();

        int expectedDay = scanner.nextInt();
        int expectedMonth = scanner.nextInt();
        int expectedYear = scanner.nextInt();

        int fine = calculeFine(returnedDay, returnedMonth, returnedYear,
        		expectedDay, expectedMonth, expectedYear);
        
        System.out.println(fine);

        scanner.close();
    }

    public static int calculeFine(int returnedDay, int returnedMonth, int returnedYear,
    		int expectedDay, int expectedMonth, int expectedYear) {
    	
        return getFine(returnedDay, returnedMonth, returnedYear, 
        		expectedDay, expectedMonth, expectedYear)
        		.calcule();
    }

	private static Fine getFine(int returnedDay, int returnedMonth, int returnedYear, int expectedDay,
			int expectedMonth, int expectedYear) {
		return FineFactory.getFine(new BookRental(new LibraryDate(expectedDay, expectedMonth, expectedYear), 
				new LibraryDate(returnedDay, returnedMonth, returnedYear)));
	}
}
