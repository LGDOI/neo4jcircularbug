package com.logicgate.neo4jtransactionaldemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Galaxy")
public class Galaxy {

  @Id
  @Property(name = "id")
  private String id;

  @Property(name = "name")
  private String name;

  @Relationship("CONTAINS_SOLAR")
  private Solar solar;
}
