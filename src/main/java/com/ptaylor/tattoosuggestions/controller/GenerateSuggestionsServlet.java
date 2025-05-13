package com.ptaylor.tattoosuggestions.controller;

import com.ptaylor.tattoosuggestions.entity.Style;
import com.ptaylor.tattoosuggestions.entity.Suggestion;
import com.ptaylor.tattoosuggestions.entity.User;
import com.ptaylor.tattoosuggestions.persistence.OpenAI;
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
        urlPatterns = {"/generateSuggestion"}
)

/**
 * This servlet handles generating the AI's response and
 * sending it along with the users list of suggestions to
 * the suggestion list page upon a POST request.
 *
 * @author ptaylor
 */
public class GenerateSuggestionsServlet extends HttpServlet {
    private TattooDAO<User> userDAO;
    private TattooDAO<Style> styleDAO;

    /**
     * This method instantiates instances of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {
        userDAO = new TattooDAO<>(User.class);
        styleDAO = new TattooDAO<>(Style.class);
    }

    /**
     * This method handles the POST request to generate a suggestion, retrieves the prompt from the request,
     * and sends it along with a list of the users suggestions, and a list of styles, to the suggestion list
     * page.
     *
     * @param request request object
     * @param response response object
     * @throws ServletException servlet exception
     * @throws IOException io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OpenAI openAI = new OpenAI();

        String prompt = request.getParameter("prompt");
        String aiResponse = openAI.getAIResponse(prompt);

        List<Style> styles = styleDAO.getAll();

        request.setAttribute("generatedResponse", aiResponse);
        request.setAttribute("styles", styles);

        RequestDispatcher rd = request.getRequestDispatcher("suggestions.jsp");
        rd.forward(request, response);
    }

}
