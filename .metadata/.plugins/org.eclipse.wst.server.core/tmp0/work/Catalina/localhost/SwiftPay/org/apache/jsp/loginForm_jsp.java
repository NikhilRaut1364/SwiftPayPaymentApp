/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-07-09 04:18:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<link type=\"text/css\" href=\"css/all.css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("*{\r\n");
      out.write("font-family:candara;\r\n");
      out.write("}\r\n");
      out.write("body{\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tbackground: #fff;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".body{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: -20px;\r\n");
      out.write("\tleft: -20px;\r\n");
      out.write("\tright: -40px;\r\n");
      out.write("\tbottom: -40px;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tbackground-color:#25488e;\r\n");
      out.write("\tbackground-size: cover;\r\n");
      out.write("\t-webkit-filter: blur(5px);\r\n");
      out.write("\tz-index: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".grad{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: -20px;\r\n");
      out.write("\tleft: -20px;\r\n");
      out.write("\tright: -40px;\r\n");
      out.write("\tbottom: -40px;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("\topacity: 0.7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(50% - 35px);\r\n");
      out.write("\tleft: calc(50% - 255px);\r\n");
      out.write("\tz-index: 2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header div{\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\t\r\n");
      out.write("\tfont-size: 35px;\r\n");
      out.write("\tfont-weight: 200;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header div span{\r\n");
      out.write("\tcolor: #ffffff !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(50% - 75px);\r\n");
      out.write("\tleft: calc(50% - 50px);\r\n");
      out.write("\theight: 150px;\r\n");
      out.write("\twidth: 350px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tz-index: 2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=text]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.6);\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\t\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=password]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.6);\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\t\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 4px;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\theight: 35px;\r\n");
      out.write("\tbackground: #fff;\r\n");
      out.write("\tborder: 1px solid #fff;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tcolor: #a18d6c;\r\n");
      out.write("\t\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-weight: 400;\r\n");
      out.write("\tpadding: 6px;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]:hover{\r\n");
      out.write("\topacity: 0.8;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=submit]:active{\r\n");
      out.write("\topacity: 0.6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=text]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=password]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tborder: 1px solid rgba(255,255,255,0.9);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login input[type=button]:focus{\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-webkit-input-placeholder{\r\n");
      out.write("   color: rgba(255,255,255,0.6);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-moz-input-placeholder{\r\n");
      out.write("   color: rgba(255,255,255,0.6);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label\r\n");
      out.write("{\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("font-size: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("i\r\n");
      out.write("{\r\n");
      out.write("cursor:default;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"LoginData\" method=\"POST\">\r\n");
      out.write("<div class=\"body\"></div>\r\n");
      out.write("\t\t<div class=\"grad\"></div>\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div><span>User Login</span></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div class=\"login\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" autocomplete=\"off\" placeholder=\"username\" name=\"uname\"><br>\r\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"password\" name=\"pass\"><br>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Login\"><br><br>\r\n");
      out.write("\t\t\t\t<label onclick=\"window.location.href='createnew.jsp'\">Create New Account</label><br>\r\n");
      out.write("\t\t\t\t<label onclick=\"window.location.href='forget.jsp'\">Forgot Password?</label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</form>\r\n");
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
