package com.danhuy.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.danhuy.dao.GenericDAO;
import com.danhuy.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	
	ResourceBundle resource = ResourceBundle.getBundle("database");
	
	public Connection getConnection() {
		
		try {
			Class.forName(resource.getString("drivername"));
			String url = resource.getString("url");
			String user = resource.getString("user");
			String password = resource.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection DB fail!");
			return null;
		}
	}
	
	
	public void setParameters(PreparedStatement ps, Object...parameters) {
		for(int i=0; i<parameters.length; i++) {
			try {
				if(parameters[i] instanceof Long)	ps.setLong(i+1, (Long)parameters[i]);
				if(parameters[i] instanceof Integer)	ps.setInt(i+1, (Integer)parameters[i]);
				if(parameters[i] instanceof String)	ps.setString(i+1, (String)parameters[i]);
				if(parameters[i] instanceof Float)	ps.setFloat(i+1, (Float)parameters[i]);
				if(parameters[i] instanceof Double)	ps.setDouble(i+1, (Double)parameters[i]);
				if(parameters[i] instanceof Timestamp)	ps.setTimestamp(i+1, (Timestamp)parameters[i]);
				if(parameters[i] == null)	ps.setNull(i+1, Types.NULL);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Set parameter DB fail!");
			}
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> mapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			setParameters(ps, parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				results.add(mapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query DB fail!");
			return null;
		} finally {
			try {
				if(conn != null)	conn.close();
				if(ps != null)	ps.close();
				if(rs != null)	rs.close();
			}catch(SQLException e) {
				System.out.println("Grabage DB for query fail!");
				e.printStackTrace();
				return null;
			}
		}
		
	}

	@Override
		// ok
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		
		try {
			Long id = null;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(ps, parameters);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			if(conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("Rollback DB for insert fail!");
				}
			e.printStackTrace();
			System.out.println("Insert DB fail!");
			return null;
		} finally {
			try {
				if(conn != null)	conn.close();
				if(ps != null)	ps.close();
				if(rs != null)	rs.close();
			}catch(SQLException e) {
				System.out.println("Grabage DB for insert fail!");
				e.printStackTrace();
				return null;
			}
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameters(ps, parameters);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if(conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("Rollback DB for update fail!");
				}
			e.printStackTrace();
			System.out.println("update DB fail!");
		} finally {
			try {
				if(conn != null)	conn.close();
				if(ps != null)	ps.close();
			}catch(SQLException e) {
				System.out.println("Grabage DB for update fail!");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameters(ps, parameters);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if(conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("Rollback DB for delete fail!");
				}
			e.printStackTrace();
			System.out.println("delete DB fail!");
		} finally {
			try {
				if(conn != null)	conn.close();
				if(ps != null)	ps.close();
			}catch(SQLException e) {
				System.out.println("Grabage DB for delete fail!");
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		
		try {
			int count = 0;
			ps = conn.prepareStatement(sql);
			setParameters(ps, parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("count fail!");
			return 0;
		} finally {
			try {
				if(conn != null)	conn.close();
				if(ps != null)	ps.close();
				if(rs != null)	rs.close();
			}catch(SQLException e) {
				System.out.println("Grabage DB for count fail!");
				e.printStackTrace();
				return 0;
			}
		}
	}

}
