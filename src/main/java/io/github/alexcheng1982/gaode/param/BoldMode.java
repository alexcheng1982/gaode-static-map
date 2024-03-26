package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;

public enum BoldMode implements ParamValue {
  OFF("0"),
  ON("1");
  private final String value;

  BoldMode(String value) {
    this.value = value;
  }

  @Override
  public String toParamValue() {
    return this.value;
  }
}
