package com.danhuy.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danhuy.model.MembersModel;
import com.danhuy.service.IMembersService;
import com.danhuy.utils.FormUtils;
import com.danhuy.utils.SessionUtils;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ResourceBundle resource = ResourceBundle.getBundle("message");
	
	@Inject IMembersService memberService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "";
		
		if(req.getParameter("action") != null && req.getParameter("action").equals("login")) {
			view = "/views/web/login.jsp";
			if(req.getParameter("message") != null && req.getParameter("message").equals("login_fail")) {
					req.setAttribute("messageResponse", resource.getString("login_fail"));
			}
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
			
		} else if(req.getParameter("action") != null && req.getParameter("action").equals("logout")) {
			view = "trang-chu";
			SessionUtils.getInstance().removeValue("MEMBERMODEL", req);
			resp.sendRedirect(view);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("action") != null && req.getParameter("action").equals("login")) {
			
			MembersModel memberModel = FormUtils.toModel(MembersModel.class, req);
			memberModel = memberService.findByUsernamePassword(memberModel.getMember_login(), memberModel.getMember_password());
			if(memberModel != null) {
				SessionUtils.getInstance().putValue("MEMBERMODEL", memberModel, req);
				if(memberModel.getRole_id() == 1) resp.sendRedirect("#");
				else if(memberModel.getRole_id() == 2) resp.sendRedirect("trang-chu");
			} else {
				resp.sendRedirect("dang-nhap?action=login&message=login_fail");
			}
			
		}
	}

}
