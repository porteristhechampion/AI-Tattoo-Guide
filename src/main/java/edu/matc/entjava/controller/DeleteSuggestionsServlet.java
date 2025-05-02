package edu.matc.entjava.controller;

import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.persistence.TattooDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/deleteSuggestion"}
)

public class DeleteSuggestionsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(DeleteSuggestionsServlet.class);

    TattooDAO<Suggestion> suggestionDAO;

    @Override
    public void init() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int suggestionId = Integer.parseInt(request.getParameter("suggestionDelete"));

        Suggestion suggestion = suggestionDAO.getById(suggestionId);
        suggestionDAO.delete(suggestion);

        logger.debug(suggestion);

        response.sendRedirect("suggestions");
    }
}
