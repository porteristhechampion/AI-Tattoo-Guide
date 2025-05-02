package edu.matc.entjava.controller;

import edu.matc.entjava.entity.Style;
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

@WebServlet (
        urlPatterns = "/updateSuggestion"
)

public class UpdateSuggestionsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EditSuggestionsServlet.class);

    TattooDAO<Suggestion> suggestionDAO;
    TattooDAO<Style> styleDAO;

    @Override
    public void init() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int suggestionId = Integer.parseInt(request.getParameter("suggestionId"));
        String suggestionText = request.getParameter("suggestion");
        int styleId = Integer.parseInt(request.getParameter("style"));

        Suggestion suggestion = suggestionDAO.getById(suggestionId);
        Style style = styleDAO.getById(styleId);

        suggestion.setSuggestion(suggestionText);
        suggestion.setStyle(style);

        suggestionDAO.update(suggestion);

        logger.debug(suggestion);

        response.sendRedirect("suggestions");
    }

}
