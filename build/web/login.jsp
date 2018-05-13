<%@page import="java.sql.Date"%>
<%@page import="DAO.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Welcome!</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        
<!--===============================================================================================-->
</head>
<body style="background-color: #666666;">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
                            <form class="login100-form validate-form" action='CheckLogin' method="POST">
                                    <span class="login100-form-title p-b-43">
                                            Login to continue
                                    </span>
                                    <%
                                        String remember="";
                                        String email="";
                                        if(request.getAttribute("emaill")!=null)
                                            email=(String) request.getAttribute("emaill");
                                        
                                            ///user = new User((String)session.getAttribute("name"),(String)session.getAttribute("email"),(String)session.getAttribute("pass"));
                                        Cookie[] cookies = request.getCookies();
                                        if(cookies!=null){
                                            cookies  = request.getCookies();
                                        
                                            for (Cookie cookie : cookies) {

                                                if(cookie.getName().equals("remember")) {
                                                    remember = cookie.getValue();
                                                }

                                            }
                                        }
                                        

                                        if(remember.equals("true")){
                                            //session.setAttribute("session", "yes");
                                            response.sendRedirect("profile.jsp");
                                        }

                                        
                                        

                                        String msg = (String)request.getAttribute("message");
                                        String check = (String)request.getAttribute("check");
                                        
                                        if(msg != null){
                                            if(check.equals("wrong")){
                                                
                                            

                                    %>
                                    <div class="alert alert-danger">
                                        <strong><%= msg%></strong> 
                                    </div>
                                    <%
                                            }
                                            if(check.equals("ok")){
                                    %>
                                    <div class="alert alert-success">
                                        <strong><%= msg%></strong> 
                                    </div>
                                    <%
                                            }
                                        }
                                    %>


                                    <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                                            <input class="input100" type="text" name="email" value = <%= email %>>
                                            <span class="focus-input100"></span>
                                            <span class="label-input100">Email</span>
                                    </div>


                                    <div class="wrap-input100 validate-input" data-validate="Password is required">
                                            <input class="input100" type="password" name="pass" >
                                            <span class="focus-input100"></span>
                                            <span class="label-input100">Password</span>
                                    </div>

                                    <div class="flex-sb-m w-full p-t-3 p-b-32">
                                            <div class="contact100-form-checkbox">
                                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me" >
                                                    <label class="label-checkbox100" for="ckb1">
                                                            Remember me
                                                    </label>
                                            </div>

                                            <div>
                                                    <a href="register.jsp" class="txt1">
                                                            Register Here!
                                                    </a>
                                            </div>
                                    </div>


                                    <div class="container-login100-form-btn">
                                            <button class="login100-form-btn">
                                                    Login
                                            </button>
                                    </div>
					
				</form>

				<div class="login100-more" style="background-image: url('images/bg-01.jpg');">
				</div>
			</div>
		</div>
	</div>
	
	

	
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>