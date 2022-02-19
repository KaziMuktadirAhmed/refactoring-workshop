package workshop;

public class PopQuestion implements QuestionCategory {
    @Override
    public boolean match(int number) {
        return (number % 4 == 0);
    }

    @Override
    public String category() {
        return "Pop";
    }

    @Override
    public String ask(int number) {
        return "Pop Question " + number;

    }
}
