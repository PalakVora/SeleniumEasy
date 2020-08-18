#@otherstab
Feature: Test Input Forms tab

  Scenario Outline: 01 Test Show Message Button
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub tab Simple form demo
    And I enter some message <message> into enter message textbox
    And I click on show button
    Then I verify <message> is getting displayed correctly

    Examples: 
      | welcome |
      |     123 |

  Scenario Outline: 02 Test the Get Total Button
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub tab Simple form demo
    And I enter some number <no1> into the enter a textbox
    And I enter some number <no2> into the enter b textbox
    And I click on Sum button
    Then I verify sum of <no1> and <no2> is the sum being displayed

    Examples: 
      | no1 | no2 |
      |   1 |   9 |
      |  11 |  99 |
      | 222 | 111 |

  Scenario: 03 Test the Single CheckBox
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub tab CheckBox Demo
    And I check the given CheckBox
    Then I verify output message is getting displayed as checked

  Scenario: 04 Test the Multiple CheckBox
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub tab CheckBox Demo
    And I click on Check All button
    And I verify the button is Uncheck all
    And I click the Uncheck All button
    Then I verify the button is check all

  Scenario: 05 Test the RadioButton
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub tab RadioButton Demo
    Then I check one of the radiobuttons and verify

  Scenario: 06 Test the multiple RadioButton
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub tab RadioButton Demo
    Then I check one of the mradiobuttons and verify

  Scenario: 07 Test the Seletct list
    Given I open the application
    And I click on Input Forms Tab
    And I click on Select Dropdown list
    Then I click on options of dropdown and verify

  Scenario Outline: 08 Test the Input Form Submit
    Given I open the application
    And I click on Input Forms Tab
    And I click on sub input form submit
    And I enter first name <fname> and <lname> into textbox1
    And I enter email <email> and <phno> into textbox2
    And I enter address <address> and <city> into textbox3
    And I select state from the state drop-down list
    And I enter zip code <zip> and  <web> into textboxes
    And I select one of the radiobuttons indicating hosting
    Then I enter project description <proj> into project textbox and send

    Examples: 
      | fname | lname | email          | phno       | address   | city   | zip | web    | proj |  |
      | palak | vora  | pogo@gmail.com | 3456574869 | sfdj4y789 | Mumbai | 123 | 123.in |  123 |  |
      |   123 |   123 |            123 |        123 |       123 |    123 | 123 |    123 |  123 |  |
