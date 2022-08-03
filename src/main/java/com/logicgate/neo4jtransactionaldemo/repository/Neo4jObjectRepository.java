package com.logicgate.neo4jtransactionaldemo.repository;

import com.logicgate.neo4jtransactionaldemo.model.Neo4jObject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jObjectRepository extends Neo4jRepository<Neo4jObject, String> {
}
