/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Administrator
 */
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("account") == null) {
            resp.setContentType("text/html; charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("account") == null) {
            resp.setContentType("text/html; charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login");
                return;
            }
        }
        session.removeAttribute("account");
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
