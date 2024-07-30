Feature: Verify the scenarios mentioned for the assignment

  @dataanchor
  Scenario: Verify user is able to login successfully
    When The user with email "settlers-cabin@iraatljd.mailosaur.net" is logging into the app
    Then Verify "Shared Page Name":"Text" "QA Assignment" is present on Shared Page

  @dataanchor
  Scenario: Verify user is able to navigate to the file list
    Given The user with email "settlers-cabin@iraatljd.mailosaur.net" is logging into the app
    And The user clicks on "Actions":"Button" on Shared Page
    And The user clicks on "Open in New Tab":"Link" on Shared Page
    And The user switch the window
    Then Verify current url on "Book" Page
    And The user switch to the original window
    And The user clicks on "Actions":"Button" on Shared Page
    And The user clicks on "Preview":"Link" on Shared Page
    And The user switch the window
    When The user switch to the "Book":"Frame" frame
    Then Verify "Mode":"Text" "Viewing" is present on Book Page

  @dataanchor
  Scenario: Verify search functionality is working
    Given The user with email "settlers-cabin@iraatljd.mailosaur.net" is logging into the app
    And The user clicks on "Home":"Button" on Menu Items
    When The user enters "Book" in "Search":"Input" on Home Page
    Then Verify "File Name":"Text" "Book.xlsx" is present on Home Page