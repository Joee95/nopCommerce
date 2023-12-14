Feature: User Registration
  I want to check that the user can register in our e-commerce website.

  Scenario Outline: User Registration
    Given The user is in Home page.
    When User clicks on register link.
    And User entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
    Then User has registered successfully.

    Examples:
      | firstname | lastname | email               | password |
      | ahmed     | mohamed  | ahmed@user434.com   | 12345678 |
      | Moataz    | ahmed    | test@newuser233.com | 87654321 |