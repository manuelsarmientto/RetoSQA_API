Feature: Create Pet

  @Post

  Scenario Outline: Consume API successfully

    When I send a request to the endpoint "<endpoint>" with the "<key>" and the "<value>"
    Then I Validate that the response code is "<code>"
    And that data contains "<key>" "<value>"

    Examples:
      | endpoint | key  | value   | code |
      | /post    | name | ManuelS | 200  |