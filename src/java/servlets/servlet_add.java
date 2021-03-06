/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OurDataBase;

/**
 *
 * @author pc-user
 */
public class servlet_add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        OurDataBase DB = new OurDataBase("unwind");

        try {
            String position = request.getParameter("pos");
            String fname = request.getParameter("fname");
            String mi = request.getParameter("mi");
            String lname = request.getParameter("lname");
            String dob = request.getParameter("bdate");
            String gender = request.getParameter("gender");
            String con = request.getParameter("con");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");

            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat dateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String currentTime = dateTime.format(dt);

            DB.initConnection();

            DB.insertNewEmployee(position, fname, lname, mi, email, pass, dob, gender, con, currentTime);

            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("home.jsp").include(request, response);
            out.close();
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            Logger.getLogger(servlet_add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
