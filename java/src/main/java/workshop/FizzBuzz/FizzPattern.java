package workshop.FizzBuzz;

public class FizzPattern extends Matcher implements Response {
    @Override
    public boolean match(int number) {
        return number % 3 == 0;
    }

    public String respond() {
        return "Fizz";
    }
}
