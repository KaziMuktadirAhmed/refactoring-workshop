package workshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriviaGame {
    List<Player> players = new ArrayList<>();
    boolean[] inPenaltyBox = new boolean[6];

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
            rockQuestions.add(createRockQuestion(i));
        }
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void add(String playerName) {
        int lastPlayerIndex = howManyPlayers();

        players.add(new Player(playerName, 0, 0));  // new field added
        inPenaltyBox[lastPlayerIndex] = false;

        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public void roll(int roll) {
        announce(currentPlayer().name() + " is the current player");

        announce("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayerIndex]) {
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
        if (currentPlayer().place() == 0) return "Pop";
        if (currentPlayer().place() == 4) return "Pop";
        if (currentPlayer().place() == 8) return "Pop";
        if (currentPlayer().place() == 1) return "Science";
        if (currentPlayer().place() == 5) return "Science";
        if (currentPlayer().place() == 9) return "Science";
        if (currentPlayer().place() == 2) return "Sports";
        if (currentPlayer().place() == 6) return "Sports";
        if (currentPlayer().place() == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayerIndex]) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                currentPlayer().addToPurse(1);

                announce(currentPlayer().name()
                        + " now has "
                        + currentPlayer().purse()
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
            currentPlayer().addToPurse(1);

            announce(currentPlayer().name()
                    + " now has "
                    + currentPlayer().purse()
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
        inPenaltyBox[currentPlayerIndex] = true;

        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
        return true;
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public int howManyPlayers() {
        return players.size();
    }

    private Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private boolean didPlayerWin() {
        return !(currentPlayer().purse() == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}