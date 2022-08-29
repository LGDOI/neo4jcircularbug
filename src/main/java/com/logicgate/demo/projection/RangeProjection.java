package com.logicgate.demo.projection;

import com.logicgate.demo.model.Syrup;

public interface RangeProjection {
  String getName();

  Syrup getSyrup();

  Syrup getOriginal();

  interface Employee {
    String getId();
  }

}
