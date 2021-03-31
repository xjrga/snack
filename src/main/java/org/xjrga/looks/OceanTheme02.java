package org.xjrga.looks;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;

public class OceanTheme02 extends OceanTheme {
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
    private final FontUIResource controlTextFont = new FontUIResource("Liberation Mono", Font.PLAIN, 13);
    private final FontUIResource systemTextFont = new FontUIResource("Liberation Mono", Font.PLAIN, 13);
    private final FontUIResource userTextFont = new FontUIResource("Liberation Mono", Font.PLAIN, 13);
    private final FontUIResource menuTextFont = new FontUIResource("Liberation Mono", Font.PLAIN, 13);
    private final FontUIResource windowTitleFont = new FontUIResource("Liberation Mono", Font.BOLD, 30);
    private final FontUIResource subTextFont = new FontUIResource("Liberation Mono", Font.PLAIN, 11);

    public OceanTheme02() {
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
        return systemTextFont;
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
        return windowTitleFont;
    }

    @Override
    public FontUIResource getSubTextFont() {
        return subTextFont;
    }
}
