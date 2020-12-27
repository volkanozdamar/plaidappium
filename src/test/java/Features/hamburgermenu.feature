Feature: Hamburger Menu
  Scenario Outline: Check the items of Hamburger Menu
    Given Open Hamburger Menu
    And Check the element with index <Index> is <Text>

    Examples:
    |Index | Text                     |
    |  0   |'Log in to Designer News' |
    |  1   |'About'                   |
