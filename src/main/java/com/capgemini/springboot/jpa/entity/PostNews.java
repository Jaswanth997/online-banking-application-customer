package com.capgemini.springboot.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "post_news")
public class PostNews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "news_id")
	private int id;
	
	@Column(name= "news_headline")
	@NotNull(message= "please mention news headline")
	private String headline;
	
	@Column(name= "news_details")
	@NotNull(message= "please write some news")
	private String news;
	
	public PostNews() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	

	
	
	
}
