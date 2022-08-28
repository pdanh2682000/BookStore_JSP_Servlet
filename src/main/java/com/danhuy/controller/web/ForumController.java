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

import com.danhuy.model.TopicMessageModel;
import com.danhuy.service.ITopicMessageService;
import com.danhuy.sort.Sorter;
import com.danhuy.utils.FormUtils;

@WebServlet(urlPatterns = { "/dien-dan", "/them-chu-de", "/chi-tiet-chu-de", "/phan-hoi", "/them-phan-hoi"})
public class ForumController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ResourceBundle resource = ResourceBundle.getBundle("message");

	@Inject
	ITopicMessageService topicMessageService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String messageResponse = req.getParameter("message");
		
		
		if (req.getParameter("action") != null && req.getParameter("action").equals("add")) {

			RequestDispatcher rd = req.getRequestDispatcher("/views/web/forum.jsp");
			rd.forward(req, resp);

		} else if (req.getParameter("action") != null && req.getParameter("action").equals("reply")) {
			
			TopicMessageModel model = topicMessageService.findTopicMessageById(Long.parseLong(req.getParameter("message_id")));
			
			req.setAttribute("model", model);
			req.setAttribute("reply", "true");
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/forum.jsp");
			rd.forward(req, resp);
			
			
		} else if(req.getParameter("message_id") != null) {
			
			TopicMessageModel model = topicMessageService.findTopicMessageById(Long.parseLong(req.getParameter("message_id")));
			List<TopicMessageModel> listMessages = 
					topicMessageService.findAllMessageByMessageId(Long.parseLong(req.getParameter("message_id")));
			
			req.setAttribute("model", model);
			req.setAttribute("listMessages", listMessages);
			req.setAttribute("detailTopic", "true");
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/forum.jsp");
			rd.forward(req, resp);
			
		} else {
			if (req.getParameter("list") != null
					&& (req.getParameter("list").equals("all") || req.getParameter("list").equals(""))) {

				Sorter sorter = FormUtils.toModel(Sorter.class, req);

				if (sorter.getSortBy() == null || sorter.getSortBy().equals("")) {
					sorter.setSortBy("asc");
				}

				TopicMessageModel model = new TopicMessageModel();
				model.setSorter(sorter);
				List<TopicMessageModel> topicMessageModel = topicMessageService.findAllTopicMessage(model, null);

				req.setAttribute("topicMessageModel", topicMessageModel);
				req.setAttribute("list", "all");

				if (sorter.getSortBy().equals("asc")) {
					sorter.setSortBy("desc");
				} else if (sorter.getSortBy().equals("desc")) {
					sorter.setSortBy("asc");
				}

				req.setAttribute("sortBy", sorter.getSortBy());
				req.setAttribute("showList", "true");
				if(messageResponse != null && !messageResponse.equals("")) {
					req.setAttribute("messageResponse", resource.getString(messageResponse));
				}

				RequestDispatcher rd = req.getRequestDispatcher("/views/web/forum.jsp");
				rd.forward(req, resp);

			} else if (req.getParameter("list") != null && req.getParameter("list").equals("search")) {

				String strSearch = req.getParameter("search");
				Sorter sorter = FormUtils.toModel(Sorter.class, req);

				if (sorter.getSortBy() == null || sorter.getSortBy().equals("")) {
					sorter.setSortBy("asc");
				}

				TopicMessageModel model = new TopicMessageModel();
				model.setSorter(sorter);
				List<TopicMessageModel> topicMessageModel = topicMessageService.findAllTopicMessage(model, strSearch);

				req.setAttribute("topicMessageModel", topicMessageModel);
				req.setAttribute("list", "search");
				req.setAttribute("search", strSearch);

				if (sorter.getSortBy().equals("asc")) {
					sorter.setSortBy("desc");
				} else if (sorter.getSortBy().equals("desc")) {
					sorter.setSortBy("asc");
				}

				req.setAttribute("sortBy", sorter.getSortBy());
				req.setAttribute("showList", "true");

				RequestDispatcher rd = req.getRequestDispatcher("/views/web/forum.jsp");
				rd.forward(req, resp);

			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if(req.getParameter("action") != null && req.getParameter("action").equals("add_topic")) {
			
			TopicMessageModel model = FormUtils.toModel(TopicMessageModel.class, req);
			if(req.getParameter("message_id") != null) {
				model.setMessage_id(Long.parseLong(req.getParameter("message_id")));
				topicMessageService.insertMessage(model);
				
				resp.sendRedirect("dien-dan?sortName=date_entered&sortBy=desc&list=all&message=insert_response_success&search=");
			}
			
			
		} else {
			TopicMessageModel model = FormUtils.toModel(TopicMessageModel.class, req);
			topicMessageService.insert(model);
	
			resp.sendRedirect("dien-dan?sortName=date_entered&sortBy=desc&list=all&message=insert_topic_success&search=");
		}
		
	}

}
