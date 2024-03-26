package io.github.alexcheng1982.gaode;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.alexcheng1982.gaode.param.GeoLocation;
import io.github.alexcheng1982.gaode.param.LabelStyle;
import io.github.alexcheng1982.gaode.param.Labels;
import io.github.alexcheng1982.gaode.param.LabelsGroup;
import io.github.alexcheng1982.gaode.param.MarkerSize;
import io.github.alexcheng1982.gaode.param.MarkerStyle;
import io.github.alexcheng1982.gaode.param.Markers;
import io.github.alexcheng1982.gaode.param.MarkersGroup;
import io.github.alexcheng1982.gaode.param.Paths;
import io.github.alexcheng1982.gaode.param.PathsGroup;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class StaticMapGeneratorTest {

  @Test
  void simple() {
    GeoLocation center = GeoLocation.builder()
        .lat(39.990464)
        .lng(116.481485)
        .build();
    GeoLocation p1 = GeoLocation.builder()
        .lat(40)
        .lng(116.5)
        .build();
    GeoLocation p2 = GeoLocation.builder()
        .lat(40.05)
        .lng(116.8)
        .build();
    StaticMap map = StaticMap.builder()
        .key("demo")
        .location(center)
        .zoom(10)
        .markers(Markers.builder()
            .markersGroups(List.of(
                MarkersGroup.builder()
                    .markerStyle(MarkerStyle.builder()
                        .size(MarkerSize.LARGE)
                        .label("A")
                        .build())
                    .locations(List.of(center))
                    .build()
            ))
            .build())
        .labels(Labels.builder()
            .labelsGroups(List.of(
                LabelsGroup.builder()
                    .labelStyle(LabelStyle.builder()
                        .content("Test")
                        .fontSize(16)
                        .build())
                    .locations(List.of(center))
                    .build()
            ))
            .build())
        .paths(Paths.builder()
            .pathsGroups(List.of(
                PathsGroup.builder()
                    .locations(Arrays.asList(
                        center, p1, p2
                    ))
                    .build()
            ))
            .build())
        .build();
    String url = StaticMapGenerator.generate(map);
    assertNotNull(url);
  }
}