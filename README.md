Good test method names serve two purposes:

- When a test fails you want to know what is broken and why
- Tests are living documentation for your production code



###### should[ConditionToBeMet]
This simple strategy uses the word “should” followed by the condition to be met. I like to use test names like this for degenerate test cases, constructors, or very simple classes.
`shouldNotBeNull()` or `shouldHaveAnAge()`

###### [unitUnderTest]_should[ConditionToBeMet]
This test name structure is good for more complex classes with a larger public API. Oftentimes the “unitUnderTest” portion of the test name will be the public method that is exercised.
`copy_shouldReturnAPerson()`


###### [unitUnderTest]_[input]_should[ConditionToBeMet]
The third naming structure I like to reserve for particularly complex methods that accept a wide range of input since it can get rather verbose.
`canVote_ageLessThan18_shouldReturnFalse()` or `canVote_ageEqualTo18_shouldReturnTrue()` or `canVote_ageGreaterThan18_shouldReturnTrue()`

