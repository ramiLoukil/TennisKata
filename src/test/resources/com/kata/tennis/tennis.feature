Feature: Tennis Kata

  Scenario Outline: Tennis Game when player 1 scores
    Given A Tennis game with an initial score of <score>
    When Player 1 scores
    Then the score is <result>
    Examples:
      | score           | result             |
      | 0 0             | 15 0               |
      | 15 0            | 30 0               |
      | 30 0            | 40 0               |
      | 40 0            | Player 1 wins      |
      | 0 15            | 15 15              |
      | 15 15           | 30 15              |
      | 30 15           | 40 15              |
      | 40 15           | Player 1 wins      |
      | 0 30            | 15 30              |
      | 15 30           | 30 30              |
      | 30 30           | 40 30              |
      | 40 30           | Player 1 wins      |
      | 0 40            | 15 40              |
      | 15 40           | 30 40              |
      | 30 40           | Deuce              |
      | 40 40           | Advantage player 1 |

  Scenario Outline: Tennis Game when player 2 scores
    Given A Tennis game with an initial score of <score>
    When Player 2 scores
    Then the score is <result>
    Examples:
      | score           | result             |
      | 0 0             | 0 15               |
      | 15 0            | 15 15              |
      | 30 0            | 30 15              |
      | 40 0            | 40 15              |
      | 0 15            | 0 30               |
      | 15 15           | 15 30              |
      | 30 15           | 30 30              |
      | 40 15           | 40 30              |
      | 0 30            | 0 40               |
      | 15 30           | 15 40              |
      | 30 30           | 30 40              |
      | 40 30           | Deuce              |
      | 0 40            | Player 2 wins      |
      | 15 40           | Player 2 wins      |
      | 30 40           | Player 2 wins      |
      | 40 40           | Advantage player 2 |

  Scenario Outline: Tennis End Game
    Given A Tennis game with an initial score of <score>
    When Player <scoring_player> scores
    Then the score is <result>
    Examples:
      | score              | scoring_player | result             |
      | Deuce              | 1              | Advantage player 1 |
      | Deuce              | 2              | Advantage player 2 |
      | Advantage player 1 | 1              | Player 1 wins      |
      | Advantage player 2 | 2              | Player 2 wins      |
      | Advantage player 1 | 2              | Deuce              |
      | Advantage player 2 | 1              | Deuce              |
