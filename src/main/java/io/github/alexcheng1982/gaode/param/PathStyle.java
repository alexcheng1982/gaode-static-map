package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class PathStyle implements ParamValue {

  @Default
  private int weight = 5;
  @Default
  private String color = "0x0000FF";
  @Default
  private float transparency = 1.0f;
  private String fillcolor;
  @Default
  private float fillTransparency = 0.5f;

  @Override
  public String toParamValue() {
    return ParamValueUtils.build(
        Stream.of(weight, color, transparency, fillcolor, fillcolor));
  }
}
