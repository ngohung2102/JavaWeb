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
public class RegistedController extends HttpServlet {

    //click mon hoc hien ra giao vien
    // han thoi gian dang ki mon hoc
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("account") == null) {
            resp.setContentType("text/html; charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login");
            }
        }
        //get teacher id, con subject id
        String subjectid = req.getParameter("subjectId");
        String acc = req.getParameter("acc");
        //Student subject(acc,subId,teaId)
        //teaId o list
        //lay list teacher va acc nao dk
        Subject s = new Subject("", subjectid);
        ArrayList<Subject> list = new ArrayList<>();
        String teacherId = "";
        list = s.getTeacherBySubject(subjectid);
        for (Subject s1 : list) {
            String x = s1.getTeacherID();
            if (req.getParameter(x) != null) {
                teacherId = s1.getTeacherID();
                break;
            }
        }
        s.setTeacherID(teacherId);
        // lay list trong databse neu trung thi ko add
        ArrayList<Subject> listRegis = new ArrayList<>();
        listRegis = s.getListSubjectRegisted(acc);
        boolean check = true;
        for (Subject l1 : listRegis) {
            if (l1.getSubjectID().equals(subjectid)) {
                check = false;
            }
        }
        if (check) {
            s.addToDatabase(acc, s);
            req.setAttribute("result", "Register success");
        }else{
            req.setAttribute("result", "Register failed");
        }
        ArrayList<Subject> listBS = s.getListBySemeter(acc);
        req.setAttribute("listBS", listBS);
        req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);

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

        User account = (User) session.getAttribute("account");
//            System.out.println("check check: " + account);
//            System.out.println("account hien tai: " + account.getAccount());
//            System.out.println("Ky hien tai: " + account.getSemeterOfStudent(account.getAccount()));
        Subject s = new Subject();
        ArrayList<Subject> listBS = s.getListBySemeter(account.getAccount());
        ArrayList<Subject> list = new ArrayList<>();
        ArrayList<Subject> listData = new ArrayList<>();
        listData = s.getListSubjectRegisted(account.getAccount());

        req.setAttribute("listBS", listBS);
        req.setAttribute("x", 1);
        req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);

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
        if (req.getParameter("luu") != null) {
//            String subjectID = req.getParameter("search");
//            if (!subjectID.isEmpty()) {
//                listBS = s.getSearchByID(subjectID);
//            }
            String id = req.getParameter("LuuID");
            ArrayList<Subject> listTeach = s.getTeacherBySubject(id);
            System.out.println("listTeacherBySubject: " + listTeach);

            for (Subject sb : listTeach) {
                String x = (sb.getTeacherID() + id);
                if (req.getParameter(x) != null) {
                    System.out.println("Teacher duoc chon: " + x);
                    list.add(sb);
                }
            }
            
            if (list.isEmpty()) {
                req.setAttribute("save", 0);
                req.setAttribute("err", "chua chon mon dang ki");
                req.setAttribute("list", listData);
                req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);

            } else {
                if (listData.isEmpty()) {
                    for (Subject s1 : list) {
                        s.addToDatabase(account.getAccount(), s1);
                    }
                    req.setAttribute("err", "Register Successfull");
                    req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);
                } else {
                    for (Subject sub : listData) {
                        for (Subject su : list) {
                            if (sub.getSubjectID().equals(id)) {
                                req.setAttribute("err", "mon nay da dang ky");
                                req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);
                            } else {
                                for (Subject s1 : list) {
                                    s.addToDatabase(account.getAccount(), s1);
                                }

                            }
                        }
                    }
                    req.setAttribute("err", "Register Successfull");
                    req.getRequestDispatcher("ListSubject.jsp").forward(req, resp);
                }

            }
            req.setAttribute("save", 1);
            req.setAttribute("listData", listData);
            req.getRequestDispatcher("ListRegisted.jsp").forward(req, resp);
        }

    }

}
