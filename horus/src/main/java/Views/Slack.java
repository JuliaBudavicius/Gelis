/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author leo5d
 */
public class Slack {

    private static HttpClient client = HttpClient.newHttpClient();
<<<<<<< HEAD
    private static final String URL = "https://hooks.slack.com/services/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";
=======
    private static final String URL = "https://hooks.slack.com/services/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";
>>>>>>> 17727c8cfea4501d9813261350f23eb06c9c6604

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}