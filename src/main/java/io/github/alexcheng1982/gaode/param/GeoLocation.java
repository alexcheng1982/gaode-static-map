package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GeoLocation implements ParamValue {

  @NonNull
  private double lat;
  @NonNull
  private double lng;

  @Override
  public String toParamValue() {
    return lat + "," + lng;
  }
}
