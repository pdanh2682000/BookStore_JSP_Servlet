package com.danhuy.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danhuy.cart.ShoppingCart;
import com.danhuy.model.MembersModel;
import com.danhuy.model.OrderModel;
import com.danhuy.service.IOrderService;
import com.danhuy.utils.FormUtils;
import com.danhuy.utils.SessionUtils;

@WebServlet(urlPatterns = {"/xac-nhan"})
public class CheckOutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject IOrderService orderService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("cart") != null) {
			if(!((ShoppingCart)req.getSession().getAttribute("cart")).isEmpty()) {
				RequestDispatcher rd = req.getRequestDispatcher("/views/web/checkout.jsp");
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("gio-hang?message=empty");
			}
			
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/thankorder.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		if(req.getParameter("action") != null && req.getParameter("action").equals("order")) {
			if(req.getSession().getAttribute("cart") != null) {
				if(req.getSession().getAttribute("MEMBERMODEL") != null) {
					RequestDispatcher rd = req.getRequestDispatcher("/views/web/order.jsp");
					rd.forward(req, resp);
				} else {
					resp.sendRedirect("dang-nhap?action=login");
				}
			}
		} else {
			
			OrderModel orderModel = FormUtils.toModel(OrderModel.class, req);
			ShoppingCart cart = (ShoppingCart) SessionUtils.getInstance().getValue("cart", req);
			Long[] listItemId = new Long[cart.getNumOfItems()];
			String[] listItemName = new String[cart.getNumOfItems()];
			Float[] listItemPrice = new Float[cart.getNumOfItems()];
			Integer[] listItemQuantity = new Integer[cart.getNumOfItems()];
			long countItem = 0;
			Enumeration<String[]> e = cart.getEnumeration();
			while(e.hasMoreElements()) {
				String[] item = (String[]) e.nextElement();
				listItemId[(int) countItem] = Long.parseLong(item[0]);
				listItemName[(int) countItem] = String.valueOf(item[1]);
				listItemPrice[(int) countItem] = Float.parseFloat(item[2]);
				listItemQuantity[(int) countItem] = Integer.parseInt(item[3]);
				countItem++;
			}
			
			orderModel.setItem_id(listItemId);
			orderModel.setName(listItemName);
			orderModel.setPrice(listItemPrice);
			orderModel.setQuantity(listItemQuantity);
			orderModel.setCountItem(countItem);
			
			MembersModel memberModel = (MembersModel) SessionUtils.getInstance().getValue("MEMBERMODEL", req);
			orderModel.setMember_id(memberModel.getMember_id());
			
			orderModel.setOrderdate(new Timestamp(System.currentTimeMillis()));
			
			
			orderService.insertOrderAndOrderDetail(orderModel);
			
			// clear session cart
			cart.clearItems();
			SessionUtils.getInstance().removeValue("cart", req);
			
			resp.sendRedirect("xac-nhan");
			
			
		}
	}

}
