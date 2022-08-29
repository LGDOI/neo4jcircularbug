package com.logicgate.demo.service;

import com.logicgate.demo.model.*;
import com.logicgate.demo.model.Syrup.Original;
import com.logicgate.demo.repository.RangeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class RangeService {

  private final RangeRepository rangeRepository;

  public Range create(String id) {

    var syrup = new Syrup.Costco();
    syrup.setName("Costco");
    syrup.setId("syrup" + id);

    var original = new Original();
    original.setName("CostoSyrup");
    original.setId("syrup-org" + id);

    var waffle = Waffle.builder()
        .name("LogicGate")
        .syrups(List.of(syrup))
        .build();

    waffle.setId("waffle" + id);

    syrup.setWaffle(waffle);

    var range = Range.builder()
        .name("Goat")
        .syrup(syrup)
        .original(original)
        .build();

    range.setId("range-" + id);

    return rangeRepository.save(range);
  }

  public Range update(String id) {
    var toUpdate = rangeRepository.findById("range-" + id).orElseThrow();
    log.info("Before > range : {}", toUpdate);

    toUpdate.setName("LogicGate");
    rangeRepository.saveWithProjection(toUpdate);

    log.info("After > range : {}", toUpdate);
    if (toUpdate.getSyrup().getWaffle() == null) {
      throw new IllegalStateException("Waffle is gone " + toUpdate);
    }
    return toUpdate;
  }

  public void deleteAll() {
    rangeRepository.deleteAllNodes();
  }
}
