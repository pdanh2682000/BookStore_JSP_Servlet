package com.danhuy.service;

import com.danhuy.model.OrderModel;

public interface IOrderService {
	Long insertOrderAndOrderDetail(OrderModel model);
}
