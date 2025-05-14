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
import java.util.List;

@WebServlet (
        urlPatterns = "/updateSuggestion"
)

/**
 * This servlet handles updating a tattoo suggestion upon
 * a POST request, and redirects back to the suggestions
 * list page.
 *
 * @author ptaylor
 */
public class UpdateSuggestionsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EditSuggestionsServlet.class);

    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<User> userDAO;
    TattooDAO<Style> styleDAO;

    /**
     * This method instantiates instances of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        userDAO = new TattooDAO<>(User.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    /**
     * This method handles the POST request to update a suggestion, retrieves the suggestion ID from
     * the request, fetches the corresponding suggestion from the database, updates it in the database,
     * and redirects back to the suggestion list page.
     *
     * @param request request object
     * @param response response object
     * @throws IOException io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int suggestionId = Integer.parseInt(request.getParameter("suggestionId"));
        String suggestionText = request.getParameter("suggestion");
        int styleId = Integer.parseInt(request.getParameter("style"));

        Suggestion suggestion = suggestionDAO.getById(suggestionId);
        Style style = styleDAO.getById(styleId);

        suggestion.setSuggestion(suggestionText);
        suggestion.setStyle(style);

        suggestionDAO.update(suggestion);

        String username = (String) request.getSession().getAttribute("username");

        List<User> updatedUsers = userDAO.getByPropertyLike("username", username);
        User updatedUser = updatedUsers.get(0);

        request.getSession().setAttribute("user", updatedUser);

        logger.debug(suggestion);

        response.sendRedirect("suggestions.jsp");
    }

}
