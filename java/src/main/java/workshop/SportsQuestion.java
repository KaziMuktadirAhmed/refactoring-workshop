package workshop;

public class SportsQuestion implements QuestionCategory {
    @Override
    public boolean match(int number) {
        return (number % 4 == 2);
    }

    @Override
    public String category() {
        return "Sports";
    }

    @Override
    public String ask(int number) {
        return "Sports Question " + number;
    }
}
