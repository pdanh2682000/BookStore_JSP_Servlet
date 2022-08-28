package com.danhuy.dao.impl;

import java.util.List;

import com.danhuy.dao.IEditorialDAO;
import com.danhuy.mapper.EditorialMapper;
import com.danhuy.model.EditorialModel;

public class EditorialDAO extends AbstractDAO<EditorialModel> implements IEditorialDAO {

	@Override
	public List<EditorialModel> findByCodeEditorial(Long id) {
		String sql = "select * from editorial where editorial_cat_id=?";
		return query(sql, new EditorialMapper(), id);
	}

	@Override
	public Long insert(EditorialModel model) {
		StringBuilder sql = new StringBuilder("insert into editorial(editorial_cat_id, article_title, article_desc, item_id)");
		sql.append(" values(?,?,?,?)");
		return insert(sql.toString(), model.getEditorial_cat_id(), model.getArticle_title(), model.getArticle_desc(), model.getItem_id());
	}

	@Override
	public void update(EditorialModel model) {
		StringBuilder sql = new StringBuilder("update editorial set editorial_cat_id=?, article_title=?, article_desc=?, item_id=?");
		sql.append(" where article_id=?");
		update(sql.toString(), model.getEditorial_cat_id(), model.getArticle_title(), model.getArticle_desc(), model.getItem_id(),
				model.getArticle_id());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from editorial where article_id=?";
		delete(sql, id);
	}

	@Override
	public List<EditorialModel> findAllItemsByCodeEditorial(Long id) {
		String sql = "select * from editorial e inner join items i on e.item_id=i.item_id where editorial_cat_id=?";
		return query(sql, new EditorialMapper(), id);
	}

	@Override
	public List<EditorialModel> findAllItemsByCodeEditorialAndPagination(EditorialModel model) {
		StringBuilder sql = new StringBuilder("select * from editorial e inner join items i on e.item_id=i.item_id"
				+ " where editorial_cat_id=? limit " + 
				(model.getPagination().getPage() - 1)*model.getPagination().getMaxItemPerPage() + ", " + model.getPagination().getMaxItemPerPage());
		List<EditorialModel> results = query(sql.toString(), new EditorialMapper(), model.getEditorial_cat_id());
		for(EditorialModel e:results) {
			e.setPagination(model.getPagination());
		}
		return results;
	}

	@Override
	public int countByCodeEditorial(Long id) {
		String sql = "select count(*) from editorial where editorial_cat_id=?";
		int result = count(sql, id);
		return result;
	}
	
	
//	public static void main(String[] args) {
//		EditorialDAO edit = new EditorialDAO();
//		EditorialModel model = new EditorialModel();
//		model.setArticle_id(4L);
//		model.setArticle_title("testupdate");
//		model.setArticle_desc("testupdate");
//		model.setEditorial_cat_id(2L);
//		model.setItem_id(2L);
//		model.getPagination().setPage(1);
//		model.getPagination().setMaxItemPerPage(3);
//		//edit.insert(model);
//		//List<EditorialModel> arr = edit.findAllItemsByCodeEditorial(2L);
//		List<EditorialModel> arr = edit.findAllItemsByCodeEditorialAndPagination(model);
//		System.out.print(arr);
//		//edit.update(model);
//		//edit.delete(4L);
//	}

}
