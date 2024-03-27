package io.github.alexcheng1982.gaode.param;

import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class PathsGroup implements Group<PathStyle> {

  @Default
  private PathStyle style = PathStyle.builder().build();
  private List<GeoLocation> locations;
}
