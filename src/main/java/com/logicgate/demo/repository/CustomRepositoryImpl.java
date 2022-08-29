package com.logicgate.demo.repository;

import com.logicgate.demo.model.Range;
import com.logicgate.demo.projection.RangeProjection;
import lombok.AllArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jOperations;

@AllArgsConstructor
public class CustomRepositoryImpl implements CustomRepository {

  private final Neo4jOperations neo4jOperations;
  private final Neo4jClient client;

  public Range saveWithProjection(Range range) {
    neo4jOperations.saveAs(range, RangeProjection.class);
    return range;
  }

  public void deleteAllNodes() {
    client.query("match (n) detach delete n;");
  }
}
