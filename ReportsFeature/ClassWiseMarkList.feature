Feature: Class Wise Mark List
    As a user I would like to open class wise mark list 
    So that I don't have to do it myself

  Background: 
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin#franciscan"
    Then signin
    And passes school name "qaerp"
    Then home page is opened

  @scenario1
  Scenario Outline: To test class wise mark list with surname
    Then class wise mark list is opened
    Then user select class "<class>" on class wise mark list
    Then user select section "<section>" on class wise mark list
    Then user click show on class wise mark list

    Examples: 
      | class | section |
      | 1     | A       |

  @scenario2
  Scenario Outline: To test class wise mark list without surname wise
    Then class wise mark list is opened
    Then user select class "<class>" on class wise mark list
    Then user select section "<section>" on class wise mark list
    Then user click surname wise on class wise mark list
    Then user click show on class wise mark list

    Examples: 
      | class | section |
      | 1     | A       |