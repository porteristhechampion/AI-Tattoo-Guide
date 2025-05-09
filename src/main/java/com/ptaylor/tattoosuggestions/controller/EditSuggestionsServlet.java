package com.ptaylor.tattoosuggestions.controller;

import com.ptaylor.tattoosuggestions.entity.Style;
import com.ptaylor.tattoosuggestions.entity.Suggestion;
import com.ptaylor.tattoosuggestions.persistence.TattooDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/editSuggestion"}
)

/**
 * This servlet handles setting up the form for updating
 * a tattoo suggestion in the database upon a POST request,
 * and redirects back to the suggestion list page.
 */
public class EditSuggestionsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EditSuggestionsServlet.class);

    private TattooDAO<Suggestion> suggestionDAO;
    private TattooDAO<Style> styleDAO;

    /**
     * This method instantiates instances of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    /**
     * This method handles the POST request to update a suggestion, retrieves the suggestion ID from the request,
     * fetches the corresponding suggestion from the database, and sends it along with a list of styles to the
     * edit page.
     *
     * @param request request object
     * @param response response object
     * @throws ServletException servlet exception
     * @throws IOException io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int suggestionId = Integer.parseInt(request.getParameter("suggestionEdit"));

        Suggestion suggestion = suggestionDAO.getById(suggestionId);
        List<Style> styles = styleDAO.getAll();

        logger.debug(suggestion);

        request.setAttribute("suggestion", suggestion);
        request.setAttribute("styles", styles);

        RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
        rd.forward(request, response);
    }
}
