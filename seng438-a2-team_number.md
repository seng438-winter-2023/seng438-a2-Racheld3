**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: Group Number 10
|--------------------------------------|
| Student 1: Rachel Dalton             |  
| Student 2: Ana Clara Perrone         |  
| Student 3: Saina Ghasemian-Roudsari  |
| Student 4: Isaiah Lemieux            |
|--------------------------------------|

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





# 3 Test cases developed

| Class         | Method                     | Partition           | Test Case                                         | Pass/Fail   |
|---------------| ---------------------------|---------------------|---------------------------------------------------|-------------|
| DataUtilities | calculateColumnTotal()     |
| DataUtilties  | calculateRowTotal()        |
| DataUtilties  | createNumberArray()        |
| DataUtilties  | createNumberArray2D()      |
| DataUtilties  | getCumulativePercentages() |                     | getCumulativePercentagesTestForValidValues()      | Fail        |
| DataUtilties  | getCumulativePercentages() |                     | getCumulativePercentagesTestForOneValue()         | Fail        |
| DataUtilties  | getCumulativePercentages() |                     | getCumulativePercentagesTestForException()        | Fail        |
| DataUtilties  | getCumulativePercentages() |                     | getCumulativePercentagesTestForNegativeValue()    | Fail        |
| DataUtilties  | getCumulativePercentages() |                     | getCumulativePercentagesTestForOneNegativeValue() | Fail        |
|---------------| ---------------------------|---------------------|---------------------------------------------------|-------------|
| Range         |                            |                     |                                                   |             |
| Range         |                            |                     |                                                   |             |
| Range         |                            |                     |                                                   |             |
| Range         |                            |                     |                                                   |             |
| Range         |                            |                     |                                                   |             |
|---------------| ---------------------------|---------------------|---------------------------------------------------|-------------|

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed
After reading the lab handout and confirming that everyone had a general understanding of how the program works, expected unit testing, and mock testing, we split the tests up between the group members. All team members did help eachother through on zoom.


# 5 Difficulties encountered, challenges overcome, and lessons learned
One of the big difficulties we ran into at first was getting all the members of the group to be able to work on the same git repository at the same time. This was resolved by 

Our group as well had a different time understanding how to start the mocking. 

# 6 Comments/feedback on the lab itself
Our group found it diffuclt as mentioned above to understand mocking. We feel as though our group would have benefited with more clear instructions and clarification on how the mocking can be done. As well, we feel that we would have benefited if it was made clear that some of our tests would fail no matter what as we were under the impression that there would be no informal or formal bug reports required, as there was supposed to have been no bugs.
