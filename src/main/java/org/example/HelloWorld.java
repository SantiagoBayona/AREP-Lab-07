package org.example;

import spark.Request;
import spark.Session;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static org.example.SecureURLReader.readSecureURL;
import static spark.Spark.*;

public class HelloWorld {

    private static Map<String, String> users = new HashMap<>();
    public static void main(String[] args) throws NoSuchAlgorithmException {
        addUser();
        port(getPort());
        staticFiles.location("/public");
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello World");
        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            System.out.println(username + " " + password);
            if (users.containsKey(username) && users.get(username).equals(hashGenerator(password))) {
                System.out.println("Login Success");
                readSecureURL("keystores/myTrustStore.p12", "123456");
                res.redirect("https://localhost:5001/loggedInPage");
            }
            return "There was an error, try again";
        });
    }

    private static void addUser() throws NoSuchAlgorithmException {
        String user = "user";
        String password = "password";
        String passwordHash = hashGenerator(password);
        users.put(user, passwordHash);
    }

    public static String hashGenerator(String input) {
        byte[] encodedHash = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            encodedHash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        StringBuilder hexStr = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexStr.append('0');
            hexStr.append(hex);
        }
        return hexStr.toString();
    }

    private static int getPort(){
        if(System.getenv("PORT")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
