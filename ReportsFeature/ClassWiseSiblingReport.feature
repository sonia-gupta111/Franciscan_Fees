Feature: Class Wise Sibling Report
     As a user I would like to open class wise sibling report
     So that I don't have to do it myself

  Background: 
    Given user enters url" http://192.168.10.101:8069/Modules.aspx"
    When enter username"admin" and password"admin@123"
    Then signin
    And passes school name "rosary"
    Then home page is opened

  @scenario1
  Scenario Outline: To test class wise sibling report based on class
    Then class wise sibling report is opened
    Then user select class "<class>" on class wise sibling report
    Then user click on show on class wise sibling report

    Examples: 
      | class |
      | 1     |

  @scenario2
  Scenario Outline: To test class wise sibling report based on class and section
    Then class wise sibling report is opened
    Then user select class "<class>" on class wise sibling report
    Then user select section"<section>" on class wise sibling report
    Then user click on show on class wise sibling report

    Examples: 
      | class | section |
      | 1     | A       |

  @scenario3
  Scenario: To test class wise sibling report without any filter
    Then class wise sibling report is opened
    Then user click on show on class wise sibling report
