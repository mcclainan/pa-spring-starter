package com.galvanize.tmo.paspringstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PaSpringStarterApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void isHealthy() throws Exception {
		mockMvc.perform(get("/health"))
				.andExpect(status().isOk());
	}
	
	@Test
	void testEndPoints() throws Exception{
		String body ="{\"author\": \"Douglas Adams\",\"title\": \"The Hitchhiker's Guide to the Galaxy\",\"yearPublished\": 1979}";
		mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON).content(body))
		.andExpect(status().isCreated())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.author").value("Douglas Adams"))
		.andExpect(jsonPath("$.title").value("The Hitchhiker's Guide to the Galaxy"))
		.andExpect(jsonPath("$.yearPublished").value("1979")
		);
	 
		body ="{\"author\": \"Philip K. Dick\",\"title\": \"Do Androids Dream of Electric Sheep?\",\"yearPublished\": 1968}";
		mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON).content(body))
		.andExpect(status().isCreated());
		
		body ="{\"author\": \"William Gibson\",\"title\": \"Neuromancer\",\"yearPublished\": 1984}";
		mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON).content(body))
		.andExpect(status().isCreated());
		
		
		mockMvc.perform(get("/api/books"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.books.[0].title").value("Do Androids Dream of Electric Sheep?"))
		.andExpect(jsonPath("$.books.[1].title").value("Neuromancer"))
		.andExpect(jsonPath("$.books.[2].title").value("The Hitchhiker's Guide to the Galaxy"));
 
	
		mockMvc.perform(delete("/api/books"))
		.andExpect(status().isNoContent());
	}
}
