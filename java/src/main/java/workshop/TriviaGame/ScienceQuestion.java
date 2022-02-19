package workshop.TriviaGame;

import java.util.LinkedList;
import java.util.List;

public class ScienceQuestion implements QuestionCategory {
    private final List<String> stackOfQuestions = new LinkedList<>();

    @Override
    public boolean match(int number) {
        return (number % 4 == 1);
    }

    @Override
    public String category() {
        return "Science";
    }

    @Override
    public void addNewQuestion(int number) {
        stackOfQuestions.add("Science Question " + number);
    }

    @Override
    public String askQuestionFromStack() {
        return stackOfQuestions.remove(0);
    }
}
