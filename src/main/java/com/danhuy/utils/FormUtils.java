package com.danhuy.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtils {
	
	@SuppressWarnings("deprecation")
	public static <T> T toModel(Class<T> classModel, HttpServletRequest request) {
		T object = null;
		try {
			object = classModel.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Lỗi mapping form to model");
		}
		return object;
	}
}
