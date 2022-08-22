package com.logicgate.demo.service;

import com.logicgate.demo.model.Employee;
import com.logicgate.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public Employee create(String id) {
    var employee = Employee.builder()
        .name("Dr. Whoo")
        .build();

    employee.setId(id);
    return employeeRepository.save(employee);
  }
}
