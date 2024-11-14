package Bai_8;

public class TennisGame {

    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int WINNING_SCORE = 4;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return getDrawScore(player1Score);
        } else if (player1Score >= WINNING_SCORE || player2Score >= WINNING_SCORE) {
            return getAdvantageOrWinScore(player1Score, player2Score);
        } else {
            return getRegularScore(player1Score, player2Score);
        }
    }

    private static String getDrawScore(int score) {
        switch (score) {
            case LOVE: return "Love-All";
            case FIFTEEN: return "Fifteen-All";
            case THIRTY: return "Thirty-All";
            case FORTY: return "Forty-All";
            default: return "Deuce";
        }
    }

    private static String getAdvantageOrWinScore(int player1Score, int player2Score) {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) return "Advantage player1";
        if (scoreDifference == -1) return "Advantage player2";
        if (scoreDifference >= 2) return "Win for player1";
        return "Win for player2";
    }

    private static String getRegularScore(int player1Score, int player2Score) {
        return getScoreDescription(player1Score) + "-" + getScoreDescription(player2Score);
    }

    private static String getScoreDescription(int score) {
        switch (score) {
            case LOVE: return "Love";
            case FIFTEEN: return "Fifteen";
            case THIRTY: return "Thirty";
            case FORTY: return "Forty";
            default: throw new IllegalArgumentException("Invalid score: " + score);
        }
    }
}
