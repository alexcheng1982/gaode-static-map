package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class LabelsGroup implements ParamValue {

  @Default
  private LabelStyle labelStyle = LabelStyle.builder().build();
  private List<GeoLocation> locations;

  @Override
  public String toParamValue() {
    return labelStyle.toParamValue() + ":" +
        locations.stream().map(GeoLocation::toParamValue)
            .collect(Collectors.joining(";"));
  }
}
