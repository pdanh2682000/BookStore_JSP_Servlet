package com.danhuy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.danhuy.model.OrderModel;

public class OrderMapper implements RowMapper<OrderModel> {

	@Override
	public OrderModel mapRow(ResultSet rs) {
		OrderModel model = new OrderModel();
		try {
			model.setOrder_id(rs.getLong("order_id"));
			model.setMember_id(rs.getLong("member_id"));
			model.setPayment(rs.getString("payment"));
			model.setShipping(rs.getString("shipping"));
			model.setOrderdate(rs.getTimestamp("orderdate"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Mapper order fail!");
			return null;
		}
		
		return model;
	}

}
