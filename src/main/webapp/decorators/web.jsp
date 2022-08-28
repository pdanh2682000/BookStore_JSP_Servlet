<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="book store home page" />
    <meta name="author" content="Danh Uy" />
    <title><decorator:title default="Trang chủ" /></title>
    
    
    
    <%-- <c:url value='/template/assets/favicon.ico' /> --%>
    
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<c:url value='/template/assets/favicon.ico' />" />
    
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value='/template/css/styles.css' />" rel="stylesheet" />
    
    <!-- pagination  -->
    
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"> -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>

</head>
<body>
	
	<%@ include file="/common/web/navigation.jsp" %>
	
		<decorator:body  />
	
	<%@ include file="/common/web/footer.jsp" %>
	
	
	
	
	<!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Core theme JS-->
    <script src="<c:url value='/template/js/scripts.js' />"></script>

</body>
</html>