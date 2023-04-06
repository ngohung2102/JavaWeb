/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


/**
 *
 * @author Administrator
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        //Xu li
        User u = new User(account, password);
        boolean check = u.checkUser();
        if (check) {
            //tao session de luu thong tin login
            HttpSession session = req.getSession(); // tao session
            session.setAttribute("account", u);
            session.setAttribute("tk", u.getAccount());
            req.setAttribute("name", u.getAccount());
            req.getRequestDispatcher("Menu.jsp").forward(req, resp);
        } else {
            req.setAttribute("err", "Account or Password");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("home.jsp");
    }

}
