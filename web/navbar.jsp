<%@page import="javax.persistence.Convert"%>
<%@page import="Conn.DB"%>
<%@page import="DAO.User"%>
<%
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
            
        %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <nav class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="GetItems">
                Home
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="col-sm-3 col-md-3 ">
                <form class="navbar-form" action="GetItems" >
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search" name="q">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
            </div>
            <ul class="nav navbar-nav navbar-right">
                
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                    class="glyphicon glyphicon-user"></span> <%= user.name%> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="profile.jsp"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                        
                        <li class="divider"></li>
                        <li><a href="logout.jsp"><span class="glyphicon glyphicon-off"></span> Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
</div>