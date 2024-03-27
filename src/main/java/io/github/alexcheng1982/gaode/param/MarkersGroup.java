package io.github.alexcheng1982.gaode.param;

import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class MarkersGroup implements Group<MarkerStyle> {

  @Default
  private MarkerStyle style = MarkerStyle.builder().build();
  private List<GeoLocation> locations;

}
