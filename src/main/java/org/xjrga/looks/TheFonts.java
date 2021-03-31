package org.xjrga.looks;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * TheFonts 
 * @author Jorge R Garcia de Alba     
 */
public class TheFonts {

    static {
        ThreadLocal.withInitial(TheFonts::new);
    }

    private TheFonts() {

    }

    public static Font getDejaVuSansMono(Float size) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/DejaVuSansMono.ttf")).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(TheFonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }

    public static Font getFreeMono(Float size) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/FreeMono.ttf")).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(TheFonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }

    public static Font getLiberationMono(Float size) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/LiberationMono-Regular.ttf")).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(TheFonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }

    public static Font getNotoMono(Float size) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/NotoMono-Regular.ttf")).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(TheFonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }

    public static Font getUbuntuMono(Float size) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/UbuntuMono-R.ttf")).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(TheFonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }

}
