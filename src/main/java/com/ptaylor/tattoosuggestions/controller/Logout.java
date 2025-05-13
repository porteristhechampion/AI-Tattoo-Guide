package com.ptaylor.tattoosuggestions.controller;

import com.ptaylor.tattoosuggestions.util.PropertiesLoader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/logout"}
)

public class Logout extends HttpServlet implements PropertiesLoader {

    Properties properties;

    public static String CLIENT_ID;
    public static String LOGOUT_URL;
    public static String REDIRECT_URL;

    @Override
    public void init() {
        properties = loadProperties("/cognito.properties");
        CLIENT_ID = properties.getProperty("client.id");
        LOGOUT_URL = properties.getProperty("logoutURL");
        REDIRECT_URL = properties.getProperty("logoutRedirect");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        String url = LOGOUT_URL + "?client_id=" + CLIENT_ID + "&logout_uri=" + REDIRECT_URL;
        response.sendRedirect(url);
    }

}
