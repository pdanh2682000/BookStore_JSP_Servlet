package com.danhuy.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danhuy.cart.ShoppingCart;

@WebServlet(urlPatterns = {"/gio-hang"})
public class ShoppingCartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ResourceBundle resource = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("message") != null && req.getParameter("message").equals("empty")) {
			req.setAttribute("messageResponse", resource.getString("cart_empty"));
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/shoppingcart.jsp");
			rd.forward(req, resp);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/shoppingcart.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cartAction = req.getParameter("cartAction");
		
		if(cartAction != null &&cartAction.equals("addnew")) {
			if(req.getSession().getAttribute("cart") == null) {
				ShoppingCart cart = new ShoppingCart();
				String item_id = req.getParameter("item_id");
				String name = req.getParameter("name");
				String price = req.getParameter("price");
				cart.addItem(item_id, name, Float.parseFloat(price), 1);
				req.getSession().setAttribute("cart", cart);
				resp.sendRedirect("trang-chu?messageAddnewJs=true_cart");
			}
			else {
				ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
				String item_id = req.getParameter("item_id");
				String name = req.getParameter("name");
				String price = req.getParameter("price");
				cart.addItem(item_id, name, Float.parseFloat(price), 1);
				resp.sendRedirect("trang-chu?messageAddnewJs=true_cart");
			}
			
		} else if(cartAction != null && cartAction.equals("update")) {
			String view = "gio-hang";
			if(req.getSession().getAttribute("cart") != null) {
				if(!((ShoppingCart)req.getSession().getAttribute("cart")).isEmpty()) {
					ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
					String itemList[] = req.getParameterValues("item_id");
					String itemQty[] = req.getParameterValues("itemQty");
					if(itemList != null) {
						if(itemList.length == 1) {
							int qty = Integer.parseInt(itemQty[0]);
							cart.updateQuantity(itemList[0], qty);
						}else {
							for(int i=0; i<itemList.length; i++) {
								int qty = Integer.parseInt(itemQty[i]);
								cart.updateQuantity(itemList[i], qty);
							}
						}
					}
				} else {
					view = "gio-hang?message=empty";
				}
			}
			resp.sendRedirect(view);
			
		} else if(cartAction != null && cartAction.equals("clear")) {
			String view = "gio-hang";
			if(req.getSession().getAttribute("cart") != null) {
				if(!((ShoppingCart)req.getSession().getAttribute("cart")).isEmpty()) {
					ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
					cart.clearItems();
				} else {
					view = "gio-hang?message=empty";
				}
			}
			resp.sendRedirect(view);
			
		} else if(cartAction != null && cartAction.equals("delete")) {
			if(req.getSession().getAttribute("cart") != null) {
				ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
				if(req.getParameter("item_id") != null) cart.removeItem(req.getParameter("item_id"));
			}
			resp.sendRedirect("gio-hang");
		}
	}

}
