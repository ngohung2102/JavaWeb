/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Subject {

    private String teacherID, subjectID;

    public Subject() {
        connect();
    }

    public Subject(String teacherID, String subjectID) {
        this.teacherID = teacherID;
        this.subjectID = subjectID;
        connect();
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    Connection cnn; //Ket noi SQL
    Statement stm; // Thu thi cau lenh
    PreparedStatement pstm; // thuc thi cau lenh sql (Ban nang cap cua stm)
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect Successfull");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
    }

    public ArrayList<Subject> getListBySemeter(String account) {
        ArrayList<Subject> list = new ArrayList<>();
        String password= "";
        User u = new User(account, password);
        int semester = u.getSemeterOfStudent(u.getAccount());
        try {
            String strSelect = " select distinct ts.subjectID from Subjects s join Teacher_Subject ts "
                    + "on s.subjectID = ts.subjectID \n" 
                    + "where s.semester= ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, semester);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectID = rs.getString(1);
                list.add(new Subject("", subjectID));
            }

        } catch (Exception e) {
            System.out.println("getListBySemeter: " + e.getMessage());

        }
        return list;
    }

    public ArrayList<Subject> getSearchByID(String subjectID) {
        ArrayList<Subject> list = new ArrayList<Subject>();
        try {
            String strSelect = " select * from Teacher_Subject "
                    + "where subjectID like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectID + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String teacherID = rs.getString(1);
                subjectID = rs.getString(2);
                list.add(new Subject(teacherID, subjectID));
            }

        } catch (Exception e) {
            System.out.println("getSearchByID: " + e.getMessage());

        }
        return list;
    }

    public ArrayList<Subject> getListSubjectRegisted(String account) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String strSelect = "select teacherID, subjectID from Student_Subject "
                    + "where account= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String TeacherID = rs.getString(1);
                String SubjectID = rs.getString(2);
                list.add(new Subject(TeacherID, SubjectID));
            }
        } catch (Exception e) {
            System.out.println("getListSubjectRegisted: " + e.getMessage());
        }
        return list;
    }

    
    public void addToDatabase(String account, Subject s){
        try {
            String strSelect= "INSERT INTO Student_Subject ([account], [teacherID],[subjectID])\n" +
"values(?, ?, ?)";
            
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, s.getTeacherID());
            pstm.setString(3, s.getSubjectID());
            pstm.execute();
            
        } catch (Exception e) {
            System.out.println("addToDatabase: "+e.getMessage());
        }
    } 

    public void delete(String subjectID) {
        try {
            String strSelect = "delete from Student_Subject "
                    + "where subjectID=? ";
                    
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectID);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("delete: "+e.getMessage());
        }
    }
    
    
    public ArrayList<Subject> getTeacherBySubject(String subjectID) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String strSelect = "select teacherID from Teacher_Subject "
                    + "where subjectID= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String TeacherID = rs.getString(1);
                list.add(new Subject(TeacherID, ""));
            }
        } catch (Exception e) {
            System.out.println("getTeacherBySubject: " + e.getMessage());
        }
        return list;
    }
    

}
