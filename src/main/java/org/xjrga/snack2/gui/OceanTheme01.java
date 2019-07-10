package org.xjrga.snack2.gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;

public class OceanTheme01 extends OceanTheme {

    private final ColorUIResource primary1 = new ColorUIResource(99, 130, 191);
    private final ColorUIResource primary2 = new ColorUIResource(163, 184, 204);
    private final ColorUIResource primary3 = new ColorUIResource(184, 207, 229);
    private final ColorUIResource secondary1 = new ColorUIResource(122, 138, 153);
    private final ColorUIResource secondary2 = new ColorUIResource(184, 207, 229);
    private final ColorUIResource secondary3 = new ColorUIResource(238, 238, 238);
    private final ColorUIResource blackColor = new ColorUIResource(51, 51, 51);
    private final ColorUIResource desktopColor = new ColorUIResource(255, 255, 255);
    private final ColorUIResource inactiveControlTextColor = new ColorUIResource(153, 153, 153);
    private final ColorUIResource controlTextColor = new ColorUIResource(51, 51, 51);
    private final ColorUIResource menuDisabledForegroundColor = new ColorUIResource(153, 153, 153);
    private final FontUIResource controlTextFont = new FontUIResource("Dialog", Font.BOLD, 12);
    private final FontUIResource systemTextFont = new FontUIResource("Dialog", Font.BOLD, 1);
    private final FontUIResource userTextFont = new FontUIResource("Dialog", Font.PLAIN, 12);
    private final FontUIResource menuTextFont = new FontUIResource("Dialog", Font.BOLD, 12);
    private final FontUIResource windowTitleFont = new FontUIResource("Dialog", Font.BOLD, 1);
    private final FontUIResource subTextFont = new FontUIResource("Dialog", Font.PLAIN, 10);

    public OceanTheme01() {
    }

    @Override
    public void addCustomEntriesToTable(UIDefaults table) {
        super.addCustomEntriesToTable(table);
    }

    @Override
    public String getName() {
        return "MyOceanTheme";
    }

    @Override
    protected ColorUIResource getPrimary1() {
        return primary1;
    }

    @Override
    protected ColorUIResource getPrimary2() {
        return primary2;
    }

    @Override
    protected ColorUIResource getPrimary3() {
        return primary3;
    }

    @Override
    protected ColorUIResource getSecondary1() {
        return secondary1;
    }

    @Override
    protected ColorUIResource getSecondary2() {
        return secondary2;
    }

    @Override
    protected ColorUIResource getSecondary3() {
        return secondary3;
    }

    @Override
    protected ColorUIResource getBlack() {
        return blackColor;
    }

    @Override
    public ColorUIResource getDesktopColor() {
        return desktopColor;
    }

    @Override
    public ColorUIResource getInactiveControlTextColor() {
        return inactiveControlTextColor;
    }

    @Override
    public ColorUIResource getControlTextColor() {
        return controlTextColor;
    }

    @Override
    public ColorUIResource getMenuDisabledForeground() {
        return menuDisabledForegroundColor;
    }

    @Override
    public FontUIResource getControlTextFont() {
        return controlTextFont;
    }

    @Override
    public FontUIResource getSystemTextFont() {
        //Empty
        //return subTextFont;
        return super.getSystemTextFont();
    }

    @Override
    public FontUIResource getUserTextFont() {
        return userTextFont;
    }

    @Override
    public FontUIResource getMenuTextFont() {
        return menuTextFont;
    }

    @Override
    public FontUIResource getWindowTitleFont() {
        //Empty
        //return windowTitleFont;
        return super.getWindowTitleFont();
    }

    @Override
    public FontUIResource getSubTextFont() {
        return subTextFont;
    }
}

/* *
Century Schoolbook L
DejaVu Math TeX Gyre
DejaVu Sans
DejaVu Sans Condensed
DejaVu Sans Light
DejaVu Sans Mono
DejaVu Serif
DejaVu Serif Condensed
*Dialog
*DialogInput
Dingbats
Droid Sans Fallback
FreeMono
FreeSans
FreeSerif
Liberation Mono
Liberation Sans
Liberation Sans Narrow
Liberation Serif
*Monospaced
Nimbus Mono L
Nimbus Roman No9 L
Nimbus Sans L
Noto Mono
Quicksand
Quicksand Light
Quicksand Medium
*SansSerif
*Serif
Standard Symbols L
URW Bookman L
URW Chancery L
URW Gothic L
URW Palladio L
* */