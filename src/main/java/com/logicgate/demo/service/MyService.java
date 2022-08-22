package com.logicgate.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MyService {

  private final CompanyService companyService;
  private final EmployeeService employeeService;

  public void createBoth(String id) throws GraphException {
    employeeService.create(id);
    companyService.create(id);
  }
}
