/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-09-18 13:51:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forget_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Sign Up</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("*{\r\n");
      out.write("font-family:candara;\r\n");
      out.write("}\r\n");
      out.write("html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, dl, dt, dd, ol, nav ul, nav li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {\r\n");
      out.write("  margin: 0;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("  border: 0;\r\n");
      out.write("  font-size: 100%;\r\n");
      out.write("  font: inherit;\r\n");
      out.write(" \r\n");
      out.write("  vertical-align: baseline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {\r\n");
      out.write("  display: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ol, ul {\r\n");
      out.write("  list-style: none;\r\n");
      out.write("  margin: 0px;\r\n");
      out.write("  padding: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("blockquote, q {\r\n");
      out.write("  quotes: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("blockquote:before, blockquote:after, q:before, q:after {\r\n");
      out.write("  content: '';\r\n");
      out.write("  content: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("  border-collapse: collapse;\r\n");
      out.write("  border-spacing: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*-- start editing from here --*/\r\n");
      out.write("a {\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".txt-rt {\r\n");
      out.write("  text-align: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* text align right */\r\n");
      out.write(".txt-lt {\r\n");
      out.write("  text-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* text align left */\r\n");
      out.write(".txt-center {\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* text align center */\r\n");
      out.write(".float-rt {\r\n");
      out.write("  float: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* float right */\r\n");
      out.write(".float-lt {\r\n");
      out.write("  float: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* float left */\r\n");
      out.write(".clear {\r\n");
      out.write("  clear: both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* clear float */\r\n");
      out.write(".pos-relative {\r\n");
      out.write("  position: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Position Relative */\r\n");
      out.write(".pos-absolute {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Position Absolute */\r\n");
      out.write(".vertical-base {\r\n");
      out.write("  vertical-align: baseline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* vertical align baseline */\r\n");
      out.write(".vertical-top {\r\n");
      out.write("  vertical-align: top;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* vertical align top */\r\n");
      out.write("nav.vertical ul li {\r\n");
      out.write("  display: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* vertical menu */\r\n");
      out.write("nav.horizontal ul li {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* horizontal menu */\r\n");
      out.write("img {\r\n");
      out.write("  max-width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*-- end reset --*/\r\n");
      out.write("body {\r\n");
      out.write("  background-color:#25488e;\r\n");
      out.write("  /* fallback for old browsers */\r\n");
      out.write("\r\n");
      out.write("  background-size: cover;\r\n");
      out.write("  background-attachment: fixed;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("  font-size: 30px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  font-weight: 100;\r\n");
      out.write("  text-transform: capitalize;\r\n");
      out.write("  letter-spacing: 4px;\r\n");
      out.write("  font-family: 'Exo', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*-- main --*/\r\n");
      out.write(".main-w3layouts {\r\n");
      out.write("  padding: 3em 0 1em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main-agileinfo {\r\n");
      out.write("  width: 35%;\r\n");
      out.write("  margin: 3em auto;\r\n");
      out.write("  background: rgba(0, 0, 0, 0.18);\r\n");
      out.write("  background-size: cover;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".agileits-top {\r\n");
      out.write("  padding: 3em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"], input[type=\"email\"], input[type=\"password\"] {\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  font-weight: 400;\r\n");
      out.write("  width: 94.5%;\r\n");
      out.write("  display: block;\r\n");
      out.write("  border: none;\r\n");
      out.write("  padding: 0.8em;\r\n");
      out.write("  border: solid 1px rgba(255, 255, 255, 0.37);\r\n");
      out.write("  -webkit-transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);\r\n");
      out.write("  transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);\r\n");
      out.write("  background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 96%, #fff 4%);\r\n");
      out.write("  background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #fff 4%);\r\n");
      out.write("  background-position: -800px 0;\r\n");
      out.write("  background-size: 100%;\r\n");
      out.write("  background-repeat: no-repeat;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input.email, input.text.w3lpass {\r\n");
      out.write("  margin: 2em 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".text:focus, .text:valid {\r\n");
      out.write("  box-shadow: none;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  background-position: 0 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".text:focus::-webkit-input-placeholder, .text:valid::-webkit-input-placeholder {\r\n");
      out.write("  color: rgba(255, 255, 255, 0.7);\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  -webkit-transform: translateY(-30px);\r\n");
      out.write("  -moz-transform: translateY(-30px);\r\n");
      out.write("  -o-transform: translateY(-30px);\r\n");
      out.write("  -ms-transform: translateY(-30px);\r\n");
      out.write("  transform: translateY(-30px);\r\n");
      out.write("  visibility: visible !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-webkit-input-placeholder {\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  font-weight: 100;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(":-moz-placeholder {\r\n");
      out.write("  /* Firefox 18- */\r\n");
      out.write("  color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-moz-placeholder {\r\n");
      out.write("  /* Firefox 19+ */\r\n");
      out.write("  color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(":-ms-input-placeholder {\r\n");
      out.write("  color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"submit\"] {\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  color: #a18d6c;\r\n");
      out.write("  background: #fff;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  border: 1px solid #fff;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  padding: 0.9em;\r\n");
      out.write("  -webkit-appearance: none;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  margin: 2em 0;\r\n");
      out.write("  letter-spacing: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"submit\"]:hover {\r\n");
      out.write("  -webkit-transition: .5s all;\r\n");
      out.write("  -moz-transition: .5s all;\r\n");
      out.write("  -o-transition: .5s all;\r\n");
      out.write("  -ms-transition: .5s all;\r\n");
      out.write("  transition: .5s all;\r\n");
      out.write("  background:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".agileits-top p {\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  letter-spacing: 1px;\r\n");
      out.write("  font-weight: 300;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".agileits-top p a {\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  -webkit-transition: .5s all;\r\n");
      out.write("  -moz-transition: .5s all;\r\n");
      out.write("  transition: .5s all;\r\n");
      out.write("  font-weight: 400;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".agileits-top p a:hover {\r\n");
      out.write("  color: #76b852;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".wthree-text label {\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  font-weight: 200;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  position: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("@keyframes rippling {\r\n");
      out.write("  50% {\r\n");
      out.write("    border-left-color: #fff;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  100% {\r\n");
      out.write("    border-bottom-color: #fff;\r\n");
      out.write("    border-left-color: #fff;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".colorlibcopy-agile {\r\n");
      out.write("  margin: 2em 0 1em;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".colorlibcopy-agile p {\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  line-height: 1.8em;\r\n");
      out.write("  letter-spacing: 1px;\r\n");
      out.write("  font-weight: 100;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".colorlibcopy-agile p a {\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  transition: 0.5s all;\r\n");
      out.write("  -webkit-transition: 0.5s all;\r\n");
      out.write("  -moz-transition: 0.5s all;\r\n");
      out.write("  -o-transition: 0.5s all;\r\n");
      out.write("  -ms-transition: 0.5s all;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".colorlibcopy-agile p a:hover {\r\n");
      out.write("  color: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".wrapper {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@-webkit-keyframes square {\r\n");
      out.write("  0% {\r\n");
      out.write("    -webkit-transform: translateY(0);\r\n");
      out.write("    -moz-transform: translateY(0);\r\n");
      out.write("    -o-transform: translateY(0);\r\n");
      out.write("    -ms-transform: translateY(0);\r\n");
      out.write("    transform: translateY(0);\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  100% {\r\n");
      out.write("    -webkit-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    -moz-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    -o-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    -ms-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes square {\r\n");
      out.write("  0% {\r\n");
      out.write("    -webkit-transform: translateY(0);\r\n");
      out.write("    -moz-transform: translateY(0);\r\n");
      out.write("    -o-transform: translateY(0);\r\n");
      out.write("    -ms-transform: translateY(0);\r\n");
      out.write("    transform: translateY(0);\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  100% {\r\n");
      out.write("    -webkit-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    -moz-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    -o-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    -ms-transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("    transform: translateY(-700px) rotate(600deg);\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*-- responsive-design --*/\r\n");
      out.write("@media(max-width:1440px) {\r\n");
      out.write("  input[type=\"text\"], input[type=\"email\"], input[type=\"password\"] {\r\n");
      out.write("    width: 94%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:1366px) {\r\n");
      out.write("  h1 {\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .agileits-top {\r\n");
      out.write("    padding: 2.5em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    margin: 2em auto;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 36%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:1280px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 40%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:1080px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 46%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:1024px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 49%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:991px) {\r\n");
      out.write("  h1 {\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .main-w3layouts {\r\n");
      out.write("    padding: 2em 0 1em;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:900px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 58%;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"text\"], input[type=\"email\"], input[type=\"password\"] {\r\n");
      out.write("    width: 93%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:800px) {\r\n");
      out.write("  h1 {\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:736px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 62%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:667px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 67%;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:600px) {\r\n");
      out.write("  .agileits-top {\r\n");
      out.write("    padding: 2.2em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input.email, input.text.w3lpass {\r\n");
      out.write("    margin: 1.5em 0;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"submit\"] {\r\n");
      out.write("    margin: 2em 0;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  h1 {\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("    letter-spacing: 3px;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:568px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 75%;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .colorlibcopy-agile p {\r\n");
      out.write("    padding: 0 2em;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:480px) {\r\n");
      out.write("  h1 {\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("    letter-spacing: 3px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .agileits-top {\r\n");
      out.write("    padding: 1.8em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"text\"], input[type=\"email\"], input[type=\"password\"] {\r\n");
      out.write("    width: 91%;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .agileits-top p {\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:414px) {\r\n");
      out.write("  h1 {\r\n");
      out.write("   font-size: 30px;\r\n");
      out.write("    letter-spacing: 2px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 85%;\r\n");
      out.write("    margin: 1.5em auto;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .text:focus, .text:valid {\r\n");
      out.write("    background-position: 0 0px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .wthree-text ul li, .wthree-text ul li:nth-child(2) {\r\n");
      out.write("    display: block;\r\n");
      out.write("    float: none;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .wthree-text ul li:nth-child(2) {\r\n");
      out.write("    margin-top: 1.5em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"submit\"] {\r\n");
      out.write("    margin: 2em 0 1.5em;\r\n");
      out.write("    letter-spacing: 3px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"submit\"] {\r\n");
      out.write("    margin: 2em 0 1.5em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .colorlibcopy-agile {\r\n");
      out.write("    margin: 1em 0 1em;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:384px) {\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 88%;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .colorlibcopy-agile p {\r\n");
      out.write("    padding: 0 1em;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:375px) {\r\n");
      out.write("  .agileits-top p {\r\n");
      out.write("    letter-spacing: 0px;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media(max-width:320px) {\r\n");
      out.write("  .main-w3layouts {\r\n");
      out.write("    padding: 1.5em 0 0;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .agileits-top {\r\n");
      out.write("    padding: 1.2em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .colorlibcopy-agile {\r\n");
      out.write("    margin: 0 0 1em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"text\"], input[type=\"email\"], input[type=\"password\"] {\r\n");
      out.write("    width: 89.5%;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  h1 {\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("    letter-spacing: 0px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .main-agileinfo {\r\n");
      out.write("    width: 92%;\r\n");
      out.write("    margin: 1em auto;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .text:focus, .text:valid {\r\n");
      out.write("    background-position: 0 0px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  input[type=\"submit\"] {\r\n");
      out.write("    margin: 1.5em 0;\r\n");
      out.write("    padding: 0.8em;\r\n");
      out.write("    font-size: .85em;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .colorlibcopy-agile p {\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .wthree-text label {\r\n");
      out.write("   font-size: 16px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .main-w3layouts {\r\n");
      out.write("    padding: 1em 0 0;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main-w3layouts wrapper\">\r\n");
      out.write("\t\t<h1>Forgot Password</h1>\r\n");
      out.write("\t\t<div class=\"main-agileinfo\">\r\n");
      out.write("\t\t\t<div class=\"agileits-top\">\r\n");
      out.write("\t\t\t\t<form action=\"ForgotPass\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<input class=\"text\" autocomplete=\"off\" type=\"text\" name=\"username\" placeholder=\"Username\" required=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"NEXT\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
