package com.logicgate.demo.projection;

public interface LaptopProjection {
  String getOs();
  Employee getEmployee();

  interface Employee {
    String getId();
  }
}
