package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "FancyDesk")
public class FancyDesk extends GraphEntity<FancyDesk> {

    @Relationship(value = "STORED_AT")
    public PrivateOffice privateOffice;

}
