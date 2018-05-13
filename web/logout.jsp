<%-- 
    Document   : logout
    Created on : Apr 25, 2018, 1:41:13 AM
    Author     : k_kur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("sessID", null);
            session.invalidate();
            Cookie cRemember = new Cookie("remember","");

            Cookie id = new Cookie("userID","");
            cRemember.setMaxAge(0);

            id.setMaxAge(0);
            response.addCookie(cRemember);

            response.addCookie(id);
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
