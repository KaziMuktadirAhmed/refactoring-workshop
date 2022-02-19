package workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Questions {
    private final ArrayList<QuestionCategory> questionCategories = new ArrayList<>();
    private final List<String> questions = new LinkedList<>();

    private final List<String> popQuestions = new LinkedList<>();
    private final List<String> scienceQuestions = new LinkedList<>();
    private final List<String> sportsQuestions = new LinkedList<>();
    private final List<String> rockQuestions = new LinkedList<>();

    public Questions() {
        questionCategories.addAll(Arrays.asList(new PopQuestion(), new ScienceQuestion(), new SportsQuestion(), new RockQuestion()));

        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);

            for (QuestionCategory category: questionCategories) {
                questions.add(category.ask(i));
            }
        }
    }

    public String currentCategory(int playerPlace) {
        String result="";
        for (QuestionCategory category: questionCategories) {
            if(category.match(playerPlace)){
                result = category.category();
            }
        }
        return result;
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
