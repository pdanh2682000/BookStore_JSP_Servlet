<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đánh giá</title>
</head>
<body>

<section class="py-5" style="background: #424246; opacity: 0.85;">
   		<h1 style="color:#fff;" class="text-center">Đánh giá về sách</h1>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	               	<div class="col mb-5">
	                       <div class="card h-100">
	                           <!-- Product image-->
	                           <img class="card-img-top" src='<c:url value='${item.image_url}'  />' alt="Book Item">
	                           <!-- Product details-->
	                           <div class="card-body p-4">
	                               <div class="text-center">
	                                   <!-- Product name-->
	                                   <h5 class="fw-bolder">${item.name}</h5>
	                                   <!-- Product price-->
	                                   ${item.price}VNĐ
	                               </div>
	                           </div>
	                       </div>
	                   </div>
                </div>
            </div>
            <div class="container px-4 px-lg-5 mt-5" style="width:50%;">
				<form action="danh-gia?action=rating" method="post">
					  <div class="form-group">
					    <label for="customer" style="color:#fff; font-weight: bold;">Tên:</label>
					    <input type="text" class="form-control" id="customer" placeholder="Tên của bạn" name="customer" required="required">
					  </div><br>
					  <div class="form-group">
					    <label for="rating" style="color:#fff; font-weight: bold;">Đánh giá:</label>
					    <select class="form-control" name="rating" id="rating">
					    	<option value="5">5 Starts</option>
					    	<option value="4">4 Starts</option>
					    	<option value="3">3 Starts</option>
					    	<option value="2">2 Starts</option>
					    	<option value="1">1 Starts</option>
					    </select>
					  </div><br>
					  <div class="form-group">
					    <label for="comment" style="color:#fff; font-weight: bold;">Bình luận:</label>
					    <textarea class="form-control" rows="5" cols="80" name="comment" id="comment" required="required"></textarea>
					  </div><br>
					  <input type="hidden" name="item_id" value="${item.item_id}">
					  <button type="submit" class="btn btn-primary">Gửi đi</button>
				</form>
			</div>	
</section>

</body>
</html>