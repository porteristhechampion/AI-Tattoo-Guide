package com.ptaylor.tattoosuggestions.controller;

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

/**
 * Clears data stored in session and sends
 * user back to homepage.
 *
 * @author ptaylor
 */
public class Logout extends HttpServlet {

    Properties properties;

    public static String CLIENT_ID;
    public static String LOGOUT_URL;
    public static String REDIRECT_URL;

    /**
     * Loads variables with property file data
     * gotten from servlet context upon
     * initialization.
     */
    @Override
    public void init() {
        properties = (Properties) getServletContext().getAttribute("cognitoProperties");
        CLIENT_ID = properties.getProperty("client.id");
        LOGOUT_URL = properties.getProperty("logoutURL");
        REDIRECT_URL = properties.getProperty("logoutRedirect");
    }

    /**
     * This method clears all data stored in the session when the user logs out and sends them to the
     * cognito logout url which then sends them back to the home page.
     * @param request http servlet request
     * @param response http servlet response
     * @throws IOException io exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (CLIENT_ID == null || LOGOUT_URL == null || REDIRECT_URL == null) {
            response.sendRedirect("error.jsp");
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        String url = LOGOUT_URL + "?client_id=" + CLIENT_ID + "&logout_uri=" + REDIRECT_URL;
        response.sendRedirect(url);
    }

}
