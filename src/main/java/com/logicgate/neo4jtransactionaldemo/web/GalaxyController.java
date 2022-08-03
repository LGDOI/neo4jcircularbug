package com.logicgate.neo4jtransactionaldemo.web;

import com.logicgate.neo4jtransactionaldemo.model.Earth;
import com.logicgate.neo4jtransactionaldemo.model.Galaxy;
import com.logicgate.neo4jtransactionaldemo.model.Solar;
import com.logicgate.neo4jtransactionaldemo.service.GalaxyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/galaxy")
public class GalaxyController {

  private final GalaxyService galaxyService;

  @PostMapping
  public Galaxy createObject(@RequestParam("id") String id) {
    var earth = Earth.builder().id("e" + id).mass(5.972).build();
    var solar = Solar.builder().id("s" + id).age(4.571).earth(earth).build();
    return galaxyService.save(Galaxy.builder().id("g" + id).name("Milky Way").solar(solar).build());
  }
}
