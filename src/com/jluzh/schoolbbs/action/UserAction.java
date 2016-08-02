package com.jluzh.schoolbbs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.UserService;
import com.jluzh.schoolbbs.utils.SomeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

public class UserAction extends ActionSupport implements SessionAware,RequestAware {

	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	private static final long serialVersionUID = 1L;

	private String message;// 用户注册校检回传信息/用户id
	private String nameVal;// 注册时的用户名(json) 还有用户账号（qq昵称传来的） 登陆账号
	private String nickVal;// 注册时的昵称(json)
	private String nickname1;// qq获取过来作为昵称的
	private String gender1;// qq获取过来作为性别的
	private String img;// qq获取过来作为头像的
	private String pwd;// 登陆密码
	private String username;
	private String sign;

	private String pwd1;
	private String pwd2;
	private String pwd3;

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public void setPwd3(String pwd3) {
		this.pwd3 = pwd3;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private UserService userService;

	public void setNickVal(String nickVal) {
		this.nickVal = nickVal;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNickname1() {
		return nickname1;
	}

	public void setNickname1(String nickname1) {
		this.nickname1 = nickname1;
	}

	public String getGender1() {
		return gender1;
	}

	public void setGender1(String gender1) {
		this.gender1 = gender1;
	}

	public String getNameVal() {
		return nameVal;
	}

	public String getImg() {
		return img;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNameVal(String nameVal) {
		this.nameVal = nameVal;
	}

	public void setFigureurl_qq_2(String img) {
		this.img = img;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String userQQ() {
		User user1 = new User();
		user1.setUserName(nameVal);
		user1.setUerImage(img);
		user1.setGender(gender1);
		user1.setNickname(nickname1);
		if (userService.userNameIsValid(nameVal)) {
			userService.addQInfo2UInfo(user1);

		}
		return "QQLogin";
	}

	public String userRegist() {

		User user = new User();
		user.setUserName(username);
		user.setPassword(pwd);
		user.setNickname(nickVal);

		if (userService.userNameIsValid(username) && userService.nicknameIsValid(nickVal) && !"".equals(username)
				&& !"".equals(pwd) && !"".equals(nickVal)) {
			userService.regist(user);
			return "SuccessRegist";
		} else {

			return "FailRegist";
		}

	}

	public String userLogin() {
		User user = userService.login(username, pwd);
		if (!"".equals(username) && !"".equals(pwd) && user != null) {
			ActionContext.getContext().getSession().put("user", user);
			return "LoginSuccess";
		} else {
			return "LoginFail";
		}

	}

	public String userShowQQ() {
		User user1 = userService.backQQuser(nameVal);
		if (user1 != null) {
			ActionContext.getContext().getSession().put("user", user1);

		}
		return SUCCESS;
	}

	public String showuserInfo() {

		return "userInfo";

	}

	public String userCancel() {
		ActionContext.getContext().getSession().remove("user");
		return "Cancel";
	}

	public String moduserPwd() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getPassword().equals(pwd1) & !"".equals(pwd1) & !"".equals(pwd2) & !"".equals(pwd3)
				&& pwd2.equals(pwd3)) {
			user.setPassword(pwd3);
			userService.ModifyPwd(user);
			ActionContext.getContext().getSession().remove("user");

			return "moduserPwd";
		} else {
			return "input";
		}
	}

	public void validateModuserPwd() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (!user.getPassword().equals(pwd1)) {
			addFieldError("user", "旧密码不正确！");
		}
		if ("".equals(pwd1)) {
			addFieldError("user", "旧密码不能为空！");
		}
		if ("".equals(pwd2)) {
			addFieldError("user", "新密码不能为空！");
		}
		if ("".equals(pwd3)) {
			addFieldError("user", "确认密码不能为空！");
		}
		if (pwd3.length() < 4 || pwd3.length() > 10) {
			addFieldError("user", "确认密码长度需为4-10！");
		}
		if (pwd2.length() < 4 || pwd3.length() > 10) {
			addFieldError("user", "确认密码长度需为4-10！");
		}
		if (!pwd2.equals(pwd3)) {
			addFieldError("user", "新密码与确认密码不一致");
		}
	}

	public String usermodInfo() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		user.setNickname(nickname1);
		user.setSign(sign);
		user.setGender(gender1);
		userService.updateUinfo(user);
		ActionContext.getContext().getSession().put("user", user);
		return "modInfo";

	}

	public String userOther() {
		User user1 = userService.backQQuser1(message);
		request1.put("other",user1);
		return "Other";
	}

	public String userCheckIn() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		String userid = user.getId() + "";
		if (SomeUtil.getDay() != userService.checkDayByUid(userid)) {
			userService.checkIn(userid, SomeUtil.getDay());
			user = userService.backQQuser1(userid);
			ActionContext.getContext().getSession().put("user", user);
		}
		return "checkIn";
	}

	public String userValidate() {

		if (!userService.userNameIsValid(nameVal)) {
			this.message = "notexist";
			// ActionContext.getContext().getSession().put("user", user1);

		}
		return message;

	}

	public String userNickValidate() {

		if (!userService.nicknameIsValid(nickVal)) {
			this.message = "notexist";
			// ActionContext.getContext().getSession().put("user", user1);

		}
		return message;

	}

	public String userq1() throws IOException {

		response.setContentType("text/html;charset=utf-8");
		try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
		return "qq";

	}

	public String userQsave() throws IOException {

		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;

			if (accessTokenObj.getAccessToken().equals("")) {
				// 我们的网站被CSRF攻击了或者用户取消了授权
				// 做一些数据统计工作
				System.out.print("没有获取到响应参数");
			} else {
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();

				// request.getSession().setAttribute("demo_access_token",
				// accessToken);
				// request.getSession().setAttribute("demo_token_expirein",
				// String.valueOf(tokenExpireIn));

				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();// qq用户对象

				if (userInfoBean.getRet() == 0) {
					User user1 = new User();
					if (userService.userNameIsValid(userInfoBean.getNickname())) {// 账号是否存在过
						user1.setUserName(userInfoBean.getNickname());
						String uimage = userInfoBean.getAvatar().getAvatarURL100().replace("qzapp.qlogo.cn/qzapp",
								"q.qlogo.cn/qqapp");
						user1.setUerImage(uimage);
						user1.setGender(userInfoBean.getGender());
						user1.setNickname(userInfoBean.getNickname());
						userService.addQInfo2UInfo(user1);
					} else {
						user1 = userService.backQQuser(userInfoBean.getNickname());
					}
					ActionContext.getContext().getSession().put("user", user1);
				} else {
					System.out.print(userInfoBean.getMsg());// 获取不到qq用户相关信息

				}

			}
		} catch (QQConnectException e) {
		}
		return "qqq";
	}

	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	Map<String, Object> request1;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request1 = arg0;
	}
	

}
