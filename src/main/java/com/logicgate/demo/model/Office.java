package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Node(primaryLabel= "Office")
public class Office extends GraphEntity<Office> {

    @Property(value = "office_number")
    public Integer officeNumber;

    @Relationship(value = "OWNED_BY")
    public Employee employee;

}
