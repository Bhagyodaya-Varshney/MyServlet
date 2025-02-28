package com.example.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean found = RegisterServlet.users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));

        if (!found) {
            response.getWriter().println("<h2 style='color:red;'>Invalid Username or Password!</h2>");
        } else {
            response.getWriter().println("<h2>Login Successful! Welcome back, " + username + "</h2>");
        }
    }
}
