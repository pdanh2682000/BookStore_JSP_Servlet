<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.danhuy.cart.ShoppingCart" %>
<%@ page import="java.util.*" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>

<div class="container-fluid" style="background: #424246; opacity: 0.85;  color:#fff; padding-top: 20px;">

<c:if test="${not empty messageResponse }">
		
			<div class="alert alert-danger text-center">
	  			<strong>${messageResponse}</strong>
			</div>
		
</c:if>

<h1 style="color:#9DCF9E;" class="text-center">Giỏ hàng</h1><br>
<form name="frm" method="post">
	<div class="row text-center">
		<div class="col">
			<h5>Tên sách:</h5>
		</div>
		<div class="col">
			<h5>Giá:</h5>
		</div>
		<div class="col">
			<h5>Số lượng:</h5>
		</div>
		<div class="col">
			<h5>Tổng tiền:</h5>
		</div>
		<div class="col">
			<h5>Xóa:</h5>
		</div>
	</div>
	


	<%
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if(cart == null || cart.isEmpty()){
	%>
	<br>
	<div class="row text-center">
		<div class="col">
			<h3 class="text-center" style="color: #DCC2C4;">Bạn chưa có sách nào trong giỏ hàng! Hãy đi shopping ngay!</h3>
		</div>
	</div>
	<%
		} else{
			Enumeration<String[]> e = cart.getEnumeration();
			String tmpItem[];
			float totalCost = cart.getCost();
			while(e.hasMoreElements()){
				tmpItem = e.nextElement();
				float subTotal = Float.parseFloat(tmpItem[2]) * Integer.parseInt(tmpItem[3]);
				String item_id = tmpItem[0];
				String name = tmpItem[1];
				String price = tmpItem[2];
				String quantity = tmpItem[3];
	%>
	
	<div class="row text-center">
		<div class="col">
			<a style="color:#FF8B26;" href="chi-tiet?action=detail&item_id=<%=item_id%>"><%=name%></a>
		</div>
		<div class="col">
			<p><%=price%>VNĐ</p>
		</div>
		<div class="col">
			<input type="text" name="itemQty" value="<%=quantity%>">
		</div>
		<div class="col">
			<p><%=subTotal%>VNĐ</p>
		</div>
		<div class="col">
			<button class="btn btn-danger mt-auto btn-sm" value="Delete" onclick="doAction1(this, <%=item_id%>)">Xóa</button>
		</div>
	</div>
	
	<input type="hidden" name="item_id" value="<%=item_id%>">
	
	<%
			}
		}
	
	%>
	<br>
	<div class="row text-center">
		<div class="col">
       		<div class="text-center">
        		<button class="btn btn-primary mt-auto" value="Update Selected" onclick="doAction(this)">Cập nhật số lượng</button>
        	</div>
		</div>
		<div class="col">
       		<div class="text-center">
        		<button class="btn btn-primary mt-auto" value="Clear Basket" onclick="doAction(this)">Xóa giỏ hàng</button>
        	</div>
		</div>
		<div class="col">
       		<div class="text-center">
        		<button class="btn btn-primary mt-auto" value="Check out" onclick="doAction(this)">Xác nhận mua hàng</button>
        	</div>
		</div>
		<div class="col">
       		<div class="text-center">
        		<button class="btn btn-primary mt-auto" value="Continue Shopping" onclick="doAction(this)">Tiếp tục mua sách</button>
        	</div>
		</div>
	</div>
	<br>
	
</form>

<script type="text/javascript">
	function doAction(button){

		if(button.value == "Update Selected"){
			frm.method = "post";
			frm.action = "gio-hang?cartAction=update";	
		}
		if(button.value == "Clear Basket"){
			frm.method = "post";
			frm.action = "gio-hang?cartAction=clear";	
		}
		if(button.value == "Check out"){
			frm.method = "get";
			frm.action = "xac-nhan";	
		}
		if(button.value == "Continue Shopping"){
			frm.method = "get";
			frm.action = "trang-chu";	
		}

	}
	
	function doAction1(button, id){
		if(button.value == "Delete"){
			frm.method = "post";
			frm.action = "gio-hang?cartAction=delete&item_id="+id;	
		}
	}

</script>

</div>

</body>
</html>