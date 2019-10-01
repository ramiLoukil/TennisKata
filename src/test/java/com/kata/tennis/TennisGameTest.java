package com.kata.tennis;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class TennisGameTest {

    @Test
    public void shoud_return_0_0_when_no_player_scored() {

        // Given
        TennisGame tennis = new TennisGame();
        String expectedScore = "0 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_15_0_when_player1_scored() {

        // Given
        TennisGame tennis = new TennisGame();
        tennis.player1Scores();
        String expectedScore = "15 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_0_15_when_player2_scored() {

        // Given
        TennisGame tennis = new TennisGame();
        tennis.player2Scores();
        String expectedScore = "0 15";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_15_15_when_player1_scores_and_the_score_was_0_15() {

        // Given
        TennisGame tennis = new TennisGame("0 15");
        tennis.player1Scores();
        String expectedScore = "15 15";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_15_15_when_player2_scores_and_the_score_was_15_0() {

        // Given
        TennisGame tennis = new TennisGame("15 0");
        tennis.player2Scores();
        String expectedScore = "15 15";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_30_0_when_player1_scores_and_the_score_was_15_0() {

        // Given
        TennisGame tennis = new TennisGame("15 0");
        tennis.player1Scores();
        String expectedScore = "30 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_40_0_when_player1_scores_and_the_score_was_30_0() {

        // Given
        TennisGame tennis = new TennisGame("30 0");
        tennis.player1Scores();
        String expectedScore = "40 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_0_30_when_player2_scores_and_the_score_was_0_15() {

        // Given
        TennisGame tennis = new TennisGame("0 15");
        tennis.player2Scores();
        String expectedScore = "0 30";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_0_40_when_player2_scores_and_the_score_was_0_30() {

        // Given
        TennisGame tennis = new TennisGame("0 30");
        tennis.player2Scores();
        String expectedScore = "0 40";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Deuce_when_player1_scores_and_the_score_was_30_40() {

        // Given
        TennisGame tennis = new TennisGame("30 40");
        tennis.player1Scores();
        String expectedScore = "Deuce";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Advantage_player_1_when_player1_scores_and_the_score_was_Deuce() {

        // Given
        TennisGame tennis = new TennisGame("Deuce");
        tennis.player1Scores();
        String expectedScore = "Advantage player 1";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_Advantage_player_2_when_player2_scores_and_the_score_was_Deuce() {

        // Given
        TennisGame tennis = new TennisGame("Deuce");
        tennis.player2Scores();
        String expectedScore = "Advantage player 2";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_player_1_wins_when_player1_scores_and_the_score_was_40_0() {

        // Given
        TennisGame tennis = new TennisGame("40 0");
        tennis.player1Scores();
        String expectedScore = "Player 1 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_player_2_wins_when_player2_scores_and_the_score_was_0_40() {

        // Given
        TennisGame tennis = new TennisGame("0 40");
        tennis.player2Scores();
        String expectedScore = "Player 2 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_player_1_wins_when_player1_scores_and_the_score_was_40_15() {

        // Given
        TennisGame tennis = new TennisGame("40 15");
        tennis.player1Scores();
        String expectedScore = "Player 1 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_player_2_wins_when_player2_scores_and_the_score_was_15_40() {

        // Given
        TennisGame tennis = new TennisGame("15 40");
        tennis.player2Scores();
        String expectedScore = "Player 2 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_player_1_wins_when_player1_scores_and_the_score_was_40_30() {

        // Given
        TennisGame tennis = new TennisGame("40 30");
        tennis.player1Scores();
        String expectedScore = "Player 1 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }

    @Test
    public void shoud_return_player_2_wins_when_player2_scores_and_the_score_was_30_40() {

        // Given
        TennisGame tennis = new TennisGame("30 40");
        tennis.player2Scores();
        String expectedScore = "Player 2 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
}
