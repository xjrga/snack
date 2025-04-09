package io.github.xjrga.snack.gui;

import io.github.xjrga.snack.logger.LoggerImpl;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class generates a Font object from a true type font file
 *
 * @author Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
 */
public final class TheFont {

  private Font font;
  private float size = 13f;

  /**
   * TheFont constructor
   *
   * @param path
   * @see java.awt.Font
   */
  public TheFont(String path) {
    set_font_file_path(path);
  }

  /**
   * @return A Font object
   * @see java.awt.Font
   */
  public Font get_font() {
    return font;
  }

  /**
   * @param path Path to truetype font
   */
  public void set_font_file_path(String path) {
    try {
      font = Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(size);
    } catch (FontFormatException | IOException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  /**
   * @param fontStream InputStream
   */
  public void set_font_file_stream(InputStream fontStream) {
    try {
      font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(size);
    } catch (FontFormatException | IOException e) {
      LoggerImpl.INSTANCE.logProblem(e);
    }
  }

  /**
   * @param size Font size
   */
  public void set_size(float size) {
    this.size = size;
  }
}
