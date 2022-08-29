package com.logicgate.demo.projection;

import com.logicgate.demo.model.Syrup;
import java.util.List;

public interface RangeProjection {
  String getName();

  Syrup getSyrup();

  Syrup getOriginal();

  List<Range> getLinkedRanges();

  interface Employee {
    String getId();
  }

  interface Range {
    String getId();
  }
}
