package com.user.po;

import java.util.Date;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String password2;
	/**
	 * 原密码
	 */
	private String passwordOld;
	// 权限
	private String rule;
	private String realname;
	private String sex;
	private City city;
	// 证件类型
	private CertType certType;
	// 证件 号码
	private String cert;
	private Date birthday;
	// 旅客类型
	private UserType userType;
	// 备注信息
	private String content;
	// 用户状态（0无效 1有效）
	private String status;
	// 登录ip
	private String loginIp;
	private String imagePath;
	//验证码
	private String code;
	//自动登录
	private boolean autoLogin;


	public User() {
		super();
	}

	public User(Integer id, String username, String password, String password2,
			String rule, String realname, String sex, City city,
			CertType certType, String cert, Date birthday, UserType userType,
			String content, String status, String loginIp, String imagePath,
			String code, boolean autoLogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.rule = rule;
		this.realname = realname;
		this.sex = sex;
		this.city = city;
		this.certType = certType;
		this.cert = cert;
		this.birthday = birthday;
		this.userType = userType;
		this.content = content;
		this.status = status;
		this.loginIp = loginIp;
		this.imagePath = imagePath;
		this.code = code;
		this.autoLogin = autoLogin;
	}

	public User(Integer id, String username, String password, String password2,
			String passwordOld, String rule, String realname, String sex,
			City city, CertType certType, String cert, Date birthday,
			UserType userType, String content, String status, String loginIp,
			String imagePath, String code, boolean autoLogin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.passwordOld = passwordOld;
		this.rule = rule;
		this.realname = realname;
		this.sex = sex;
		this.city = city;
		this.certType = certType;
		this.cert = cert;
		this.birthday = birthday;
		this.userType = userType;
		this.content = content;
		this.status = status;
		this.loginIp = loginIp;
		this.imagePath = imagePath;
		this.code = code;
		this.autoLogin = autoLogin;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(boolean autoLogin) {
		this.autoLogin = autoLogin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public CertType getCertType() {
		return certType;
	}

	public void setCertType(CertType certType) {
		this.certType = certType;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", password2=" + password2 + ", passwordOld="
				+ passwordOld + ", rule=" + rule + ", realname=" + realname
				+ ", sex=" + sex + ", city=" + city + ", certType=" + certType
				+ ", cert=" + cert + ", birthday=" + birthday + ", userType="
				+ userType + ", content=" + content + ", status=" + status
				+ ", loginIp=" + loginIp + ", imagePath=" + imagePath
				+ ", code=" + code + ", autoLogin=" + autoLogin + "]";
	}

}
