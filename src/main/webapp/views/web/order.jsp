<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt hàng</title>
</head>
<body>

<section class="py-5" style="background: #424246; opacity: 0.85; color: #fff">
   	<h1 style="color:#fff;" class="text-center">Xác nhận thông tin đặt hàng</h1>
   	<br><br>
    <form action="xac-nhan" method="post" style="width: 30%; margin: auto;">
    	
    	<div class="row">
			<div class="col">
				<p>Phương thức thanh toán</p>
			</div>
			<div class="col">
				<select name="payment">
					<option value="thẻ tín dụng">Thẻ tín dụng</option>
					<option value="khi nhận hàng">Khi nhận hàng</option>
				</select>
			</div>
		</div>
					
		<div class="row">
			<div class="col">
				<p>Thời gian</p>
			</div>
			<div class="col">
				<select name="shipping">
					<option value="nhanh">Express (3 days)</option>
					<option value="tiết kiệm">1 month</option>
				</select>
			</div>
		</div>
					
		<div class="row text">
			<div class="col">
				<p>Email</p>
			</div>
			<div class="col">
				<input type="email" name="email">
			</div>
		</div>
		<br>
					
		<button type="submit" class="btn btn-primary mt-auto">Xác nhận đặt hàng</button>
    
    </form>
</section>


</body>
</html>