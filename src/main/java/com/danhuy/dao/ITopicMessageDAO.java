package com.danhuy.dao;

import java.util.List;

import com.danhuy.model.TopicMessageModel;

public interface ITopicMessageDAO {
	List<TopicMessageModel> findAllTopicMessage(TopicMessageModel model, String search);
	List<TopicMessageModel> findAllMessageByMessageId(Long id);
	TopicMessageModel findTopicMessageById(Long id);
	Long insert(TopicMessageModel model);
	Long insertMessage(TopicMessageModel model);
}
