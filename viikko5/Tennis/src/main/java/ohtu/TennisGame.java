package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String[] tieScores;
    private String[] nonTieScores;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        tieScores = createTieScores();
        nonTieScores = createNonTieScores();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    private String[] createTieScores() {
        String[] tieScores = {
            "Love-All",
            "Fifteen-All",
            "Thirty-All",
            "Forty-All",
            "Deuce"
        };
        return tieScores;
    }

    private String[] createNonTieScores() {
        String[] nonTieScores = {
            "Love",
            "Fifteen",
            "Thirty",
            "Forty"
        };
        return nonTieScores;
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2) {
            return getTieScore();
        } else if (m_score1>=4 || m_score2>=4) {
            int minusResult = m_score1-m_score2;
            if (minusResult==1 || minusResult ==-1) return getAdvantage(minusResult);
            else return getWinner(minusResult);
        }
            return getNonTieScore();
    }

    private String getAdvantage(int minusResult) {
        if(minusResult == 1) return "Advantage for player1";
        return "Advantage for player2";
    }

    private String getWinner(int minusResult) {
        if(minusResult > 1) return "Win for player1";
        return "Win for player2";
    }

    private String getNonTieScore() {
        int tempScore=0;
        String score = "";
        for (int i=1; i<3; i++) {
            if (i==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
            score+=nonTieScores[tempScore];
        }
        return score;
    }

    private String getTieScore() {
        return tieScores[m_score1];
    }



    public static void main(String[] args) {
        TennisGame game = new TennisGame("player1", "player2");
    
        System.out.println(game.getScore());
    
        game.wonPoint("player1");
        System.out.println(game.getScore());
    
        game.wonPoint("player1");
        System.out.println(game.getScore());
    
        game.wonPoint("player2");
        System.out.println(game.getScore());
    
        game.wonPoint("player1");
        System.out.println(game.getScore());
    
        game.wonPoint("player1");
        System.out.println(game.getScore());
    }
}