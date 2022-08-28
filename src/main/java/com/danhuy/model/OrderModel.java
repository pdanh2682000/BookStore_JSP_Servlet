package com.danhuy.model;

import java.sql.Timestamp;

public class OrderModel{
	private Long order_id, member_id;
	private String payment, shipping;
	private Timestamp orderdate;
	private Long item_id[] = null;
	private String name[] = null;
	private Float price[] = null;
	private Integer quantity[] = null;
	private Long countItem;
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public Float[] getPrice() {
		return price;
	}
	public void setPrice(Float[] price) {
		this.price = price;
	}
	public Integer[] getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}
	public Long getCountItem() {
		return countItem;
	}
	public void setCountItem(Long countItem) {
		this.countItem = countItem;
	}
	public Long[] getItem_id() {
		return item_id;
	}
	public void setItem_id(Long[] item_id) {
		this.item_id = item_id;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	
}
