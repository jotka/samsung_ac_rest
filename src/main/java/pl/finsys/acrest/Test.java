package pl.finsys.acrest;

import org.apache.tomcat.util.json.ParseException;
import pl.finsys.acrest.samsung.in.State;

import java.io.IOException;

public class Test {

    public static final String PRACOWNIA = "837249dd-9e7c-ad8a-9035-6b8cf5da271b";

    public static void main(String[] args) throws IOException, ParseException {
        ACController rest = new ACController();
        rest.power(PRACOWNIA, new Param("on"));

        State state = rest.status(PRACOWNIA);
        System.out.println(state);
    }
}
