package com.logicgate.neo4jtransactionaldemo.web;

import com.logicgate.neo4jtransactionaldemo.model.Neo4jObject;
import com.logicgate.neo4jtransactionaldemo.service.Neo4jObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/object")
public class Neo4jObjectController {

  private final Neo4jObjectService service;

  @PostMapping
  public Neo4jObject createObject(@RequestParam("id") String id) {
    return service.save(id);
  }
}
