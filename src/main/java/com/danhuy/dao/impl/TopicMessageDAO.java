package com.danhuy.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.danhuy.dao.ITopicMessageDAO;
import com.danhuy.mapper.TopicMessageMapper;
import com.danhuy.model.TopicMessageModel;

public class TopicMessageDAO extends AbstractDAO<TopicMessageModel> implements ITopicMessageDAO {

	@Override
	public List<TopicMessageModel> findAllTopicMessage(TopicMessageModel model, String search) {
		StringBuilder sql = new StringBuilder("select * from topic_messages");
		if(search != null && !search.equals("")) sql.append(" where topic like '%"+search+"%'");
		sql.append(" order by "+model.getSorter().getSortName() + " " + model.getSorter().getSortBy());
		return query(sql.toString(), new TopicMessageMapper());
	}

	@Override
	public List<TopicMessageModel> findAllMessageByMessageId(Long id) {
		String sql = "select * from messages where message_id=?";
		return query(sql, new TopicMessageMapper(), id);
	}

	@Override
	public Long insert(TopicMessageModel model) {
		StringBuilder sql = new StringBuilder("insert into topic_messages(topic, author, date_entered)");
		sql.append(" values(?,?,?)");
		return insert(sql.toString(), model.getTopic(), model.getAuthor(), new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public TopicMessageModel findTopicMessageById(Long id) {
		String sql = "select * from topic_messages where message_id=?";
		List<TopicMessageModel> results = query(sql, new TopicMessageMapper(), id);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public Long insertMessage(TopicMessageModel model) {
		StringBuilder sql = new StringBuilder("insert into messages(message_id, message, author, date_entered)");
		sql.append(" values(?,?,?,?)");
		return insert(sql.toString(), model.getMessage_id(), model.getMessage(), model.getAuthor(), new Timestamp(System.currentTimeMillis()));
	}
	
	
	
//	public static void main(String[] args) {
//		TopicMessageDAO t = new TopicMessageDAO();
//		TopicMessageModel model = new TopicMessageModel();
//		model.getSorter().setSortName("topic");
//		model.getSorter().setSortBy("desc");
//		List<TopicMessageModel> m = t.findAllMessageByMessageId(1L);
//		System.out.print(m);
//	}

	

}
