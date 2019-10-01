package com.kata.tennis;

import java.util.Arrays;
import java.util.function.BiPredicate;


public class TennisSet {
    private int player1SetScore;
    private int player2SetScore;

    public TennisSet() {
         this.player1SetScore = 0;
         this.player2SetScore = 0;
    }
    

    public TennisSet(String initialScore) {
            String[] scores = initialScore.split(" ");
            this.player1SetScore = Integer.parseInt(scores[0]);
            this.player2SetScore = Integer.parseInt(scores[1]);
    }
    
    public void player1Scores() {
        this.player1SetScore++;
    }

    public void player2Scores() {
        this.player2SetScore++;
    } 
    
    public String score() {
        if (aPlayerMayWin()) {
            GameScore gameScore = GameScore.of(this.player1SetScore, this.player2SetScore);
            return gameScore.label;
        }

        return player1SetScore + " " + player2SetScore;
    }

    private boolean aPlayerMayWin() {
        return (player1SetScore > 5 && player2SetScore <= 4) || (player2SetScore > 5 && player1SetScore <= 4)|| player1SetScore==player2SetScore+2||player2SetScore==player1SetScore+2;
    }
    
    private enum GameScore {
        PLAYER_1_WINS((s1, s2) -> s1 > s2 + 1, "Player 1 wins"),
        PLAYER_2_WINS((s1, s2) -> s2 > s1 + 1, "Player 2 wins");

        private final BiPredicate<Integer, Integer> check;
        public final String label;

        GameScore(BiPredicate<Integer, Integer> check, String label) {
            this.check = check;
            this.label = label;
        }

        public static GameScore of(int player1SetScore, int player2SetScore) {
            return Arrays.stream(values()).filter(score -> score.check(player1SetScore, player2SetScore)).findAny().get();
        }

        private boolean check(int player1SetScore, int player2SetScore) {
            return this.check.test(player1SetScore, player2SetScore);
        }
    }
    
}
