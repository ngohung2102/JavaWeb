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
public class TeacherController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("account") == null) {
            resp.setContentType("text/html; charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login");
            }
        }
        
        User account = (User) session.getAttribute("account");
        Subject s = new Subject();
        ArrayList<Subject> listBS = s.getListBySemeter(account.getAccount());
        ArrayList<Subject> list = new ArrayList<>();
        ArrayList<Subject> listData = new ArrayList<>();
        listData = s.getListSubjectRegisted(account.getAccount());

//        if (req.getParameter("mod") != null) {
//            req.setAttribute("listBS", listBS);
//            req.setAttribute("x", 1);
//            req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);
//        }

      if (req.getParameter("tim") != null) {
            String subjectID = req.getParameter("search");
            if (subjectID.isEmpty()) {
                req.setAttribute("err", "Must input information in search");
                req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);
            } else {
                listBS = s.getSearchByID(subjectID);
                for (Subject subject : listBS) {
                    req.setAttribute("SubjectID", subject.getSubjectID());
                }
                req.setAttribute("listBS", listBS);
                req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);

            }

        }
        // Save
        if (req.getParameter("save") != null) {
            String subjectID = req.getParameter("search");
            if (!subjectID.isEmpty()) {
                listBS = s.getSearchByID(subjectID);
            }
            for (Subject sb : listBS) {
                String x = sb.getSubjectID();
                if (req.getParameter(x) != null) {
//                    session.setAttribute("subjectID", x);
                    System.out.println("mon hoc da chon: "+sb.getSubjectID());
                    System.out.println("mon hoc da chon: "+x);
                    list.add(sb);
                }
            }
          
            if (list.isEmpty()) {
                req.setAttribute("save", 0);
                req.setAttribute("err", "chua chon mon dang ki");
                req.setAttribute("list", listData);
                req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);
            } else{
                ArrayList<Subject> listTeach = new ArrayList<>();
                for (Subject subject : list) {
                    String id = subject.getSubjectID();
                    
                    req.setAttribute("subjectId", id);
                    //acc
                    req.setAttribute("acc", account.getAccount());
                    System.out.println("subjectID luu: "+id);
                    listTeach = s.getTeacherBySubject(id);
                }
                
                for (Subject subject : listTeach) {
                    System.out.println("listTeach: "+subject.getTeacherID());
                }
                req.setAttribute("listTeach", listTeach);
                req.getRequestDispatcher("Teacher.jsp").forward(req, resp);
            }

        }
    }
    
    
}
