package com.danhuy.dao;

import java.util.List;

import com.danhuy.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> mapper,Object...parameters);
	Long insert(String sql, Object...parameters);
	void update(String sql, Object...parameters);
	void delete(String sql, Object...parameters);
	int count(String sql, Object...parameters);
}