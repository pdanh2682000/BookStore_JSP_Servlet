package com.danhuy.controller.web;

import java.io.IOException;

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


@WebServlet(urlPatterns = {"/dang-ky"})
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject IMembersService memberService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/register.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MembersModel memberModel = FormUtils.toModel(MembersModel.class, req);
		memberService.insertMember(memberModel);
		resp.sendRedirect("trang-chu?messageAddnewJs=true_register");
	}

}
