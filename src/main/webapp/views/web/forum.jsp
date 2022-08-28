<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diễn đàn</title>
</head>
<body>

<div class="container-fluid" style="background: #424246; opacity: 0.85;  color:#fff; padding-top: 20px;">

	<c:if test="${not empty messageResponse }">
		
			<div class="alert alert-success text-center">
	  			${messageResponse}
			</div>
		
	</c:if>

	<h1 style="color:#9DCF9E;" class="text-center">Trang diễn đàn của BookStore Danh Uy</h1><br>
	
	<div class="row text-center">
		<div class="col">
			<a href="dien-dan?sortName=date_entered&sortBy=desc&list=all&search="><button class="btn btn-info mt-auto btn-bg">Về diễn đàn chính</button></a>
		</div>
		<div class="col">
			<a href="them-chu-de?action=add"><button class="btn btn-info mt-auto btn-bg">Thêm chủ đề</button></a>
		</div>
	</div>
	
	<br>
<c:if test="${not empty showList}">	
	<div class="row text-center">
		<div class="row justify-content-center">
	        <div class="col-12 col-md-10 col-lg-4">
	            <form class="card card-sm" action="dien-dan" method="get">
	                <div class="card-body row no-gutters align-items-center">
	                    <div class="col-auto">
	                        <i class="fas fa-search h6 text-body"></i>
	                    </div>
	                    <!--end of col-->
	                    <div class="col">
	                        <input class="form-control form-control-lg form-control-borderless" type="search" name="search" placeholder="Chủ đề">
	                    </div>
	                    <!--end of col-->
	                    <div class="col-auto">
	                        <button class="btn btn-lg btn-success" type="submit">Tìm kiếm</button>
	                    </div>
	                    <!--end of col-->
	                </div>
	                <input type="hidden" name="sortName" value="date_entered">
	                <input type="hidden" name="sortBy" value="desc">
	                <input type="hidden" name="list" value="search">
	            </form>
	        </div>
	        <!--end of col-->
        </div>
	</div>
	
	<br><br>
	
	<div class="row text-center">
		<h3>Thảo luận</h3>
	</div>
	
	<div class="row text-center">
		<div class="col">
			<h5><a href="dien-dan?sortName=topic&sortBy=${sortBy}&list=${list}&search=${search}" style="color: #E89142;">Chủ đề</a></h5>
		</div>
		<div class="col">
			<h5><a href="dien-dan?sortName=author&sortBy=${sortBy}&list=${list}&search=${search}" style="color: #E89142;">Tác giả</a></h5>
		</div>
		<div class="col">
			<h5><a href="dien-dan?sortName=date_entered&sortBy=${sortBy}&list=${list}&search=${search}" style="color: #E89142;">Ngày đăng</a></h5>
		</div>
	</div>
	<hr>
	
	<c:forEach var="item" items="${topicMessageModel}">
	
		<div class="row text-center" style="padding: 10px;">
			<div class="col">
				<h6><a href="chi-tiet-chu-de?message_id=${item.message_id}" style="color: #fff;">${item.topic}</a></h6>
			</div>
			<div class="col">
				<h6>${item.author}</h6>
			</div>
			<div class="col">
				<h6>${item.date_entered}</h6>
			</div>
		</div>
		<hr>
	
	</c:forEach>
	
</c:if>
	
	
<c:if test="${empty showList}">

	<c:if test="${empty detailTopic}">
	
		<c:if test="${empty reply}">
		
			<h3 class="text-center">Thêm mới chủ đề</h3>
			<br>
			<form action="them-chu-de" method="post" style="width: 30%; margin: auto;">
		    	
		    	<div class="row">
					<div class="col">
						<p>Tên chủ đề</p>
					</div>
					<div class="col">
						<input type="text" name="topic">
					</div>
				</div>
							
				<div class="row">
					<div class="col">
						<p>Tác giả</p>
					</div>
					<div class="col">
						<input type="text" name="author">
					</div>
				</div>
				<br>
							
				<button type="submit" class="btn btn-primary mt-auto">Thêm mới chủ đề</button>
		    </form>
		    
		</c:if>
		
		<c:if test="${not empty reply}">

			<h3 class="text-center">Chủ đề chính</h3>
			<br>
			
			<div class="row" style="width: 30%; margin: auto;">
				<div class="col">
					<p>Chủ đề: </p>
				</div>
				<div class="col">
					<p>${model.topic}</p>
				</div>
			</div>
			
			<div class="row" style="width: 30%; margin: auto;">
				<div class="col">
					<p>Tác giả: </p>
				</div>
				<div class="col">
					<p>${model.author}</p>
				</div>
			</div>
			
			<div class="row" style="width: 30%; margin: auto;">
				<div class="col">
					<p>Ngày: </p>
				</div>
				<div class="col">
					<p>${model.date_entered}</p>
				</div>
			</div>
		
			<h3 class="text-center">Phản hồi của bạn</h3>
			<br>
			
			<form action="them-phan-hoi" method="post" style="width: 30%; margin: auto;">
		    				
				<div class="row">
					<div class="col">
						<p>Tác giả</p>
					</div>
					<div class="col">
						<input type="text" name="author">
					</div>
				</div>
				
				<div class="row">
					<div class="col">
						<p>Thông điệp</p>
					</div>
					<div class="col">
						<input type="text" name="message">
					</div>
				</div>
				<br>
				
				<input type="hidden" name="message_id" value="${model.message_id}">	
				<input type="hidden" name="action" value="add_topic">		
				<button type="submit" class="btn btn-primary mt-auto">Thêm mới phản hồi</button>
		    </form>
			<br>
		</c:if>
		
	</c:if>
	
	
	<c:if test="${not empty detailTopic}">
	
		<h3 class="text-center">Chủ đề chính</h3>
		<br>
		
		<div class="row" style="width: 30%; margin: auto;">
			<div class="col">
				<p>Chủ đề: </p>
			</div>
			<div class="col">
				<p>${model.topic}</p>
			</div>
		</div>
		
		<div class="row" style="width: 30%; margin: auto;">
			<div class="col">
				<p>Tác giả: </p>
			</div>
			<div class="col">
				<p>${model.author}</p>
			</div>
		</div>
		
		<div class="row" style="width: 30%; margin: auto;">
			<div class="col">
				<p>Ngày: </p>
			</div>
			<div class="col">
				<p>${model.date_entered}</p>
			</div>
		</div>
		
		<div class="row" style="width: 30%; margin: auto;">
			<div class="col text-left">
				<a href="phan-hoi?action=reply&message_id=${model.message_id}"><button class="btn btn-lg btn-success">Phản hồi</button></a>
			</div>
		</div>
		
		<br>
		<h3 class="text-center">Thảo luận</h3>
		<br>
		
		<c:forEach var="item" items="${listMessages}">
		
			<div class="row" style="width: 30%; margin: auto;">
				<div class="col">
					<p>Tác giả: </p>
				</div>
				<div class="col">
					<p>${item.author}</p>
				</div>
			</div>
			
			<div class="row" style="width: 30%; margin: auto;">
				<div class="col">
					<p>Ngày: </p>
				</div>
				<div class="col">
					<p>${item.date_entered}</p>
				</div>
			</div>
			
			<div class="row" style="width: 30%; margin: auto;">
				<div class="col">
					<p>Thông điệp: </p>
				</div>
				<div class="col">
					<p>${item.message}</p>
				</div>
			</div>
			<hr>
			
		</c:forEach>
		
	
	</c:if>
	

</c:if>	
	


</div>

</body>
</html>