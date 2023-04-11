Feature: Login Test - The user should be able to log in with valid credentials

  Background: Go to the store page
    Given The user is on the login page

  Scenario:  Pozitive Login Test 1
    When The user enters valid credentials
    Then The user verify that Welcome George George is displayed

@wip
  Scenario: Povitive Login Test 2 Login With Parameter
    When The user enters "George George" and "12345" credentials
    Then The user verify that user "Welcome George George" is displayed

  @wip
  Scenario Outline: Positive Login test 3 login with scenario outline
    When The user enters "<username>" and "<password>" credentials
    Then The user verify that "<Welcomeusername>" is displayed
    Examples:
      | username      | password | Welcomeusername       |
      | George George | 12345    | Welcome George George |
      | JhonyQ        | Test1234 | Welcome JhonyQ        |


  Scenario Outline: Positive Login test 4 login with scenario outline and data table
    When The user enters valid username and password credentials
      | username | <username> |
      | password | <password> |
    Then The user verify that "<Welcomeusername>" is displayed
    Examples:
      | username      | password | Welcomeusername       |
      | George George | 12345    | Welcome George George |
      | JhonyQ        | Test1234 | Welcome JhonyQ        |


  Scenario Outline: Negative scenario - The user should not be able to log in with invalid credentials
    When The user enters invalid user name "<username>" or password "<password>" credentials
    Then  The user verify invalid credential "<message>"
    Examples:
      | username      | password | message                                |
      | George George | 123      | Wrong password.                        |
      | alg           | 12345    | User does not exist.                   |
      |               | 12345    | Please fill out Username and Password. |
      | George George |          | Please fill out Username and Password. |
      |               |          | Please fill out Username and Password. |


