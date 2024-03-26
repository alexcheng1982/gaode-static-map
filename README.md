# Gaode Static Map URL Generator

[![build](https://github.com/alexcheng1982/gaode-static-map/actions/workflows/build.yaml/badge.svg)](https://github.com/alexcheng1982/gaode-static-map/actions/workflows/build.yaml)

Generate URL
for [Gaode Static Maps](https://developer.amap.com/api/webservice/guide/api/staticmaps/).

Add the following Maven dependency to your project.

```xml

<dependency>
  <groupId>io.github.alexcheng1982</groupId>
  <artifactId>gaode-static-map</artifactId>
  <version>1.0.0</version>
</dependency>
```

Build a `StaticMap` and pass to `StaticMapGenerator.generate()` to generate the
URL.

```java
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
        .markersGroups(Arrays.asList(
            MarkersGroup.builder()
                .markerStyle(MarkerStyle.builder()
                    .size(MarkerSize.LARGE)
                    .label("A")
                    .build())
                .locations(Arrays.asList(center))
                .build()
        ))
        .build())
    .labels(Labels.builder()
        .labelsGroups(Arrays.asList(
            LabelsGroup.builder()
                .labelStyle(LabelStyle.builder()
                    .content("Test")
                    .fontSize(16)
                    .build())
                .locations(Arrays.asList(center))
                .build()
        ))
        .build())
    .paths(Paths.builder()
        .pathsGroups(Arrays.asList(
            PathsGroup.builder()
                .locations(Arrays.asList(
                    center, p1, p2
                ))
                .build()
        ))
        .build())
    .build();
String url = StaticMapGenerator.generate(map);
```