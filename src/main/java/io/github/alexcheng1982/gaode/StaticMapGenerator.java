package io.github.alexcheng1982.gaode;

import static io.github.alexcheng1982.gaode.param.ParamValueUtils.getParamValue;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Generate {@linkplain StaticMap}s
 */
public class StaticMapGenerator {

  private StaticMapGenerator() {
  }

  public static String generate(StaticMap map) {
    Map<String, String> params = new HashMap<>();
    params.put("key", map.getKey());
    params.put("location", getParamValue(map.getLocation()));
    params.put("zoom", getParamValue(map.getZoom()));
    params.put("size", getParamValue(map.getSize()));
    params.put("scale", getParamValue(map.getScale()));
    params.put("markers", getParamValue(map.getMarkers()));
    params.put("labels", getParamValue(map.getLabels()));
    params.put("paths", getParamValue(map.getPaths()));
    params.put("traffic", getParamValue(map.getTraffic()));
    params.put("sig", getParamValue(map.getSig()));
    String queryString = params.entrySet().stream()
        .filter(entry -> !entry.getValue().isEmpty())
        .map(entry -> entry.getKey() + "=" + encode(entry.getValue()))
        .collect(Collectors.joining("&"));
    return "https://restapi.amap.com/v3/staticmap?" + queryString;
  }

  private static String encode(String value) {
    try {
      return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException e) {
      return value;
    }
  }
}
