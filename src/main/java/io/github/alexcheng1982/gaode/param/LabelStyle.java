package io.github.alexcheng1982.gaode.param;

import io.github.alexcheng1982.gaode.ParamValue;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class LabelStyle implements ParamValue {

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
        Stream.of(content, font, bold, fontSize, fontColor, background));
  }
}
