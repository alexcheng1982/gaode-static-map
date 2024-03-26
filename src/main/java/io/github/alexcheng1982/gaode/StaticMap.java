package io.github.alexcheng1982.gaode;

import io.github.alexcheng1982.gaode.param.GeoLocation;
import io.github.alexcheng1982.gaode.param.Labels;
import io.github.alexcheng1982.gaode.param.MapScaleMode;
import io.github.alexcheng1982.gaode.param.MapSize;
import io.github.alexcheng1982.gaode.param.Markers;
import io.github.alexcheng1982.gaode.param.Paths;
import io.github.alexcheng1982.gaode.param.TrafficMode;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class StaticMap {

  @NonNull
  private String key;
  private GeoLocation location;
  @Default
  private Integer zoom = 10;
  @Default
  private MapSize size = MapSize.DEFAULT;
  @Default
  private MapScaleMode scale = MapScaleMode.NORMAL;
  @Default
  private TrafficMode traffic = TrafficMode.OFF;
  private Markers markers;
  private Labels labels;
  private Paths paths;
  private String sig;
}
