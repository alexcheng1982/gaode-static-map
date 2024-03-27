package io.github.alexcheng1982.gaode.param;

import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class LabelsGroup implements Group<LabelStyle> {

  @Default
  private LabelStyle style = LabelStyle.builder().build();
  private List<GeoLocation> locations;

}
