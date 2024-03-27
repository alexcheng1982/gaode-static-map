package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.List;
import java.util.stream.Collectors;

public interface Group<S extends Style> extends ParamValue {

  S getStyle();

  List<GeoLocation> getLocations();

  @Override
  default String toParamValue() {
    return getStyle().toParamValue() + ":" +
        getLocations().stream().map(GeoLocation::toParamValue)
            .collect(Collectors.joining(";"));
  }
}
