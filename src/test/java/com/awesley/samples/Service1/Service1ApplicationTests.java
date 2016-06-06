package com.awesley.samples.Service1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;

//import com.jayway.restassured.RestAssured;



import static org.junit.Assert.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import java.io.InputStream;
import java.net.URI;
//import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
//import javax.ws.rs.core.UriBuilder;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Service1Application.class)
@WebIntegrationTest(randomPort = true)
public class Service1ApplicationTests {
	@Value("${local.server.port}") private int port;
	private URI sayHelloUri;
	
	@Before
	public void setUp() throws Exception {
		sayHelloUri = new URI("http://localhost:" + port + "/services/sayhello");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldSayHello() throws Exception 
	{
        WebClient client = WebClient.create(sayHelloUri);
        Response r = client.accept("application/json").get();
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        String value = IOUtils.toString((InputStream)r.getEntity());
        assertEquals("{\"id\":0,\"content\":\"Hello World!!\"}", value);
	}
}
