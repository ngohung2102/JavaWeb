/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class User {

    public String account, password, dateCreated;

    public User() {
        connect();
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }
    
    

    public User(String account, String password, String dateCreated) {
        this.account = account;
        this.password = password;
        this.dateCreated = dateCreated;
        connect();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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

    public boolean checkUser() {
        try {
            String strSelect = "select * from Accounts where account= ? and password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());

        }

        return false;
    }
    
    public int getSemeterOfStudent(String account) {
        int semester = 0;
        try {
            String strSelect = " select s.semesterID from Accounts a join Students s "
                    + "on a.account = s.account "
                    + "where a.account = ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();

            if (rs.next()) {
                semester = rs.getInt(1);
                return semester;
            }
            

        } catch (Exception e) {
            System.out.println("getSemeterOfStudent: " + e.getMessage());

        }
        return 0;
    }

    

}
