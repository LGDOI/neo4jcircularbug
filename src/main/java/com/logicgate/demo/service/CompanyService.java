package com.logicgate.demo.service;

import com.logicgate.demo.model.Company;
import com.logicgate.demo.model.Employee;
import com.logicgate.demo.repository.CompanyRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CompanyService {

  private final CompanyRepository companyRepository;

  public Company create(String id) throws GraphException {
    if (id.equals("checked")) {
      throw new GraphException();
    } else if (id.equals("unchecked")) {
      throw new LogicGateException();
    }
    var company = Company.builder()
        .name("LogicGate")
        .build();

    company.setId(id);
    return companyRepository.save(company);
  }

}
