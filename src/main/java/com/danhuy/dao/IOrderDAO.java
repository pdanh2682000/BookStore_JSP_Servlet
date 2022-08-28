package com.danhuy.dao;

import com.danhuy.model.OrderModel;

public interface IOrderDAO {
	Long insertOrderAndOrderDetail(OrderModel model);
}
