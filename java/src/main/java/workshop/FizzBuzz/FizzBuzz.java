package workshop.FizzBuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    private final List<Matcher> matchers;
    private final Response nullResponse;

    public FizzBuzz () {
        super();
        this.matchers = new ArrayList<>(Arrays.asList(new FizzPattern(), new BuzzPattern(), new NotMatchedPattern()));
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
