<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<style>

body {
  margin: 0;
  padding: 0;
  background-color: #17a2b8;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  margin-top: 120px;
  max-width: 600px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}

</style>
</head>

<body>
    <div id="login" style="background: #424246; opacity: 0.85; padding-top: 20px;">
    
    	<c:if test="${not empty messageResponse }">
		
			<div class="alert alert-danger text-center">
	  			${messageResponse}
			</div>
		
		</c:if>
    
    
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                    
                    	<c:if test="${empty MEMBERMODEL }">
	                        <form id="login-form" class="form" action="dang-nhap?action=login" method="post">
	                            <h3 class="text-center text-info">Đăng nhập</h3>
	                            <div class="form-group">
	                                <label for="member_login" class="text-info">Tên đăng nhập:</label><br>
	                                <input type="text" name="member_login" id="member_login" class="form-control">
	                            </div>
	                            <div class="form-group">
	                                <label for="member_password" class="text-info">Mật khẩu:</label><br>
	                                <input type="password" name="member_password" id="member_password" class="form-control">
	                            </div><br>
	                            <div class="form-group">
	                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Đăng nhập">
	                            </div>
	                            <div id="register-link" class="text-right">
	                                <a href="dang-ky" class="text-info">Register here</a>
	                            </div>
	                        </form>
	                       </c:if>
	                       
	                       <c:if test="${not empty MEMBERMODEL }">
	                       		<h3 class="text-center text-info">Cần thoát tài khoản trước khi đăng nhập!</h3>
	                       		<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4 text-center">
					            	<li class="nav-item">
					            		<a class="nav-link" style="color:#800000; font-weight: 1000;" href="#!"><button class="btn btn-info mt-auto btn-lg">Hi, ${MEMBERMODEL.first_name}</button></a>
					     			</li>
					     			<li class="nav-item">
					     				<a class="nav-link" style="color:#800000;  font-weight: 1000;" href="dang-nhap?action=logout"><button class="btn btn-info mt-auto btn-lg">Đăng xuất</button></a>
					     			</li>
								</ul>
	                       </c:if>
	                       
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>


</html>