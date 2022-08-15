package com.logicgate.demo.projection;

import java.util.List;

public interface LaptopProjection {
  String getOs();
  Employee getEmployee();
  List<Software> getSoftware();

  interface Employee {
    String getId();
  }

  interface Software {
    String getId();
  }

}
