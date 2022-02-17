package workshop.PlainTextToHtml;

public class symbolNewLinePattern implements Matcher {
    @Override
    public boolean match(Character toBeMatched) {
        return toBeMatched == '\n';
    }
}
