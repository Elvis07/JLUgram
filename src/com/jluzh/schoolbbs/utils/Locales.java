package com.jluzh.schoolbbs.utils;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Locales {

	private Locale current;

	public void setCurrent(Locale cur) {
		this.current = cur;
	}

	public Map<String, Locale> getLocales() {

		Map<String, Locale> locales = new Hashtable<String, Locale>();
		ResourceBundle bundle = ResourceBundle.getBundle("mess", current);

		locales.put(bundle.getString("enus"), Locale.US);
		locales.put(bundle.getString("zhcn"), Locale.CHINA);
		return locales;
	}
}
