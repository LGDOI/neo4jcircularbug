package com.logicgate.neo4jtransactionaldemo.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import com.logicgate.neo4jtransactionaldemo.model.Neo4jMessage;
import com.logicgate.neo4jtransactionaldemo.model.Neo4jObject;
import com.logicgate.neo4jtransactionaldemo.repository.Neo4jObjectRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=REQUIRES_NEW)
@AllArgsConstructor
public class Neo4jObjectService {

  private final Neo4jObjectRepository neo4jObjectRepository;
  private final ApplicationEventPublisher publisher;

  public Optional<Neo4jObject> findById(String id) {
    return neo4jObjectRepository.findById(id);
  }

  public Neo4jObject save(String id) {
    var saved = neo4jObjectRepository.save(new Neo4jObject(id));
    publisher.publishEvent(new Neo4jMessage(id));
    return saved;
  }
}
