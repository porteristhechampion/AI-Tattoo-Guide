package edu.matc.entjava.controller;

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
        urlPatterns = {"/users"}
)

/**
 * This servlet handles the displaying of the users
 * on the admin page.
 */
public class UsersServlet extends HttpServlet {
    private TattooDAO<User> userDAO;

    /**
     * This method instantiates an instance of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {userDAO = new TattooDAO<>(User.class);}

    /**
     * This method handles the GET request to display the users, and sends them to the suggestions
     * list page.
     *
     * @param request request object
     * @param response response object
     * @throws ServletException servlet exception
     * @throws IOException io exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userDAO.getAll();

        request.setAttribute("users", users);

        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);
    }
}
