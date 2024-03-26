# Gaode Static Map URL Generator

Generate URL
for [Gaode Static Maps](https://developer.amap.com/api/webservice/guide/api/staticmaps/).

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