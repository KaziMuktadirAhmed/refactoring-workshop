package workshop;

public class PopQuestion implements QuestionCatagory{
    private final int questionPos;

    public PopQuestion(int questionPos) {
        super();
        this.questionPos = questionPos;
    }

    @Override
    public boolean match(int number) {
        return (number % 4 == 0);
    }

    @Override
    public String ask() {
        return "Pop Question " + questionPos;

    }
}
