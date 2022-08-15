package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "PrivateOffice")
public class PrivateOffice extends Office{

    @Property(value = "square_footage")
    public Double squareFootage;

    @Relationship(value = "HAS_FANCY_DESK")
    public FancyDesk fancyDesk;

}
