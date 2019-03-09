package com.sayed.example.restfulwebsevices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Whats up";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hey json", 2);
	}

	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean helloWorldName(@PathVariable String name) {
		return new HelloWorldBean(name, 2);
	}

	@GetMapping(path = "/hello-world-bean/{name}/{id}")
	public HelloWorldBean helloWorldNameId(@PathVariable String name, @PathVariable Integer id) {
		return new HelloWorldBean(String.format("Hello, %s", name), id);
	}

}
