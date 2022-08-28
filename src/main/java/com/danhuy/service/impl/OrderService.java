package com.danhuy.service.impl;

import javax.inject.Inject;

import com.danhuy.dao.IOrderDAO;
import com.danhuy.model.OrderModel;
import com.danhuy.service.IOrderService;

public class OrderService implements IOrderService {

	@Inject
	IOrderDAO orderDao;
	
	@Override
	public Long insertOrderAndOrderDetail(OrderModel model) {
		return orderDao.insertOrderAndOrderDetail(model);
	}

}
