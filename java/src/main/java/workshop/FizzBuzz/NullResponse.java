package workshop.FizzBuzz;

import workshop.Response;

public class NullResponse implements Response {
    @Override
    public String respond() {
        return "";
    }
}
