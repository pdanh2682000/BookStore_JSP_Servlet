package com.danhuy.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.danhuy.dao.ITopicMessageDAO;
import com.danhuy.model.TopicMessageModel;
import com.danhuy.service.ITopicMessageService;

public class TopicMessageService implements ITopicMessageService {

	@Inject ITopicMessageDAO topicMessage;
	
	@Override
	public List<TopicMessageModel> findAllTopicMessage(TopicMessageModel model, String search) {
		return topicMessage.findAllTopicMessage(model, search);
	}

	@Override
	public List<TopicMessageModel> findAllMessageByMessageId(Long id) {
		return topicMessage.findAllMessageByMessageId(id);
	}

	@Override
	public Long insert(TopicMessageModel model) {
		return topicMessage.insert(model);
	}

	@Override
	public TopicMessageModel findTopicMessageById(Long id) {
		return topicMessage.findTopicMessageById(id);
	}

	@Override
	public Long insertMessage(TopicMessageModel model) {
		return topicMessage.insertMessage(model);
	}

}
