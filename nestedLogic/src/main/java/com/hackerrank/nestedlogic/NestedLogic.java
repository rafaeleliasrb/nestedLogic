package com.hackerrank.nestedlogic;

import java.util.Scanner;

public class NestedLogic {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int day1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int year1 = scanner.nextInt();

        int day2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int year2 = scanner.nextInt();

        int fine = calculeFine(day1, month1, year1,
        		day2, month2, year2);
        
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
