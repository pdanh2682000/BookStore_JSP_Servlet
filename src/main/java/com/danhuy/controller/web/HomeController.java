package com.danhuy.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danhuy.cart.ShoppingCart;
import com.danhuy.model.EditorialModel;
import com.danhuy.model.ItemsModel;
import com.danhuy.model.RatingModel;
import com.danhuy.paging.Pagination;
import com.danhuy.service.IEditorialService;
import com.danhuy.service.IItemsService;
import com.danhuy.service.IRatingService;
import com.danhuy.utils.FormUtils;
import com.danhuy.utils.SessionUtils;

@WebServlet(urlPatterns= {"/trang-chu", "/chi-tiet", "/danh-gia"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ResourceBundle resource = ResourceBundle.getBundle("message");
	
	@Inject IItemsService itemsService;
	@Inject IEditorialService editorialService;
	@Inject IRatingService ratingService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ------- luôn luôn khởi tạo trước giỏ hàng cho user khi vào trang ------------
		
		if(req.getSession().getAttribute("cart") == null) {
			ShoppingCart cart = new ShoppingCart();
			SessionUtils.getInstance().putValue("cart", cart, req);
		}
			
//		if(req.getSession().getAttribute("cart") == null) {
//			ShoppingCart cart = new ShoppingCart();
//			req.getSession().setAttribute("cart", cart);
//		}
		
		// ----------------------------------------------------------------------------------
		
		
		if(req.getParameter("item_id") != null) {
			String view = new String("");
			if(req.getParameter("action") != null && req.getParameter("action").equals("detail")) {
				view = "/views/web/detail.jsp";
				List<RatingModel> ratingModel = ratingService.findAllByItem(Long.parseLong(req.getParameter("item_id")));
				req.setAttribute("ratings", ratingModel);
				if(req.getParameter("message") != null && req.getParameter("message").equals("thanks")) {
					req.setAttribute("messageResponse", resource.getString("thanks"));
				}
			}else if(req.getParameter("action") != null && req.getParameter("action").equals("rating")) {
				view = "/views/web/rating.jsp";
			}
			ItemsModel item = itemsService.findOne(Long.parseLong(req.getParameter("item_id")));
			req.setAttribute("item", item);
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
			
		}  else {
				// recommended
			if(req.getParameter("list") != null && req.getParameter("list").equals("recommended")) {
				
				Pagination pagination = FormUtils.toModel(Pagination.class, req);
				EditorialModel model = new EditorialModel();
				if(pagination.getPage() == null) {
					pagination.setPage(1);
				}
				pagination.setMaxItemPerPage(3);
				pagination.setTotalPage(pagination.countPage(editorialService.countByCodeEditorial(1L)));
				model.setPagination(pagination);
				model.setEditorial_cat_id(1L);
				List<EditorialModel> editorialModel = editorialService.findAllItemsByCodeEditorialAndPagination(model);
				req.setAttribute("listItemsRecommended", editorialModel);
				
			} else {
				
				Pagination pagination = new Pagination();
				EditorialModel model = new EditorialModel();
				pagination.setPage(1);
				pagination.setMaxItemPerPage(3);
				pagination.setTotalPage(pagination.countPage(editorialService.countByCodeEditorial(1L)));
				model.setPagination(pagination);
				model.setEditorial_cat_id(1L);
				List<EditorialModel> editorialModel = editorialService.findAllItemsByCodeEditorialAndPagination(model);
				req.setAttribute("listItemsRecommended", editorialModel);
				
			}
			
				// advertise
			if(req.getParameter("list") != null && req.getParameter("list").equals("advertise")) {
				
				Pagination pagination1 = FormUtils.toModel(Pagination.class, req);
				EditorialModel model1 = new EditorialModel();
				if(pagination1.getPage() == null) {
					pagination1.setPage(1);
				}
				pagination1.setMaxItemPerPage(3);
				pagination1.setTotalPage(pagination1.countPage(editorialService.countByCodeEditorial(2L)));
				model1.setPagination(pagination1);
				model1.setEditorial_cat_id(2L);
				List<EditorialModel> editorialModel1 = editorialService.findAllItemsByCodeEditorialAndPagination(model1);
				req.setAttribute("listItemsAdvertise", editorialModel1);
				
			} else {
				
				Pagination pagination1 = new Pagination();
				EditorialModel model1 = new EditorialModel();
				pagination1.setPage(1);
				pagination1.setMaxItemPerPage(3);
				pagination1.setTotalPage(pagination1.countPage(editorialService.countByCodeEditorial(2L)));
				model1.setPagination(pagination1);
				model1.setEditorial_cat_id(2L);
				List<EditorialModel> editorialModel1 = editorialService.findAllItemsByCodeEditorialAndPagination(model1);
				req.setAttribute("listItemsAdvertise", editorialModel1);
				
			}
			
				// new
			if(req.getParameter("list") != null && req.getParameter("list").equals("new")) {
				
				Pagination pagination2 = FormUtils.toModel(Pagination.class, req);
				EditorialModel model2 = new EditorialModel();
				if(pagination2.getPage() == null) {
					pagination2.setPage(1);
				}
				pagination2.setMaxItemPerPage(3);
				pagination2.setTotalPage(pagination2.countPage(editorialService.countByCodeEditorial(3L)));
				model2.setPagination(pagination2);
				model2.setEditorial_cat_id(3L);
				List<EditorialModel> editorialModel2 = editorialService.findAllItemsByCodeEditorialAndPagination(model2);
				req.setAttribute("listItemsNew", editorialModel2);
				
			} else {
				
				Pagination pagination2 = new Pagination();
				EditorialModel model2 = new EditorialModel();
				pagination2.setPage(1);
				pagination2.setMaxItemPerPage(3);
				pagination2.setTotalPage(pagination2.countPage(editorialService.countByCodeEditorial(3L)));
				model2.setPagination(pagination2);
				model2.setEditorial_cat_id(3L);
				List<EditorialModel> editorialModel2 = editorialService.findAllItemsByCodeEditorialAndPagination(model2);
				req.setAttribute("listItemsNew", editorialModel2);
				
				
			}
			
				
				// all
			
			if(req.getParameter("list") != null && req.getParameter("list").equals("all")) {
				
				Pagination pagination3 = FormUtils.toModel(Pagination.class, req);
				ItemsModel model3 = new ItemsModel();
				if(pagination3.getPage() == null) {
					pagination3.setPage(1);
				}
				pagination3.setMaxItemPerPage(3);
				pagination3.setTotalPage(pagination3.countPage(itemsService.count()));
				model3.setPagination(pagination3);
				List<ItemsModel> listItems = itemsService.findAllItemsPagination(model3);
				req.setAttribute("listItems", listItems);
				
			} else {
				
				Pagination pagination3 = FormUtils.toModel(Pagination.class, req);
				ItemsModel model3 = new ItemsModel();
				pagination3.setPage(1);
				pagination3.setMaxItemPerPage(3);
				pagination3.setTotalPage(pagination3.countPage(itemsService.count()));
				model3.setPagination(pagination3);
				List<ItemsModel> listItems = itemsService.findAllItemsPagination(model3);
				req.setAttribute("listItems", listItems);
				
			}
			
			
			
			if(req.getParameter("messageAddnewJs") != null) {
				if(req.getParameter("messageAddnewJs").equals("true_cart"))
					req.setAttribute("messageAddnewJs", resource.getString("cart_success"));
				if(req.getParameter("messageAddnewJs").equals("true_register"))
					req.setAttribute("messageAddnewJs", resource.getString("register_success"));
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if(req.getParameter("action") != null && req.getParameter("action").equals("rating")) {
			RatingModel ratingModel = FormUtils.toModel(RatingModel.class, req);
			ratingService.insert(ratingModel);
			resp.sendRedirect("chi-tiet?action=detail&item_id="+ratingModel.getItem_id()+"&message=thanks");
		}
	}

}
	