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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OurDataBase;

/**
 *
 * @author GL503
 */
@WebServlet(name = "servlet_update", urlPatterns = {"/servlet_update"})
public class servlet_update extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
            String employee_id=request.getParameter("employee_id");

            DB.initConnection();

            DB.updateEmployee(employee_id,position, fname, lname, mi, email, pass, dob, gender, con);

            out.print("<p>Update successfully!</p>");
            request.getRequestDispatcher("home.jsp").include(request, response);
            out.close();
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            Logger.getLogger(servlet_add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
