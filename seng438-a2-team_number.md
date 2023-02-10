**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: Group Number 10
|--------------------------------------|
| Student 1: Rachel Dalton             |  
| Student 2: Ana Clara Perrone         |  
| Student 3: Saina Ghasemian-Roudsari  |
| Student 4: Isaiah Lemieux            |

# 1 Introduction
In this lab our group was able to apply the different concepts and practices we covered in lectures. We had to use both Junit, Javadoc, and Eclipse to test the given system JFreeChart. Junit was used to create a testing environment which used mock testing and test cases. We were able to demonstrate the creation of unit tests and using mock objects within our unit test code.


# 2 Detailed description of unit test strategy

Our unit test strategy will begin with each team member individually and carefully going through the documentation of both of the classes to be tested: org.jfree.data.DataUtilities and org.jfree.data.Range. This will allow each one of us to gain an understanding of the functionality of the methods we will be testing inside these classes before creating our test suite. Once this step is done we will proceed to split up the tests between the group members to facilitate with the workload, however, we will make sure to reconvene and go through each other's tests to make sure we all have an understanding of all the tests.

When designing input partitions, our group first took an equivalence class testing approach, then applying boundary value testing to this. For each SUT, we went through documentation for each method we were meant to test. This gave us a better understanding of what each method is meant to do, and more importantly, specification of the domain of appropriate inputs for each method, if there were any input restrictions. Following the identification of these domains for each method, we then split the domain into appropriate equivalence classes, if it could be divided further. The creation of these classes would create boundaries that we would later have to consider in the test creation phase. Once a nominal value for each input was chosen to use in the test of a method, we then considered these boundaries recently created, and considered more possible inputs for testing. More specifically, we chose an input for both upper bound, lower bound, below upper bound, and above lower bound. Values that extend past the domain of each parameter were not considered as we were only concerned with valid inputs, which would improve efficiency of test writing.

An example of the following could be seen when partitioning inputs for testing Range.getCentralValue(). We can see there are no input parameters for the method itself, as it is a getter. Instead we examine what each Range object is composed of, as this is the data that getCentralValue() will be accessing. Both upper and lower bounds in Range are represented by variables of type double. This could easily be grouped in as one large domain of real numbers, as the method does not specify a valid domain, however, in an attempt to test the system futher, we split this domain into two smaller domains; positive values and negative values. This creates a boundary at 0. After identifying these input partitions, five test cases were created. 

    1. Positive valued lower bound and positive valued upper bound
    2. Zero lower bound and positive valued upper bound
    3. Negative valued lower bound and positive valued upper bound
    4. Negative valued lower bound and zero upper bound
    5. Negative valued lower bound and negative valued upper bound
Additionally, a final sixth test case was created to test a range with a length of zero (ie, lower bound value = upper bound value).

Input partitions:

Data Utilities Methods

1. calculateColumnTotal(Values2D data, int column) 
    a. data with 1+ columns and rows, and the first column of the data
    b. data with 1+ columns and rows, and the last column of the data
    c. data with 1 column and row, and the only column of the data
    d. data with no columns, and requesting the first column
    e. data with 1 column and row, and requesting a negative column

2. calculateRowTotal(Values2D data, int row) 
    a. data with 1+ columns and rows, and the first row of the data
    b. data with 1+ columns and rows, and the last row of the data
    c. data with 1 column and row, and the only row of the data
    d. data with no columns, and requesting the first row
    e. data with 1 column and row, and requesting a negative row

3. createNumberArray(double[] data) 
    a. null data
    b. empty data
    c. data of length one
    d. data of length > 1

4. createNumberArray2D(double[][] data)

5. getCumulativePercentages(KeyedValues data) 
    a. data table with three positive values
    b. data table with one positive table
    c. null data
    d. data table with two positive values and one negative value
    e. datable table with one negative value

Range Methods:

6. getLowerBound()
    a. a range with positive values for both the lowet and upper bounds
    b. a range with zero for the value for the lower bound, and a positive value for the upper bound
    c. a range with negative value for lower bound, and a positive value for the upper bound
    d. a range with the lower and upper bounds being the same values

7. getLength()
    a. a range with positive numbers for both the lower and upper bounds, therefore, valid range
    b. a range with the lower bound as zero and a positive upper bound
    c. a range with negative lower bound and positive upper bound
    d. a range with negative lower bound and zero as the upper bound
    e. a range with negative numbers for both the lower and upper bounds
    f. a range with the same values for both upper and lower bound

8. getUpperBound()
    a. a range with negative value for lower bound, and a positive value for the upper bound
    b. a range with negative values for both upper and lower bound
    c. a range with positive values for both the lower and upper bounds
    d. a range with negative value for lower bound, and a value of zero for the upper bound
    e. a range with the lower and upper bounds being the same values


9. getCentralValue()
    a. a range with positive value for lower bound, and a positive value for upper bound
    b. a range with lower bound of zero, and a positive value for upper bound
    c. a range with negative value for lower bound, and a positive value for upper bound
    d. a range with negative value for lower bound, and upper bound of zero
    e. a range with negative value for lower bound, and a negative value for upper bound
    f. a range with length zero

10. contains(double value)
    a. any range of values (any value for each lower bound and upper bound), method input variable slightly greater than upper bound
    b. any range of values, method input variable at upper bound
    c. any range of values, method input variable slightly less than upper bound
    d. any range of values, method input variable between upper bound and lower bound
    e. any range of values, method input variable slightly greater than lower bound
    f. any range of values, method input variable at lower bound
    g. any range of values, method input variable slightly less than lower bound






# 3 Test cases developed

| Class         | Method                     | Partition           | Test Case                                                     | Pass/Fail   |
|---------------| ---------------------------|---------------------|---------------------------------------------------            |-------------|
| DataUtilities | calculateColumnTotal()     | 1.e                 | calculateColumnTotalForInvalidColumn()                        | Pass        |
| DataUtilities | calculateColumnTotal()     | 1.d                 | calculateColumnTotalForNoValues()                             | Pass        |
| DataUtilities | calculateColumnTotal()     | 1.c                 | calculateColumnTotalForOneValue()                             | Pass        |
| DataUtilities | calculateColumnTotal()     | 1.b                 | calculateColumnTotalForThreeValuesLastColumn()                | Pass        |
| DataUtilities | calculateColumnTotal()     | 1.a                 | calculateColumnTotalForTwoValuesFirstColumn()                 | Pass        |
| DataUtilties  | calculateRowTotal()        | 2.e                 | calculateRowTotalForInvalidColumn()                           | Pass        | 
| DataUtilties  | calculateRowTotal()        | 2.d                 | calculateRowTotalForNoValues()                                | Pass        |  
| DataUtilties  | calculateRowTotal()        | 2.c                 | calculateRowTotalForOneValue()                                | Fail        |
| DataUtilties  | calculateRowTotal()        | 2.b                 | calculateRowTotalForThreeValuesLastRow()                      | Fail        | 
| DataUtilties  | calculateRowTotal()        | 2.a                 | calculateRowTotalForTwoValuesFirstRow()                       | Fail        |
| DataUtilties  | createNumberArray()        | 3.c                 | createNumberArrayForArrayOfLengthOne()                        | Fail        | 
| DataUtilties  | createNumberArray()        | 3.b                 | createNumberArrayForEmptyArray()                              | Pass        |
| DataUtilties  | createNumberArray()        | 3.d                 | createNumberArrayForNominalArray()                            | Fail        | 
| DataUtilties  | createNumberArray()        | 3.a                 | testCreateNumberArrayWithNullInput()                          | Fail        |
| DataUtilties  | createNumberArray2D()      |                     | testCreateNumberArray2D()                                     | Fail        |
| DataUtilties  | createNumberArray2D()      |                     | testCreateNumberArray2DEmptyArray()                           | Pass        | 
| DataUtilties  | createNumberArray2D()      |                     | testCreateNumberArray2DNegativeValuesOneArray()               | Fail        | 
| DataUtilties  | createNumberArray2D()      |                     | testCreateNumberArray2DPositiveValues()                       | Fail        |
| DataUtilties  | createNumberArray2D()      |                     | testCreateNumberArray2DPositiveValuesAndEmptyArray()          | Fail
| DataUtilties  | getCumulativePercentages() | 5.a                 | getCumulativePercentagesTestForValidValues()                  | Fail        |
| DataUtilties  | getCumulativePercentages() | 5.b                 | getCumulativePercentagesTestForOneValue()                     | Fail        |
| DataUtilties  | getCumulativePercentages() | 5.c                 | getCumulativePercentagesTestForException()                    | Fail        |
| DataUtilties  | getCumulativePercentages() | 5.d                 | getCumulativePercentagesTestForNegativeValue()                | Fail        |
| DataUtilties  | getCumulativePercentages() | 5.e                 | getCumulativePercentagesTestForOneNegativeValue()             | Fail        |
| Range         | getLowerBound()            | 6.a                 | testGetLowerBoundForLowerBoundPositive()                      | Pass        |
| Range         | getLowerBound()            | 6.a                 | testGetLowerBoundForLowerBoundAboveZero()                     | Pass        |
| Range         | getLowerBound()            | 6.b                 | testGetLowerBoundForLowerBoundZero()                          | Pass        |
| Range         | getLowerBound()            | 6.c                 | testGetLowerBoundForLowerBoundBelowZero()                     | Pass        |
| Range         | getLowerBound()            | 6.c                 | testGetLowerBoundForLowerBoundNegative()                      | Pass        |
| Range         | getLowerBound()            | 6.d                 | testGetLowerBoundForSameLowerAndUpperBounds()                 | Pass        |
| Range         | getLength()                | 7.a                 | getLengthForNegativeLowerNegativeUpper()                      | Pass        |
| Range         | getLength()                | 7.b                 | getLengthForNegativeLowerPositiveUpper()                      | Pass        |
| Range         | getLength()                | 7.c                 | getLengthForNegativeLowerZeroUpper()                          | Pass        |
| Range         | getLength()                | 7.d                 | getLengthForValidRange()                                      | Pass        |
| Range         | getLength()                | 7.e                 | getLengthForZeroLowerPositiveUpper()                          | Pass        |
| Range         | getLength()                | 7.f                 | getLengthForIdenticalLowerUpper()                             | Pass        |
| Range         | getUpperBound()            |                     | getUpperBoundForUpperBoundAboveZero()                         | Fail        |
| Range         | getUpperBound()            |                     | getUpperBoundForUpperBoundBelowZero()                         | Fail        |
| Range         | getUpperBound()            |                     | getUpperBoundForUpperBoundNegative()                          | Fail        |
| Range         | getUpperBound()            |                     | getUpperBoundForUpperBoundPositive()                          | Fail        |
| Range         | getUpperBound()            |                     | getUpperBoundForUpperBoundZero()                              | Fail        |
| Range         | getUpperBound()            |                     | getUpperBoundFOrSameLowerAndUpperBounds()                     | Pass        |
| Range         | getCentralValue()          | 9.a                 | testGetCentralValueForLowerBoundPositiveUpperBoundPositive()  | Pass        |
| Range         | getCentralValue()          | 9.b                 | testGetCentralValueForLowerBoundZeroUpperBoundPositive()      | Pass        |
| Range         | getCentralValue()          | 9.c                 | testGetCentralValueForLowerBoundNegativeUpperBoundPositive()  | Pass        |
| Range         | getCentralValue()          | 9.d                 | testGetCentralValueForLowerBoundNegativeUpperBoundZero()      | Pass        |
| Range         | getCentralValue()          | 9.e                 | testGetCentralValueForLowerBoundNegativeUpperBoundNegative()  | Pass        |
| Range         | getCentralValue()          | 9.f                 | testGetCentralValueForRangeOfLengthZero()                     | Pass        |
| Range         | contains()                 | 10.a                | testContainsAboveUpperBoundOfRange()                          | Pass        |
| Range         | contains()                 | 10.b                | testContainsAtUpperBoundOfRange()                             | Pass        |
| Range         | contains()                 | 10.c                | testContainsBelowUpperBoundOfRange()                          | Pass        |
| Range         | contains()                 | 10.d                | testContainsForNominalValue()                                 | Pass        |
| Range         | contains()                 | 10.e                | testContainsAboveLowerBoundOfRange()                          | Pass        |
| Range         | contains()                 | 10.f                | testContainsAtLowerBoundOfRange()                             | Pass        |
| Range         | contains()                 | 10.g                | testContainsBelowLowerBoundOfRange()                          | Pass        |



# 4 How the team work/effort was divided and managed
After reading the lab handout and confirming that everyone had a general understanding of how the program works, expected unit testing, and mock testing, we split the tests up between the group members. Methods that would require the use of Mocking were divided between members of the group, so we could all learn and practice the technique. After deciding which members would examine and test each of the methods to be tested, the remaining work was performed alone. Each member would perform a combination of ECT and BVT on each of the methods assigned to them. This would involve finding the acceptable domain of each method and identifying equivalence classes. During the initial portions of writing tests that involve mocking, group members worked together on a zoom call to understand mocking interfaces.


# 5 Difficulties encountered, challenges overcome, and lessons learned
One of the big difficulties we ran into at first was getting all the members of the group to be able to work on the same git repository at the same time. We faced merge conflicts since we were using external .jar libraries, and the file paths were different on each team member's computer. This was resolved by adding the .jar files in a lib folder in the same directory as the src and bin folders in Eclipse. We then added the .jar files as internal libraries, which solved the issue. We now know how to properly set up an eclipse project with gitHub. 

We also struggled with learning how to use mocks at first. After going through the examples in detail, every team member felt comfortable using mocking. 

# 6 Comments/feedback on the lab itself
Our group found it diffuclt as mentioned above to understand mocking. We feel as though our group would have benefited with more clear instructions and clarification on how the mocking can be done. As well, we feel that we would have benefited if it was made clear that some of our tests would fail no matter what as we were under the impression that there would be no bugs to be found in the code.
After some of the challenges we faced were overcome, this lab did help us in gaining a strong understanding of how to write effective unit tests to help determine bugs. As well as how using mocking objects are used in unit tests.
