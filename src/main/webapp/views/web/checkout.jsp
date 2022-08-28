<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.danhuy.cart.ShoppingCart" %>
<%@ page import="java.util.*" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận</title>
</head>
<body>

<div class="container-fluid" style="background: #424246; opacity: 0.85;  color:#fff; padding-top: 20px;">
<h1 style="color:#9DCF9E;" class="text-center">Xác nhận đơn hàng</h1><br>

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
	</div>
	


	<%
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if(cart == null){
	%>
	<div class="row text-center">
		<div class="col">
			<h5 class="text-center">Bạn chưa có sách nào trong giỏ hàng! Hãy đi shopping ngay!</h5>
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
			<p><%=quantity%></p>
		</div>
		<div class="col">
			<p><%=subTotal%>VNĐ</p>
		</div>
	</div>
	
	<input type="hidden" name="item_id" value="<%=item_id%>">
	
	<%
			}
	%>
	<div class="row text-center">
		<div class="col">
			<h4 class="text-center" style="color: #FF9228;">Thành tiền: <%=totalCost%>VNĐ</h4>
		</div>
	</div>
	<%
		}
	
	%>
	<br>
	<div class="row text-center">
		<div class="col">
       		<div class="text-center">
        		<button class="btn btn-primary mt-auto" value="Order now" onclick="doAction(this)">Đặt hàng ngay</button>
        	</div>
		</div>
		<div class="col">
       		<div class="text-center">
        		<button class="btn btn-primary mt-auto" value="Change" onclick="doAction(this)">Thay đổi</button>
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
		if(button.value == "Order now"){
			frm.action = "xac-nhan?action=order";	
		}
		if(button.value == "Change"){
			frm.method = "get";
			frm.action = "gio-hang";	
		}
		if(button.value == "Continue Shopping"){
			frm.method = "get";
			frm.action = "trang-chu";	
		}
	}

</script>

</div>

</body>
</html>