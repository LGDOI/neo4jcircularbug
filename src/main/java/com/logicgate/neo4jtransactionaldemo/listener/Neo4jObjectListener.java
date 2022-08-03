package com.logicgate.neo4jtransactionaldemo.listener;

import com.logicgate.neo4jtransactionaldemo.model.Neo4jMessage;
import com.logicgate.neo4jtransactionaldemo.service.Neo4jObjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class Neo4jObjectListener {

  private final Neo4jObjectService service;

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  public void logObject(Neo4jMessage message) {
    log.info("Before Lookup: {}", message);

    try {
      var neo4jObject = service.findById(message.getMessageId());
      neo4jObject.ifPresent(it -> log.info("After Lookup: {}", it));
    } catch (Exception e) {
      log.warn("Exception: ", e);
    }



  }
}
