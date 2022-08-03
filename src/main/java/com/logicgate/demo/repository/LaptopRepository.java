package com.logicgate.demo.repository;

import com.logicgate.demo.model.Laptop;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends Neo4jRepository<Laptop, String>, CustomRepository {

}
