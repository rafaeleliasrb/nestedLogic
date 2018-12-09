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
The solutions are in Java and the project is Maven. the project has only one dependency which is the JUnit test framework.
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

> For implementation details see: https://github.com/rafaeleliasrb/nestedLogic

