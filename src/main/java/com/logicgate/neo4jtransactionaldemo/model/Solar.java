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
@Node(primaryLabel = "Solar")
public class Solar {

  @Id
  @Property(name = "id")
  private String id;

  @Property(name = "age")
  private double age;

  @Relationship("CONTAINS_EARTH")
  private Earth earth;
}
