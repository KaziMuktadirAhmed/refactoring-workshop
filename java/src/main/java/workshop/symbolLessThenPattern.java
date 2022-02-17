package workshop;

import java.util.List;

public class symbolLessThenPattern implements Matcher, NormalResponse {
    private String toBeAdded;

    @Override
    public boolean match(char toBeMatched) {
        toBeAdded = "&lt;";
        return toBeMatched == '<';
    }

    @Override
    public void addToList(List<String> convertedLine) {
        convertedLine.add(toBeAdded);
    }
}
