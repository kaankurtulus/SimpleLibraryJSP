<%@page import="DAO.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/profile.css" rel="stylesheet" type="text/css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <title>Profile</title>
    </head>
    <body>
        
        <%@ include file="navbar.jsp" %>

        <div class="container">
            <div class="row profile">
                <div class="col-md-3">
                    <div class="profile-sidebar">
                        <!-- SIDEBAR USERPIC -->
                        <div class="profile-userpic">
                                <img src="images/profile_pic.png" class="img-responsive" alt="">
                        </div>
                        <!-- END SIDEBAR USERPIC -->
                        <!-- SIDEBAR USER TITLE -->
                        <div class="profile-usertitle">
                                <div class="profile-usertitle-name">
                                    <%= user.name%>
                                </div>
                                
                        </div>
                        <!-- END SIDEBAR USER TITLE -->
                        <!-- SIDEBAR BUTTONS -->
                        <div class="profile-userbuttons">
                                <button type="button" class="btn btn-success btn-sm">Follow</button>
                                <button type="button" class="btn btn-danger btn-sm">Message</button>
                        </div>
                        <!-- END SIDEBAR BUTTONS -->
                        <!-- SIDEBAR MENU -->
                        <div class="profile-usermenu">
                                <ul class="nav flex-column" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                        <li>
                                                <a href="#information" data-toggle="tab">
                                                <i class="glyphicon glyphicon-home"></i>
                                                Overview </a>
                                        </li>
                                        <li>
                                                <a href="#settings" data-toggle="tab">
                                                <i class="glyphicon glyphicon-cog"></i>
                                                Account Settings </a>
                                        </li>
                                        <li>
                                                <a href="#booklist" data-toggle="tab">
                                                <i class="glyphicon glyphicon-list-alt"></i>
                                                Books you read </a>
                                        </li>
                                        <li>
                                                <a href="#booklist2" data-toggle="tab">
                                                <i class="glyphicon glyphicon-list-alt"></i>
                                                Books you will read </a>
                                        </li>
                                </ul>
                        </div>
                        <!-- END MENU -->
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="tab-content profile-content">
                         <!-- INFO -->
                        <div id="information" class="tab-pane active">
                            <h1>overview</h1>
                            <p>the number of books you read : <%=user.readBooks.size()%></p>
                            <p>the number of books you will read : <%=user.willBooks.size()%></p>
                            
                            
                        </div>
                        
                        <!-- SETTINGS -->
                        <div id="settings" class="tab-pane">
                            
                            <div class="container">
                                <h2>Edit Profile</h2>
                                    
                                    <div class="row">
                                  <!-- left column -->


                                  <!-- edit form column -->
                                  <%
                                        String msg = (String)request.getAttribute("message");
                                        if(msg!=null){
                                    %>
                                        <div class="alert alert-danger">
                                        <strong><%= msg%></strong> 
                                        </div>
                                    <%
                                        }
                                    %>
                                  <div class="col-md-8 personal-info">
                                        <div class="text-center profile-avatar">
                                            <img src="images/profile_pic.png" class="avatar img-circle" alt="avatar" style="width: 100px;">
                                            <h6>Upload a different photo...</h6>

                                            <input type="file" class="form-control">
                                        </div>

                                    <h3>Personal info</h3>

                                    <form class="form-horizontal" role="form" action='UpdateInfo' method="POST">
                                      <div class="form-group">
                                        <label class="col-lg-3 control-label">Full name:</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" type="text" value=<%=user.name%> required>
                                        </div>
                                      </div>
                                      
                                      <div class="form-group">
                                        <label class="col-lg-3 control-label">Email:</label>
                                        <div class="col-lg-8">
                                          <input class="form-control" type="text" value=<%=user.email%> required>
                                        </div>
                                      </div>

                                      <div class="form-group">
                                        <label class="col-md-3 control-label">Password:</label>
                                        <div class="col-md-8">
                                          <input class="form-control" type="password" value=<%=user.pass%> required>
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="col-md-3 control-label">Confirm password:</label>
                                        <div class="col-md-8">
                                          <input class="form-control" type="password" value=<%=user.pass%> required>
                                        </div>
                                      </div>
                                      <div class="form-group">
                                        <label class="col-md-3 control-label"></label>
                                        <div class="col-md-8">
                                          <button type="submit" class="btn btn-primary">Submit</button>
                                          <span></span>
                                          <input type="reset" class="btn btn-default" value="Cancel">
                                        </div>
                                      </div>
                                    </form>
                                  </div>
                              </div>
                            </div>
                            <hr>
                        </div>
                        
                        <!-- BOOK LIST -->
                        <div id="booklist" class="tab-pane">
                            <h4>You read these books!</h4>
                            <ul>
                            <%
                                for(int i=0; i<user.readBooks.size(); i++){
                            %>
                            <% Book ub = (Book)user.readBooks.get(i);%>
                            
                                <li><%=ub.Name%></li>
                            
                            
                            <%
                                }
                            
                            %>
                            </ul>
                        </div>
                            
                         <!-- BOOK LIST2 -->
                        <div id="booklist2" class="tab-pane">
                            <h4>You are planning to read these!</h4>
                            <%
                                for(int i=0; i<user.willBooks.size(); i++){
                            %>
                            <% Book ub = (Book)user.willBooks.get(i);%>
                            
                                <li><%=ub.Name%></li>
                            
                            
                            <%
                                }
                            
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
