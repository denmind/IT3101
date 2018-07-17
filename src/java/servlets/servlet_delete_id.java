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
import models.Employee;
import models.OurDataBase;

/**
 *
 * @author pc-user
 */
public class servlet_delete_id extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        OurDataBase DB = new OurDataBase("unwind");

        try {
            String employee_id = request.getParameter("employee_id");

            int empID=Integer.valueOf(employee_id);
            
            DB.initConnection();

            DB.deleteEmployee(empID);

            out.print("<p>Delete successfully!</p>");
            request.getRequestDispatcher("home.jsp").include(request, response);
            out.close();
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            Logger.getLogger(servlet_add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
