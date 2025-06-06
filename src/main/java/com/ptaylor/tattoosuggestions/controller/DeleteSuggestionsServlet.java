package com.ptaylor.tattoosuggestions.controller;

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

@WebServlet(
        urlPatterns = {"/deleteSuggestion"}
)

/**
 * This servlet handles deletion of a tattoo
 * suggestion from the database upon a POST request,
 * and redirects back to the suggestion list page.
 *
 * @author ptaylor
 */
public class DeleteSuggestionsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(DeleteSuggestionsServlet.class);

    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<User> userDAO;

    /**
     * This method instantiates an instance of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        userDAO = new TattooDAO<>(User.class);
    }

    /**
     * This method handles the POST request to delete a suggestion, retrieves the
     * suggestion ID from the request, fetches the corresponding suggestion from
     * the database, deletes it, and redirects back to the suggestion list page.
     *
     * @param request request object
     * @param response response object
     * @throws IOException io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int suggestionId = Integer.parseInt(request.getParameter("suggestionDelete"));

        Suggestion suggestion = suggestionDAO.getById(suggestionId);
        suggestionDAO.delete(suggestion);

        String username = (String) request.getSession().getAttribute("username");

        List<User> updatedUsers = userDAO.getByPropertyLike("username", username);
        User updatedUser = updatedUsers.get(0);

        request.getSession().setAttribute("user", updatedUser);

        logger.debug(suggestion);

        response.sendRedirect("suggestions.jsp");
    }
}
