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
@Node(primaryLabel= "ParkingPass")
public class ParkingPass extends GraphEntity<ParkingPass> {

    @Property(value = "parking_lot_numnber")
    private Integer parkingLotNumber;

    @Relationship(value = "OWNER")
    private Employee employee;

}
