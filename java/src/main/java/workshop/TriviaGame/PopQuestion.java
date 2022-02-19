package workshop.TriviaGame;

import java.util.LinkedList;
import java.util.List;

public class PopQuestion implements QuestionCategory {
    private final List<String> stackOfQuestions = new LinkedList<>();

    @Override
    public boolean match(int number) {
        return (number % 4 == 0);
    }

    @Override
    public String category() {
        return "Pop";
    }

    @Override
    public void addNewQuestion(int number) {
        stackOfQuestions.add("Pop Question " + number);
    }

    @Override
    public String askQuestionFromStack() {
        return stackOfQuestions.remove(0);
    }
}
