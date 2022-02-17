package workshop.FizzBuzz;

public class NotMatchedPattern extends Matcher{
    private String responseStr = "";
    @Override
    public boolean match(int number) {
        responseStr = String.valueOf(number);
        return (number%3 != 0 && number%5 != 0);
    }

    @Override
    public String respond() {
        return responseStr;
    }
}
