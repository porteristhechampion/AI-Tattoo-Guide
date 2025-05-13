package com.ptaylor.tattoosuggestions.controller;

import com.ptaylor.tattoosuggestions.entity.Suggestion;
import com.ptaylor.tattoosuggestions.entity.User;
import com.ptaylor.tattoosuggestions.persistence.TattooDAO;

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

/**
 * This servlet handles displaying the users suggestions
 * on the suggestions list page.
 *
 * @author ptaylor
 */
public class SuggestionsServlet extends HttpServlet {
    private TattooDAO<User> userDAO;

    /**
     * This method instantiates an instance of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {userDAO = new TattooDAO<>(User.class);}

    /**
     * This method handles the GET request to display the users suggestions, and sends them to the
     * suggestions list page.
     *
     * @param request request object
     * @param response response object
     * @throws ServletException servlet exception
     * @throws IOException io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        List<User> users = userDAO.getByPropertyLike("username", username);
        User user = users.get(0);
        List<Suggestion> suggestions = user.getSuggestions();

        request.setAttribute("suggestions", suggestions);

        RequestDispatcher rd = request.getRequestDispatcher("suggestions.jsp");
        rd.forward(request, response);
    }
}
