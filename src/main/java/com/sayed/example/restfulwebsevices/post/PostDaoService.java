package com.sayed.example.restfulwebsevices.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	private static List<Post> posts1 = new ArrayList<>();
	private static List<Post> posts2 = new ArrayList<>();
	private static List<Post> posts3 = new ArrayList<>();
	private static List<List<Post>> postsList = new ArrayList<List<Post>>();

	static {
		posts1.add(new Post(1, "Hi Sayed"));
		posts1.add(new Post(2, "Hi Kamar Whats up"));
		posts1.add(new Post(3, "Hi Ravi Good Morning"));
		postsList.add(posts1);
		posts2.add(new Post(1, "Hi Avi"));
		posts2.add(new Post(2, "Hi Avi Whats up"));
		posts2.add(new Post(3, "Hi Chabi Good Morning"));
		postsList.add(posts2);
		posts3.add(new Post(1, "Hi Sima"));
		posts3.add(new Post(2, "Hi Sima Whats up"));
		posts3.add(new Post(3, "Hi Sima Good Morning"));
		postsList.add(posts3);
	}

	public static List<Post> getAllPostForUser(Integer id) {
		return postsList.get(id - 1);
	}

	public static Post getOnePostForUser(Integer id, Integer pid) {
		List<Post> userPosts = postsList.get(id - 1);

		for (Post post : userPosts) {
			if (post.getId() == pid) {
				return post;
			}
		}

		return null;
	}

	public static Post saveOnePostForUser(Post post, Integer id) {
		List<Post> userPosts = postsList.get(id - 1);

		if (post.getId() == null) {
			post.setId(userPosts.size() + 1);
		}

		userPosts.add(post);

		return post;
	}

}
