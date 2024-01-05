package com.example.demo_login_page.controller;

import com.example.demo_login_page.model.User;
import com.example.demo_login_page.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("loginPage")) {
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("doLogin")) {
            doLogin(request, response);
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);
        UserService userService = new UserService();
        request.setAttribute("user", username);

        if (userService.checkLogin(user)) {
//            response.sendRedirect("welcome.jsp");
           request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            response.sendRedirect("loginPage.jsp?err=1");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
