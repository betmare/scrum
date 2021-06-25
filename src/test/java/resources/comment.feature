Feature: the comment is posted
  Scenario: client makes call to POST /comment
    When the client calls /comment
    Then the client receives status code of 200
  Scenario: client makes call to POST /comment
    When the client post a comment with invalid phone
    Then the client receives status code of 400