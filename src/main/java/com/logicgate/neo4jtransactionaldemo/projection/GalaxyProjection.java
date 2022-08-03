package com.logicgate.neo4jtransactionaldemo.projection;

public interface GalaxyProjection {
  Solar getSolar();

  interface Solar {
    String getId();
  }
}
