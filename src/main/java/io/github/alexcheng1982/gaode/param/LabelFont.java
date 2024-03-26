package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;

public enum LabelFont implements ParamValue {
  MS_YAHEI("0"),
  SONG_TI("1"),
  TIMES_NEW_ROMAN("2"),
  HELVETICA("3");
  private final String fontValue;

  LabelFont(String fontValue) {
    this.fontValue = fontValue;
  }

  @Override
  public String toParamValue() {
    return this.fontValue;
  }
}
