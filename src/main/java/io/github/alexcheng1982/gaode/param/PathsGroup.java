package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class PathsGroup implements ParamValue {

  @Default
  private PathStyle pathStyle = PathStyle.builder().build();
  private List<GeoLocation> locations;

  @Override
  public String toParamValue() {
    return pathStyle.toParamValue() + ":" +
        locations.stream().map(GeoLocation::toParamValue)
            .collect(Collectors.joining(";"));
  }
}
