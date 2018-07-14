<%-- 
    Document   : home
    Created on : 07 11, 18, 4:44:50 PM
    Author     : Carah
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.LinkedList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*"%>
<%
    OurDataBase DB = new OurDataBase("unwind");
    DB.initConnection();

    LinkedList<Employee> list = DB.getEmployeeIDs();

%>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel='stylesheet' href='Bootstrap/css/bootstrap.min.css'>
        <script src="Bootstrap/js/jquery-331.min.js"></script>
        <script src="Bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%            Employee globalEmployee = new Employee();
            if (session.getAttribute("employee") == null) {
                try {
                    OurDataBase db = new OurDataBase("unwind");
                    globalEmployee = db.getUserCredentials(request);

                    session = request.getSession();
                    session.setAttribute("employee", globalEmployee);
                } catch (Exception E) {
                    response.sendRedirect("redirect_home.jsp");
                }
            } else {
                globalEmployee = (Employee) session.getAttribute("employee");
                session.setAttribute("employee", globalEmployee);
            }
        %>
        <div class="row" align="center">

            <div class="col-md-12">
                <nav class="navbar navbar-inverse" style="color: #d9534f ; border-radius: 0px ">
                    <div class="navbar-header" >
                        <a class="navbar-brand" href="home.jsp" style="">Salary Management System</a>
                    </div>
                    <p class="navbar-text navbar-right" style="margin-right: 10px">Welcome back, 
                        <a href="#" class="navbar-link" style="padding-right: 50px"><% out.println(globalEmployee.getFullName()); %></a>
                        <a href="index.jsp" class="navbar-link"><span class="glyphicon glyphicon-log-out"></span></a>
                    </p>
                </nav>        
            </div>

        </div>

        <div class="row">
            <center><h3>Employee List</h3></center>
        </div>
        <div class="row">
            <div class="col-md-12" style="padding: 2%">
                <div class="row">
                    <div class="col-md-2">
                        <div class="list-group">
                            <a href="adjustSalary.jsp" class="list-group-item">Adjust Employee Wages</a> <!-- EMPLOYEE TYPES WITH DIFFERENT SALARIES -->
                            <a href="salaryModifications.jsp" class="list-group-item">Recent Salary Modifications</a> 
                        </div>
                        <div class="list-group"><!-- MODAL! EMPLOYEE CUD-->
                            <a href="#" class="list-group-item" data-toggle="modal" data-target="#addEmployee">Add New Employee</a>
                            <a href="#" class="list-group-item" data-toggle="modal" data-target="#updateEmployee">Update Employee</a>
                            <a href="#" class="list-group-item" data-toggle="modal" data-target="#deleteEmployee">Delete Employee</a>
                        </div>


                    </div>

                    <!--- MODALS! -->
                    <!-- ADD NEW EMPLOYEE -->
                    <div class="modal fade" id="addEmployee" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Add New Employee</h4>
                                </div>
                                <div class="modal-body">

                                    <form method="POST" action="servlet_add">
                                        <fieldset>
                                            <legend style="text-align: center"><span class="glyphicon glyphicon-info-sign"></span></legend>
                                            <label for="fn">First Name</label>
                                            <input type="text" class="form-control" placeholder="Joanne" name="fname" id="fn">
                                            <br>
                                            <label for="mi">Middle Initial</label>
                                            <input type="text" class="form-control" placeholder="K" name="mi" id="mi">
                                            <br>
                                            <label for="ln">Last Name</label>
                                            <input type="text" class="form-control" placeholder="Rowling" name="lname" id="ln">
                                            <br>
                                            <label for="bd">Date of Birth:</label>
                                            <input type="date" class="form-control" name="bdate" id="bd">
                                            <br>
                                            <label for="g">Gender</label>
                                            <p style="padding-left: 10px"><input type="radio" name="gender" value="Male" id="g"> Male</p> 
                                            <p style="padding-left: 10px"><input type="radio" name="gender" value="Female" id="g"> Female</p>
                                        </fieldset>
                                        <br>
                                        <fieldset>
                                            <legend style="text-align: center"><span class="glyphicon glyphicon-envelope"></span></legend>
                                            <label for="cn">Contact No.</label>
                                            <input type="text" class="form-control" name="con" placeholder="09172348594" id="cn">
                                            <br>
                                            <label for="e">Email Address</label>
                                            <input type="email" class="form-control" placeholder="chef@chefchef.com" name="email" id="e">
                                            <br>
                                            <label for="p">Password</label>
                                            <input type="password" class="form-control" name="pass" id="p">
                                            <br>
                                        </fieldset>
                                        <br>
                                        <fieldset>
                                            <legend style="text-align: center"><span class="glyphicon glyphicon-user"></span></legend>
                                            <label for="pos">Employee Position</label>
                                            <input type="text" class="form-control" placeholder="Secretary" name="pos" id="pos">
                                            <br>
                                            <label for="wH">Employee Working Hours</label>
                                            <p style="padding-left: 10px"><input type="radio" name="workingHours" value="4" id="wH"> 4</p> 
                                            <p style="padding-left: 10px"><input type="radio" name="workingHours" value="8" id="wH"> 8</p>
                                            <p style="padding-left: 10px"><input type="radio" name="workingHours" value="12" id="wH"> 12</p> 
                                            <br>
                                            <label for="wH">Employee Shift</label>
                                            <p style="padding-left: 10px"><input type="radio" name="workingShift" value="AM" id="wS"> AM</p> 
                                            <p style="padding-left: 10px"><input type="radio" name="workingShift" value="PM" id="wS"> PM</p>
                                        </fieldset>
                                    </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default" data-dismiss="modal">Add Employee</button>
                                </div>
                            </div>

                        </div>
                    </div>

                    <!-- UPDATE EMPLOYEE -->
                    <div class="modal fade" id="updateEmployee" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Update Employee</h4>
                                </div>
                                <div class="modal-body">

                                    <center>
                                        <form method="POST" action="servlet_select_id">
                                            <label for="id">Select Employee ID</label>
                                            <select class="form-control" style="width: 300px" name="id">
                                                <!-- ID NUMBERS -->
                                                <%                                                    for (Employee E : list) {
                                                        out.println("<option>[" + E.getEmployee_id() + "] " + E.getFullName() + "</option>");
                                                    }
                                                %> 
                                            </select>
                                        </form>
                                    </center>

                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default" data-toggle="modal" data-target="#toUpdateEmployeeDetails"><!--data-dismiss="modal"-->Next</button>
                                </div>
                            </div>

                        </div>
                    </div>

                    <!-- UPDATE EMPLOYEE INFO-->
                    <div class="modal fade" id="toUpdateEmployeeDetails" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Update Employee</h4>
                                </div>
                                <div class="modal-body">

                                    <form method="POST" action="servlet_update">
                                        <fieldset>
                                            <legend style="text-align: center"><span class="glyphicon glyphicon-info-sign"></span></legend>
                                            <label for="fn">First Name</label>
                                            <input type="text" class="form-control" placeholder="Joanne" name="fname" id="fn">
                                            <br>
                                            <label for="mi">Middle Initial</label>
                                            <input type="text" class="form-control" placeholder="K" name="mi" id="mi">
                                            <br>
                                            <label for="ln">Last Name</label>
                                            <input type="text" class="form-control" placeholder="Rowling" name="lname" id="ln">
                                            <br>
                                            <label for="bd">Date of Birth:</label>
                                            <input type="date" class="form-control" name="bdate" id="bd">
                                            <br>
                                            <label for="g">Gender</label>
                                            <p style="padding-left: 10px"><input type="radio" name="gender" value="Male" id="g"> Male</p> 
                                            <p style="padding-left: 10px"><input type="radio" name="gender" value="Female" if="g"> Female</p>
                                            <br>
                                            <label for="pos">Employee Position</label>
                                            <input type="text" class="form-control" placeholder="Secretary" name="pos" id="pos">
                                            <br>
                                        </fieldset>
                                        <br>
                                        <fieldset>
                                            <legend style="text-align: center"><span class="glyphicon glyphicon-envelope"></span></legend>
                                            <label for="cn">Contact No.</label>
                                            <input type="text" class="form-control" name="con" placeholder="09172348594" id="cn">
                                            <br>
                                            <label for="e">Email Address</label>
                                            <input type="email" class="form-control" placeholder="chef@chefchef.com" name="email" id="e">
                                            <br>
                                            <label for="p">Password</label>
                                            <input type="password" class="form-control" name="pass" id="p">
                                            <br>
                                        </fieldset>
                                        <fieldset>
                                            <legend style="text-align: center"><span class="glyphicon glyphicon-user"></span></legend>
                                            <label for="pos">Employee Position</label>
                                            <input type="text" class="form-control" placeholder="Secretary" name="pos" id="pos">
                                            <br>
                                            <label for="wH">Employee Working Hours</label>
                                            <p style="padding-left: 10px"><input type="radio" name="workingHours" value="4" id="wH"> 4</p> 
                                            <p style="padding-left: 10px"><input type="radio" name="workingHours" value="8" id="wH"> 8</p>
                                            <p style="padding-left: 10px"><input type="radio" name="workingHours" value="12" id="wH"> 12</p> 
                                            <br>
                                            <label for="wH">Employee Shift</label>
                                            <p style="padding-left: 10px"><input type="radio" name="workingShift" value="AM" id="wS"> AM</p> 
                                            <p style="padding-left: 10px"><input type="radio" name="workingShift" value="PM" id="wS"> PM</p>
                                        </fieldset>
                                    </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default" data-dismiss="modal">Update Employee</button>
                                </div>
                            </div>

                        </div>
                    </div>                   

                    <!-- DELETE EMPLOYEE -->
                    <div class="modal fade" id="deleteEmployee" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Delete Employee</h4>
                                </div>
                                <div class="modal-body"> 
                                    <form method="POST" action="servlet_select_id">
                                        <center>
                                            <label for="id">Select Employee ID</label>
                                            <select class="form-control" style="width: 300px" name="id">
                                                <!-- ID NUMBERS -->
                                                <%
                                                    for (Employee E : list) {
                                                        out.println("<option>[" + E.getEmployee_id() + "] " + E.getFullName() + "</option>");
                                                    }
                                                %>
                                            </select>
                                            <!-- make java function to remove other characters except for numbers -->
                                        </center>

                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default delEmp" data-dismiss="modal">Delete Employee</button>
                                    <!-- onclick alert are you sure you want to delete 0 ? -->
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-md-10"> <!-- MAKE DIV SCROLLABLE -->
                        <table class="table">
                            <thead>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Middle Initial</th>
                            <th>Last Name</th>
                            <th>Position</th>
                            <th>Salary</th>
                            <th style="width: 200px"></th>
                            </thead>
                            <tbody style="overflow: auto">
                                <tr>
                                    <td id="emp_id">1</td>
                                    <td id="emp_fn">Carah</td>
                                    <td id="emp_mi">A</td>
                                    <td id="emp_ln">Regudo</td>
                                    <td id="emp_pos">Chef</td>
                                    <td id="emp_sal">999,999</td>
                                    <!--                                    <td style="width: 200px"><button type="submit" class="btn btn-info" data-toggle="modal" data-target="#toUpdateEmployeeDetails">Update</button>   <button class="btn btn-danger delEmp">Delete</button></td>-->
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>


<script>
    $(document).ready(function () {
        $(".delEmp").click(function () {
            alert("Are you sure?");
        });


    });
</script>