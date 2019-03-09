package com.sayed.example.restfulwebsevices.helloworld;

public class HelloWorldBean {

	private String message;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HelloWorldBean(String message, Integer id) {
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
