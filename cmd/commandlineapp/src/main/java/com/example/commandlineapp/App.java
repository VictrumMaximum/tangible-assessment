package commandlineapp.src.main.java.com.example.commandlineapp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;

public class App 
{
    private final static String BASE_URL = "??";
    private final static String PERSON_PATH = "/person";


    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("First argument must be action 'get' or 'create'");
            System.exit(1);
        }

        String action = args[0];

        switch (action) {
            case "get":
                getUsers();
                break;
            case "create":
                createUser(args);
                break;
            default:
            System.out.println("Invalid action");
            System.exit(1);
        }
    }
    
    public static void getUsers() throws Exception {
        System.out.println("Fetching users...");

        HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL + PERSON_PATH)).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response status code " + response.statusCode());
        System.out.println("Response body:");
        System.out.println(response.body());
    }
    
    public static void createUser(String[] args) {
        if (args.length < 4) {
            System.out.println("Provide input as: firstname lastname year-month-day");
            System.exit(1);
        }
    }
}
