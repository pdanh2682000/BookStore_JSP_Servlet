package com.danhuy.mail;

import java.sql.Timestamp;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class GetMail {
	

	public static Message[] getMessages(final String username, final String password) {
		String host = "pop.gmail.com";

		Properties props = new Properties();
		props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.pop3.socketFactory.fallback", "false");
	    props.put("mail.pop3.socketFactory.port", "995");
	    props.put("mail.pop3.port", "995");
	    props.put("mail.pop3.host", "pop.gmail.com");
	    props.put("mail.pop3.user", username);
	    props.put("mail.store.protocol", "pop3");
	    
	    Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        
        
        try {
        	Session mailsession = Session.getDefaultInstance(props, auth);
			Store store = mailsession.getStore("pop3");
			store.connect(host, username, password);
			
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			
			Message message[] = folder.getMessages();
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Lá»—i khi láº¥y Store tá»« Pop3");
		}
		return null;
		
	}
	
	public static String getSubjectMessage(Message[] messages, int index) {
		try {
			return messages[index].getSubject();
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.print("Lá»—i khi láº¥y tÃªn tiÃªu Ä‘á»� Message");
		}
		return null;
	}
	
	public static int getCapacityMessage(Message[] messages, int index) {
		try {
			int size = messages[index].getSize() / 1024; // KB
			if(size == 0) size = 1;
			return size;
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.print("Lá»—i khi láº¥y dung lÆ°á»£ng Message");
		}
		return -1;
	}
	
	public static Timestamp getSendDateMessage(Message[] messages, int index) {
		try {
			 Timestamp date = new Timestamp(messages[index].getSentDate().getTime());
			return date;
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.print("Lá»—i khi láº¥y ngÃ y gá»­i Message");
		}
		return null;
	}
	
	public static String getSendFromMessage(Message[] messages, int index) {
		try {
			Address address[] = messages[index].getFrom();
			return address[0].toString(); // only 1
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.print("Lá»—i khi láº¥y Ä‘á»‹a chá»‰ gá»­i Message");
		}
		return null;
	}
	
	public static void cleanGarbage(Folder folder, Store store) {
		try {
			folder.close(false);
			store.close();
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.print("Lá»—i khi dá»�n dáº¹p Message");
		}
	}
	
	public static void main(String[] args) {
		Message[] m = GetMail.getMessages("luutru2682000@gmail.com", "phanduyanh123");
		System.out.print(GetMail.getSendDateMessage(m, 5));
	}
	
	
}
