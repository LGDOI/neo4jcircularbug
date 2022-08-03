package com.logicgate.demo.repository;

import com.logicgate.demo.model.Laptop;

public interface CustomRepository {
  Laptop saveWithProjection(Laptop laptop);
}
