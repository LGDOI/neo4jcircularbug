package com.logicgate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

// Record
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Laptop")
public class Range extends GraphEntity<Range> {

  @Property(name = "name")
  private String name;

  // Step.Chain : step
  @Relationship("IS_ON")
  private Syrup syrup;

  // Step.Origin : origin
  @Relationship("CREATED_ON")
  private Syrup original;

  @JsonIgnore
  @Relationship(type = "HAS_CHILD")
  private List<Range> ranges = new ArrayList<>();

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Range range = (Range) o;
    return Objects.equals(getId(), range.getId()) && Objects.equals(name, range.name);
  }

  @Override public int hashCode() {
    return Objects.hash(getId(), name);
  }

  @Override public String toString() {
    return new StringJoiner(", ", Range.class.getSimpleName() + "[", "]")
        .add("id='" + getId() + "'")
        .add("name='" + name + "'")
        .add("syrup=" + syrup)
        .add("original=" + original)
        .toString();
  }
}
