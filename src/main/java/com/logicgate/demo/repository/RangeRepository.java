package com.logicgate.demo.repository;

import com.logicgate.demo.model.Range;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeRepository extends Neo4jRepository<Range, String>, CustomRepository {

}
