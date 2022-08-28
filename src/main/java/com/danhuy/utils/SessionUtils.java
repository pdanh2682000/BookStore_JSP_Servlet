package com.danhuy.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	
	private static SessionUtils sessionUtil = null;
	
	public static SessionUtils getInstance() {
		if(sessionUtil == null) return new SessionUtils();
		return sessionUtil;
	}
	
	public void putValue(String key, Object value, HttpServletRequest req) {
		req.getSession().setAttribute(key, value);;
	}
	
	public Object getValue(String key, HttpServletRequest req) {
		return req.getSession().getAttribute(key);
	}
	
	public void removeValue(String key, HttpServletRequest req) {
		req.getSession().removeAttribute(key);
	}
}
