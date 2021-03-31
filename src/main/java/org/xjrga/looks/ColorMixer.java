package org.xjrga.looks;

import java.awt.Color;

/*
 * @author Jorge R Garcia de Alba     
 */
public class ColorMixer {
    
    private final int mixR;
    private final int mixG;
    private final int mixB;
    private final int srcR;
    private final int srcG;
    private final int srcB;
    private final Color src;
    private final Color mix;
    
    public ColorMixer(Color src, Color mix) {
        this.src = src;
        this.mix = mix;
        srcR = src.getRed();
        srcG = src.getGreen();
        srcB = src.getBlue();
        mixR = mix.getRed();
        mixG = mix.getGreen();
        mixB = mix.getBlue();        
    }
    
    public Color getColorTone(float mixValue) {
        testMixValueRange(mixValue);
        int r = (int) (srcR * (1.0f - mixValue) + mixR * mixValue);
        int g = (int) (srcG * (1.0f - mixValue) + mixG * mixValue);
        int b = (int) (srcB * (1.0f - mixValue) + mixB * mixValue);  
        //System.out.println("New Color: "+r+","+g+","+b);
        return new Color(r, g, b);
    }
    
    public Color getColorSource(){
        return src;
    }
    
    public Color getColorMix(){
        return mix;
    }


    private static void testMixValueRange(float mixValue) {
        boolean error = false;
        String message = "";

        if (mixValue < 0.0f || mixValue > 1.0f) {
            error = true;
            message = message + " Mix value";
        }

        if (error == true) {
            throw new IllegalArgumentException("Mix value outside of expected range:"
                    + message);
        }
    }    
}
