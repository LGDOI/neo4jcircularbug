package com.logicgate.demo.model;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

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
@Node(primaryLabel = "Employee")
public class Employee extends GraphEntity<Employee> {

  @Property(name = "name")
  private String name;

  @Relationship(value = "EMPLOY", direction = INCOMING)
  private Company company;

  @Relationship(value = "HAS_PARKING_PASS")
  private ParkingPass parkingPass;

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(getId(), employee.getId()) && Objects.equals(name, employee.name);
  }

  @Override public int hashCode() {
    return Objects.hash(getId(), name);
  }

  @Override public String toString() {
    return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
        .add("id='" + getId() + "'")
        .add("name='" + name + "'")
        .add("company=" + company)
        .toString();
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}
