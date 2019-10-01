package com.kata.tennis;

import java.util.Arrays;
import java.util.function.BiPredicate;


public class TennisGame {

    private int player1Score;
    private int player2Score;

    public TennisGame() {
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public TennisGame(String initialScore) {
        if (initialScore.equals("Deuce")) {
            this.player1Score = 3;
            this.player2Score = 3;
        } else if (initialScore.equals("Advantage player 1")) {
            this.player1Score = 4;
            this.player2Score = 3;
        } else if (initialScore.equals("Advantage player 2")) {
            this.player1Score = 3;
            this.player2Score = 4;
        } else {
            String[] scores = initialScore.split(" ");
            this.player1Score = convertScoreToInt(scores[0]);
            this.player2Score = convertScoreToInt(scores[1]);
        }
    }

    private int convertScoreToInt(String score) {
        IndividualScore individualScore = IndividualScore.byLabel(score);
        return individualScore.score;
    }

    public String score() {
        if (aPlayerMayWin()) {
            GameScore gameScore = GameScore.of(this.player1Score, this.player2Score);
            return gameScore.label;
        }

        return convertScoreToString(player1Score) + " " + convertScoreToString(player2Score);
    }

    private boolean aPlayerMayWin() {
        return (this.player1Score >= 3 && this.player2Score >= 3) || this.player1Score > 3 || this.player2Score > 3;
    }

    private String convertScoreToString(int score) {
        IndividualScore individualScore = IndividualScore.byScore(score);
        return individualScore.label;
    }

    public void player1Scores() {
        this.player1Score++;
    }

    public void player2Scores() {
        this.player2Score++;
    }

    private enum IndividualScore {
        LOVE(0, "0"),
        FIFTEEN(1, "15"),
        THIRTY(2, "30"),
        FOURTY(3, "40");

        private final int score;
        private final String label;

        IndividualScore(int score, String label) {
            this.score = score;
            this.label = label;
        }

        public static IndividualScore byScore(int score) {
            return Arrays.stream(values()).filter(individualScore -> individualScore.score == score).findAny().get();
        }

        public static IndividualScore byLabel(String label) {
            return Arrays.stream(values()).filter(individualScore -> individualScore.label.equals(label)).findAny().get();
        }
    }

    private enum GameScore {
        DEUCE((s1, s2) -> s1 == s2, "Deuce"),
        ADVANTAGE_PLAYER_1((s1, s2) -> s1 == s2 + 1, "Advantage player 1"),
        ADVANTAGE_PLAYER_2((s1, s2) -> s2 == s1 + 1, "Advantage player 2"),
        PLAYER_1_WINS((s1, s2) -> s1 > s2 + 1, "Player 1 wins"),
        PLAYER_2_WINS((s1, s2) -> s2 > s1 + 1, "Player 2 wins");

        private final BiPredicate<Integer, Integer> check;
        public final String label;

        GameScore(BiPredicate<Integer, Integer> check, String label) {
            this.check = check;
            this.label = label;
        }

        public static GameScore of(int player1Score, int player2Score) {
            return Arrays.stream(values()).filter(score -> score.check(player1Score, player2Score)).findAny().get();
        }

        private boolean check(int player1Score, int player2Score) {
            return this.check.test(player1Score, player2Score);
        }
    }
}
