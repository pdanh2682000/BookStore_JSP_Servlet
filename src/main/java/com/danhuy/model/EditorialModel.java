package com.danhuy.model;

import com.danhuy.paging.Pagination;

public class EditorialModel {
	private Long article_id, editorial_cat_id, item_id;
	private String article_title, article_desc;
	private ItemsModel items = new ItemsModel();
	private Pagination pagination = new Pagination();
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public ItemsModel getItems() {
		return items;
	}
	public void setItems(ItemsModel items) {
		this.items = items;
	}
	public Long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
	public Long getEditorial_cat_id() {
		return editorial_cat_id;
	}
	public void setEditorial_cat_id(Long editorial_cat_id) {
		this.editorial_cat_id = editorial_cat_id;
	}
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_desc() {
		return article_desc;
	}
	public void setArticle_desc(String article_desc) {
		this.article_desc = article_desc;
	}
	
	
}
