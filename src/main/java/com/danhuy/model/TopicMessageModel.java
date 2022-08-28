package com.danhuy.model;

import java.sql.Timestamp;

import com.danhuy.sort.Sorter;

public class TopicMessageModel {
	private Long id;
	private Long message_id;
	private String topic, author, message;
	private Timestamp date_entered;
	private Sorter sorter = new Sorter();
	

	public Sorter getSorter() {
		return sorter;
	}
	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getDate_entered() {
		return date_entered;
	}
	public void setDate_entered(Timestamp date_entered) {
		this.date_entered = date_entered;
	}
	
	

}
