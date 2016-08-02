package com.jluzh.schoolbbs.entities;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String password="mimabugeikan";//出于qq登陆安全原因
	private String gender="男";
	private String nickname="昵称1";
	private String uerImage="avatar/default.jpg";
	private String sign="这是个性签名，可以修改一波";
	private int checkDay;
	private int witchModerator;
	private int Integral;

	public int getCheckDay() {
		return checkDay;
	}

	public void setCheckDay(int checkDay) {
		this.checkDay = checkDay;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUerImage() {
		return uerImage;
	}

	public void setUerImage(String uerImage) {
		this.uerImage = uerImage;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getWitchModerator() {
		return witchModerator;
	}

	public void setWitchModerator(int witchModerator) {
		this.witchModerator = witchModerator;
	}

	public int getIntegral() {
		return Integral;
	}

	public void setIntegral(int integral) {
		Integral = integral;
	}

}
