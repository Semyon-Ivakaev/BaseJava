package out.homework12.api.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import out.homework12.api.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static String getUsersInfo(int page) throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(String.format("https://reqres.in/api/users?page=%d", page)))
                .build();
        HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static String getDeleteUserState(int id) throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(String.format("https://reqres.in/api/users/%d", id)))
                .build();
        HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static int createUser(User user) throws IOException, InterruptedException {
        String body = mapper.writeValueAsString(user);
        HttpRequest post = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("content-type", "application/json")
                .uri(URI.create("https://reqres.in/api/users"))
                .build();
        HttpResponse<String> createResponse = client.send(post, HttpResponse.BodyHandlers.ofString());

        return createResponse.statusCode();
    }

    public static int deleteUser(int id) throws IOException, InterruptedException {
        HttpRequest delete = HttpRequest.newBuilder()
                .DELETE()
                .header("accept", "application/json")
                .uri(URI.create(String.format("https://reqres.in/api/users/%d", id)))
                .build();
        HttpResponse<String> response = client.send(delete, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }
}
