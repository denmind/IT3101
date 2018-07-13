<%-- 
    Document   : index.jsp
    Created on : 07 11, 18, 4:43:20 PM
    Author     : Carah
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Salary Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel='stylesheet' href='Bootstrap/css/bootstrap.min.css'>
        <style>
            body{
                background-image: url(Images/background.jpg);
                background-repeat: no-repeat;
                background-size: 100% ;
            }
        </style>
    </head>
    <body style="padding: 10%;">
        <div class="row" align="center"><h2 style="color:white ; font-weight: bold;">Salary Management System</h2></div>
        <div class="row" align="center"><h4 style="color:white">Unwind Website</h3></div>
        <br><br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="form-group" id="login" >
                    <form action="servlet_login" method="post" autocomplete="off">
                        <center><input type="text" name="email" class="form-control" id="em" style="width: 350px" placeholder="Email Address"></center>
                        <br>
                        <center><input type="password" name="password" class="form-control" id="pw" style="width: 350px" placeholder="Password"></center>
                        <br>
                        <center><button type="submit" class="btn btn-info">Login</button></center>
                    </form>
                </div>         
            </div>
            <div class="col-md-4"></div>


        </div>
    </body>
</html>
