package workshop.PlainTextToHtml;

import java.util.List;

public class notMatchedPattern implements NormalResponse{
    private String toBeAdded = "nai";

    @Override
    public boolean match(Character toBeMatched) {
        toBeAdded = String.valueOf(toBeMatched);
        return !(toBeMatched.equals('>')  || toBeMatched.equals('<') || toBeMatched.equals('&')  || toBeMatched.equals('\n'));
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
