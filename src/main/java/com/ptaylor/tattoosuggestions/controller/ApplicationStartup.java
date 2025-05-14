package com.ptaylor.tattoosuggestions.controller;

import com.ptaylor.tattoosuggestions.util.PropertiesLoader;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Properties;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = {"/startup"},
        loadOnStartup = 1
)

/**
 * This servlet loads on startup and loads the api and cognito properties and
 * places them in the servlet context so all servlets can access them.
 *
 * @author ptaylor
 */
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    /**
     * Initialization method loads properties and places
     * them in servlet context.
     */
    @Override
    public void init() {
        ServletContext context = getServletContext();

        Properties apiProperties = loadProperties("/api.properties");
        Properties cognitoProperties = loadProperties("/cognito.properties");

        context.setAttribute("apiProperties", apiProperties);
        context.setAttribute("cognitoProperties", cognitoProperties);

    }

}
