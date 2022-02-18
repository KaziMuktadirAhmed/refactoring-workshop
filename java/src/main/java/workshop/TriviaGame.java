package workshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriviaGame {
    List<Player> players = new ArrayList<>();

    List<String> popQuestions = new LinkedList<>();
    List<String> scienceQuestions = new LinkedList<>();
    List<String> sportsQuestions = new LinkedList<>();
    List<String> rockQuestions = new LinkedList<>();

    int currentPlayerIndex = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
    }

    public void add(String playerName) {
        players.add(new Player(playerName, 0, 0, false));

        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public void roll(int roll) {
        announce(currentPlayer().name() + " is the current player");
        announce("They have rolled a " + roll);

        if (currentPlayer().PenaltyStatus()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(currentPlayer().name() + " is getting out of the penalty box");
                currentPlayer().move(roll);

                announce(currentPlayer().name()
                        + "'s new location is "
                        + currentPlayer().place());

                announce("The category is " + currentCategory());
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

            announce("The category is " + currentCategory());
            askQuestion();
        }
    }

    private void askQuestion() {
        String question;

        switch (currentCategory()) {
            case "Pop":
                question = popQuestions.remove(0);
                break;
            case "Science":
                question = scienceQuestions.remove(0);
                break;
            case "Sports":
                question = sportsQuestions.remove(0);
                break;
            case "Rock":
                question = rockQuestions.remove(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentCategory());
        }

        announce(question);
    }

    private String currentCategory() {
        if (currentPlayer().place()%4 == 0) return "Pop";
        if (currentPlayer().place()%4 == 1) return "Science";
        if (currentPlayer().place()%4 == 2) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer().PenaltyStatus()) {
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