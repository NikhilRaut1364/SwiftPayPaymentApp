/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-09-18 06:48:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mobileRecharge_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>Mobile Recharge</title>\r\n");
      out.write("<style>\r\n");
      out.write("*{\r\n");
      out.write("margin:0px;\r\n");
      out.write("font-family:candara;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:100%;\r\n");
      out.write("background-color:#25488e;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write(".plane{\r\n");
      out.write("height:100px;\r\n");
      out.write("width:250px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write(".title{\r\n");
      out.write("height:120px;\r\n");
      out.write("width:700px;\r\n");
      out.write("}\r\n");
      out.write(".home{\r\n");
      out.write("height:120px;\r\n");
      out.write("width:120px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write(".home:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write(".parent{\r\n");
      out.write("height:605px;\r\n");
      out.write("width:100%;\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write(".child1{\r\n");
      out.write("height:550px;\r\n");
      out.write("width:600px;\r\n");
      out.write("background-color:white;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write(".child2{\r\n");
      out.write("height:550px;\r\n");
      out.write("width:600px;\r\n");
      out.write("background-color:white;\r\n");
      out.write("}\r\n");
      out.write(".b1{\r\n");
      out.write("height:35px;\r\n");
      out.write("width:300px;\r\n");
      out.write("font-size:20px;\r\n");
      out.write("border-radius:4px;\r\n");
      out.write("}\r\n");
      out.write(".b1:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#25488e;\r\n");
      out.write("color:white;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link href=\"css/all.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color:#c2d1ef;\">\r\n");
      out.write("<form action=\"mobilePayment.jsp\" method=\"POST\">\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("\t<div class=\"plane\">\r\n");
      out.write("\t<i class=\"fas fa-paper-plane\" style=\"color:white; font-size:50px;\"></i>\r\n");
      out.write("\t&nbsp&nbsp&nbsp\r\n");
      out.write("\t<span style=\"font-size:35px;color:white;\">SwiftPay</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"title\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"home\" onclick=\"document.location.href='main.jsp'\">\r\n");
      out.write("\t<i class=\"fas fa-home\" style=\"color:white; font-size:40px;\"></i>\r\n");
      out.write("\t<span style=\"font-size:30px;color:white;\">Home</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"parent\">\r\n");
      out.write("\t<div class=\"child1\">\r\n");
      out.write("\t\t<h1 style=\"margin-bottom:15px;font-size:30px;color:#666666;\">Recharge Your Mobile</h1>\r\n");
      out.write("\t\t<table style=\"height:330px;width:500px;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><center><input type=\"text\" autocomplete=\"off\" name=\"number\" placeholder=\" Contact Number\" style=\"height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;\"></center></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><center>\r\n");
      out.write("\t\t\t\t<label style=\"font-size:20px;margin-right:10px;color:#666666;\">Select Provider</label>\r\n");
      out.write("\t\t\t\t<select name=\"provider\" style=\"height:35px;font-size:20px;width:148px;border:none;border-bottom:2px solid #25488e;\">\r\n");
      out.write("\t\t\t\t<option value=\"idea\">Idea</option>\r\n");
      out.write("\t\t\t\t<option value=\"vodafone\">Vodafone</option>\r\n");
      out.write("\t\t\t\t<option value=\"jio\">Jio</option>\r\n");
      out.write("\t\t\t\t<option value=\"airtel\">Airtel</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</center></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><center><input type=\"text\" autocomplete=\"off\" name=\"amount\" placeholder=\" Amount\" style=\"height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;\"></center></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><center><input type=\"submit\" value=\"Proceed To Recharge\" class=\"b1\"></center></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"child2\">\r\n");
      out.write("\t\t<img src=\"images java/recharge1.gif\" height=\"550\" width=\"600\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");

	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("loginForm.jsp");
	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
