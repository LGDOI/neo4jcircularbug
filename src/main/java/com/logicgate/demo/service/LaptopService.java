package com.logicgate.demo.service;

import com.logicgate.demo.model.*;
import com.logicgate.demo.repository.LaptopRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class LaptopService {

  private final LaptopRepository laptopRepository;

  public Laptop create(String id) {
    var employee = Employee.builder()
        .name("Dr. Whoo")
        .build();

    employee.setId("E" + id);

    var company = Company.builder()
        .name("LogicGate")
        .employees(List.of(employee))
        .build();

    company.setId("C" + id);

    employee.setCompany(company);

    var laptop = Laptop.builder()
        .os("DOS")
        .employee(employee)
        .build();

    laptop.setId("L" + id);

    var software = Software.builder()
            .softwareName("Risk Cloud")
            .manufacturer("Logicgate")
            .laptop(List.of(laptop))
            .build();

    software.setId("Software" + id);
    laptop.setSoftwareList(List.of(software));

    return laptopRepository.save(laptop);
  }

  public Laptop update(String id) {
    var toUpdate = laptopRepository.findById("L-" + id).orElseThrow();
    log.info("Before > laptop : {}", toUpdate);

    toUpdate.setOs("UNIX");
    laptopRepository.saveWithProjection(toUpdate);

    log.info("After > laptop : {}", toUpdate);
    if (toUpdate.getEmployee().getCompany() == null) {
      throw new IllegalStateException("Company is gone " + toUpdate);
    }
    return toUpdate;
  }
}
