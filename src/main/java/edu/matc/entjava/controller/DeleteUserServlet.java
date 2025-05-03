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

public class DeleteUserServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(DeleteUserServlet.class);

    TattooDAO<User> userDAO;

    @Override
    public void init() {userDAO = new TattooDAO<>(User.class);}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userDelete"));

        User user = userDAO.getById(userId);
        userDAO.delete(user);

        logger.debug(user);

        response.sendRedirect("users");
    }
}
