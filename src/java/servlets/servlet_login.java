/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import models.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc-user
 */
@WebServlet(name = "servlet_login", urlPatterns = {"/servlet_login"})
public class servlet_login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            /**
             * Starts empty employee not null
             */
            Employee E = new Employee();
            OurDataBase DB = new OurDataBase("unwind");
            HttpSession session = request.getSession(true);
            
            DB.initConnection();
            
            E.setEmail(request.getParameter("email"));
            E.setPassword(request.getParameter("password"));
            
            /**Updates employee if successful else throws exception redirecting to .jsp**/
            E = DB.employeeExists(E);
            session.setAttribute("employee_session", E);
            response.sendRedirect("home.jsp");
            
            
        } catch (SQLException | NullPointerException | ClassNotFoundException E) {
            response.sendRedirect("redirect_home.jsp");
        }
    }

}
