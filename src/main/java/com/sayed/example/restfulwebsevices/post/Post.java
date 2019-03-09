package com.sayed.example.restfulwebsevices.post;

public class Post {
	private Integer id;
	private String post;

	public Post(Integer id, String post) {
		super();
		this.id = id;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}
