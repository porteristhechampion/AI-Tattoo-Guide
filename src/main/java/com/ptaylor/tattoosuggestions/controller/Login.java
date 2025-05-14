package com.ptaylor.tattoosuggestions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/login"}
)

/** Begins the authentication process using AWS Cognito
 *
 */
public class Login extends HttpServlet {
    Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    public static String CLIENT_ID;
    public static String LOGIN_URL;
    public static String REDIRECT_URL;

    @Override
    public void init() throws ServletException {
        super.init();
        properties = (Properties) getServletContext().getAttribute("cognitoProperties");
        CLIENT_ID = properties.getProperty("client.id");
        logger.info(CLIENT_ID);

        LOGIN_URL = properties.getProperty("loginURL");
        logger.info(LOGIN_URL);

        REDIRECT_URL = properties.getProperty("redirectURL");
        logger.info(REDIRECT_URL);
    }

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws IOException io exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (CLIENT_ID == null || LOGIN_URL == null || REDIRECT_URL == null) {
            resp.sendRedirect("error.jsp");
        }
        String url = LOGIN_URL + "?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL;
        resp.sendRedirect(url);
    }
}
