package edu.matc.entjava.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = {"/startup"},
        loadOnStartup = 1
)

public class ApplicationStartup {
}
