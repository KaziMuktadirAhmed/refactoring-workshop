package workshop;

public class symbolNewLinePattern implements Matcher{
    @Override
    public boolean match(char toBeMatched) {
        return toBeMatched == '\n';
    }
}
