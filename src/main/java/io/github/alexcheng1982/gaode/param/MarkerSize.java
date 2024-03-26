package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;

public enum MarkerSize implements ParamValue {
  SMALL("small"),
  MEDIUM("mid"),
  LARGE("large"),
  ;
  private final String size;

  MarkerSize(String size) {
    this.size = size;
  }

  @Override
  public String toParamValue() {
    return this.size;
  }
}
