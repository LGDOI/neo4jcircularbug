package com.logicgate.neo4jtransactionaldemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Neo4jObject")
public class Neo4jObject {

  @Id
  @Property(name = "id")
  private String id;
}
