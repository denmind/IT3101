<%-- 
    Document   : adjustSalary
    Created on : 07 11, 18, 4:46:11 PM
    Author     : Carah
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adjust Wages</title>
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
            <center><h3>Adjust Employee Wages</h3></center>
        </div>
        <div class="row" style="padding-left: 5%; padding-right: 5%">
            <div class="col-md-3">
                <div class="row">
                    <div class="col-md-12">
                        <h4>Select Employee Position</h4>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-8" style="overflow: auto">
                        <div class="list-group"><!-- MODAL! EMPLOYEE POSITIONS--> <!-- CLICKING MODIFIES entireThing-->
                            <a href="#" class="list-group-item" name="Housekeeping">Housekeeping</a>
                            <a href="#" class="list-group-item" name="Concierge">Concierge</a>
                            <a href="#" class="list-group-item" name="Chef">Chef</a>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-10" id="entireThing">
                        <h4>Position: </h4><h4><!--Insert Employee Position--></h4>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-default" data-toggle="modal" data-target="#baseSalary">Adjust Base Salary</button>

                        <!-- BASE SALARY MODAL -->
                        <div class="modal fade" id="baseSalary" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Base Salary</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form action="POST">
                                            <center>
                                                <label for="newSal">Enter new BASE SALARY / HOUR </label>
                                                <input type="number" style="width: 30%" class="form-control" placeholder="0" name="fname" id="newSal">
                                                <!-- make java function to remove other characters except for numbers -->
                                            </center>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-default" data-dismiss="modal">Save</button>
                                        <!-- onclick alert are you sure you want to delete 0 ? -->
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="height: 500px">
                    <table class="table">
                        <thead>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Middle Initial</th>
                        <th>Last Name</th>
                        <th>Position</th>
                        <th width="150px">Salary</th>
                        <th></th>
                        </thead>
                        <tbody style="overflow: auto">
                            <tr>
                                <td id="emp_id">1</td>
                                <td id="emp_fn">Carah</td>
                                <td id="emp_mi">A</td>
                                <td id="emp_ln">Regudo</td>
                                <td id="emp_pos">Chef</td>
                                <td id="emp_sal">999, 999</td>
                                <td id="edit"  width="150px"><button class="btn btn-default btn-sm btn-info" data-toggle="modal" data-target="#editSalary">Edit Salary</button></td>
                            </tr>

                        </tbody>
                    </table>
                </div>

            </div>

            <!-- PERSONALIZED SALARY MODAL -->
            <div class="modal fade" id="editSalary" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Edit Salary for Mark Otto <!-- REPLACE MARK OTTO WITH EMPLOYEE NAME --></h4>
                        </div>
                        <div class="modal-body">         

                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Salary Bonus</h4>
                                    
                                    <form method="POST">
                                        <label for="addAmount" style="padding-right: 10px">Amount</label>
                                        <input type="number" class="form-control" id="addAmount" name="addAmount" style="width: 30%; display: inline-block">
                                        <br><br>
                                        <label for="deductReason" style="padding-right: 10px"> Reason </label>
                                        <input type="text" id="addReason" class="form-control" placeholder="Reason for Adding" style="width: 80%; display: inline-block">
                                        <br><br>
                                        <button type="button" class="btn btn-success">Add to Salary</button>
                                    </form>
                                    
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Salary Deduction</h4>
                                    
                                    <form method="POST">
                                        <label for="deductAmount" style="padding-right: 10px">Amount</label>
                                        <input type="number" class="form-control" id="deductAmount" name="deductAmount" style="width: 30%; display: inline-block">
                                        <br><br>
                                        <label for="deductReason" style="padding-right: 10px"> Reason </label>
                                        <input type="text" id="deductReason" class="form-control" placeholder="Reason for Deduction" style="width: 80%; display: inline-block">
                                        <br><br>
                                        <button type="button" class="btn btn-danger">Deduct from Salary</button>
                                    </form>
                                </div>
                            </div>
                            <hr>
                            <div class="row" style="padding-left: 20px">
                                <h4>Total Salary for this Month</h4>
                                <h2>3000.00</h2><!-- THIS SALARY WILL BE SAVED TO THE DATABASE -->
                            </div>
                      
                        </div>
                    </div>

                </div>
            </div>

        </div>

    </body>
</html>

