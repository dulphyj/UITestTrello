Feature: Test Trello login

  @Login
  Scenario: Verify it is possible to log into Trello
    Given the user opens a web browser on Login page
    When the user logs into Trello with Atlassian
    Then the user sees the home content
    And the user sees "Tableros | Trello" as the title of the home page