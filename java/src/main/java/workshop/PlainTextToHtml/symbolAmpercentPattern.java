package workshop.PlainTextToHtml;

import java.util.List;

public class symbolAmpercentPattern implements NormalResponse {
    private String toBeAdded;

    @Override
    public boolean match(char toBeMatched) {
        toBeAdded = "&amp;";
        return toBeMatched == '&';
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
