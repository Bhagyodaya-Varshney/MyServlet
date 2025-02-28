package com.example.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public static List<User> users = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!isValidUsername(username)) {
            response.getWriter().println("Invalid Username! Name must start with a capital letter and have at least 3 characters.");
            return;
        }

        if (!isValidPassword(password)) {
            response.getWriter().println("Invalid Password! Must have 8 characters, 1 uppercase, 1 digit, and exactly 1 special character.");
            return;
        }

        users.add(new User(username, password));
        response.getWriter().println("Registration Successful! Welcome " + username);
    }

    private boolean isValidUsername(String username) {
        return Pattern.matches("^[A-Z][a-zA-Z]{2,}$", username);
    }

    private boolean isValidPassword(String password) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9])(?!.*[^A-Za-z0-9].*[^A-Za-z0-9]).{8,}$", password);
    }
}
