# Gaode Static Map URL Generator (高德静态地图URL生成器)

[![build](https://github.com/alexcheng1982/gaode-static-map/actions/workflows/build.yaml/badge.svg)](https://github.com/alexcheng1982/gaode-static-map/actions/workflows/build.yaml)

Generate URL
for [Gaode Static Maps](https://developer.amap.com/api/webservice/guide/api/staticmaps/).
生成高德地图的静态地图的URL.

Requires Java 11.

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
```