package com.logicgate.neo4jtransactionaldemo.repository;

import com.logicgate.neo4jtransactionaldemo.model.Galaxy;

public interface CustomRepository {
  Galaxy saveWithProjection(Galaxy galaxy);
}
