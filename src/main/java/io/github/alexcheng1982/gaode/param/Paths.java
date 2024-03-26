package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Paths implements ParamValue {

  private List<PathsGroup> pathsGroups;

  @Override
  public String toParamValue() {
    if (pathsGroups == null) {
      return "";
    }
    return pathsGroups.stream().map(PathsGroup::toParamValue).collect(
        Collectors.joining("|"));
  }
}
