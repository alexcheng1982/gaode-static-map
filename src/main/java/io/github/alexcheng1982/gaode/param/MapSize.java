package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import lombok.Value;

@Value
public class MapSize implements ParamValue {

  private int width;
  private int height;

  @Override
  public String toParamValue() {
    return width + "*" + height;
  }
}
