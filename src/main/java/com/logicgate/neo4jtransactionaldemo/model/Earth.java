package com.logicgate.neo4jtransactionaldemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Earth")
public class Earth {

  @Id
  @Property(name = "id")
  private String id;

  @Property(name = "mass")
  private double mass;

}
