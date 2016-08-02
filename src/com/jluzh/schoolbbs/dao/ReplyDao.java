package com.jluzh.schoolbbs.dao;

import java.util.List;

import org.hibernate.Transaction;

import com.jluzh.schoolbbs.entities.Reply;

public class ReplyDao extends BaseDao {
	// 获取所有回复
	@SuppressWarnings("unchecked")
	public List<Reply> getAll() {
		String hql = "from Reply";
		return getSession().createQuery(hql).list();

	}

	// 保存回复
	public void save(Reply reply) {
		
		getSession().save(reply);

	}

	// 通过帖子ID找到所有评论
	@SuppressWarnings("unchecked")
	public List<Reply> getbyid(Integer postid) {
		// TODO Auto-generated method stub
		String hql = "from Reply r LEFT OUTER JOIN FETCH r.post LEFT OUTER JOIN FETCH r.user LEFT OUTER JOIN FETCH r.post.plate where r.post.id=?";
		List<Reply> replylist= getSession().createQuery(hql).setInteger(0, postid).list();
		System.out.println(replylist);
		return replylist;
	}

	// 通过用户ID获取所有回复
	@SuppressWarnings("unchecked")
	public List<Reply> getuserbyid(Integer userid) {
		String hql = "from Reply where user.id=?";
		return getSession().createQuery(hql).setInteger(0, userid).list();
	}

	// 通过回复id删除回复
	public void delete(Integer replyId) {
		String hql = "DELETE FROM Reply r WHERE r.id = ?";
		getSession().createQuery(hql).setInteger(0, replyId).executeUpdate();
	}

	// 通过贴子id找到最后回复

	public Reply findlastreplybypostid(Integer postid) {
		String hql = "from Reply where post.id=? order by replytime desc ";
		Reply reply = (Reply) getSession().createQuery(hql).setInteger(0, postid).list().get(0);

		// Hibernate.initialize(reply.getUser());
		return reply;

	}

	// 通过帖子ID找到所有评论 带分页
	public List<Reply> getPageEntity(int beginIndex, int pageSize, int postId) {
		String hql = "from Reply p LEFT OUTER JOIN FETCH p.post LEFT OUTER JOIN FETCH p.user LEFT OUTER JOIN FETCH p.post.plate LEFT OUTER JOIN FETCH p.post.user where p.post.id=? ORDER BY p.replayTime DESC";
		List<Reply> repleyLost = getSession().createQuery(hql).setFirstResult(beginIndex).setMaxResults(pageSize)
				.setInteger(0, postId).list();
		return repleyLost;
	}

	// 获取所有帖子的总数量
	public Object findNum(int postId) {
		String hql = "select count(*) From Reply r where  r.post.id = ?";
		Object count = getSession().createQuery(hql).setInteger(0, postId).uniqueResult();
		return count;
	}

}
