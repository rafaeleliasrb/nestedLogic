package com.hackerrank.nestedlogic;

import java.util.Scanner;

import com.hackerrank.nestedlogic.fine.BigFine;
import com.hackerrank.nestedlogic.fine.Fine;
import com.hackerrank.nestedlogic.fine.MediumFine;
import com.hackerrank.nestedlogic.fine.NoFine;
import com.hackerrank.nestedlogic.fine.SmallFine;

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
		if(expectedYear > returnedYear || 
            (expectedYear == returnedYear && expectedMonth > returnedMonth) || 
            (expectedYear == returnedYear && expectedMonth == returnedMonth && 
                expectedDay >= returnedDay)) {
        	return new NoFine();
        }
        else if(expectedYear == returnedYear && 
        	expectedMonth == returnedMonth) {
        	return new SmallFine(returnedDay, expectedDay);
        }

        else if(expectedYear == returnedYear) {
        	return new MediumFine(returnedMonth, expectedMonth);
        }
        else {
        	return new BigFine();
        }
	}
}
