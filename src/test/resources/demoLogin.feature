Feature: Test login functionality

  Scenario: Validate user is able to login successfully
    Given user enters "abcde" and "12345" in the input field
    When user clicks on login button
    Then verify user is on the the home page with "abcde" message

  Scenario Outline: Validate multiple users are able to login successfully
    Given user enters "<username>" and "<password>" in the input field
    When user clicks on login button
    Then verify user is on the the home page with "<username>" message

    Examples:
      | username | password |
      | abcde    | 12345    |
#      | jalksdj  | 12345    |
#      | xnzcv    | 12345    |

  Scenario: Validate user is able to login
    Given user enters "abcde" and "12345" in the input field
    When user clicks on login button
    Then verify user is on the the home page with "abcde" message
    Then this test should fail