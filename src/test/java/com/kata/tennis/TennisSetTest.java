package com.kata.tennis;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TennisSetTest {
    
    @Test
    public void shoud_return_0_0_when_no_player_scored() {

        // Given
        TennisSet tennis = new TennisSet();
        String expectedScore = "0 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    


    @Test
    public void shoud_return_1_0_when_player1_scored() {

        // Given
        TennisSet tennis = new TennisSet();
        tennis.player1Scores();
        String expectedScore = "1 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    
    @Test
    public void shoud_return_3_0_when_player1_scores_and_the_score_was_2_0() {

        // Given
        TennisSet tennis = new TennisSet("2 0");
        tennis.player1Scores();
        String expectedScore = "3 0";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    
    @Test
    public void shoud_return_Player_1_wins_when_player1_scores_and_the_score_was_5_0() {

        // Given
        TennisSet tennis = new TennisSet("5 0");
        tennis.player1Scores();
        String expectedScore = "Player 1 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    
    @Test
    public void shoud_return_6_5_when_player1_scores_and_the_score_was_5_5() {

        // Given
        TennisSet tennis = new TennisSet("5 5");
        tennis.player1Scores();
        String expectedScore = "6 5";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    
    @Test
    public void shoud_return_6_6_when_player2_scores_and_the_score_was_6_5() {

        // Given
        TennisSet tennis = new TennisSet("6 5");
        tennis.player2Scores();
        String expectedScore = "6 6";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    
    @Test
    public void shoud_return_Player_1_wins_when_player1_scores_and_the_score_was_6_5() {

        // Given
        TennisSet tennis = new TennisSet("6 5");
        tennis.player1Scores();
        String expectedScore = "Player 1 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
    
    
    @Test
    public void shoud_return_Player_2_wins_when_player2_scores_and_the_score_was_5_6() {

        // Given
        TennisSet tennis = new TennisSet("5 6");
        tennis.player2Scores();
        String expectedScore = "Player 2 wins";

        // When
        String score = tennis.score();

        // Then
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
}