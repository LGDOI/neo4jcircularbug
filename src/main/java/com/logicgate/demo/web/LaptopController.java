package com.logicgate.demo.web;

import com.logicgate.demo.model.Laptop;
import com.logicgate.demo.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/laptop")
public class LaptopController {

  private final LaptopService laptopService;

  @PostMapping
  public Laptop create(@RequestParam("id") String id) {
    return laptopService.create(id);
  }

  @PatchMapping
  public Laptop update(@RequestParam("id") String id) {
    return laptopService.update(id);
  }
}
