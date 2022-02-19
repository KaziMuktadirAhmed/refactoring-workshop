package workshop;

public class ScienceQuestion implements QuestionCategory {
    @Override
    public boolean match(int number) {
        return (number % 4 == 1);
    }

    @Override
    public String category() {
        return "Science";
    }

    @Override
    public String ask(int number) {
        return "Science Question " + number;
    }
}
