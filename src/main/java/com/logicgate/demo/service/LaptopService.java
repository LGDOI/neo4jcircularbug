package com.logicgate.demo.service;

import com.logicgate.demo.model.Company;
import com.logicgate.demo.model.Employee;
import com.logicgate.demo.model.Laptop;
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
        .id("E-" + id)
        .name("Dr. Whoo")
        .build();

    var company = Company.builder()
        .id("C-" + id)
        .name("LogicGate")
        .employees(List.of(employee))
        .build();

    employee.setCompany(company);

    var laptop = Laptop.builder()
        .id("L-" + id)
        .os("DOS")
        .employee(employee)
        .build();

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
