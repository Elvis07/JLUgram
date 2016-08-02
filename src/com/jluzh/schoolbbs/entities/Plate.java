package com.jluzh.schoolbbs.entities;

import java.io.Serializable;

public class Plate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	// 增加属性
	private Integer postsCount;

	public Integer getPostsCount() {
		return postsCount;
	}

	public void setPostsCount(Integer postsCount) {
		this.postsCount = postsCount;
	}

	private String palteName;
	private String plateDesc;
	private String plateImage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPalteName() {
		return palteName;
	}

	public void setPalteName(String palteName) {
		this.palteName = palteName;
	}

	public String getPlateDesc() {
		return plateDesc;
	}

	public void setPlateDesc(String plateDesc) {
		this.plateDesc = plateDesc;
	}

	public String getPlateImage() {
		return plateImage;
	}

	public void setPlateImage(String plateImage) {
		this.plateImage = plateImage;
	}

}
