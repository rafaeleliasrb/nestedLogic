package com.hackerrank.nestedlogic;

import java.util.Scanner;

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
    	
        if(expectedYear > returnedYear || 
            (expectedYear == returnedYear && expectedMonth > returnedMonth) || 
            (expectedYear == returnedYear && expectedMonth == returnedMonth && 
                expectedDay >= returnedDay)) {
        	return 0;
        }
        else if(expectedYear == returnedYear && 
        	expectedMonth == returnedMonth) {
        	return 15*(returnedDay - expectedDay);
        }

        else if(expectedYear == returnedYear) {
        	return 500*(returnedMonth - expectedMonth);
        }
        else {
        	return 10000;
        }

    }
}
