package edu.matc.entjava.controller;

import edu.matc.entjava.entity.Style;
import edu.matc.entjava.entity.Suggestion;
import edu.matc.entjava.entity.User;
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
    private TattooDAO<User> userDAO;
    private TattooDAO<Style> styleDAO;

    @Override
    public void init() {
        userDAO = new TattooDAO<>(User.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OpenAI openAI = new OpenAI();

        String prompt = request.getParameter("prompt");
        String aiResponse = openAI.getAIResponse(prompt);

        User user = userDAO.getById(47);
        List<Suggestion> suggestions = user.getSuggestions();
        List<Style> styles = styleDAO.getAll();

        request.setAttribute("generatedResponse", aiResponse);
        request.setAttribute("suggestions", suggestions);
        request.setAttribute("styles", styles);

        RequestDispatcher rd = request.getRequestDispatcher("suggestions.jsp");
        rd.forward(request, response);
    }

}
