package com.logicgate.neo4jtransactionaldemo.repository;

import com.logicgate.neo4jtransactionaldemo.model.Galaxy;
import com.logicgate.neo4jtransactionaldemo.projection.GalaxyProjection;
import lombok.AllArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jOperations;

@AllArgsConstructor
public class CustomRepositoryImpl implements CustomRepository {

  private final Neo4jOperations neo4jOperations;

  public Galaxy saveWithProjection(Galaxy galaxy) {
    neo4jOperations.saveAs(galaxy, GalaxyProjection.class);
    return galaxy;
  }
}
