@otherstab
Feature: Test Others tab

  Scenario: 01 Validate others tab is present
    Given I am able to launch the site
    Then I verify others tab is present

  Scenario Outline: 02 Test three drop-down options after clicking others tab
    Given I am able to launch the site
    When I click on Others Tab
    Then I verify <item> is getting displayed

    Examples: 
      | item                 |
      | Drag and Drop        |
      | Dynamic Data Loading |
      | Charts Demo          |

  Scenario Outline: 03 The options in drop down menu are clickable
    Given I am able to launch the site
    And I verify others tab is present
    When I click on Others Tab
    When I click on <item> in the drop down menu
    Then I verify that it takes me to <name> page

    Examples: 
      | item                 | name                      |
      | Drag and Drop        | drag-and-drop-demo        |
      | Dynamic Data Loading | dynamic-data-loading-demo |
      | Charts Demo          | charts-mouse-hover-demo   |

  Scenario: 04 Drag and Drop state
    Given I am able to launch the site
    And I verify others tab is present
    And I click on Others Tab
    And I verify Drag and Drop is getting displayed
    When I click on Drag and Drop in the drop down menu
    Then I verify that it takes me to drag-and-drop-demo page
    And I verify Drag and Drop Demo for Automation is displayed

  Scenario: 05 Test the Drag and drop is correct
    Given I am able to launch the site
    And I verify others tab is present
    And I click on Others Tab
    And I verify Drag and Drop is getting displayed
    And I click on Drag and Drop in the drop down menu
    And I verify that it takes me to drag-and-drop-demo page
    And I verify Drag and Drop Demo for Automation is displayed
    Then I verify items to drag is displayed
    And I verify that drop here is displayed
    And I verify that dropped items list is visible

  Scenario: 06  Test the functionality of Drag and Drop Demo for Automation
    Given I am able to launch the site
    And I verify others tab is present
    And I click on Others Tab
    And I verify Drag and Drop is getting displayed
    And I click on Drag and Drop in the drop down menu
    And I verify that it takes me to drag-and-drop-demo page
    And I verify Drag and Drop Demo for Automation is displayed
    And I verify items to drag is displayed
    And I verify that drop here is displayed
    And I verify that dropped items list is visible

  #When I drag and drop an item to the drop here box
  #Then I verify The draggable is displayed on the dropped items list
  #And I verify the same draggable dsplayed which was dropped
  
  Scenario: 07 Test the Dynamic data loading option
    Given I am able to launch the site
    And I verify others tab is present
    And I click on Others Tab
    And I verify Dynamic Data Loading is getting displayed
    When I click on Dynamic Data Loading in the drop down menu
    Then I verify that it takes me to dynamic-data-loading-demo page
    And I verify that a button named get new user under the Loading the data dynamically is present

  Scenario: 08 Test if the get new user button is clickable
    Given I am able to launch the site
    And I verify others tab is present
    And I click on Others Tab
    And I verify Dynamic Data Loading is getting displayed
    When I click on Dynamic Data Loading in the drop down menu
    Then I verify that it takes me to dynamic-data-loading-demo page
    And I verify that a button named get new user under the Loading the data dynamically is present
    When I click the get new user button
    Then I verify getting a new User and name and photo

  Scenario: 09 Test the charts demo
    Given I am able to launch the site
    And I verify others tab is present
    And I click on Others Tab
    And I verify Charts Demo is getting displayed
    When I click on Charts Demo in the drop down menu
    Then I verify that it takes me to charts-mouse-hover-demo page
    And I verify display of data transfer block on the page
    And I verify display of monthly volume and yearly change block
