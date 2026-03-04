Feature: Validate WordPress Website

  Scenario: Validate WordPress Website functionalities

    Given User launches the WordPress website
    Then User verifies the page title
    When User mouse over on Download & Extend and click Get WordPress
    Then User verifies "Get WordPress" text
    When User clicks on Community and selects Photo Directory
    Then User searches for a photo and verifies pictures are displayed