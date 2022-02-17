package workshop.FizzBuzz;

public abstract class Matcher implements Response{
    public abstract boolean match(int number);
    public abstract String respond();
}
