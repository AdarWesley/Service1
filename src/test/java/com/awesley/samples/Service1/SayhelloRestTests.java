package com.awesley.samples.Service1;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Service1Application.class)
@WebIntegrationTest(randomPort = true)
public class SayhelloRestTests {
	@Value("${local.server.port}") private int port;
	
	@Before
	public void setUp() {
		RestAssured.port = port;
	}
	
	@Test
	public void shouldSayHello() {
		given()
			.when() 
			.contentType(ContentType.JSON)
			.get("/services/sayhello")
			.then()
			.statusCode(200)
			.log()
			.ifValidationFails();
	}
}
