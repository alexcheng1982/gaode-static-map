package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class MarkerStyle implements ParamValue {

  private MarkerSize size;
  @Default
  private String color = "0xFC6054";
  private String label;

  @Override
  public String toParamValue() {
    return ParamValueUtils.build(Stream.of(size, color, label));
  }
}
