package workshop;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame {
    private final List<Player> players = new ArrayList<>();
    private final Questions questions = new Questions();
    private int currentPlayerIndex = 0;
    private boolean isGettingOutOfPenaltyBox;

    public void add(String playerName) {
        players.add(new Player(playerName, 0, 0, false));
        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    private void askQuestion() {
        String question = questions.nextQuestion(currentPlayer().place());
        announce(question);
    }

    public void roll(int roll) {
        announce(currentPlayer().name() + " is the current player");
        announce("They have rolled a " + roll);

        if (currentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                currentPlayer().setPenaltyStatus(false);
                announce(currentPlayer().name() + " is getting out of the penalty box");
                movePlayerAndAskQuestion(roll);

            } else {
                announce(currentPlayer().name() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            movePlayerAndAskQuestion(roll);
        }
    }

    private void movePlayerAndAskQuestion(int roll) {
        currentPlayer().move(roll);
        announce(currentPlayer().name() + "'s new location is " + currentPlayer().place());
        announce("The category is " + questions.currentCategory(currentPlayer().place()));
        askQuestion();
    }

    public boolean wasCorrectlyAnswered() {
        boolean result = checkForPenalty();
        nextPlayer();
        return  result;
    }

    private boolean checkForPenalty() {
        if (currentPlayer().isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                currentPlayer().setPenaltyStatus(false);
                announceCorrectAndAddCoins();
                return currentPlayer().didPlayerWin();
            } else {
                return true;
            }
        } else {
            announceCorrectAndAddCoins();
            return currentPlayer().didPlayerWin();
        }
    }

    private void announceCorrectAndAddCoins() {
        announce("Answer was correct!!!!");
        currentPlayer().addCoin(1);
        announce(currentPlayer().name() + " now has " + currentPlayer().coins() + " Gold Coins.");
    }

    public void wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(currentPlayer().name() + " was sent to the penalty box");
        currentPlayer().setPenaltyStatus(true);
        nextPlayer();
    }

    private void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) {
            currentPlayerIndex = 0;
        }
    }

    private Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}