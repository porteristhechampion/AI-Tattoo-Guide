package com.ptaylor.tattoosuggestions.controller;

import com.ptaylor.tattoosuggestions.entity.Style;
import com.ptaylor.tattoosuggestions.entity.Suggestion;
import com.ptaylor.tattoosuggestions.entity.User;
import com.ptaylor.tattoosuggestions.persistence.TattooDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(
        urlPatterns = {"/insertSuggestion"}
)

/**
 * This servlet handles adding a new tattoo suggestion to the
 * database upon a POST request, and redirects back to the
 * suggestion list page.
 *
 * @author ptaylor
 */
public class InsertSuggestionServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(InsertSuggestionServlet.class);

    TattooDAO<User> userDAO;
    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<Style> styleDAO;

    /**
     * This method instantiates instances of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {
        userDAO = new TattooDAO<>(User.class);
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    /**
     * This method handles the POST request to add a suggestion, retrieves the user ID,
     * and style ID from the request, fetches the corresponding user, and style, adds it
     * to the database, and redirects back to the suggestion list page.
     *
     * @param request request object
     * @param response response object
     * @throws IOException io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String suggestionText = request.getParameter("suggestion");
        int styleId = Integer.parseInt(request.getParameter("style"));

        String username = (String) request.getSession().getAttribute("username");
        List<User> users = userDAO.getByPropertyLike("username", username);
        User user = users.get(0);
        Style style = styleDAO.getById(styleId);

        Suggestion newSuggestion = new Suggestion(suggestionText, user, style, LocalDateTime.now());
        int insertedId = suggestionDAO.insert(newSuggestion);

        logger.info(suggestionText);
        logger.info(styleId);
        logger.info(insertedId);

        response.sendRedirect("suggestions");
    }

}
