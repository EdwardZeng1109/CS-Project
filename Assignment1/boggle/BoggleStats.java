package boggle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The BoggleStats class for the first Assignment in CSC207, Fall 2022
 * The BoggleStats will contain statsitics related to game play Boggle 
 */
public class BoggleStats {

    /**
     * set of words the player finds in a given round 
     */  
    private Set<String> playerWords = new HashSet<String>();  
    /**
     * set of words the computer finds in a given round 
     */  
    private Set<String> computerWords = new HashSet<String>();  
    /**
     * the player's score for the current round
     */  
    private int pScore; 
    /**
     * the computer's score for the current round
     */  
    private int cScore; 
    /**
     * the player's total score across every round
     */  
    private int pScoreTotal; 
    /**
     * the computer's total score across every round
     */  
    private int cScoreTotal; 
    /**
     * the average number of words, per round, found by the player
     */  
    private double pAverageWords; 
    /**
     * the average number of words, per round, found by the computer
     */  
    private double cAverageWords; 
    /**
     * the current round being played
     */  
    private int round;
    /**
     * the total words found by player
     */
    private int pTotalwords;
    /**
     * the total words found by computer
     */
    private int cTotalwords;
    /**
     * enumarable types of players (human or computer)
     */  
    public enum Player {
        Human("Human"),
        Computer("Computer");
        private final String player;
        Player(final String player) {
            this.player = player;
        }
    }

    /* BoggleStats constructor
     * ----------------------
     * Sets round, totals and averages to 0.
     * Initializes word lists (which are sets) for computer and human players.
     */
    public BoggleStats() {
        this.round = 0;
        this.pScore = 0;
        this.pScoreTotal = 0;
        this.pAverageWords = 0;
        this.cScore = 0;
        this.cScoreTotal = 0;
        this.cAverageWords = 0;
        this.pTotalwords = 0;
        this.cTotalwords = 0;
        this.playerWords = new HashSet<String>();
        this.computerWords = new HashSet<String>();
    }

    /* 
     * Add a word to a given player's word list for the current round.
     * You will also want to increment the player's score, as words are added.
     *
     * @param word     The word to be added to the list
     * @param player  The player to whom the word was awarded
     */
    public void addWord(String word, Player player) {
        if (player == Player.Human){
            this.playerWords.add(word);
            if(word.length() == 4){
                this.pScore += 1;
            }
            else{
                this.pScore += word.length() - 4 + 1;
            }
        }
        else{
            this.computerWords.add(word);
            if(word.length() == 4){
                this.cScore += 1;
            }
            else{
                this.cScore += word.length() - 4 + 1;
            }
        }
    }

    /* 
     * End a given round.
     * This will clear out the human and computer word lists, so we can begin again.
     * The function will also update each player's total scores, average scores, and
     * reset the current scores for each player to zero.
     * Finally, increment the current round number by 1.
     */
    public void endRound() {
        int pWordslen = this.playerWords.size();
        int cWordslen = this.computerWords.size();
        this.pTotalwords += pWordslen;
        this.cTotalwords += cWordslen;
        this.pScoreTotal += this.pScore;
        this.cScoreTotal += this.cScore;
        this.pScore = 0;
        this.cScore = 0;
        this.round += 1;
        this.pAverageWords = this.pTotalwords / round;
        this.cAverageWords = this.cTotalwords / round;
        this.playerWords.clear();
        this.computerWords.clear();
    }

    /* 
     * Summarize one round of boggle.  Print out:
     * The words each player found this round.
     * Each number of words each player found this round.
     * Each player's score this round.
     */
    public void summarizeRound() {
        Iterator<String> pIter = this.playerWords.iterator();
        Iterator<String> cIter = this.computerWords.iterator();
        int pWordslen = this.playerWords.size();
        int cWordslen = this.computerWords.size();
        System.out.println("The total number of words found by player in this round is: " + pWordslen);
        System.out.println("The player's score in this round is: " + this.pScore);
        System.out.println("The words found by player are listed below: ");
        while (pIter.hasNext()){
            System.out.println(pIter.next());
        }
        System.out.println("The total number of words found by computer in this round is: " + cWordslen);
        System.out.println("The computer's score in this round is: " + this.cScore);
        System.out.println("The words found by computer are listed below: ");
        while (cIter.hasNext()){
            System.out.println(cIter.next());
        }
    }

    /* 
     * Summarize the entire boggle game.  Print out:
     * The total number of rounds played.
     * The total score for either player.
     * The average number of words found by each player per round.
     */
    public void summarizeGame() {
        System.out.println("The total number of rounds played is: " + this.round);
        System.out.println("The total score for player is: " + this.pScoreTotal);
        System.out.println("The average number of words found by player is: " + this.pAverageWords);
        System.out.println("The total score for computer is: " + this.cScoreTotal);
        System.out.println("The average number of words found by computer is: " + this.cAverageWords);
    }

    /* 
     * @return Set<String> The player's word list
     */
    public Set<String> getPlayerWords() {
        return this.playerWords;
    }

    /*
     * @return int The number of rounds played
     */
    public int getRound() { return this.round; }

    /*
    * @return int The current player score
    */
    public int getScore() {
        return this.pScore;
    }

}
