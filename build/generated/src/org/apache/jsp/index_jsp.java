package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.Book;
import java.util.List;
import Conn.DB;
import java.sql.PreparedStatement;
import DAO.User;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.persistence.Convert;
import Conn.DB;
import DAO.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <link href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         ");
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
      out.write("         ");

             if(request.getAttribute("added")!=null){
                 System.out.print("ife girdikl");
         
      out.write("\n");
      out.write("         <div class=\"container alert alert-success alert-dismissible fade in\">\n");
      out.write("            <a href=\"#\" class=\"alert-success\" data-dismiss=\"alert\" aria-label=\"close\">\n");
      out.write("            <strong>Success!</strong> Successfully added book.Click to dismiss.\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("         ");
}
      out.write("\n");
      out.write("        ");

                List list = (List) session.getAttribute("bookDetail");
                List pageNumbers = (List) session.getAttribute("pages");
        
      out.write("\n");
      out.write("         <div class=\"container\">\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                        <!-- Category -->\n");
      out.write("                        <div class=\"single category\">\n");
      out.write("                            <h3 class=\"side-title\">Category</h3>\n");
      out.write("                            <ul class=\"list-unstyled\">\n");
      out.write("                                ");

                                    DB con = new DB();
                                    PreparedStatement ps = con.Connect().prepareStatement("select * from categories");
                                    ResultSet rs = ps.executeQuery();
                                    while(rs.next()){
                                        
                                
      out.write("\n");
      out.write("                                <li><a href=\"GetItems?c=");
      out.print(rs.getString(1));
      out.write("\" title=\"\">");
      out.print(rs.getString(2));
      out.write("</a></li>\n");
      out.write("                                ");

                                    }
                                
                                
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                   </div>\n");
      out.write("                </div>\n");
      out.write("                            \n");
      out.write("                <div class=\"container-fluid col-sm-9 single category\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        ");
 int l =0;
                        
                            for(int i=0; i<list.size(); i++){
                                Book b = (Book) list.get(i);
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                            <div class=\"col-md-5\">\n");
      out.write("                                <div class=\"artist-data pull-left\">\n");
      out.write("                                <div class=\"artst-pic pull-left\">\n");
      out.write("\n");
      out.write("                                        <a href=\"#\">\n");
      out.write("                                                <img src=\"http://placehold.it/122x122\" alt=\"\" class=\"img-responsive\" />\n");
      out.write("                                        </a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"artst-prfle pull-right\">\n");
      out.write("                                        <div class=\"art-title\">\n");
      out.write("                                            <a href=\"\">");
      out.print(b.Name);
      out.write("</a>\n");
      out.write("                                            <span class=\"artst-sub\"><span class=\"byname\">");
      out.print(b.Cat);
      out.write("</span> </span> \n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"bot-links\">\n");
      out.write("                                        <a href=\"Save?bookid=");
      out.print(b.id);
      out.write("&type=r\">Read</a>\n");
      out.write("                                        <a href=\"Save?bookid=");
      out.print(b.id);
      out.write("&type=w\">Will Read</a>\n");
      out.write("                                        <a href=\"#\">More Info</a>\n");
      out.write("                                </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("                    <center>\n");
      out.write("                        <ul class=\"pagination justify-content-center\">\n");
      out.write("                            ");

                                int p = 0;
                                String pageNumberValue = request.getParameter("p");
                                String c = request.getParameter("c");
                                String q = request.getParameter("q");

                                if (pageNumberValue != null){
                                    p = Integer.parseInt(pageNumberValue);
                                    p--;
                                }
					for (int i = 0; i < pageNumbers.size(); i++) {
                                        
				
      out.write("\n");
      out.write("                                <li ");
if(i==p){
      out.write("class=\"active\"");
}
      out.write(">\n");
      out.write("                                    <a href=\"GetItems?p=");
      out.print(pageNumbers.get(i));
if(c!=null){
      out.write("&c=");
      out.print(c);
}
if(q!=null){
      out.write("&q=");
      out.print(q);
}
      out.write('"');
      out.write('>');
      out.print(pageNumbers.get(i));
      out.write("</a>\n");
      out.write("                                </li>\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </center>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("                 \n");
      out.write("\n");
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
