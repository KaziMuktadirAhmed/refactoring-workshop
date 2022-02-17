package workshop.PlainTextToHtml;

import java.util.List;

public class symbolGreaterThenPattern implements NormalResponse {
    private String toBeAdded;

    @Override
    public boolean match(Character toBeMatched) {
        toBeAdded = "&gt;";
        return toBeMatched == '>';
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
