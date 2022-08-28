package com.danhuy.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;

import com.danhuy.mail.GetMail;
import com.danhuy.model.MailMessageModel;

public class MailMessageMapper {
	
	public static List<MailMessageModel> getListModel(final String username, final String password) {
		List<MailMessageModel> listModel = new ArrayList<MailMessageModel>();
		System.out.println(username);
		System.out.println(password);
		Message[] messages = GetMail.getMessages(username, password);
		
		for(int i=0; i<messages.length; i++) {
			MailMessageModel model = new MailMessageModel();
			model.setSender(GetMail.getSendFromMessage(messages, i));
			model.setDate(GetMail.getSendDateMessage(messages, i));
			model.setCapacity(GetMail.getCapacityMessage(messages, i));
			model.setSubject(GetMail.getSubjectMessage(messages, i));
			listModel.add(model);
		}
		
		return listModel;
	}
	
	
//	public static void main(String[] args) {
//		final String username = "luutru2682000@gmail.com";
//		final String password = "phanduyanh123";
//		
//		List<MailMessageModel> listModels = MailMessageMapper.getListModel(username, password);
//		System.out.print(listModels);
//	}
}
