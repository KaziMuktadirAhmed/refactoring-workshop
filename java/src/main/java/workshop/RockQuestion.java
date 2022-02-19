package workshop;

public class RockQuestion implements QuestionCategory {
    @Override
    public boolean match(int number) {
        return (number % 4 == 0);
    }

    @Override
    public String category() {
        return "Rock";
    }

    @Override
    public String ask(int number) {
        return "Rock Question " + number;
    }
}
