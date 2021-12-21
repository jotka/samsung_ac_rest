package pl.finsys.acrest.samsung.out;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.springframework.core.env.Environment;
import pl.finsys.acrest.samsung.in.State;

import java.io.IOException;

public class SamsungRequest {
    private String API_TOKEN;
    private String API_URL;

    private final static String contentType = "text/plain; charset=utf-8";

    private String device;

    public SamsungRequest(Environment env, String device) {
        this.API_URL = env.getProperty("API_URL");
        this.API_TOKEN = env.getProperty("API_TOKEN");
        this.device = device;
    }

    public void execute(String capability, String command) throws IOException {
        execute(new SamsungCommand(capability, command));
    }

    public void execute(String capability, String command, Object[] params) throws IOException {
        execute(new SamsungCommand(capability, command, params));
    }

    private void execute(SamsungCommand command) throws IOException {
        String json = new Gson().toJson(command);
        Request.Post(API_URL + device + "/commands")
                .addHeader("Authorization", API_TOKEN).addHeader("Content-Type", contentType)
                .bodyString(json, ContentType.DEFAULT_TEXT)
                .execute().returnContent();
    }

    public State status() throws IOException {
        Content content = Request.Get(API_URL + device + "/status")
                .addHeader("Authorization", API_TOKEN).addHeader("Content-Type", contentType)
                .execute().returnContent();
        return new Gson().fromJson(content.toString(), State.class);
    }


}
