package workshop.TriviaGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Questions {
    private ArrayList<QuestionCategory> questionCategories = new ArrayList<>();

    public Questions() {
        questionCategories.addAll(Arrays.asList(new PopQuestion(), new ScienceQuestion(), new SportsQuestion(), new RockQuestion()));

        for (int i = 0; i < 50; i++) {
            for (QuestionCategory category: questionCategories) {
                category.addNewQuestion(i);
            }
        }
    }

    public Questions(ArrayList<QuestionCategory> questionCategories) {
        this.questionCategories = questionCategories;

        for (int i = 0; i < 50; i++) {
            for (QuestionCategory category: questionCategories) {
                category.addNewQuestion(i);
            }
        }
    }

    public String currentCategory(int playerPlace) {
        String result="";
        for (QuestionCategory category: questionCategories) {
            if(category.match(playerPlace)){
                result = category.category();
            }
        }
        return result;
    }

    public String nextQuestion(int playerPlace) {
        String question = "";
        for (QuestionCategory category: questionCategories) {
            if (category.match(playerPlace)){
                question = category.askQuestionFromStack();
            }
        }
        return question;
    }
}
