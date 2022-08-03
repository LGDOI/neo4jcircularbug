package com.logicgate.neo4jtransactionaldemo.repository;

import com.logicgate.neo4jtransactionaldemo.model.Galaxy;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalaxyRepository extends Neo4jRepository<Galaxy, String>, CustomRepository {

}
