package com.jluzh.schoolbbs.service;

import java.util.List;

import org.hibernate.Hibernate;

import com.jluzh.schoolbbs.dao.NewsManagerDao;
import com.jluzh.schoolbbs.entities.News;

public class NewsManagerService {
	private NewsManagerDao newsManagerDao;
	public void setNewsManagerDao(NewsManagerDao newsManagerDao) {
		this.newsManagerDao = newsManagerDao;
	}
public List<News> getPageEntity(int beginIndex, int pageSize) {
		
		return newsManagerDao.getPageEntity(beginIndex,pageSize);
	}
	public Object getCount() {
		return newsManagerDao.getCount();
	}
	public void delete(Integer id) {
		News news = newsManagerDao.get(id);
		if(news != null )
			newsManagerDao.delete(news);
	}
	public void saveOrUpdate(News news) {
		newsManagerDao.saveOrUpdate(news);
	}
	public News get(Integer id) {
		News news= newsManagerDao.get(id);
	
			Hibernate.initialize(news.getAdmin());
		
		return news;
	}
	public List<News> get8News() {
		return newsManagerDao.get8News();
	}
	public News findNewsDetail(Integer id) {

		return newsManagerDao.findNewsDetail(id);
	}
	
}
