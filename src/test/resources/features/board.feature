@Boards
Feature: Test Trello new Board

  @CreateBoard
  Scenario Outline: Verify it is possible to create a new board in Trello
    Given the user is on home page trello
    When the user click create button
    And the user click create board button
    And the user sees a menu displayed and in board title enters the "<title>" and click create button
    Then the user can see "<title>" in the board title
    And the user can see the content of the board page
    Examples:
      | title      |
      | board test |

  @EditBoard
  Scenario Outline: Verify it is possible to edit a board in Trello
    Given The user is on the board page "this board"
    When the user click on the board title
    And the user enter the "<new title>" of the board
    Then the user can see "<new title>" in the board title
    And the user can see the content of the board page
    Examples:
      | new title    |
      | title update |