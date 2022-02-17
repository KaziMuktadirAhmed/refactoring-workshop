package workshop.PlainTextToHtml;

import java.util.List;

public class symbolLessThenPattern implements NormalResponse {
    private String toBeAdded;

    @Override
    public boolean match(Character toBeMatched) {
        toBeAdded = "&lt;";
        return toBeMatched == '<';
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
