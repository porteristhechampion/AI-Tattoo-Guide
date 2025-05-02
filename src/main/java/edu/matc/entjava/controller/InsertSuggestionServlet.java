package edu.matc.entjava.controller;

import edu.matc.entjava.entity.Style;
import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.entity.User;
import edu.matc.entjava.persistence.TattooDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(
        urlPatterns = {"/insertSuggestion"}
)

public class InsertSuggestionServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(InsertSuggestionServlet.class);

    TattooDAO<User> userDAO;
    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<Style> styleDAO;

    @Override
    public void init() {
        userDAO = new TattooDAO<>(User.class);
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String suggestionText = request.getParameter("suggestion");
        int styleId = Integer.parseInt(request.getParameter("style"));

        User user = userDAO.getById(47);
        Style style = styleDAO.getById(styleId);

        Suggestion newSuggestion = new Suggestion(suggestionText, user, style, LocalDateTime.now());
        int insertedId = suggestionDAO.insert(newSuggestion);

        logger.info(suggestionText);
        logger.info(styleId);
        logger.info(insertedId);

        response.sendRedirect("suggestions");
    }

}
