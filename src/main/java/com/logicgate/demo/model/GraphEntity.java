package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class GraphEntity<T extends GraphEntity<T>> {
    @Id
    @Property(name = "id")
    protected String id;
}
