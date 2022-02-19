package workshop;

import java.util.LinkedList;
import java.util.List;

public class SportsQuestion implements QuestionCategory {
    private final List<String> stackOfQuestions = new LinkedList<>();

    @Override
    public boolean match(int number) {
        return (number % 4 == 2);
    }

    @Override
    public String category() {
        return "Sports";
    }

    @Override
    public void addNewQuestion(int number) {
        stackOfQuestions.add("Sports Question " + number);
    }

    @Override
    public String askQuestionFromStack() {
        return stackOfQuestions.remove(0);
    }
}
