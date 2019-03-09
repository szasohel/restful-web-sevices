package com.sayed.example.restfulwebsevices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sayed.example.restfulwebsevices.post.Post;
import com.sayed.example.restfulwebsevices.post.PostDaoService;

@RestController
public class UserController {

	@GetMapping(path = "/users")
	public List<User> getAllUser() {
		return UserDaoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = UserDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}

		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = UserDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getPosts(@PathVariable int id) {
		User user = UserDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		} else {
			return PostDaoService.getAllPostForUser(id);
		}
	}

	@GetMapping(path = "/users/{id}/posts/{pid}")
	public Post getOnePost(@PathVariable int id, @PathVariable int pid) {
		User user = UserDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		} else {
			return PostDaoService.getOnePostForUser(id, pid);
		}
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> saveOnePost(@PathVariable int id, @RequestBody Post post) {
		Post savedPost = PostDaoService.saveOnePostForUser(post, id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
