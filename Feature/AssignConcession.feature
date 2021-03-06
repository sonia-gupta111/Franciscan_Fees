Feature: Assign concession amount to student
    As a user I would like to assign concession to a student in different ways
    So that I don't have to do it manually 
    
  @scenario1
  Scenario: To test assign concession as amount to student
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign concession page is opened
    Then user searches a student of class "1" section "A" and text "sonia1" on assign concession page
    Then user select fee type "SCHOOL FEE" on assign concession page
    Then user select installment "APRIL" on assign concession page
    Then user select concession type "special" on assign concession page
    Then user assign concession on "BUILDING MAINT. FEE" as "amount" to student on assign concession page
    Then user click save on assign concession page

  @scenario2
  Scenario: To test assign concession as percent to student
    Given user enters url"http://qaerp.franciscanecare.net"
    When enter username"admin" and password"Admin@987"
    Then signin
    Then home page is opened
    Then assign concession page is opened
    Then user searches a student of class "1" section "A" and text "sonia1" on assign concession page
    Then user select fee type "SCHOOL FEE" on assign concession page
    Then user select installment "APRIL" on assign concession page
    Then user select concession type "special" on assign concession page
    Then user assign concession on "BUILDING MAINT. FEE" as "percent" to student on assign concession page
    Then user click save on assign concession page