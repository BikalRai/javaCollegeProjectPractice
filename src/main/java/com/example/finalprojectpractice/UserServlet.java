package com.example.finalprojectpractice;

import com.example.finalprojectpractice.model.Student;
import com.example.finalprojectpractice.service.UserService;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("newUser")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/register.jsp");
            requestDispatcher.forward(request, response);
        }


        if (page.equals("register")) {
            Student student = new Student();

            student.setUsername(request.getParameter("username"));
            student.setAddress(request.getParameter("address"));
            student.setPassword(request.getParameter("password"));

            System.out.println(student.getUsername());
            System.out.println(student.getAddress());
            System.out.println(student.getPassword());

            new UserService().insertUser(student);
            System.out.println("Data inserted Successfully");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("login")) {
            String name = request.getParameter("username");
            String password = request.getParameter("password");

            Student student = new UserService().getStudent(name, password);

            if (student != null){
                HttpSession session = request.getSession();
                session.setAttribute("username", name);
                System.out.println(session.getAttribute("username"));

                Cookie cookie = new Cookie("username", name);
                response.addCookie(cookie);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/dashboard.jsp");
                requestDispatcher.forward(request, response);

            } else  {
                printWriter.println("Invalid Username or Password.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    public void destroy() {
    }
}