Feature: Exercise2

  Scenario: User Table Page test
    Given I am on Home Page
    And I login as user 'Piter Chailovskii'
    When I click on 'Service' button in Header on Home Page
    And I click on 'User Table' button in Service dropdown on Home Page
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns should be displayed on Users Table on User Table Page
    And 6 User names should be displayed on Users Table on User Table Page
    And 6 Description images should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table contains following values:
      | Number |        User        |          Description              |
      |   1    | Roman              |  Wolverine                        |
      |   2    | Sergey Ivan        |  Spider Man                       |
      |   3    | Vladzimir          |  Punisher                         |
      |   4    | Helen Bennett      |  Captain America some description |
      |   5    | Yoshi Tannamuri    |  Cyclope some description         |
      |   6    | Giovanni Rovelli   |  Hulk some description            |
    When I select 'vip' checkbox for 'Sergey Ivan' on Users Table on User Table Page
    Then 1 log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user 'Roman' on Users Table on User Table Page
    Then droplist for user 'Roman' should contain values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |