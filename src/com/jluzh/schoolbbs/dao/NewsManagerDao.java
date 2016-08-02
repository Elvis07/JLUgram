package com.jluzh.schoolbbs.dao;

import java.util.List;

import com.jluzh.schoolbbs.entities.News;

public class NewsManagerDao extends BaseDao {
	public List<News> getPageEntity(int beginIndex, int pageSize) {
		String hql = "From News n LEFT OUTER JOIN FETCH n.admin ORDER BY n.launchTime DESC";
		List<News> list = (List<News>) getSession().createQuery(hql).setFirstResult(beginIndex).setMaxResults(pageSize).list();
		
 		
		return list;
	}

	public Object getCount() {
		String hql = "select count(*) from News";
		Object count = getSession().createQuery(hql).uniqueResult();
		return count;
	}

	public void delete(News news) {
		 getSession().delete(news);
	}
	
	public News get(Integer id){
		return (News) getSession().get(News.class,id);
				
	}

	public void saveOrUpdate(News news) {
		getSession().saveOrUpdate(news);
	}

	public List<News> get8News() {
		String hql = "From News n LEFT OUTER JOIN FETCH n.admin ORDER BY n.launchTime DESC";
		List<News> list = (List<News>) getSession().createQuery(hql).setFirstResult(0).setMaxResults(8).list();

		return list;
	}

	public News findNewsDetail(Integer id) {
		String hql = "From News n LEFT OUTER JOIN FETCH n.admin where n.id = ?";
		News news = (News) getSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return news;
	}

	
}
