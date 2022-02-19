package workshop;

public class ScienceQuestion implements QuestionCatagory{
    private final int questionPos;

    public ScienceQuestion(int questionPos) {
        super();
        this.questionPos = questionPos;
    }
    @Override
    public boolean match(int number) {
        return (number % 4 == 1);
    }

    @Override
    public String ask() {
        return "Science Question " + questionPos;
    }
}
