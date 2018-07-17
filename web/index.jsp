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
        <link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <style>
            body{
                background-image: url(Images/background.jpg);
                background-repeat: no-repeat;
                background-size: cover ;
            }
        </style>
    </head>
    <body style="padding: 10%;">
        <!-- Top content -->
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <div class="description">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">

                                <div class="row" align="center"><h2 style="color:#66ffff ; font-weight: bold;">Salary Management System</h2></div>
                                <div class="row" align="center"><h4 style="color:#66ff99">Unwind Website</h3></div>
                                <div class="form-top-left">
                                    <p style="color: yellow">Enter your username and password to log on:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" action="home.jsp" method="POST" class="login-form" autocomplete="off">
                                    <div class="form-group">
                                        <label class="sr-only" for="form-username">Email Address</label>
                                        <input type="text" name="email" placeholder="Email Address..." class="form-email form-control" id="em">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="form-password">Password</label>
                                        <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="pw">
                                    </div>
                                    <button type="submit" class="btn">Sign in!</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </body>
    </body>
</html>
