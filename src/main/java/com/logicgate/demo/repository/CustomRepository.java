package com.logicgate.demo.repository;

import com.logicgate.demo.model.Range;

public interface CustomRepository {
  Range saveWithProjection(Range range);
  void deleteAllNodes();
}
