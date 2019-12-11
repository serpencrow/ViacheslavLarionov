Feature: Exercise1

  Scenario: HomePage And Different Elements Page functionality check
    Given I open EPAM JDI Site
    And I login as user 'epam' with password '1234' on Home Page
    Then username should be 'PITER CHAILOVSKII' on Home Page
    And browser title should be 'Home Page'
    And '4' header items should be displayed on the Home Page
    And benefit images should be displayed on the Home Page
    And '4' benefit images should be on the Home Page
    And texts under images should be displayed on the Home Page
    And '4' texts under images should be on the Home Page
    When I click in 'header' menu on item 'Service' on Home Page
    Then service dropdown should be displayed in 'header' menu on Home Page
    And service subcategories in 'header' menu should contain options
      | Support |
      | Dates |
      | Complex Table |
      | Simple Table |
      | User Table |
      | Table With Pages |
      | Different Elements |
      | Performance |
    When I click in 'left' menu on item 'Service' on Home Page
    Then service dropdown should be displayed in 'left' menu on Home Page
    And service subcategories in 'left' menu should contain options
      | Support |
      | Dates |
      | Complex Table |
      | Simple Table |
      | User Table |
      | Table With Pages |
      | Different Elements |
      | Performance |
    When I click in 'header' menu on item 'Service' on Home Page
    And I click on item 'Different Elements' in service subcategories in 'header' menu on Home Page
    Then I should see that page has URL 'https://epam.github.io/JDI/different-elements.html'
    And 4 checkboxes should be displayed on Different Elements page
    And 4 radiobuttons should be displayed on Different Elements Page
    And 2 buttons should be displayed on the DifferentElements page
    And dropdown should be displayed on DifferentElements page
    And right section should be displayed on Different Elements Page
    And left section should be displayed on Different Elements Page
    When I click on 'checkbox' with name 'Water' on Different Elements Page
    Then I should see that first log row is displayed
    And first log row should contain 'Water: condition changed to true'
    When I click on 'checkbox' with name 'Wind' on Different Elements Page
    Then I should see that first log row is displayed
    And first log row should contain 'Wind: condition changed to true'
    When I click on 'radiobutton' with name 'Selen' on Different Elements Page
    Then I should see that first log row is displayed
    And first log row should contain 'metal: value changed to Selen'
    When I click on dropdown colors on Different Elements Page
    And I choose 'Yellow' color in the dropdown
    Then I should see that first log row is displayed
    And first log row should contain 'Colors: value changed to Yellow'
    When I click on 'checkbox' with name 'Water' on Different Elements Page
    Then I should see that 'checkbox' with name 'Water' is unchecked
    And I should see that first log row is displayed
    And first log row should contain 'Water: condition changed to false'
    When I click on 'checkbox' with name 'Wind' on Different Elements Page
    Then I should see that 'checkbox' with name 'Wind' is unchecked
    And I should see that first log row is displayed
    And first log row should contain 'Wind: condition changed to false'
