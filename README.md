# Hackerrank problem Nested Logic

<p align="justify">
This is a simple problem whose objective is <i>"puts your understanding of nested conditional statements to the test"</i>.
However, although easy to solve, the solution can be confusing if we don't use good programming techniques.
This situation is common in our work, when we wrote complicated solutions to problems that seemed simple.</p>
<p align="justify">
This is not related to the beauty of the code, beauty is something relative, but the ease of understanding the code because a certainty we have in the programmer's life is that the code will have changes and the more complicated to understand the code the more time will be spent to change it.</p>
<p align="justify">
In this post we will make three different solutions to the problem and discuss what the improvements are in relation to each other.
For more datails about the problem see the link: <a href="https://www.hackerrank.com/challenges/30-nested-logic/problem">Nested Logic</a>
</p>

## Environment
The solutions are in Java, using Maven. The project has only one dependency which is the JUnit test framework.
> **Tip:** <span align="justify">Since we're talking about saving time, knowing the keyboard shortcuts of your IDE, each IDE has dozen of them. Tasks that we use multiple clicks on the mouse can be done with just a touch on the keyboard.</span>

## Unit Test
<p align="justify">
First of all, let's write the unit tests to ensure that any improvements we make to the code do not change the expected result.
The tests are:
</p>

1. ifReturnedYearBeforeExpectedYearNoFine
2. ifSameYearAndReturnedMonthBeforeExpectedMonthNoFine
3. ifSameYearAndReturnedMonthBeforeExpectedMonthNoFine
4. ifSameYearAndSameMonthAndSameDayNoFine
5. ifSameYearAndSameMonthAndReturnedDayAfterExpectedDaySmallFine
6. ifSameYearAndReturnedMonthAfterExpectedMonthMediumFine
7. ifReturnedYearAfterExpectedYearBigFine

> **Observation:** <span align="justify">The tests were not done on the data as if the day were a positive integer less than 32 or the month was a positive integer less than 13. These tests are also important but it isn't the focus of this post.</span>

> For implementation details see: <a href="https://github.com/rafaeleliasrb/nestedLogic">https://github.com/rafaeleliasrb/nestedLogic</a>

## The Ugly, the Bad and the Good solution
In this section, we will discuss solutions and improvements with each other, incrementally.

### The Ugly
The first solution is just a method with nested If statements without the use of OO concepts.

```java
public static int calculeFine(int day1, int month1, int year1,
        int day2, int month2, int year2) {
    	
    if(year2 > year1 || 
        (year2 == year1 && month2 > month1) || 
        (year2 == year1 && month2 == month1 && day2 >= day1)) {
      return 0;
    }
    else if(year2 == year1 && month2 == month1) {
      return 15*(day1 - day2);
    }
    else if(year2 == year1) {
      return 500*(month1 - month2);
    }
    else {
      return 10000;
    }
}
```

<p align="justify">
This solution is ugly because variable names have no meaning and nested Ifs may be difficult to understand.
Names like day1 and day2 are not good names and maybe a week after they are written, it will be hard to tell what they are.
</p>

### The Bad
This solution is an improved version of the ugly version, has more meaningful names for variables, but uses the same If statements.
```java
public static int calculeFine(int returnedDay, int returnedMonth, int returnedYear,
        int expectedDay, int expectedMonth, int expectedYear) {

    boolean isSameYearAndReturnedMonthBeforeExpected = 
            expectedYear == returnedYear && expectedMonth > returnedMonth;
    boolean isSameYearAndMonth = 
            expectedYear == returnedYear && expectedMonth == returnedMonth;
    boolean isSameYearAndMonthAndReturnedDayBeforeExpected = 
            isSameYearAndMonth && expectedDay >= returnedDay;

    if(expectedYear > returnedYear || 
        isSameYearAndReturnedMonthBeforeExpected || 
        isSameYearAndMonthAndReturnedDayBeforeExpected) {
        return 0;
    }
    else if(isSameYearAndMonth) {
        return 15*(returnedDay - expectedDay);
    }
    else if(expectedYear == returnedYear) {
        return 500*(returnedMonth - expectedMonth);
    }
    else {
        return 10000;
    }
}
```

<p align="justify">
Nested Ifs are more understandable and it will be easier to read the code one week after it has been written. But still doesn't make good use of OO concepts.
</p>

### The Good
This solution makes better use of OO concepts and is more readable and easier to maintain.
```java
public static int calculeFine(int returnedDay, int returnedMonth, int returnedYear,
        int expectedDay, int expectedMonth, int expectedYear) {
    LibraryDate expectedDate = new LibraryDate(expectedDay, expectedMonth, expectedYear);
    LibraryDate returnedDate = new LibraryDate(returnedDay, returnedMonth, returnedYear);
    return FineFactory.getFine(new BookRental(returnedDate, expectedDate))
         .calcule();
}
```
<p align="justify">
As we can see, some classes were created. For example, the LibraryDate class groups the year, month, and day variables. The BookRental class groups the expected and returned dates.
</p>
<p align="justify">
But where are the nested Ifs?
For this, the Fine interface was created that only has a method called calcule.
</p>

```java
public interface Fine {
    public int calcule();
}
```
<p align="justify">
And the content was put in classes that implements Fine interface, the classes are: NoFine, SmallFine, MediumFine and BigFine.<br/>
For example, SmallFine class:

```java
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
```
</p>

<p align="justify">
For selected the right class were created FineFactory class.
</p>

```java
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
```

<p align="justify">
The latter solution the If statements are placed in a more appropriate place. Design patterns can be a good solution for nested ifs that look complicated
</p>

## Conclusion
<p align="justify">
As has been said previously, simple problems to solve sometimes have complicated solutions due to the use of wrong techniques. Object orientation is a powerful tool if well used and facilitates our work as a programmer.<br/>
What do you think of these solutions?
</p>
