package workshop.FizzBuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {
    private List<Matcher> matchers;
    private Response nullResponse;

    public FizzBuzz () {
        super();
        this.matchers = new ArrayList<Matcher>(Arrays.asList(new FizzPattern(), new BuzzPattern(), new NotMatchedPattern()));
        this.nullResponse = new NullResponse();
    }

    public FizzBuzz(List<Matcher> matchers, Response nullResponse) {
        this.matchers = matchers;
        this.nullResponse = nullResponse;
    }

    public String say(int number) {
        String strReturn = nullResponse.respond();

        for (Matcher matcher: matchers) {
            if (matcher.match(number)) strReturn = strReturn.concat(matcher.respond());
        }

        return strReturn;
    }
}
