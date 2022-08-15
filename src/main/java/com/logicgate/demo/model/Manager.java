package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Manager")
public class Manager extends Employee {

    @Relationship(value = "DIRECT_REPORTS")
    private List<Employee> directReports;

}
