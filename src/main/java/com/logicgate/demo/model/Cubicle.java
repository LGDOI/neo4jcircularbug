package com.logicgate.demo.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node(value = "Cubicle")
public class Cubicle extends Office {

    @Property(value = "width")
    public Double width;

    @Property(value = "length")
    public Double length;

}
