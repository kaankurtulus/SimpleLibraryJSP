<%-- 
    Document   : index
    Created on : Apr 27, 2018, 2:03:45 AM
    Author     : k_kur
--%>

<%@page import="DAO.Book"%>
<%@page import="java.util.List"%>
<%@page import="Conn.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="DAO.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
        
         <%@ include file="navbar.jsp" %>
         <%
             if(request.getAttribute("added")!=null){
                 System.out.print("ife girdikl");
         %>
         <div class="container alert alert-success alert-dismissible fade in">
            <a href="#" class="alert-success" data-dismiss="alert" aria-label="close">
            <strong>Success!</strong> Successfully added book.Click to dismiss.
            </a>
          </div>
         <%}%>
        <%
                List list = (List) session.getAttribute("bookDetail");
                List pageNumbers = (List) session.getAttribute("pages");
        %>
         <div class="container">
                <div class="col-sm-3">
                        <!-- Category -->
                        <div class="single category">
                            <h3 class="side-title">Category</h3>
                            <ul class="list-unstyled">
                                <%
                                    DB con = new DB();
                                    PreparedStatement ps = con.Connect().prepareStatement("select * from categories");
                                    ResultSet rs = ps.executeQuery();
                                    while(rs.next()){
                                        
                                %>
                                <li><a href="GetItems?c=<%=rs.getString(1)%>" title=""><%=rs.getString(2)%></a></li>
                                <%
                                    }
                                
                                %>
                            </ul>
                   </div>
                </div>
                            
                <div class="container-fluid col-sm-9 single category">
                    
                    <div class="row">
                        <% int l =0;
                        
                            for(int i=0; i<list.size(); i++){
                                Book b = (Book) list.get(i);
                        %>
                        
                            <div class="col-md-5">
                                <div class="artist-data pull-left">
                                <div class="artst-pic pull-left">

                                        <a href="#">
                                                <img src="http://placehold.it/122x122" alt="" class="img-responsive" />
                                        </a>
                                </div>
                                <div class="artst-prfle pull-right">
                                        <div class="art-title">
                                            <a href=""><%=b.Name%></a>
                                            <span class="artst-sub"><span class="byname"><%=b.Cat%></span> </span> 
                                    </div>
                                    <div class="bot-links">
                                        <a href="Save?bookid=<%=b.id%>&type=r">Read</a>
                                        <a href="Save?bookid=<%=b.id%>&type=w">Will Read</a>
                                        <a href="#">More Info</a>
                                </div>
                                </div>

                                </div>
                            </div>
                        <%}%>
                </div>
                    <center>
                        <ul class="pagination justify-content-center">
                            <%
                                int p = 0;
                                String pageNumberValue = request.getParameter("p");
                                String c = request.getParameter("c");
                                String q = request.getParameter("q");

                                if (pageNumberValue != null){
                                    p = Integer.parseInt(pageNumberValue);
                                    p--;
                                }
					for (int i = 0; i < pageNumbers.size(); i++) {
                                        
				%>
                                <li <%if(i==p){%>class="active"<%}%>>
                                    <a href="GetItems?p=<%=pageNumbers.get(i)%><%if(c!=null){%>&c=<%=c%><%}%><%if(q!=null){%>&q=<%=q%><%}%>"><%=pageNumbers.get(i)%></a>
                                </li>
				<%
					}
				%>
                        </ul>
                    </center>

                </div>

        </div>
                 

    </body>
</html>
