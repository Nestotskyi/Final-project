Feature: As a user I want to check correct title of news

  Scenario Outline: Checks that name of main article is correct
    And User opens BBC home page
    And User clicks on news
    Then User checks that name of main article is '<name>'
    Examples:
      | name   |
      | Title1 |

  Scenario: Secondary news titles should have correct name
    And User opens BBC home page
    And User clicks on news
    Then User checks that secondary news has on of this titles
      | Title2 |
      | Title2 |
      | Title2 |
      | Title2 |
      | Title2 |

  Scenario: Check that title of main article is the same that first title of first article ini this category
    And User opens BBC home page
    And User clicks on news
    And User makes search by name of category of main article
    Then User checks that title is "Title3"