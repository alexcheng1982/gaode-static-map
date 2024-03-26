package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;

public enum MapScaleMode implements ParamValue {
  NORMAL("1"),
  HIGH_RES("2"),
  ;

  private final String value;

  MapScaleMode(String value) {
    this.value = value;
  }

  @Override
  public String toParamValue() {
    return this.value;
  }
}
