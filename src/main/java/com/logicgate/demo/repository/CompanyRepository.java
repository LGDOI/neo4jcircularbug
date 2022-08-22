package com.logicgate.demo.repository;

import com.logicgate.demo.model.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends Neo4jRepository<Company, String> {

}
