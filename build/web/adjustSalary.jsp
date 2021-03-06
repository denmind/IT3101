<%-- 
    Document   : adjustSalary
    Created on : 07 11, 18, 4:46:11 PM
    Author     : Carah
--%>
<%@page import="servlets.*"%>
<%@page import="models.*"%>
<%@page import="java.util.LinkedList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    OurDataBase DB = new OurDataBase("unwind");
    DB.initConnection();

    LinkedList<String> list = DB.getPositions();
    LinkedList<Employee> empList = DB.getAllEmployees();

    Employee globalEmployee = (Employee) session.getAttribute("employee");
    session.setAttribute("employee", globalEmployee);

    LinkedList<Integer> idList = new LinkedList();
    LinkedList<Employee> newEmpList = empList;

    for (Employee empIter : empList) {
        idList.add(empIter.getEmployee_id());
    }

    String posi = "Viewing All";

%>
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
                    <p class="navbar-text navbar-right" style="margin-right: 10px">Welcome back, <a href="#" class="navbar-link" style="padding-right: 50px"><% out.println(globalEmployee.getFullName()); %></a>
                        <a href="index.jsp" class="navbar-link"><span class="glyphicon glyphicon-log-out"></span></a></p>
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
                            <%
                                for (String pos : list) {
                                    out.println("<form method='post'><input type='submit' class='btn btn-default' name='selectedPosition'value='" + pos + "' style='width: 200px; text-align: left; margin-bottom: 3px;'></form>");
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>

            <%
                if (request.getParameter("selectedPosition") != null) {

                    posi = request.getParameter("selectedPosition");

                    empList = DB.getAllEmployeesBasedOnPosition(posi);

                    while (!idList.isEmpty()) {
                        idList.removeFirst();
                    }

                    for (Employee empIter : empList) {
                        idList.add(empIter.getEmployee_id());
                    }

                }
            %>

            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-10" id="entireThing">
                        <h4>Position: <%=posi%></h4><h4></h4>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-default" data-toggle="modal" data-target="#baseSalary">Adjust Base Salary</button>

                        <!-- BASE SALfiARY MODAL -->
                        <div class="modal fade" id="baseSalary" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">New Base Salary</h4>
                                    </div>
                                    <div class="modal-body">
                                        <!-- HELP HERE PO. KANANG ANG LINK DLI MA FOUND DAW.  -->
                                        <form method="POST" action="${pageContext.request.contextPath}/servlet_edit_base_salary">
                                            <center>
                                                <label for="newSal">Enter new Base Salary for:<br> <%
                                                    for (int i : idList) {
                                                        out.println("<input type='hidden' name='idList' value='" + i + "'><span>" + i + " </span>");
                                                    }

                                                    %>
                                                </label>
                                                <input type="number" style="width: 30%" class="form-control" placeholder="0" name="newBaseSalary" id="newSal">
                                                <br>

                                                <button type="submit" class="btn btn-default">Save</button>
                                            </center>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="height: 500px">
                    <table class="table" id="empTable">
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
                            <% for (Employee empIter : empList) {
                                    out.println("<tr>");
                                    out.println("<td id='emp_id'>" + empIter.getEmployee_id() + "</td>");
                                    out.println("<td id='emp_fn'>" + empIter.getFirst_name() + "</td>");
                                    out.println("<td id='emp_mi'>" + empIter.getMiddle_initial() + "</td>");
                                    out.println("<td id='emp_ln'>" + empIter.getLast_name() + "</td>");
                                    out.println("<td id='emp_pos'>" + empIter.getPosition() + "</td>");
                                    out.println("<td id='emp_sal'>" + empIter.getSalary() + "</td>");
                            %>
                        <td id='edit'  width='150px'><button class='btn btn-default btn-sm btn-info' data-toggle='modal' data-target="#editSalary<%= empIter.getEmployee_id()%>">Edit Salary</button></td>
                        <%
                                out.println("</tr>");

                                idList.add(empIter.getEmployee_id());
                            }
                        %>



                        </tbody>
                    </table>
                </div>

            </div>
            <% for (Employee e : newEmpList) {%>
            <!-- PERSONALIZED SALARY MODAL -->
            <div class="modal fade" id="editSalary<%= e.getEmployee_id()%>" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Edit Salary for <%=e.getFullName()%></h4>

                        </div>
                        <div class="modal-body">         

                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Salary Bonus</h4>

                                    <form method="POST" action="${pageContext.request.contextPath}/servlet_edit_salary">
                                        <label for="addAmount" style="padding-right: 10px">Amount</label>
                                        <input type="hidden" name="type" value="ADDITION">
                                        <input type="hidden" name="employee_id" value="<%=e.getEmployee_id()%>">
                                        <input type="number" class="form-control" id="addAmount" name="amount" value="0.0" style="width: 30%; display: inline-block">
                                        <br><br>
                                        <label for="addReason" style="padding-right: 10px"> Reason </label>
                                        <input type="text" name="Description" id="addReason" value="Bonus" class="form-control" placeholder="Reason for Adding" style="width: 80%; display: inline-block">
                                        <br><br>
                                        <input type="submit" class="btn btn-success" value="Add to Salary">
                                    </form>

                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Salary Deduction</h4>

                                    <form method="POST" action="${pageContext.request.contextPath}/servlet_edit_salary">
                                        <input type="hidden" name="type" value="DEDUCTION">
                                        <input type="hidden" name="employee_id" value="<%=e.getEmployee_id()%>">
                                        <label for="deductAmount" style="padding-right: 10px">Amount</label>
                                        <input type="number" class="form-control" id="deductAmount" name="amount" value="0.0" style="width: 30%; display: inline-block">
                                        <br><br>
                                        <label for="deductReason" style="padding-right: 10px"> Reason </label>
                                        <input type="text" name="Description" id="deductReason" value="Fine" class="form-control" placeholder="Reason for Deduction" style="width: 80%; display: inline-block">
                                        <br><br>
                                        <input type="submit" class="btn btn-danger" value="Deduct from Salary">
                                    </form>
                                </div>
                            </div>
                            <hr>

                            <div class="row" style="padding-left: 20px">
                                <h4>Total Salary for this Month</h4>
                                <h2><%= e.getSalary()%></h2><!-- THIS SALARY WILL BE SAVED TO THE DATABASE -->
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <%
                }
            %>
        </div>

    </body>
</html>