package com.logicgate.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "Software")
public class Software extends GraphEntity<Software> {

    @Property(value = "manufacturer")
    private String manufacturer;

    @Property(value = "softwareName")
    private String softwareName;

    @JsonIgnore
    @Relationship(value = "INSTALLED_ON")
    private List<Range> range;

}
