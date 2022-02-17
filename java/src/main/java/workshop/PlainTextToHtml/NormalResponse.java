package workshop.PlainTextToHtml;

import java.util.List;

public interface NormalResponse extends Matcher {
    public void addToList (List<String> convertedLine);
}
