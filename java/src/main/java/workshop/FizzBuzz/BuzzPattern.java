package workshop.FizzBuzz;

public class BuzzPattern extends Matcher{
    @Override
    public boolean match(int number) {
        return number % 5 == 0;
    }

    public String respond() {
        return "Buzz";
    }
}
