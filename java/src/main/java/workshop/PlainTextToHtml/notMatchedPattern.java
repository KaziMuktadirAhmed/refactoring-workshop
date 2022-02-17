package workshop.PlainTextToHtml;

import java.util.List;

public class notMatchedPattern implements NormalResponse{
    private String toBeAdded;

    @Override
    public boolean match(char toBeMatched) {
        toBeAdded = String.valueOf(toBeAdded);
        return (toBeMatched != '>' && toBeMatched != '<' && toBeMatched != '&'  && toBeMatched != '\n');
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
