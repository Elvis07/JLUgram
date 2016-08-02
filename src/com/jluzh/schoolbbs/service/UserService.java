package com.jluzh.schoolbbs.service;

import com.jluzh.schoolbbs.dao.UserDao;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.utils.SomeUtil;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean userNameIsValid(String userName) {

		if (userDao.getUserByUserName(userName) == null) {
			return true;
		}
		return false;
	}

	public boolean nicknameIsValid(String nickname) {

		if (userDao.getUserByNickname(nickname) == null) {
			return true;
		}
		return false;
	}

	public User backQQuser(String userName) {

		return userDao.getUserByUserName(userName);

	}

	public User backQQuser1(String userid) {

		return userDao.getUserByUserId(userid);

	}

	public void addQInfo2UInfo(User user) {
		userDao.addQInfo2UInfo(user);

	}

	public void regist(User user) {
		userDao.addOrUpdateUser(user);
	}

	public void ModifyPwd(User user) {
		userDao.addOrUpdateUser(user);
	}

	public void updateUinfo(User user) {
		userDao.addOrUpdateUser(user);
	}

	public void updateUserImg(User user) {
		userDao.addOrUpdateUser(user);

	}

	public User login(String uname,String pwd) {
		return userDao.queryUserByUserNamePwd(uname,pwd);
	}
	
	public User login(User user) {
		return userDao.queryUserByUserNamePwd(user);
	}

	public void updateNickname(String userid, String nickname) {
		userDao.modNickname(userid, nickname);
	}

	public void updateGender(String userid, String gender) {
		userDao.modGender(userid, gender);
	}

	public void updateSign(String userid, String sign) {
		userDao.modSign(userid, sign);
	}

	public void uploadImg(String userid, String uerImage) {
		userDao.uploadImg(userid, uerImage);
	}

	public String ImgByUid(String userid) {
		return userDao.ImgByUid(userid);
	}

	public int checkDayByUid(String userid) {
		return userDao.checkDayByUid(userid);
	}

	public void checkIn(String userid, int checkday) {
		userDao.addIntegral(userid, checkday);
	}
}
