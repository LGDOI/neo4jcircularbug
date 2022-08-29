package com.logicgate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Company")
public class Waffle extends GraphEntity<Waffle> {

  @Property(name = "name")
  private String name;

  @JsonIgnore
  @Relationship("CONTAINS")
  private List<Syrup> syrups;

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Waffle waffle = (Waffle) o;
    return Objects.equals(getId(), waffle.getId()) && Objects.equals(name, waffle.name);
  }

  @Override public int hashCode() {
    return Objects.hash(getId(), name);
  }

  @Override public String toString() {
    return new StringJoiner(", ", Waffle.class.getSimpleName() + "[", "]")
        .add("id='" + getId() + "'")
        .add("name='" + name + "'")
        .toString();
  }
}
