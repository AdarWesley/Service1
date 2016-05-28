package com.awesley.samples.Service1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Path("/sayhello")
@Component
public class SayHello {
	
	@GET
	@Produces({"application/json"})
	public Greeting sayHello() {
		Greeting greeting = new Greeting(0, "Hello World!!");
		return greeting;
	}
}
