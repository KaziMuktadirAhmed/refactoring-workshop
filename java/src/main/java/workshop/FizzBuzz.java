package workshop;

import java.util.ArrayList;
import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {
    private List<Matcher> matchers = new ArrayList<Matcher>();
    private Response nullResponse;

    public FizzBuzz(ArrayList<Matcher> matchers, Response nullResponse) {
        super();
        this.matchers = matchers;
        this.nullResponse = nullResponse;
    }

    public static String say(int number) {
        String strReturn = null;

        if (number % 15 == 0) {
            strReturn = "FizzBuzz";
        } else {
            if (number % 3 == 0) strReturn = "Fizz";

            if (number % 5 == 0) strReturn = "Buzz";
        }

        if (strReturn != null) return strReturn;

        return String.valueOf(number);
    }

    public Response getNullResponse() {
        return nullResponse;
    }

    public void setNullResponse(Response nullResponse) {
        this.nullResponse = nullResponse;
    }

    public List<Matcher> getMatchers() {
        return matchers;
    }

    public void setMatchers(List<Matcher> matchers) {
        this.matchers = matchers;
    }
}
