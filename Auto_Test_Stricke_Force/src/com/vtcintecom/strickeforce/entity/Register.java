package com.vtcintecom.strickeforce.entity;

public class Register {
	private double id;
	private String username;
	private String password;
	private String confirm_pass;
	private String expect;
	private String img_expect;
	private String result1;
	private String result2;

	public Register() {
	}

	public Register(double id, String username, String password, String confirm_pass, String expect,
			String img_expect) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirm_pass = confirm_pass;
		this.expect = expect;
		this.img_expect = img_expect;
	}

	public Register(double id, String username, String password, String confirm_pass, String expect, String img_expect,
			String result1, String result2) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirm_pass = confirm_pass;
		this.expect = expect;
		this.img_expect = img_expect;
		this.result1 = result1;
		this.result2 = result2;
	}

	public Register(Register obj) {
		super();
		this.id = obj.id;
		this.username = obj.username;
		this.password = obj.password;
		this.confirm_pass = obj.confirm_pass;
		this.expect = obj.expect;
		this.img_expect = obj.img_expect;
		this.result1 = obj.result1;
		this.result2 = obj.result2;
	}

	/**
	 * @return the id
	 */
	public double getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(double id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirm_pass
	 */
	public String getConfirm_pass() {
		return confirm_pass;
	}

	/**
	 * @param confirm_pass
	 *            the confirm_pass to set
	 */
	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}

	/**
	 * @return the expect
	 */
	public String getExpect() {
		return expect;
	}

	/**
	 * @param expect
	 *            the expect to set
	 */
	public void setExpect(String expect) {
		this.expect = expect;
	}

	/**
	 * @return the img_expect
	 */
	public String getImg_expect() {
		return img_expect;
	}

	/**
	 * @param img_expect
	 *            the img_expect to set
	 */
	public void setImg_expect(String img_expect) {
		this.img_expect = img_expect;
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

}
