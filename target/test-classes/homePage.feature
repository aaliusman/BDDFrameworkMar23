Feature: State farm home page

  Scenario: Validate zipcode matches with city
    Given navigate to statefarm homepage
    When user select Homeowners from product dropdown
    And user enters zipcode in the input field
    And user clicks start a quote button
    Then user verifies city matches with zipcode

  Scenario: Validate zipcode matches with city
    Given navigate to statefarm homepage
    When user select Homeowners from product dropdown
    And user enters zipcode in the input field
    And user clicks start a quote button
    Then user verifies city matches with zipcode