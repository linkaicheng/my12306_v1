package com.user.po;

public class CertType {
	private Integer id;
	// 证件类型
	private String content;

	public CertType(Integer id, String contentString) {
		super();
		this.id = id;
		this.content = contentString;
	}

	public CertType() {
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

	public void setContent(String contentString) {
		this.content = contentString;
	}

	@Override
	public String toString() {
		return "CertType [id=" + id + ", contentString=" + content + "]";
	}

}
