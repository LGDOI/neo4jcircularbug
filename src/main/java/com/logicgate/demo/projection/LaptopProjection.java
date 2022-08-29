package com.logicgate.demo.projection;

import java.util.List;

public interface LaptopProjection {
  String getOs();
  Employee getEmployee();
  Employee getManager();

  interface Employee {
    String getId();
  }

}
