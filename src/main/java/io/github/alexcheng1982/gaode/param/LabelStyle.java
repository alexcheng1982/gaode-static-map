package io.github.alexcheng1982.gaode.param;

import java.util.stream.Stream;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class LabelStyle implements Style {

  private String content;
  @Default
  private LabelFont font = LabelFont.MS_YAHEI;
  @Default
  private BoldMode bold = BoldMode.OFF;
  @Default
  private int fontSize = 10;
  @Default
  private String fontColor = "0xFFFFFF";
  @Default
  private String background = "0x5288d8";

  @Override
  public String toParamValue() {
    return ParamValueUtils.build(
        Stream.of(
            content != null ? content.trim().replace(" ", "").substring(0, 15)
                : null,
            font, bold, Math.max(Math.min(fontSize, 72), 1), fontColor,
            background));
  }
}
