package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
public class MapSize implements ParamValue {

  int width;
  int height;

  public static MapSize DEFAULT = new MapSize(400, 400);
  public static MapSize MAXIMUM = new MapSize(1024, 1024);

  @Override
  public String toParamValue() {
    return width + "*" + height;
  }
}
