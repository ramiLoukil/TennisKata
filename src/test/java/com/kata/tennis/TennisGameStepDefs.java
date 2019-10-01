package com.kata.tennis;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;


public class TennisGameStepDefs {

    private TennisGame tennisGame;

    @Given("^A Tennis game with an initial score of (.*)$")
    public void a_tennis_game_with_initial_score(String initialScore) throws Throwable {
        this.tennisGame = new TennisGame(initialScore);
    }

    @When("^Player (\\d) scores$")
    public void the_scoring_player_is(int scoringPlayer) throws Throwable {
        if (scoringPlayer == 1) {
            tennisGame.player1Scores();
        } else {
            tennisGame.player2Scores();
        }
    }

    @Then("^the score is (.*)$")
    public void the_expected_score_is(String expectedScore) throws Throwable {
        String score = tennisGame.score();
        Assertions.assertThat(score).isEqualTo(expectedScore);
    }
}
