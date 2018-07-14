<%-- 
    Document   : salaryModifications
    Created on : 07 11, 18, 4:47:28 PM
    Author     : Carah
--%>

<%@page import="models.*"%>
<%@page import="java.util.LinkedList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%
    OurDataBase DB = new OurDataBase("unwind_sms");

    DB.initConnection();

    LinkedList<EmployeeModifications> modifs_list = DB.getSalaryModifications();
    Employee globalEmployee = (Employee) session.getAttribute("employee");
    session.setAttribute("employee", globalEmployee);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Salary Modifications</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel='stylesheet' href='Bootstrap/css/bootstrap.min.css'>
        <script src="Bootstrap/js/jquery-331.min.js"></script>
        <script src="Bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row" align="center">
            <div class="col-md-12">
                <nav class="navbar navbar-inverse" style="color: #d9534f ; border-radius: 0px ">
                    <div class="navbar-header" >
                        <a class="navbar-brand" href="home.jsp" style="">Salary Management System</a>
                    </div>
                    <p class="navbar-text navbar-right" style="margin-right: 10px">Welcome back, <a href="#" class="navbar-link" style="padding-right: 50px"><% out.println(globalEmployee.getFullName()); %></a><a href="#" class="navbar-link"><span class="glyphicon glyphicon-log-out"></span></a></p>
                </nav>        
            </div>

        </div>

        <div class="row">
            <center><h3>Salary Modifications</h3></center>
        </div>
        <br>
        <div class="row">
            <div class="col-md-12" style="padding-left: 5%; padding-right: 5%">
                <!--WITH PAGINATION I GUESS HAHAHA-->
                <% if (modifs_list.isEmpty()) { %>

                <% } else { %>
                <table class="table">
                    <thead>
                    <th>Modification ID</th>
                    <th>Employee ID</th>
                    <th>Employee Name</th> <!-- CONCAT FULL NAME -->
                    <th>Employee Position</th>
                    <th>Description</th>
                    <th>Amount</th>
                    <th>Updated Salary</th>
                    <th>Date & Time Modified</th> 
                    </thead>
                    <tbody style="overflow: auto">
                        <%
                            for (EmployeeModifications EM : modifs_list) {
                                out.println("<tr>");
                                out.println("<td>" + EM.getModif().getId() + "</td>");
                                out.println("<td>" + EM.getEmp().getEmployee_id() + "</td>");
                                out.println("<td>" + EM.getEmp().getFullName() + "</td>");
                                out.println("<td>" + EM.getEmp().getPosition() + "</td>");
                                out.println("<td>" + EM.getModif().getDescription() + "</td>");
                                out.println("<td>" + EM.getModif().getAmount() + "</td>");
                                out.println("<td>" + EM.getModif().getUpdatedSalary() + "</td>");
                                out.println("<td>" + EM.getModif().getSchedule() + "</td>");
                                out.println("</tr>");
                            }
                        %>
                    </tbody>
                </table>  
                <% }%>
            </div>
        </div>


    </body>
</html>

