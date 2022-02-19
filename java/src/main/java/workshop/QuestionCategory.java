package workshop;

public interface QuestionCategory {
    public boolean match (int number);
    public String category();
    public void addNewQuestion(int number);
    public String askQuestionFromStack();
}
