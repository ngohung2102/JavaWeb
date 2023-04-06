/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Subject;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ShowController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        if (s.getAttribute("account") == null) {
            resp.setContentType("text/html; charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login");
                return;
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        if (s.getAttribute("account") == null) {
            resp.setContentType("text/html; charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login");
                return;
            }
        }
        User u = (User) s.getAttribute("account");
        Subject sb = new Subject();
        
        if (req.getParameter("mod") != null) {
            String subjectID = req.getParameter("id");
            sb.delete(subjectID);
            ArrayList<Subject> data = sb.getListSubjectRegisted(u.getAccount());
            req.setAttribute("data", data);
            req.setAttribute("err", "Xoa thanh cong mon hoc " + subjectID);
            req.getRequestDispatcher("Edit.jsp").forward(req, resp);
        }
        

        ArrayList<Subject> list = new ArrayList<>();
        list = sb.getListSubjectRegisted(u.getAccount());
        if (list.isEmpty()) {
            req.setAttribute("err", "chua co mon hoc nao duoc dang ky");
            req.getRequestDispatcher("ShowRegisted.jsp").forward(req, resp);
        } else {
            req.setAttribute("list", list);
            req.getRequestDispatcher("ShowRegisted.jsp").forward(req, resp);
        }
        
        

        
    }

}
