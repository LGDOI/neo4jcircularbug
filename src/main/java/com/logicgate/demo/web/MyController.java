package com.logicgate.demo.web;

import com.logicgate.demo.service.GraphException;
import com.logicgate.demo.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/my")
public class MyController {

  private final MyService myService;

  @PostMapping
  public void create(@RequestParam("id") String id) throws GraphException {
    myService.createBoth(id);
  }

}
