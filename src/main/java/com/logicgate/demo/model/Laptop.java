package com.logicgate.demo.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Laptop")
public class Laptop extends GraphEntity<Laptop> {

  @Property(name = "os")
  private String os;

  @Relationship("ASSIGNED_TO")
  private Employee employee;

  @Relationship("IS_INSTALLED")
  private List<Software> softwareList;

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Laptop laptop = (Laptop) o;
    return Objects.equals(getId(), laptop.getId()) && Objects.equals(os, laptop.os);
  }

  @Override public int hashCode() {
    return Objects.hash(getId(), os);
  }

  @Override public String toString() {
    return new StringJoiner(", ", Laptop.class.getSimpleName() + "[", "]")
        .add("id='" + getId() + "'")
        .add("os='" + os + "'")
        .add("employee=" + employee)
        .toString();
  }

  public void setOs(String os) {
    this.os = os;
  }
}
