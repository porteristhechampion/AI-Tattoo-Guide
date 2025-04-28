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
        urlPatterns = {"/generateSuggestion"}
)

public class GenerateSuggestionsServlet extends HttpServlet {
    private TattooDAO<Suggestion> suggestionDAO;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OpenAI openAI = new OpenAI();
        suggestionDAO = new TattooDAO<>(Suggestion.class);

        String prompt = request.getParameter("prompt");
        String aiResponse = openAI.getAIResponse(prompt);

        List<Suggestion> suggestions = suggestionDAO.getAllByID(1);

        request.setAttribute("generatedResponse", aiResponse);
        request.setAttribute("suggestions", suggestions);

        RequestDispatcher rd = request.getRequestDispatcher("suggestions.jsp");
        rd.forward(request, response);

    }

}
