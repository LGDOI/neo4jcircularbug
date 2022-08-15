package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(primaryLabel = "DeskLamp")
public class DeskLamp extends GraphEntity<DeskLamp> {

    @Property(value = "brightness")
    private Double brightness;

    @Relationship(value = "AT_DESK")
    private FancyDesk fancyDesk;

}
