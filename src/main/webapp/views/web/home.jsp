<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<header class="py-5" style="background: #424246; opacity: 0.85;">
            <div class="container px-4 px-lg-5 my-5 row">
            	<div class="col-md-8">
            		<img src="<c:url value='/template/IMAGES/banner_bookstore.jpg' />" class="img-responsive">
            	</div>
            	<div class="col-md-4">
	                <div class="text-center text-white" style="margin-top:70px;">
	                    <h1 class="display-4 fw-bolder">BookStore's Danh Uy</h1>
	                    <p class="lead fw-normal text-white-50 mb-0">Hello, mình là Danh Uy nè!!!</p>
	                </div>
	            </div>
            </div>
</header>
<br>

<section class="py-5" style="background: #424246; opacity: 0.85;">
	<form action="trang-chu" method="get" id="frm">
   		<h1 style="color:#fff;" class="text-center">Sách khuyến nghị</h1>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                	<c:forEach var="item" items="${listItemsRecommended}">
                		<c:set var = "modelRecommended"  value = "${item}"/>
	                	<div class="col mb-5">
	                        <div class="card h-100">
	                            <!-- Product image-->
	                            <img class="card-img-top img-responsive" src='<c:url value='${item.items.image_url}'  />' alt="Book Item">
	                            <!-- Product details-->
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <!-- Product name-->
	                                    <h5 class="fw-bolder">${item.items.name}</h5>
	                                    <!-- Product price-->
	                                    ${item.items.price}VNĐ
	                                </div>
	                            </div>
	                            <!-- Product actions-->
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                <div class="text-center">
	                                	<a class="btn btn-outline-dark mt-auto" href="<c:url value="/chi-tiet?action=detail&item_id=${item.item_id}" />">Xem chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
                </div>
            </div>
            
			<input type="hidden" name="page" id="page">
			<input type="hidden" name="maxItemPerPage" id="maxItemPerPage">
			<input type="hidden" name="list" value="recommended">
			
	</form>
				<!-- pagination -->
				
			<div class="container" style="width:45%; margin:auto;">
				<nav aria-label="Page navigation" style="width:50%; margin:auto;">
					<ul  class="pagination" id="paginationRecommended"></ul>
				</nav>
			</div>
			
			<script type="text/javascript">
				var currentPage1 = ${modelRecommended.pagination.page}
				var constVisiblePages1 = 5;
				var constMaxItemPerPage1 = 3;
				var total_page1 = ${modelRecommended.pagination.totalPage};
			
			    $(function () {
			        window.pagObj = $('#paginationRecommended').twbsPagination({
			            totalPages: total_page1,
			            visiblePages: constVisiblePages1,
			            startPage: currentPage1,
			            onPageClick: function (event, page) {
			                if(currentPage1 != page){
			                	$("#page").val(page);
			                	$("#maxItemPerPage").val(constMaxItemPerPage1);
			                	$("#frm").submit();
			                }
			            }
			        }).on('page', function (event, page) {
			            console.info(page + ' (from event listening)');
			        });
			    });
			</script>
</section>
<br>

<section class="py-5" style="background: #424246; opacity: 0.85;">
	<form action="trang-chu" method="get" id="frm1">
   		<h1 style="color:#fff;" class="text-center">Sách quảng cáo</h1>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                	<c:forEach var="item" items="${listItemsAdvertise}">
                		<c:set var = "modelAdvertise"  value = "${item}"/>
	                	<div class="col mb-5">
	                        <div class="card h-100">
	                            <!-- Product image-->
	                            <img class="card-img-top" src='<c:url value='${item.items.image_url}'  />' alt="Book Item">
	                            <!-- Product details-->
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <!-- Product name-->
	                                    <h5 class="fw-bolder">${item.items.name}</h5>
	                                    <!-- Product price-->
	                                    ${item.items.price}VNĐ
	                                </div>
	                            </div>
	                            <!-- Product actions-->
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                <div class="text-center">
	                                	<a class="btn btn-outline-dark mt-auto" href="<c:url value="/chi-tiet?action=detail&item_id=${item.item_id}" />">Xem chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
                </div>
            </div>
            
            <input type="hidden" name="page" id="page1">
			<input type="hidden" name="maxItemPerPage" id="maxItemPerPage1">
			<input type="hidden" name="list" value="advertise">
	</form>
            
            <!-- pagination -->
				
			<div class="container" style="width:45%; margin:auto;">
				<nav aria-label="Page navigation" style="width:50%; margin:auto;">
					<ul  class="pagination" id="paginationAdvertise"></ul>
				</nav>
			</div>
			
			<script type="text/javascript">
				var currentPage2 = ${modelAdvertise.pagination.page}
				var constVisiblePages2 = 5;
				var constMaxItemPerPage2 = 3;
				var total_page2 = ${modelAdvertise.pagination.totalPage};
			
			    $(function () {
			        window.pagObj = $('#paginationAdvertise').twbsPagination({
			            totalPages: total_page2,
			            visiblePages: constVisiblePages2,
			            startPage: currentPage2,
			            onPageClick: function (event, page) {
			                if(currentPage2 != page){
			                	$("#page1").val(page);
			                	$("#maxItemPerPage1").val(constMaxItemPerPage2);
			                	$("#frm1").submit();
			                }
			            }
			        }).on('page', function (event, page) {
			            console.info(page + ' (from event listening)');
			        });
			    });
			</script>
</section>
<br>

<section class="py-5" style="background: #424246; opacity: 0.85;">
	<form action="trang-chu" method="get" id="frm2">
   		<h1 style="color:#fff;" class="text-center">Sách Mới</h1>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                	<c:forEach var="item" items="${listItemsNew}">
                		<c:set var = "modelNew"  value = "${item}"/>
	                	<div class="col mb-5">
	                        <div class="card h-100">
	                            <!-- Product image-->
	                            <img class="card-img-top" src='<c:url value='${item.items.image_url}'  />' alt="Book Item">
	                            <!-- Product details-->
	                            <div class="card-body p-4">
	                                <div class="text-center">
	                                    <!-- Product name-->
	                                    <h5 class="fw-bolder">${item.items.name}</h5>
	                                    <!-- Product price-->
	                                    ${item.items.price}VNĐ
	                                </div>
	                            </div>
	                            <!-- Product actions-->
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                               <div class="text-center">
	                                	<a class="btn btn-outline-dark mt-auto" href="<c:url value="/chi-tiet?action=detail&item_id=${item.item_id}" />">Xem chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
                </div>
            </div>
            
            <input type="hidden" name="page" id="page2">
			<input type="hidden" name="maxItemPerPage" id="maxItemPerPage2">
			<input type="hidden" name="list" value="new">
	</form>
            
            <!-- pagination -->
				
			<div class="container" style="width:45%; margin:auto;">
				<nav aria-label="Page navigation" style="width:50%; margin:auto;">
					<ul  class="pagination" id="paginationNew"></ul>
				</nav>
			</div>
			
			<script type="text/javascript">
				var currentPage3 = ${modelNew.pagination.page}
				var constVisiblePages3 = 5;
				var constMaxItemPerPage3 = 3;
				var total_page3 = ${modelNew.pagination.totalPage};
			
			    $(function () {
			        window.pagObj = $('#paginationNew').twbsPagination({
			            totalPages: total_page3,
			            visiblePages: constVisiblePages3,
			            startPage: currentPage3,
			            onPageClick: function (event, page) {
			                if(currentPage3 != page){
			                	$("#page2").val(page);
			                	$("#maxItemPerPage2").val(constMaxItemPerPage3);
			                	$("#frm2").submit();
			                }
			            }
			        }).on('page', function (event, page) {
			            console.info(page + ' (from event listening)');
			        });
			    });
			</script>
</section>
<br>

<section class="py-5" style="background: #424246; opacity: 0.85;">
	<form action="trang-chu" method="get" id="frm3">
   		<h1 style="color:#fff;" class="text-center">Tất cả sách</h1>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                	<c:forEach var="item" items="${listItems}">
                		<c:set var = "modelList"  value = "${item}"/>
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
	                                <div class="text-center">
	                                	<a class="btn btn-outline-dark mt-auto" href="<c:url value="/chi-tiet?action=detail&item_id=${item.item_id}" />">Xem chi tiết</a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
                </div>
            </div>
            
            <input type="hidden" name="page" id="page3">
			<input type="hidden" name="maxItemPerPage" id="maxItemPerPage3">
			<input type="hidden" name="list" value="all">
	</form>
            
            <!-- pagination -->
				
			<div class="container" style="width:45%; margin:auto;">
				<nav aria-label="Page navigation" style="width:50%; margin:auto;">
					<ul  class="pagination" id="paginationList"></ul>
				</nav>
			</div>
			
			<script type="text/javascript">
				var currentPage4 = ${modelList.pagination.page}
				var constVisiblePages4 = 5;
				var constMaxItemPerPage4 = 3;
				var total_page4 = ${modelList.pagination.totalPage};
			
			    $(function () {
			        window.pagObj = $('#paginationList').twbsPagination({
			            totalPages: total_page4,
			            visiblePages: constVisiblePages4,
			            startPage: currentPage4,
			            onPageClick: function (event, page) {
			                if(currentPage4 != page){
			                	$("#page3").val(page);
			                	$("#maxItemPerPage3").val(constMaxItemPerPage4);
			                	$("#frm3").submit();
			                }
			            }
			        }).on('page', function (event, page) {
			            console.info(page + ' (from event listening)');
			        });
			    });
			</script>
</section>

<c:if test="${ not empty messageAddnewJs }">
	<script type="text/javascript">
		alert("${messageAddnewJs}");
	</script>
</c:if>
