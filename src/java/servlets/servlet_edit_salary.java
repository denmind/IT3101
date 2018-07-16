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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc-user
 */
public class servlet_edit_salary extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OurDataBase db = new OurDataBase("unwind_sms");
        
        double employeeSalary = 0.0;
        double newEmployeeSalary = 0.0;
        double modif_amount = 0.0;
        int employeeId = 0;
        String modif_type = "";
        String description = "";

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat dateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String currentTime = dateTime.format(dt);

        try {
            db.initConnection();

            modif_type = request.getParameter("type");

            employeeId = Integer.parseInt(request.getParameter("employee_id"));
            employeeSalary = db.getSalary(employeeId);

            description = request.getParameter("Description");

            modif_amount = Double.parseDouble(request.getParameter("amount"));

            switch (modif_type) {
                case "ADDITION":
                    newEmployeeSalary = employeeSalary + modif_amount;
                    break;
                case "DEDUCTION":
                    newEmployeeSalary = employeeSalary - modif_amount;
                    break;
            }

            db.changeEmployeeSalary(employeeId, newEmployeeSalary);
//            System.out.println(employeeId + ", " + modif_amount + ", " + newEmployeeSalary + ", " + description + ", " + modif_type + ", " + currentTime);
            db.addEmployeeModification(employeeId, modif_amount, newEmployeeSalary, description, modif_type, currentTime);
            response.sendRedirect("adjustSalary.jsp");

        } catch (ClassNotFoundException | SQLException | NumberFormatException ex ) {
            response.sendRedirect("redirect_edit_salary_error.jsp");
        }

    }

}
