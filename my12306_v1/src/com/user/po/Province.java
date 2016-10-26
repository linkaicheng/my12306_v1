package com.user.po;

public class Province {
	private Integer id;
	// 省标识
	private String provinceId;
	// 省份名称
	private String province;

	public Province(Integer id, String provinceId, String province) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.province = province;
	}

	public Province() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceId=" + provinceId + ", province=" + province + "]";
	}

}
