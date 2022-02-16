package workshop.FizzBuzz;

import workshop.Response;

public abstract class Matcher implements Response {
    public abstract boolean match(int number);
}
