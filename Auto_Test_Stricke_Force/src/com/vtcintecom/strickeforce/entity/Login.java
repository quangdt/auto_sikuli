package com.vtcintecom.strickeforce.entity;

public class Login {
	private double id;
	private String username;
	private String password;
	private String expect;
	private String img_expect;
	private String result1;
	private String result2;

	double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	/**
	 * @return the result1
	 */
	public String getResult1() {
		return result1;
	}

	/**
	 * @param result1
	 *            the result1 to set
	 */
	public void setResult1(String result1) {
		this.result1 = result1;
	}

	/**
	 * @return the result2
	 */
	public String getResult2() {
		return result2;
	}

	/**
	 * @param result2
	 *            the result2 to set
	 */
	public void setResult2(String result2) {
		this.result2 = result2;
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

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getImg_expect() {
		return img_expect;
	}

	public void setImg_expect(String img_expect) {
		this.img_expect = img_expect;
	}

	public Login(int id, String username, String password, String expect, String img_expect) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.expect = expect;
		this.img_expect = img_expect;
	}

	public Login(double id, String username, String password, String expect, String img_expect, String result1,
			String result2) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.expect = expect;
		this.img_expect = img_expect;
		this.result1 = result1;
		this.result2 = result2;
	}

	public Login(Login obj_login) {
		this.id = obj_login.id;
		this.username = obj_login.username;
		this.password = obj_login.password;
		this.expect = obj_login.expect;
		this.img_expect = obj_login.img_expect;
		this.result1 = obj_login.result1;
		this.result2 = obj_login.result2;
	}

	public Login() {
	}

}
