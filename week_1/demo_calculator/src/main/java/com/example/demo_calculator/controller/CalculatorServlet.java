package com.example.demo_calculator.controller;

import com.example.demo_calculator.model.CalculatorModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("calculatorPage")) {
            request.getRequestDispatcher("calculator.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operator = request.getParameter("operator");
        CalculatorModel model = new CalculatorModel(Float.parseFloat(num1),
                Float.parseFloat(num2), operator);

//        Float result = model.calculate();

        request.setAttribute("result", model);
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }

}
