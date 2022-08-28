<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ page import="com.danhuy.cart.ShoppingCart" %>
<%@ page import="java.util.*" %>
<%

	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	int quantity = 0;
	if(cart != null){
		quantity = cart.getNumOfItems();
	}

%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
		
		<c:if test="${empty MEMBERMODEL}">

			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
            	<li class="nav-item">
            		<a class="nav-link" style="color:#800000; font-weight: 1000;" href="dang-nhap?action=login"><button class="btn btn-info mt-auto btn-sm">Đăng nhập</button></a>
     			</li>
     			<li class="nav-item">
     				<a class="nav-link" style="color:#800000;  font-weight: 1000;" href="dang-ky"><button class="btn btn-info mt-auto btn-sm">Đăng ký</button></a>
     			</li>
			</ul>
			
		</c:if>
		
		
		<c:if test="${not empty MEMBERMODEL}">

			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
            	<li class="nav-item">
            		<a class="nav-link" style="color:#800000; font-weight: 1000;" href="#!"><button class="btn btn-info mt-auto btn-sm">Hi, ${MEMBERMODEL.first_name}</button></a>
     			</li>
     			<li class="nav-item">
     				<a class="nav-link" style="color:#800000;  font-weight: 1000;" href="dang-nhap?action=logout"><button class="btn btn-info mt-auto btn-sm">Đăng xuất</button></a>
     			</li>
			</ul>
			
		</c:if>
			
			
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="trang-chu	"><img src="<c:url value='template/IMAGES/Logo_bookstore.gif' />"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item">
                        	<a class="nav-link active" aria-current="page" href="trang-chu"><img src="<c:url value='template/IMAGES/icon_home.gif' />"></a>
                        </li>
                        <li class="nav-item">
                        	<a class="nav-link" href="gio-hang"><img src="<c:url value='template/IMAGES/icon_shop.gif' />"></a>
                        </li>
 						<li class="nav-item">
                        	<a class="nav-link" href="dang-ky"><img src="<c:url value='template/IMAGES/ICON_REG.GIF' />"></a>
                        </li>
                        <li class="nav-item">
                        	<a class="nav-link" href="dang-nhap?action=login"><img src="<c:url value='template/IMAGES/icon_sign.gif' />"></a>
                        </li>
                        <li class="nav-item">
                        	<a class="nav-link" href="dien-dan?sortName=date_entered&sortBy=desc&list=all&search="><img src="<c:url value='template/IMAGES/icon_forum.jpg' />"></a>
                        </li>
                        <li class="nav-item">
                        	<a class="nav-link" href="trang-chu-mail"><img src="<c:url value='template/IMAGES/icon_mail.jpg' />"></a>
                        </li>
                        <li class="nav-item">
                        	<a class="nav-link" href="#!"><img src="<c:url value='template/IMAGES/icon_admin.gif' />"></a>
                        </li>

                        
                    </ul>
                    
                    <form class="d-flex" method="get" action="gio-hang">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill"><%=quantity%></span>
                        </button>
                    </form>
                    
                </div>
            </div>
</nav>