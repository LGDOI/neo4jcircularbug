package com.logicgate.demo.web;

import com.logicgate.demo.model.Range;
import com.logicgate.demo.service.RangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/range")
public class RangeController {

  private final RangeService rangeService;

  @PostMapping
  public Range create(@RequestParam("id") String id) {
    return rangeService.create(id);
  }

  @PatchMapping
  public Range update(@RequestParam("id") String id) {
    return rangeService.update(id);
  }

  @DeleteMapping
  public void deleteAll() {
    rangeService.deleteAll();
  }
}
