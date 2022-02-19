package workshop.TriviaGame;

import java.util.LinkedList;
import java.util.List;

public class RockQuestion implements QuestionCategory {
    private final List<String> stackOfQuestions = new LinkedList<>();

    @Override
    public boolean match(int number) {
        return (number % 4 == 0);
    }

    @Override
    public String category() {
        return "Rock";
    }

    @Override
    public void addNewQuestion(int number) {
        stackOfQuestions.add("Rock Question " + number);
    }

    @Override
    public String askQuestionFromStack() {
        return stackOfQuestions.remove(0);
    }
}
