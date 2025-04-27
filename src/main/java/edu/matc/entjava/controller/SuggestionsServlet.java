package edu.matc.entjava.controller;

import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.persistence.TattooDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/suggestions"}
)

public class SuggestionsServlet extends HttpServlet {
    private TattooDAO<Suggestion> suggestionDAO;

    @Override
    public void init() {
        suggestionDAO = new TattooDAO<>(Suggestion.class);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Suggestion> suggestions = suggestionDAO.getAllByID(1);

        request.setAttribute("suggestions", suggestions);

        RequestDispatcher rd = request.getRequestDispatcher("suggestions.jsp");
        rd.forward(request, response);
    }
}
