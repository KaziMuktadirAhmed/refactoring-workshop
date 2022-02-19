package workshop;

import java.util.LinkedList;
import java.util.List;

public class Questions {
    private final List<String> popQuestions = new LinkedList<>();
    private final List<String> scienceQuestions = new LinkedList<>();
    private final List<String> sportsQuestions = new LinkedList<>();
    private final List<String> rockQuestions = new LinkedList<>();

    public Questions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
    }

    public String currentCategory(int playerPlace) {
        switch (playerPlace % 4) {
            case 0:
                return "Pop";
            case 1:
                return "Science";
            case 2:
                return "Sports";
            default:
                return "Rock";
        }
    }

    public String nextQuestion(int playerPlace) {
        String question;

        switch (currentCategory(playerPlace)) {
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
                throw new IllegalStateException("Unexpected value: " + currentCategory(playerPlace));
        }
        return question;
    }
}
