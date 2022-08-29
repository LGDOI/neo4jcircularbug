package com.logicgate.demo.model;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

import java.util.Objects;
import java.util.StringJoiner;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Employee")
public class Syrup extends GraphEntity<Syrup> {

  @Property(name = "name")
  private String name;

  // Workflow
  @Relationship(value = "CONTAINS", direction = INCOMING)
  private Waffle waffle;

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Syrup syrup = (Syrup) o;
    return Objects.equals(getId(), syrup.getId()) && Objects.equals(name, syrup.name);
  }

  @Override public int hashCode() {
    return Objects.hash(getId(), name);
  }

  @Override public String toString() {
    return new StringJoiner(", ", Syrup.class.getSimpleName() + "[", "]")
        .add("id='" + getId() + "'")
        .add("name='" + name + "'")
        .add("company=" + waffle)
        .toString();
  }

  public void setWaffle(Waffle waffle) {
    this.waffle = waffle;
  }
}
