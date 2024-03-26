package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Markers implements ParamValue {

  private List<MarkersGroup> markersGroups;

  @Override
  public String toParamValue() {
    if (markersGroups == null) {
      return "";
    }
    return markersGroups.stream().map(MarkersGroup::toParamValue).collect(
        Collectors.joining("|"));
  }
}
