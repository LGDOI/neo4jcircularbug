package com.logicgate.demo.repository;

import com.logicgate.demo.model.Laptop;
import com.logicgate.demo.projection.LaptopProjection;
import lombok.AllArgsConstructor;
import org.springframework.data.neo4j.core.Neo4jOperations;

@AllArgsConstructor
public class CustomRepositoryImpl implements CustomRepository {

  private final Neo4jOperations neo4jOperations;

  public Laptop saveWithProjection(Laptop laptop) {
    neo4jOperations.saveAs(laptop, LaptopProjection.class);
    return laptop;
  }
}
