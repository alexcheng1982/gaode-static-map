package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;

public enum TrafficMode implements ParamValue {
  ON("1"),
  OFF("0"),
  ;

  private final String value;

  TrafficMode(String value) {
    this.value = value;
  }

  @Override
  public String toParamValue() {
    return this.value;
  }
}
