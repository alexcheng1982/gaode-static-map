package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParamValueUtils {

  private ParamValueUtils() {
  }

  public static String getParamValue(Object value) {
    if (value instanceof ParamValue) {
      return ((ParamValue) value).toParamValue();
    } else if (value != null) {
      return Objects.toString(value);
    } else {
      return "";
    }
  }

  public static String build(Stream<Object> values) {
    return values
        .map(ParamValueUtils::getParamValue)
        .collect(Collectors.joining(","));
  }
}
