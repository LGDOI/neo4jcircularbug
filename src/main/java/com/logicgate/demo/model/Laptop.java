package com.logicgate.demo.model;

import java.util.Objects;
import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Laptop")
public class Laptop {

  @Id
  @Property(name = "id")
  private String id;

  @Property(name = "os")
  private String os;

  @Relationship("ASSIGNED_TO")
  private Employee employee;

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Laptop laptop = (Laptop) o;
    return Objects.equals(id, laptop.id) && Objects.equals(os, laptop.os);
  }

  @Override public int hashCode() {
    return Objects.hash(id, os);
  }

  @Override public String toString() {
    return new StringJoiner(", ", Laptop.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("os='" + os + "'")
        .add("employee=" + employee)
        .toString();
  }

  public void setOs(String os) {
    this.os = os;
  }
}
