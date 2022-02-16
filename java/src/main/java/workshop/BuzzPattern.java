package workshop;

public class BuzzPattern extends Matcher implements Response{
    @Override
    public boolean match(int number) {
        return number%5 == 0;
    }

    public String respond() {
        return "Buzz";
    }
}
