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
        urlPatterns = {"/suggestions"}
)

public class SuggestionsServlet extends HttpServlet {
    private TattooDAO<User> userDAO;

    @Override
    public void init() {userDAO = new TattooDAO<>(User.class);}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = userDAO.getById(47);
        List<Suggestion> suggestions = user.getSuggestions();

        request.setAttribute("suggestions", suggestions);

        RequestDispatcher rd = request.getRequestDispatcher("suggestions.jsp");
        rd.forward(request, response);
    }
}
