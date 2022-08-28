package com.danhuy.dao.impl;

import com.danhuy.dao.IOrderDAO;
import com.danhuy.model.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO {

	@Override
	public Long insertOrderAndOrderDetail(OrderModel model) {
		StringBuilder sql = new StringBuilder("insert into orders(member_id, payment, shipping, orderdate)");
		sql.append(" values(?,?,?,?)");
		Long orderId = insert(sql.toString(), model.getMember_id(), model.getPayment(), model.getShipping(), model.getOrderdate());
		
		for(int i=0; i<model.getCountItem(); i++) {
			StringBuilder sql2 = new StringBuilder("insert into orderdetails(order_id, item_id, item_desc, quantity, price)");
			sql2.append(" values(?,?,?,?,?)");
			
			float price = model.getQuantity()[i] * model.getPrice()[i];
			
			insert(sql2.toString(), orderId, model.getItem_id()[i], model.getName()[i], model.getQuantity()[i], price);
		}
		
		return orderId;
	}

	

}
