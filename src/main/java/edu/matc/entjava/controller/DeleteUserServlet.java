package edu.matc.entjava.controller;

import edu.matc.entjava.entity.User;
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
        urlPatterns = {"/deleteUser"}
)

/**
 * This servlet handles deletion of a user from
 * the database upon a POST request,and redirects
 * back to the admin user list page.
 *
 * @author ptaylor
 */
public class DeleteUserServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(DeleteUserServlet.class);

    TattooDAO<User> userDAO;

    /**
     * This method instantiates an instance of the DAO
     * once the servlet is first loaded.
     */
    @Override
    public void init() {userDAO = new TattooDAO<>(User.class);}

    /**
     * This method handles the POST request to delete a user, retrieves the
     * user ID from the request, fetches the corresponding user from the
     * database, deletes it, and redirects back to the user list page.
     *
     * @param request request object
     * @param response response object
     * @throws IOException io exception
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int userId = Integer.parseInt(request.getParameter("userDelete"));

        User user = userDAO.getById(userId);
        userDAO.delete(user);

        logger.debug(user);

        response.sendRedirect("users");
    }
}
