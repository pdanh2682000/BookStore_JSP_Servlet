package com.danhuy.service;

import java.util.List;

import com.danhuy.model.TopicMessageModel;

public interface ITopicMessageService {
	List<TopicMessageModel> findAllTopicMessage(TopicMessageModel model, String search);
	List<TopicMessageModel> findAllMessageByMessageId(Long id);
	TopicMessageModel findTopicMessageById(Long id);
	Long insert(TopicMessageModel model);
	Long insertMessage(TopicMessageModel model);
}
