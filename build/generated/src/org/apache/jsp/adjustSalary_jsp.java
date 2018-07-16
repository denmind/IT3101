package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import servlets.*;
import models.*;
import java.util.LinkedList;

public final class adjustSalary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

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


      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Adjust Wages</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel='stylesheet' href='Bootstrap/css/bootstrap.min.css'>\n");
      out.write("        <script src=\"Bootstrap/js/jquery-331.min.js\"></script>\n");
      out.write("        <script src=\"Bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"row\" align=\"center\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <nav class=\"navbar navbar-inverse\" style=\"color: #d9534f ; border-radius: 0px \">\n");
      out.write("                    <div class=\"navbar-header\" >\n");
      out.write("                        <a class=\"navbar-brand\" href=\"home.jsp\" style=\"\">Salary Management System</a>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"navbar-text navbar-right\" style=\"margin-right: 10px\">Welcome back, <a href=\"#\" class=\"navbar-link\" style=\"padding-right: 50px\">");
 out.println(globalEmployee.getFullName()); 
      out.write("</a>\n");
      out.write("                        <a href=\"index.jsp\" class=\"navbar-link\"><span class=\"glyphicon glyphicon-log-out\"></span></a></p>\n");
      out.write("                </nav>        \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <center><h3>Adjust Employee Wages</h3></center>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\" style=\"padding-left: 5%; padding-right: 5%\">\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <h4>Select Employee Position</h4>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-8\" style=\"overflow: auto\">\n");
      out.write("                        <div class=\"list-group\"><!-- MODAL! EMPLOYEE POSITIONS--> <!-- CLICKING MODIFIES entireThing-->\n");
      out.write("                            ");

                                for (String pos : list) {
                                    out.println("<form method='post'><input type='submit' class='btn btn-default' name='selectedPosition'value='" + pos + "' style='width: 200px; text-align: left; margin-bottom: 3px;'></form>");
                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-9\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-10\" id=\"entireThing\">\n");
      out.write("                        <h4>Position: ");
      out.print(posi);
      out.write("</h4><h4></h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-2\">\n");
      out.write("                        <button class=\"btn btn-default\" data-toggle=\"modal\" data-target=\"#baseSalary\">Adjust Base Salary</button>\n");
      out.write("\n");
      out.write("                        <!-- BASE SALfiARY MODAL -->\n");
      out.write("                        <div class=\"modal fade\" id=\"baseSalary\" role=\"dialog\">\n");
      out.write("                            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                                <!-- Modal content-->\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                        <h4 class=\"modal-title\">New Base Salary</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        <!-- HELP HERE PO. KANANG ANG LINK DLI MA FOUND DAW.  -->\n");
      out.write("                                        <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/servlet_edit_base_salary\">\n");
      out.write("                                            <center>\n");
      out.write("                                                <label for=\"newSal\">Enter new Base Salary for:<br> ");

                                                    for (int i : idList) {
                                                        out.println("<input type='hidden' name='idList[]' value='" + i + "'><span>" + i + " </span>");
                                                    }

                                                    
      out.write("\n");
      out.write("                                                </label>\n");
      out.write("                                                <input type=\"number\" style=\"width: 30%\" class=\"form-control\" placeholder=\"0\" name=\"newBaseSalary\" id=\"newSal\">\n");
      out.write("                                                <br>\n");
      out.write("\n");
      out.write("                                                <button type=\"submit\" class=\"btn btn-default\">Save</button>\n");
      out.write("                                            </center>\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\" style=\"height: 500px\">\n");
      out.write("                    <table class=\"table\">\n");
      out.write("                        <thead>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>First Name</th>\n");
      out.write("                        <th>Middle Initial</th>\n");
      out.write("                        <th>Last Name</th>\n");
      out.write("                        <th>Position</th>\n");
      out.write("                        <th width=\"150px\">Salary</th>\n");
      out.write("                        <th></th>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody style=\"overflow: auto\">\n");
      out.write("                            ");
 for (Employee empIter : empList) {
                                    out.println("<tr>");
                                    out.println("<td id='emp_id'>" + empIter.getEmployee_id() + "</td>");
                                    out.println("<td id='emp_fn'>" + empIter.getFirst_name() + "</td>");
                                    out.println("<td id='emp_mi'>" + empIter.getMiddle_initial() + "</td>");
                                    out.println("<td id='emp_ln'>" + empIter.getLast_name() + "</td>");
                                    out.println("<td id='emp_pos'>" + empIter.getPosition() + "</td>");
                                    out.println("<td id='emp_sal'>" + empIter.getSalary() + "</td>");
                            
      out.write("\n");
      out.write("                        <td id='edit'  width='150px'><button class='btn btn-default btn-sm btn-info' data-toggle='modal' data-target=\"#editSalary");
      out.print( empIter.getEmployee_id());
      out.write("\">Edit Salary</button></td>\n");
      out.write("                        ");

                                out.println("</tr>");

                                idList.add(empIter.getEmployee_id());
                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
 for (Employee e : newEmpList) {
      out.write("\n");
      out.write("            <!-- PERSONALIZED SALARY MODAL -->\n");
      out.write("            <div class=\"modal fade\" id=\"editSalary");
      out.print( e.getEmployee_id());
      out.write("\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                    <!-- Modal content-->\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                            <h4 class=\"modal-title\">Edit Salary for ");
      out.print(e.getFullName());
      out.write("</h4>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">         \n");
      out.write("\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <h4>Salary Bonus</h4>\n");
      out.write("\n");
      out.write("                                    <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/servlet_edit_salary\">\n");
      out.write("                                        <label for=\"addAmount\" style=\"padding-right: 10px\">Amount</label>\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"ADDITION\">\n");
      out.write("                                        <input type=\"hidden\" name=\"employee_id\" value=\"");
      out.print(e.getEmployee_id());
      out.write("\">\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"addAmount\" name=\"amount\" value=\"0.0\" style=\"width: 30%; display: inline-block\">\n");
      out.write("                                        <br><br>\n");
      out.write("                                        <label for=\"addReason\" style=\"padding-right: 10px\"> Reason </label>\n");
      out.write("                                        <input type=\"text\" name=\"Description\" id=\"addReason\" value=\"Bonus\" class=\"form-control\" placeholder=\"Reason for Adding\" style=\"width: 80%; display: inline-block\">\n");
      out.write("                                        <br><br>\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-success\" value=\"Add to Salary\">\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <hr>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <h4>Salary Deduction</h4>\n");
      out.write("\n");
      out.write("                                    <form method=\"POST\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/servlet_edit_salary\">\n");
      out.write("                                        <input type=\"hidden\" name=\"type\" value=\"DEDUCTION\">\n");
      out.write("                                        <input type=\"hidden\" name=\"employee_id\" value=\"");
      out.print(e.getEmployee_id());
      out.write("\">\n");
      out.write("                                        <label for=\"deductAmount\" style=\"padding-right: 10px\">Amount</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"deductAmount\" name=\"amount\" value=\"0.0\" style=\"width: 30%; display: inline-block\">\n");
      out.write("                                        <br><br>\n");
      out.write("                                        <label for=\"deductReason\" style=\"padding-right: 10px\"> Reason </label>\n");
      out.write("                                        <input type=\"text\" name=\"Description\" id=\"deductReason\" value=\"Fine\" class=\"form-control\" placeholder=\"Reason for Deduction\" style=\"width: 80%; display: inline-block\">\n");
      out.write("                                        <br><br>\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-danger\" value=\"Deduct from Salary\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <hr>\n");
      out.write("\n");
      out.write("                            <div class=\"row\" style=\"padding-left: 20px\">\n");
      out.write("                                <h4>Total Salary for this Month</h4>\n");
      out.write("                                <h2>");
      out.print( e.getSalary());
      out.write("</h2><!-- THIS SALARY WILL BE SAVED TO THE DATABASE -->\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
