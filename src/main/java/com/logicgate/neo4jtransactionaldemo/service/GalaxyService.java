package com.logicgate.neo4jtransactionaldemo.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import com.logicgate.neo4jtransactionaldemo.model.Galaxy;
import com.logicgate.neo4jtransactionaldemo.model.Neo4jMessage;
import com.logicgate.neo4jtransactionaldemo.model.Neo4jObject;
import com.logicgate.neo4jtransactionaldemo.repository.GalaxyRepository;
import com.logicgate.neo4jtransactionaldemo.repository.Neo4jObjectRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class GalaxyService {

  private final GalaxyRepository galaxyRepository;

  public Galaxy save(Galaxy galaxy) {
    log.info("Before > Galaxy : {}", galaxy);
    galaxyRepository.saveWithProjection(galaxy);
    log.info("After > Galaxy : {}", galaxy);
    if (galaxy.getSolar().getEarth() == null) {
      log.error("Earth is gone");
    }
    return galaxy;
  }
}
