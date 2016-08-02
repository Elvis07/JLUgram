package com.jluzh.schoolbbs.dao;

import java.util.List;

import org.hibernate.Query;

import com.jluzh.schoolbbs.entities.User;

public class UserDao extends BaseDao {

	public User getUserByUserName(String userName) {
		String hql = "FROM User u WHERE u.userName = ?";

		Query query = getSession().createQuery(hql).setString(0, userName);
		return (User) query.uniqueResult();
	}

	public User getUserByNickname(String nickname) {
		String hql = "FROM User u WHERE u.nickname = ?";

		Query query = getSession().createQuery(hql).setString(0, nickname);
		return (User) query.uniqueResult();
	}

	public User getUserByUserId(String userid) {
		String hql = "FROM User u WHERE u.id = ?";

		Query query = getSession().createQuery(hql).setString(0, userid);
		return (User) query.uniqueResult();
	}

	public void addOrUpdateUser(User user) {
		getSession().saveOrUpdate(user);
	}

	public User queryUserByUserNamePwd(String uname,String pwd) {
		Query query = getSession().createQuery("from User u " + "where u.userName=? and u.password=? ");
		query.setParameter(0, uname);
		query.setParameter(1, pwd);
		return (User) query.uniqueResult();
	}
	
	public User queryUserByUserNamePwd(User user) {
		Query query = getSession().createQuery("from User u " + "where u.userName=? and u.password=? ");
		query.setParameter(0, user.getUserName());
		query.setParameter(1, user.getPassword());
		return (User) query.uniqueResult();
	}

	public void addQInfo2UInfo(User user) {
		{
			getSession().save(user);

		}
	}

	public void modNickname(String userid, String nickname) {

		Query query = getSession().createQuery("update User u set u.nickname='" + nickname + "' where u.id=" + userid);
		query.executeUpdate();
	}

	public void modGender(String userid, String gender) {
		Query query = getSession().createQuery("update User u set u.gender='" + gender + "' where u.id=" + userid);
		query.executeUpdate();
	}

	public void modSign(String userid, String sign) {
		Query query = getSession().createQuery("update User u set u.sign='" + sign + "' where u.id=" + userid);
		query.executeUpdate();
	}

	public void uploadImg(String userid, String uerImage) {
		Query query = getSession().createQuery("update User u set u.uerImage='" + uerImage + "' where u.id=" + userid);
		query.executeUpdate();
	}

	public String ImgByUid(String userid) {
		Query query = getSession().createQuery("from User u where u.id=" + userid);
		String Imgpath = null;
		List<User> lists = query.list();
		for (User user : lists) {
			Imgpath = user.getUerImage();
		}
		return Imgpath;
	}

	public int checkDayByUid(String userid) {
		Query query = getSession().createQuery("from User u where u.id=" + userid);
		int checkDay = 0;
		List<User> lists = query.list();
		for (User user : lists) {
			checkDay = user.getCheckDay();
		}
		return checkDay;
	}

	public void addIntegral(String userid, int checkday) {
		Query query = getSession().createQuery(
				"update User u set u.Integral=u.Integral+5,u.checkDay=" + checkday + " where u.id=" + userid);
		query.executeUpdate();
	}

}
