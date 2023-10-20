package org.example;

import static spark.Spark.*;

public class LoggedIn {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("/loggedInPage", (req, res) -> {
            res.redirect("https://localhost:5001/loggedInPage.html");
            return null;
        });
    }

    public static Integer getPort() {
        return 5001;
    }

}