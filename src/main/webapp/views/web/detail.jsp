<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết</title>
</head>
<body>

<section class="py-5" style="background: #424246; opacity: 0.85;">

		<c:if test="${not empty messageResponse }">
		
			<div class="alert alert-success text-center">
	  			${messageResponse}
			</div>
		
		</c:if>
		
   		<h1 style="color:#9DCF9E;" class="text-center">Chi tiết về sách</h1>
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
	                           <!-- Product actions-->
	                           <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                    			<form action="gio-hang" method="post">
	                    				<input type="hidden" name="item_id" value="${item.item_id}">
	                    				<input type="hidden" name="name" value="${item.name}">
	                    				<input type="hidden" name="price" value="${item.price}">
	                    				<input type="hidden" name="cartAction" value="addnew">
		                               <div class="text-center">
		                               		<button class="btn btn-outline-dark mt-auto" type="submit">Thêm vào giỏ hàng</button>
		                               </div>
	                               	</form>
	                           </div>
	                       </div>
	                   </div>
                </div>
            </div>
            <h5 style="color: yellow; font-weight: bold;" class="text-center"><a href="<c:url value="/danh-gia?action=rating&item_id=${item.item_id}" />">Đánh giá sách này</a></h5>
            <br>
            <h5 style="color:#CF817E; font-weight: bold;" class="text-center">Thể loại: <span style="color:#fff;">${item.category_name}</span></h5>
            <h5 style="color:#CF817E; font-weight: bold;" class="text-center">Tác giả: <span style="color:#fff;">${item.author}</span></h5>
            <h5 style="color:#CF817E; font-weight: bold;" class="text-center">Ghi chú: <span style="color:#fff;">${item.notes}</span></h5>
            <h5 style="color:#CF817E; font-weight: bold;" class="text-center">Link tham khảo: <span style="color:#fff;">${item.product_url}</span></h5>
            <br>
            <h3 style="color:#4A90B9; font-weight: bold;" class="text-center">Đánh giá</h3>
            
            <c:forEach items="${ratings}" var="rate">
            
            	<h5 style="color:#CF817E; font-weight: bold;" class="text-center">Tên: <span style="color:#fff;">${rate.customer}</span></h5>
            	<h5 style="color:#CF817E; font-weight: bold;" class="text-center">Đánh giá: <img width="82px" height="15px" src="<c:url value='/template/IMAGES/${rate.rating}STARS.GIF' />"></h5>
            	<h5 style="color:#CF817E; font-weight: bold;" class="text-center">Bình luận: <span style="color:#fff;">${rate.comment}</span></h5>
            	<hr style="background-color: #fff; height: 5px; width:30%; margin:auto;"><br>
            	
            </c:forEach>
</section>

</body>
</html>