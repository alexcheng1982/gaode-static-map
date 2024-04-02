# Gaode Static Map URL Generator (高德静态地图URL生成器)

[![build](https://github.com/alexcheng1982/gaode-static-map/actions/workflows/build.yaml/badge.svg)](https://github.com/alexcheng1982/gaode-static-map/actions/workflows/build.yaml)
![Maven Central Version](https://img.shields.io/maven-central/v/io.github.alexcheng1982/gaode-static-map)

Generate URL
for [Gaode Static Maps](https://developer.amap.com/api/webservice/guide/api/staticmaps/).
生成高德地图的静态地图的URL.

Requires Java 8.

A [Gaode API key](https://lbs.amap.com/api/webservice/create-project-and-key) is
required to render the map.

Add the following Maven dependency to your project.

```xml

<dependency>
  <groupId>io.github.alexcheng1982</groupId>
  <artifactId>gaode-static-map</artifactId>
  <version>1.1.0</version>
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
                .style(MarkerStyle.builder()
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
                .style(LabelStyle.builder()
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

The output url looks
like `https://restapi.amap.com/v3/staticmap?size=400*400&paths=5%2C0x0000FF%2C1.0%2C%2C%3A116.481485%2C39.990464%3B116.5%2C40.0%3B116.8%2C40.05&scale=1&location=116.481485%2C39.990464&zoom=10&markers=large%2C0xFC6054%2CA%3A116.481485%2C39.990464&key=demo&labels=Test%2C0%2C0%2C16%2C0xFFFFFF%2C0x5288d8%3A116.481485%2C39.990464&traffic=0`.