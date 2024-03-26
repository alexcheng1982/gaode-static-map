package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Labels implements ParamValue {

  private List<LabelsGroup> labelsGroups;

  @Override
  public String toParamValue() {
    if (labelsGroups == null) {
      return "";
    }
    return labelsGroups.stream().map(LabelsGroup::toParamValue)
        .collect(Collectors.joining("|"));
  }
}
