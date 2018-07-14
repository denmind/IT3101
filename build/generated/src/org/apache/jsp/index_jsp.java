package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Salary Management System</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel='stylesheet' href='Bootstrap/css/bootstrap.min.css'>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-image: url(Images/background.jpg);\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: 100% ;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"padding: 10%;\">\n");
      out.write("        <div class=\"row\" align=\"center\"><h2 style=\"color:white ; font-weight: bold;\">Salary Management System</h2></div>\n");
      out.write("        <div class=\"row\" align=\"center\"><h4 style=\"color:white\">Unwind Website</h3></div>\n");
      out.write("        <br><br>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <div class=\"form-group\" id=\"login\" >\n");
      out.write("                    <form action=\"home.jsp\" method=\"post\" autocomplete=\"off\">\n");
      out.write("                        <center><input type=\"text\" name=\"email\" class=\"form-control\" id=\"em\" style=\"width: 350px\" placeholder=\"Email Address\"></center>\n");
      out.write("                        <br>\n");
      out.write("                        <center><input type=\"password\" name=\"password\" class=\"form-control\" id=\"pw\" style=\"width: 350px\" placeholder=\"Password\"></center>\n");
      out.write("                        <br>\n");
      out.write("                        <center><button type=\"submit\" class=\"btn btn-info\">Login</button></center>\n");
      out.write("                    </form>\n");
      out.write("                </div>         \n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
