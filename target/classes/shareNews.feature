Feature: Tests for form of share

  Scenario Outline: The submit button should be enabled after wrong input
    And User opens BBC home page

    And User clicks on news
    And User closes popup
    And User clicks on coronavirus
    And User clicks contact BBC
    And User clicks send story
    When A user fills the form with empty or invalid required fields and clicks or doesn't click on accept
    | story         | <story>  |
    | Name          | <name>   |
    | Email address | <email>  |
    And User clicks on '<accept>'
    And User clicks on submit button
    Then User checks that submit is still enabled
    Examples:
      | story              | name    | email            |accept|
      | Ooo! privet        | Vasya   | vasya@gmail.com  | no   |
      | Ooo! privet        |         | vasya@gmail.com  | yes  |
      |                    | Vasya   | vasya@gmail.com  | yes  |
      | Ooo! privet        | Vasya   | 1111             | yes  |




