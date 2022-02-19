package workshop;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame {
    private final List<Player> players = new ArrayList<>();
    private final Questions questions = new Questions();

    int currentPlayerIndex = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
    }

    private void askQuestion() {
        String question = questions.nextQuestion(currentPlayer().place());
        announce(question);
    }

    public void add(String playerName) {
        players.add(new Player(playerName, 0, 0, false));

        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public void roll(int roll) {
        announce(currentPlayer().name() + " is the current player");
        announce("They have rolled a " + roll);

        if (currentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(currentPlayer().name() + " is getting out of the penalty box");
                currentPlayer().move(roll);

                announce(currentPlayer().name()
                        + "'s new location is "
                        + currentPlayer().place());

                announce("The category is " + questions.currentCategory(currentPlayer().place()));
                askQuestion();

            } else {
                announce(currentPlayer().name() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            currentPlayer().move(roll);
            announce(currentPlayer().name()
                    + "'s new location is "
                    + currentPlayer().place());

            announce("The category is " + questions.currentCategory(currentPlayer().place()));
            askQuestion();
        }
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer().isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                currentPlayer().addCoin(1);

                announce(currentPlayer().name()
                        + " now has "
                        + currentPlayer().coins()
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayerIndex++;
                if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;

                return winner;

            } else {
                currentPlayerIndex++;
                if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
                return true;
            }

        } else {
            announce("Answer was correct!!!!");
            currentPlayer().addCoin(1);

            announce(currentPlayer().name()
                    + " now has "
                    + currentPlayer().coins()
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayerIndex++;
            if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(currentPlayer().name() + " was sent to the penalty box");
        currentPlayer().setPenaltyStatus(true);

        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
        return true;
    }

    private Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private boolean didPlayerWin() {
        return !(currentPlayer().coins() == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}