<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<section>
	  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
	    <div class="container h-100">
	      <div class="row d-flex justify-content-center align-items-center h-100">
	        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
	          <div class="card" style="border-radius: 15px;">
	            <div class="card-body p-5">
	              <h2 class="text-uppercase text-center mb-5">Đăng ký tài khoản</h2>
	
	              <form action="dang-ky" method="post">
	
	                <div class="form-outline mb-4">
	                  <input type="text" name="member_login" id="form3Example1cg" class="form-control form-control-lg"  required="required"/>
	                  <label class="form-label" for="form3Example1cg">*Tên đăng nhập</label>
	                </div>
	
	                <div class="form-outline mb-4">
	                  <input type="email" name="email" id="form3Example2cg" class="form-control form-control-lg" required="required"/>
	                  <label class="form-label" for="form3Example2cg">*Email</label>
	                </div>
	
	                <div class="form-outline mb-4">
	                  <input type="password" name="member_password" id="form3Example3cg" class="form-control form-control-lg" required="required"/>
	                  <label class="form-label" for="form3Example3cg">*Mật khẩu</label>
	                </div>
	
	                <div class="form-outline mb-4">
	                  <input type="text" name="first_name" id="form3Example4cdg" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example4cdg">Tên</label>
	                </div>
	                
 	                <div class="form-outline mb-4">
	                  <input type="text" name="last_name" id="form3Example5cdg" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example5cdg">Họ</label>
	                </div>
	                
	                <div class="form-outline mb-4">
	                  <input type="text" name="phone" id="form3Example6cdg" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example6cdg">Số điện thoại</label>
	                </div>
	                
	                <div class="form-outline mb-4">
	                  <input type="text" name="address" id="form3Example7cdg" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example7cdg">Địa chỉ</label>
	                </div>
	                
	                <div class="form-outline mb-4">
	                  <select id="form3Example8cdg" name="card_type_id" class="form-control form-control-lg" required="required">
	                  		<option value="1">Sacombank</option>
	                  		<option value="2">HDBank</option>
	                  </select>
	                  <label class="form-label" for="form3Example8cdg">*Chọn thẻ</label>
	                </div>
	                
	                <div class="form-outline mb-4">
	                  <input type="text" name="card_number" id="form3Example9cdg" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example9cdg">Số thẻ</label>
	                </div>
	                
	                <input type="hidden" name="role_id" value="2">
	                <input type="hidden" name="notes" value="Tài khoản người dùng">
	
	                
	
	                <div class="d-flex justify-content-center">
	                  <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Đăng ký</button>
	                </div>
	
	               
	
	              </form>
	
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
</section>

</body>
</html>