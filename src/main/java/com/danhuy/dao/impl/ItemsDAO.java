package com.danhuy.dao.impl;

import java.util.List;

import com.danhuy.dao.IItemsDAO;
import com.danhuy.mapper.ItemsMapper;
import com.danhuy.model.ItemsModel;

public class ItemsDAO extends AbstractDAO<ItemsModel> implements IItemsDAO {

	@Override
	public List<ItemsModel> findAll() {
		String sql = "select * from items";
		return query(sql, new ItemsMapper());
	}

	@Override
	public List<ItemsModel> findByField(String field, Object value) {
		String sql =  "select * from items where "+field+"=?";;
		return query(sql, new ItemsMapper(), value);
	}

	@Override
	public Long insert(ItemsModel model) {
		StringBuilder sql = new StringBuilder("insert into items(category_id, name, author, price, product_url, image_url, notes)");
		sql.append(" values(?,?,?,?,?,?,?)");
		return insert(sql.toString(), model.getCategory_id(), model.getName(), model.getAuthor(), model.getPrice(),
				model.getProduct_url(), model.getImage_url(), model.getNotes());
	}

	@Override
	public void update(ItemsModel model) {
		StringBuilder sql = new StringBuilder("update items set category_id=?, name=?, author=?, price=?, product_url=?, "
				+ "image_url=?, notes=?");
		sql.append(" where item_id=?");
		update(sql.toString(), model.getCategory_id(), model.getName(), model.getAuthor(), model.getPrice(),
				model.getProduct_url(), model.getImage_url(), model.getNotes(), model.getItem_id());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from items where item_id=?";
		delete(sql, id);
	}

	@Override
	public int count() {
		String sql = "select count(*) from items";
		int result = count(sql);
		return result;
	}

	@Override
	public ItemsModel findOne(Long id) {
		String sql = "select * from items i inner join categories c on i.category_id=c.category_id where item_id=?";
		List<ItemsModel> results = query(sql, new ItemsMapper(), id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<ItemsModel> findAllItemsPagination(ItemsModel model) {
		StringBuilder sql = new StringBuilder("select * from items limit " + 
				(model.getPagination().getPage() - 1)*model.getPagination().getMaxItemPerPage() + ", " + model.getPagination().getMaxItemPerPage());
		List<ItemsModel> results = query(sql.toString(), new ItemsMapper());
		for(ItemsModel e:results) {
			e.setPagination(model.getPagination());
		}
		return results;
	}
	
	
//	public static void main(String[] args) {
//		ItemsDAO i = new ItemsDAO();
//		//List<ItemsModel> arr = i.findAll();
//		List<ItemsModel> arr = i.findByField("category_id", "2");
//		ItemsModel m = new ItemsModel();
//		m.setItem_id(4L);
//		m.setCategory_id(2L);
//		m.setName("testu");
//		m.setAuthor("testu");
//		m.setPrice(3F);
//		m.setProduct_url("testu");
//		m.setImage_url("testu");
//		//i.insert(m);
//		//i.update(m);
//		//i.delete(4L);
//		//System.out.print(arr);
//	}

}
