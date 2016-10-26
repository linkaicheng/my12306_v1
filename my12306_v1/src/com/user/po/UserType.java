package com.user.po;

public class UserType {
	private Integer id;
	//
	private String content;

	public UserType(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public UserType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "UserType [id=" + id + ", content=" + content + "]";
	}

}
