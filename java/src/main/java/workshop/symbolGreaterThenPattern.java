package workshop;

import java.util.List;

public class symbolGreaterThenPattern implements Matcher, NormalResponse {
    private String toBeAdded;

    @Override
    public boolean match(char toBeMatched) {
        toBeAdded = "&gt;";
        return toBeMatched == '>';
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
