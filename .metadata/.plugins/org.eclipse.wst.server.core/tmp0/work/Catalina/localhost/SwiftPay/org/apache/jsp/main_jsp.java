/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-07-09 04:18:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
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
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>SwiftPay Main</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function search(a)\r\n");
      out.write("{\r\n");
      out.write("\tvar find=a.toLowerCase().split(\" \").join(\"\");\r\n");
      out.write("\tif(find==\"movie\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"movie.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"electricity\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"electricity1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"mobilerecharge\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"mobileRecharge.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"postpaid\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"postpaid.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"dth\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"dth1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"landline\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"landline1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"broadband\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"broadband1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"schoolfees\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"schoolfees.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"creditcard\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"creditcard1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"bus\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"bus.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"flight\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"flight.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"train\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"train.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"event\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"event.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"endgame\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"endgame1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"jumanji\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"jumanji1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"thegooddinosaur\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"dino1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(find==\"justiceleague\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.location.href=\"justice1.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var slideIndex = 0;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function showSlides() {\r\n");
      out.write("  var i;\r\n");
      out.write("  var slides = document.getElementsByClassName(\"mySlides\");\r\n");
      out.write("  var dots = document.getElementsByClassName(\"dot\");\r\n");
      out.write("  for (i = 0; i < slides.length; i++) {\r\n");
      out.write("    slides[i].style.display = \"none\";  \r\n");
      out.write("  }\r\n");
      out.write("  slideIndex++;\r\n");
      out.write("  if (slideIndex > slides.length) {slideIndex = 1}    \r\n");
      out.write("  for (i = 0; i < dots.length; i++) {\r\n");
      out.write("    dots[i].className = dots[i].className.replace(\" active\", \"\");\r\n");
      out.write("  }\r\n");
      out.write("  slides[slideIndex-1].style.display = \"block\";  \r\n");
      out.write("  dots[slideIndex-1].className += \" active\";\r\n");
      out.write("  setTimeout(\"showSlides()\", 2000);\r\n");
      out.write("}\r\n");
      out.write("window.onload=showSlides;\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("*{\r\n");
      out.write("margin:0px;\r\n");
      out.write("font-family:candara;\r\n");
      out.write("}\r\n");
      out.write(".heading{\r\n");
      out.write("height:180px;\r\n");
      out.write("width:100%;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("}\r\n");
      out.write(".plane{\r\n");
      out.write("height:120px;\r\n");
      out.write("width:220px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write(".search{\r\n");
      out.write("height:100px;\r\n");
      out.write("width:550px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".history{\r\n");
      out.write("height:130px;\r\n");
      out.write("width:130px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wallet{\r\n");
      out.write("height:130px;\r\n");
      out.write("width:130px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wallet:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".noti{\r\n");
      out.write("height:130px;\r\n");
      out.write("width:130px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".noti:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".about{\r\n");
      out.write("height:100px;\r\n");
      out.write("width:190px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("margin-left:30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".about:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".logout{\r\n");
      out.write("height:130px;\r\n");
      out.write("width:130px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".logout:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=text]{\r\n");
      out.write("width:550px;\r\n");
      out.write("background-color:white;\r\n");
      out.write("background-image:url('search.png');\r\n");
      out.write("background-position:10px 10px;\r\n");
      out.write("background-size:25px 25px;\r\n");
      out.write("background-repeat:no-repeat;\r\n");
      out.write("font-size:20px;\r\n");
      out.write("padding:12px 20px 12px 40px;\r\n");
      out.write("border:none;\r\n");
      out.write("border-bottom:2px solid #25488e;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".parent{\r\n");
      out.write("height:380px;\r\n");
      out.write("width:100%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("align-items:center;\r\n");
      out.write("background-color:#25488e;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child{\r\n");
      out.write("height:250px;\r\n");
      out.write("width:75%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-1{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:150px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-1:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#5d85d5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".parent1{\r\n");
      out.write("margin-top:30px;\r\n");
      out.write("height:620px;\r\n");
      out.write("width:80%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("background-color:white;\r\n");
      out.write("box-shadow: 10px 10px 5px grey;\r\n");
      out.write("border-radius:25px;\r\n");
      out.write("padding:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child1{\r\n");
      out.write("height:550px;\r\n");
      out.write("width:70%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("flex-wrap:wrap;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-2{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:150px;\r\n");
      out.write("margin-left:50px;\r\n");
      out.write("margin-right:50px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-2:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".parent2{\r\n");
      out.write("height:330px;\r\n");
      out.write("width:80%;\r\n");
      out.write("margin-top:30px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("background-color:white;\r\n");
      out.write("box-shadow: 10px 10px 5px grey;\r\n");
      out.write("border-radius:25px;\r\n");
      out.write("padding:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child2{\r\n");
      out.write("height:230px;\r\n");
      out.write("width:75%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("align-items:center;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-3{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:150px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".parent3{\r\n");
      out.write("height:300px;\r\n");
      out.write("width:80%;\r\n");
      out.write("margin-top:30px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("background-color:white;\r\n");
      out.write("box-shadow: 10px 10px 5px grey;\r\n");
      out.write("border-radius:25px;\r\n");
      out.write("padding:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child3{\r\n");
      out.write("height:200px;\r\n");
      out.write("width:75%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-4{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:150px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".parent4{\r\n");
      out.write("height:300px;\r\n");
      out.write("width:80%;\r\n");
      out.write("margin-top:30px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("background-color:white;\r\n");
      out.write("box-shadow: 10px 10px 5px grey;\r\n");
      out.write("border-radius:25px;\r\n");
      out.write("padding:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".parent5{\r\n");
      out.write("height:600px;\r\n");
      out.write("width:80%;\r\n");
      out.write("margin-top:30px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("background-color:white;\r\n");
      out.write("box-shadow: 10px 10px 5px grey;\r\n");
      out.write("border-radius:25px;\r\n");
      out.write("padding:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child5{\r\n");
      out.write("height:200px;\r\n");
      out.write("width:75%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-6{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:150px;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-3:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-4:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-5:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".child-6:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main{\r\n");
      out.write("background-color:#c2d1ef;\r\n");
      out.write("height:2500px;\r\n");
      out.write("width:100%;\r\n");
      out.write("display:flex;\r\n");
      out.write("justify-content:space-around;\r\n");
      out.write("align-items:center;\r\n");
      out.write("flex-direction:column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".footer{\r\n");
      out.write("height:150px;\r\n");
      out.write("width:100%;\r\n");
      out.write("background-color:#25488e;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".terms{\r\n");
      out.write("height:100px;\r\n");
      out.write("width:400px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("margin-left:30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".terms:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".reward{\r\n");
      out.write("height:100px;\r\n");
      out.write("width:200px;\r\n");
      out.write("display:flex;\r\n");
      out.write("align-items:center;\r\n");
      out.write("justify-content:center;\r\n");
      out.write("margin-left:30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".reward:hover{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".mySlides {display: none;}\r\n");
      out.write("img {vertical-align: middle;}\r\n");
      out.write("\r\n");
      out.write(".slideshow-container {\r\n");
      out.write("  max-width: 1000px;\r\n");
      out.write("  position: relative;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".text {\r\n");
      out.write("  color: #f2f2f2;\r\n");
      out.write("  font-size: 15px;\r\n");
      out.write("  padding: 8px 12px;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  bottom: 8px;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".numbertext {\r\n");
      out.write("  color: #f2f2f2;\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("  padding: 8px 12px;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  top: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The dots/bullets/indicators */\r\n");
      out.write(".dot {\r\n");
      out.write("  height: 15px;\r\n");
      out.write("  width: 15px;\r\n");
      out.write("  margin: 0 2px;\r\n");
      out.write("  background-color: #bbb;\r\n");
      out.write("  border-radius: 50%;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  transition: background-color 0.6s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active {\r\n");
      out.write("  background-color: #717171;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fade {\r\n");
      out.write("  -webkit-animation-name: fade;\r\n");
      out.write("  -webkit-animation-duration: 1.5s;\r\n");
      out.write("  animation-name: fade;\r\n");
      out.write("  animation-duration: 1.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@-webkit-keyframes fade {\r\n");
      out.write("  from {opacity: .4} \r\n");
      out.write("  to {opacity: 1}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes fade {\r\n");
      out.write("  from {opacity: .4} \r\n");
      out.write("  to {opacity: 1}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media only screen and (max-width: 300px) {\r\n");
      out.write("  .text {font-size: 11px}\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link href=\"css/all.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String n="";
	Connection con=null;
	String uname=(String)session.getAttribute("username");
	String sql="select name from user where username='"+uname+"'";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			n=rs.getString(1);
		}
	}
	catch(Exception e)
	{
		
	}

      out.write("\r\n");
      out.write("<div class=\"heading\">\r\n");
      out.write("\t<div class=\"plane\">\r\n");
      out.write("\t<i class=\"fas fa-paper-plane\" style=\"color:#25488e; font-size:50px;\"></i>\r\n");
      out.write("\t&nbsp&nbsp&nbsp\r\n");
      out.write("\t<span style=\"font-size:35px;\">SwiftPay</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"search\">\r\n");
      out.write("\t<input type=\"text\" name=\"search1\" placeholder=\"Search\" onkeypress=\"search(this.value)\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"history\">\r\n");
      out.write("\t<span style=\"font-size:20px\">Welcome,</span>\r\n");
      out.write("\t<label style=\"font-size:20px\">");
 out.println(n); 
      out.write("</label>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"wallet\" onclick=\"document.location.href='profile.jsp'\">\r\n");
      out.write("\t<i class=\"fas fa-user-tie\" style=\"color:#25488e; font-size:40px;margin-bottom:10px;\"></i>\r\n");
      out.write("\t<span style=\"font-size:20px;\">Profile</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"noti\" onclick=\"document.location.href='notification.jsp'\">\r\n");
      out.write("\t<i class=\"fas fa-bell\" style=\"color:#25488e; font-size:40px;margin-bottom:10px;\"></i>\r\n");
      out.write("\t<span style=\"font-size:20px;\">Notification</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"logout\" onclick=\"document.location.href='logout.jsp'\">\r\n");
      out.write("\t<i class=\"fas fa-sign-out-alt\" style=\"color:#25488e; font-size:40px;margin-bottom:10px;\"></i>\r\n");
      out.write("\t<span style=\"font-size:20px;\">Logout</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"parent\">\r\n");
      out.write("\t<span style=\"font-size:30px;color:white;\"><b> MONEY TRANSFER </b></span>\r\n");
      out.write("\t<div class=\"child\">\r\n");
      out.write("\t\t<div class=\"child-1\" onclick=\"document.location.href='toContact.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-external-link-square-alt\" style=\"color:white; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:white;\">To Contact</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-1\" onclick=\"document.location.href='toBank.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-university\" style=\"color:white; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:white;\">To Account</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-1\" onclick=\"document.location.href='checkBalance.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-rupee-sign\" style=\"color:white; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:white;\">Bank Balance</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-1\" onclick=\"document.location.href='requestMoney.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-level-up-alt\" style=\"color:white; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:white;\">Request</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("<div class=\"parent1\">\r\n");
      out.write("\t<span style=\"font-size:30px;color:#666666;\"><b>PAY BILLS & RECHARGE</b></span>\r\n");
      out.write("\t<div class=\"child1\">\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='mobileRecharge.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-mobile\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Mobile</span><span style=\"font-size:25px;color:#666666;\">Recharge</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='postpaid.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-mobile-alt\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">PostPaid</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='electricity1.jsp'\">\r\n");
      out.write("\t\t<i class=\"far fa-lightbulb\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Electricity</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='dth1.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-satellite-dish\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">DTH</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='landline1.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-tty\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">LandLine</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='broadband1.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-wifi\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">BroadBand</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='schoolfees.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-book-open\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">School Fees</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-2\" onclick=\"document.location.href='creditcard1.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-credit-card\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Credit Card</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"parent2\">\r\n");
      out.write("<span style=\"font-size:30px;color:#666666;\"><b>TRAVEL</b></span>\r\n");
      out.write("\t<div class=\"child2\">\r\n");
      out.write("\t\t<div class=\"child-3\" onclick=\"document.location.href='bus.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-bus-alt\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Bus</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-3\" onclick=\"document.location.href='flight.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-plane-departure\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Flight</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-3\" onclick=\"document.location.href='train.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-subway\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Train</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"parent3\">\r\n");
      out.write("<span style=\"font-size:30px;color:#666666;\"><b>ENTERTAINMENT</b></span>\r\n");
      out.write("\t<div class=\"child3\">\r\n");
      out.write("\t\t<div class=\"child-4\" onclick=\"document.location.href='event.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-theater-masks\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Events</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"child-4\" onclick=\"document.location.href='movie.jsp'\">\r\n");
      out.write("\t\t<i class=\"fas fa-film\" style=\"color:#25488e; font-size:60px; margin-bottom:10px;\"></i>\r\n");
      out.write("\t\t<span style=\"font-size:25px;color:#666666;\">Movies</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"parent5\">\r\n");
      out.write("\t<div class=\"slideshow-container\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"mySlides fade\">\r\n");
      out.write(" \t <img src=\"images java/coronaad.jpg\" style=\"height:500px;width:100%\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"mySlides fade\">\r\n");
      out.write(" \t <img src=\"images java/coronaad1.png\" style=\"height:500px;width:100%\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"mySlides fade\">\r\n");
      out.write(" \t <img src=\"images java/ad.png\" style=\"height:500px;width:100%\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"mySlides fade\">\r\n");
      out.write(" \t <img src=\"images java/ad1.jpg\" style=\"height:500px;width:100%\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"text-align:center;display:none;\">\r\n");
      out.write("  \t<span class=\"dot\"></span> \r\n");
      out.write("  \t<span class=\"dot\"></span> \r\n");
      out.write(" \t<span class=\"dot\"></span> \r\n");
      out.write(" \t<span class=\"dot\"></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\t<div class=\"about\" onclick=\"document.location.href='AboutUs.jsp'\">\r\n");
      out.write("\t<span style=\"font-size:30px;color:white;\">About Us</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"terms\" onclick=\"document.location.href='Terms.jsp'\">\r\n");
      out.write("\t<span style=\"font-size:30px;color:white;\">Terms & Conditions</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"reward\">\r\n");
      out.write("\t<span style=\"font-size:30px;color:white;\"></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");

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