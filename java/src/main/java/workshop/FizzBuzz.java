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

    public FizzBuzz(ArrayList<Matcher> matchers, NullResponse nullResponse) {
        super();
        this.matchers = matchers;
        this.nullResponse = nullResponse;
    }

    public String say(int number) {
        String strReturn = nullResponse.respond();

        for (Matcher matcher: matchers) {
            if (matcher.match(number)) strReturn = matcher.respond();
        }

        return strReturn;
    }

    public void setNullResponse(Response nullResponse) {
        this.nullResponse = nullResponse;
    }
}
