/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OurDataBase;

/**
 *
 * @author Carah
 */
@WebServlet(name = "servlet_edit_base_salary", urlPatterns = {"/servlet_edit_base_salary"})
public class servlet_edit_base_salary extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OurDataBase db = new OurDataBase("unwind_sms");

        double employeeSalary = 0.0;
        int employeeId = 0;
        LinkedList<Integer> idList = new LinkedList();

        try {
            db.initConnection();

            String[] idStr = request.getParameterValues("idList");

            employeeSalary = Double.parseDouble(request.getParameter("newBaseSalary"));

            for (int len = 0; len < idStr.length; len++) {
                idList.add(Integer.parseInt(idStr[len]));
            }

            System.out.println(idStr.length);
            System.out.println(employeeSalary);

            for (int x : idList) {
                db.changeEmployeeSalary(x, employeeSalary);
            }
            response.sendRedirect("adjustSalary.jsp");

        } catch (ClassNotFoundException | SQLException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
            response.sendRedirect("redirect_edit_salary_error.jsp");
        }

    }

}
