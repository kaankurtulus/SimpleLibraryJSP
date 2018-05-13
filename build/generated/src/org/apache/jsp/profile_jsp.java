package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.Book;
import javax.persistence.Convert;
import Conn.DB;
import DAO.User;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/navbar.jsp");
  }

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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <link href=\"css/profile.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        \n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Profile</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");

            User user = new User(-1,"j","j","j","j");
            
            String remember="";
            String email="";
            String pass="";
            int id=-1;
            RequestDispatcher rd;

            if (session.getAttribute("session")!="yes"||session.getAttribute("session")==null) {
                System.out.print("Set user !!!");
                Cookie[] cookies = request.getCookies();
                if(cookies!=null){
                    System.out.print("Cookies found");
                    cookies  = request.getCookies();

                    for (Cookie cookie : cookies) {
                        System.out.print(cookie.getName());
                        if(cookie.getName().equals("userID")){
                            System.out.print("cookie id:"+cookie.getValue());
                            id = Integer.parseInt(cookie.getValue());
                        }
                        if(cookie.getName().equals("remember")) {
                            remember = cookie.getValue();
                            System.out.print(remember);
                        }

                    }
                    if(remember.equals("true")&&id!=-1){
                        DB db = new DB();
                        System.out.print(id);
                        user = db.GetUser(id);
                        if(user.ID!=-1){
                            System.out.print("Set user !!!");
                            session.setAttribute("User", user);
                            session.setAttribute("Id", id);
                            session.setAttribute("session", "yes");
                        }else{
                            request.setAttribute("message", "Your session has ended.");
                            request.setAttribute("check", "wrong");
                            
                            rd = getServletContext().getRequestDispatcher("/login.jsp");
                            rd.forward(request, response);
                        }
                        
                        //response.sendRedirect("profile.jsp");
                    }else{
                        request.setAttribute("message", "Your session has ended");
                        request.setAttribute("check", "wrong");

                        rd = getServletContext().getRequestDispatcher("/login.jsp");
                        rd.forward(request, response);
                    }
                }else{
                    request.setAttribute("message", "Your session has ended");
                    request.setAttribute("check", "wrong");

                    rd = getServletContext().getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                    //response.sendRedirect("login.jsp");
                }
            }else{
                //user loggedIN
                System.out.print("Get user !!!");
                user =(User) session.getAttribute("User");
                //response.sendRedirect("login.jsp");
            }
            
        
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <nav class=\"navbar navbar-default\" role=\"navigation\">\n");
      out.write("        <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"GetItems\">\n");
      out.write("                Home\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("            <div class=\"col-sm-3 col-md-3 \">\n");
      out.write("                <form class=\"navbar-form\" action=\"GetItems\" >\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search\" name=\"q\">\n");
      out.write("                        <div class=\"input-group-btn\">\n");
      out.write("                            <button class=\"btn btn-default\" type=\"submit\"><i class=\"glyphicon glyphicon-search\"></i></button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                \n");
      out.write("                <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><span\n");
      out.write("                    class=\"glyphicon glyphicon-user\"></span> ");
      out.print( user.name);
      out.write(" <b class=\"caret\"></b></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a href=\"profile.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Profile</a></li>\n");
      out.write("                        \n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li><a href=\"logout.jsp\"><span class=\"glyphicon glyphicon-off\"></span> Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.navbar-collapse -->\n");
      out.write("    </nav>\n");
      out.write("</div>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row profile\">\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"profile-sidebar\">\n");
      out.write("                        <!-- SIDEBAR USERPIC -->\n");
      out.write("                        <div class=\"profile-userpic\">\n");
      out.write("                                <img src=\"images/profile_pic.png\" class=\"img-responsive\" alt=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <!-- END SIDEBAR USERPIC -->\n");
      out.write("                        <!-- SIDEBAR USER TITLE -->\n");
      out.write("                        <div class=\"profile-usertitle\">\n");
      out.write("                                <div class=\"profile-usertitle-name\">\n");
      out.write("                                    ");
      out.print( user.name);
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                        </div>\n");
      out.write("                        <!-- END SIDEBAR USER TITLE -->\n");
      out.write("                        <!-- SIDEBAR BUTTONS -->\n");
      out.write("                        <div class=\"profile-userbuttons\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-success btn-sm\">Follow</button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-danger btn-sm\">Message</button>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- END SIDEBAR BUTTONS -->\n");
      out.write("                        <!-- SIDEBAR MENU -->\n");
      out.write("                        <div class=\"profile-usermenu\">\n");
      out.write("                                <ul class=\"nav flex-column\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">\n");
      out.write("                                        <li>\n");
      out.write("                                                <a href=\"#information\" data-toggle=\"tab\">\n");
      out.write("                                                <i class=\"glyphicon glyphicon-home\"></i>\n");
      out.write("                                                Overview </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                                <a href=\"#settings\" data-toggle=\"tab\">\n");
      out.write("                                                <i class=\"glyphicon glyphicon-cog\"></i>\n");
      out.write("                                                Account Settings </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                                <a href=\"#booklist\" data-toggle=\"tab\">\n");
      out.write("                                                <i class=\"glyphicon glyphicon-list-alt\"></i>\n");
      out.write("                                                Books you read </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                                <a href=\"#booklist2\" data-toggle=\"tab\">\n");
      out.write("                                                <i class=\"glyphicon glyphicon-list-alt\"></i>\n");
      out.write("                                                Books you will read </a>\n");
      out.write("                                        </li>\n");
      out.write("                                </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- END MENU -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-9\">\n");
      out.write("                    <div class=\"tab-content profile-content\">\n");
      out.write("                         <!-- INFO -->\n");
      out.write("                        <div id=\"information\" class=\"tab-pane active\">\n");
      out.write("                            <h1>overview</h1>\n");
      out.write("                            <p>the number of books you read : ");
      out.print(user.readBooks.size());
      out.write("</p>\n");
      out.write("                            <p>the number of books you will read : ");
      out.print(user.willBooks.size());
      out.write("</p>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <!-- SETTINGS -->\n");
      out.write("                        <div id=\"settings\" class=\"tab-pane\">\n");
      out.write("                            \n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <h2>Edit Profile</h2>\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                  <!-- left column -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                                  <!-- edit form column -->\n");
      out.write("                                  <div class=\"col-md-8 personal-info\">\n");
      out.write("                                        <div class=\"text-center profile-avatar\">\n");
      out.write("                                            <img src=\"images/profile_pic.png\" class=\"avatar img-circle\" alt=\"avatar\" style=\"width: 100px;\">\n");
      out.write("                                            <h6>Upload a different photo...</h6>\n");
      out.write("\n");
      out.write("                                            <input type=\"file\" class=\"form-control\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    <h3>Personal info</h3>\n");
      out.write("\n");
      out.write("                                    <form class=\"form-horizontal\" role=\"form\" action='UpdateInfo' method=\"POST\">\n");
      out.write("                                      <div class=\"form-group\">\n");
      out.write("                                        <label class=\"col-lg-3 control-label\">Full name:</label>\n");
      out.write("                                        <div class=\"col-lg-8\">\n");
      out.write("                                            <input class=\"form-control\" type=\"text\" value=");
      out.print(user.name);
      out.write(" required>\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                      \n");
      out.write("                                      <div class=\"form-group\">\n");
      out.write("                                        <label class=\"col-lg-3 control-label\">Email:</label>\n");
      out.write("                                        <div class=\"col-lg-8\">\n");
      out.write("                                          <input class=\"form-control\" type=\"text\" value=");
      out.print(user.email);
      out.write(" required>\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("\n");
      out.write("                                      <div class=\"form-group\">\n");
      out.write("                                        <label class=\"col-md-3 control-label\">Password:</label>\n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                          <input class=\"form-control\" type=\"password\" value=");
      out.print(user.pass);
      out.write(" required>\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                      <div class=\"form-group\">\n");
      out.write("                                        <label class=\"col-md-3 control-label\">Confirm password:</label>\n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                          <input class=\"form-control\" type=\"password\" value=");
      out.print(user.pass);
      out.write(" required>\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                      <div class=\"form-group\">\n");
      out.write("                                        <label class=\"col-md-3 control-label\"></label>\n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                          <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
      out.write("                                          <span></span>\n");
      out.write("                                          <input type=\"reset\" class=\"btn btn-default\" value=\"Cancel\">\n");
      out.write("                                        </div>\n");
      out.write("                                      </div>\n");
      out.write("                                    </form>\n");
      out.write("                                  </div>\n");
      out.write("                              </div>\n");
      out.write("                            </div>\n");
      out.write("                            <hr>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <!-- BOOK LIST -->\n");
      out.write("                        <div id=\"booklist\" class=\"tab-pane\">\n");
      out.write("                            <h4>You read these books!</h4>\n");
      out.write("                            <ul>\n");
      out.write("                            ");

                                for(int i=0; i<user.readBooks.size(); i++){
                            
      out.write("\n");
      out.write("                            ");
 Book ub = (Book)user.readBooks.get(i); 
                            System.out.print(ub.Name);
      out.write("\n");
      out.write("                            \n");
      out.write("                                <li>");
      out.print(ub.Name);
      out.write("</li>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            ");

                                }
                            
                            
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                         <!-- BOOK LIST2 -->\n");
      out.write("                        <div id=\"booklist2\" class=\"tab-pane\">\n");
      out.write("                            <h4>You are planning to read these!</h4>\n");
      out.write("                            ");

                                for(int i=0; i<user.willBooks.size(); i++){
                            
      out.write("\n");
      out.write("                            ");
 Book ub = (Book)user.willBooks.get(i); 
                            System.out.print(ub.Name);
      out.write("\n");
      out.write("                            \n");
      out.write("                                <li>");
      out.print(ub.Name);
      out.write("</li>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            ");

                                }
                            
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
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
