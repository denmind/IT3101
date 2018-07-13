<%-- 
    Document   : salaryModifications
    Created on : 07 11, 18, 4:47:28 PM
    Author     : Carah
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*"%>

<% 
    OurDataBase DB = new OurDataBase("unwind_sms");
    
    
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
                    <p class="navbar-text navbar-right" style="margin-right: 10px">Welcome back, <a href="#" class="navbar-link" style="padding-right: 50px">Mark Otto</a><a href="#" class="navbar-link"><span class="glyphicon glyphicon-log-out"></span></a></p>
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
                        <tr>
                            <td>1</td>
                            <td>3</td>
                            <td>Regudo, Carah Justine A</td>
                            <td>Chef</td>
                            <td>Deduction : Late Fine</td>
                            <td>3000</td>
                            <td>45000</td>
                            <td>12-07-2018 10:30:20 AM</td>
                            
                        </tr>
                    </tbody>
                </table>  
            </div>
        </div>


    </body>
</html>

