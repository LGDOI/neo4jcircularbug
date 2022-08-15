package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class GraphEntity<T extends GraphEntity> {
    @Id
    @Property(name = "id")
    private String id;
}
