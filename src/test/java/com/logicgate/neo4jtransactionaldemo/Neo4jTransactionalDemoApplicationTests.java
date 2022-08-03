package com.logicgate.neo4jtransactionaldemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Neo4jTransactionalDemoApplication.class)
@ContextConfiguration(classes = Neo4jTransactionalDemoApplication.class)
class Neo4jTransactionalDemoApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testPostEndpoint() throws Exception {
    mockMvc.perform(post("/api/object?id=1")).andExpect(status().isOk());
  }
}
