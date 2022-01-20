Feature: Tests for form of share

  Scenario Outline: The submit button should be enabled after wrong input
    And blabla
    When A user fills the form with empty or invalid required fields and clicks or doesn't click on accept

    | story         | <story>  |
    | Name          | <name>   |
    | Email address | <email>  |
    | accept        | <accept> |

    And User clicks on submit button
    Then User checks that submit is still enabled
    Examples:
      | story              | name     | email            |accept|
      | Ooo! privet        | VASYA    | vasya@gmail.com  | no   |
      | Ooo! privet        |          | vasya@gmail.com  | yes  |
      |                    | vasyaa   | vasya@gmail.com  | yes  |
      | Ooo! privet        | vasyaa   | 1111             | yes  |




