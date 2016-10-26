package com.user.po;

public class City {
	private Integer id;
	// 市标示
	private String cityId;
	// 市名称
	private String city;
	// 省份
	private Province province;

	public City(Integer id, String cityId, String city, Province province) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.city = city;
		this.province = province;
	}

	public City() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityId=" + cityId + "]";
	}

}
