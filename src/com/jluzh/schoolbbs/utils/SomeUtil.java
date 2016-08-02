package com.jluzh.schoolbbs.utils;

import java.util.Calendar;

public class SomeUtil {
	
	public static int getDay() {
		Calendar ca = Calendar.getInstance();
		int day = ca.get(Calendar.DATE);// 获取日
		return day;

	}
}
