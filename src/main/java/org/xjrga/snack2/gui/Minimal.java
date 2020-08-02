package org.xjrga.snack2.gui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalTheme;
import java.awt.*;

public class Minimal extends MetalTheme {
    private final FontUIResource font = new FontUIResource("Dialog", Font.PLAIN, 13);
    private final ColorUIResource colorUIResource0 = new ColorUIResource(0xF7F7F7);
    private final ColorUIResource colorUIResource2 = new ColorUIResource(0xE6E6E6);
    private final ColorUIResource colorUIResource1 = new ColorUIResource(0, 0, 0);

    public Minimal() {
        UIManager.put("TabbedPane.focus", colorUIResource2);
        UIManager.put("TabbedPane.selected", colorUIResource2);
        UIManager.put("Button.select", colorUIResource2);
    }

    @Override
    public String getName() {
        return "Minimal";
    }

    @Override
    protected ColorUIResource getPrimary1() {
        return colorUIResource1;
    }

    @Override
    protected ColorUIResource getPrimary2() {
        //selected menu,menuitem background
        return colorUIResource2;
    }

    @Override
    protected ColorUIResource getPrimary3() {
        //selected field,row background
        return colorUIResource2;
    }

    @Override
    protected ColorUIResource getSecondary1() {
        return colorUIResource1;
    }

    @Override
    protected ColorUIResource getSecondary2() {
        //panel, table outlines
        return colorUIResource0;
    }

    @Override
    protected ColorUIResource getSecondary3() {
        //app background
        return colorUIResource0;
    }

    public ColorUIResource getFocusColor() {
        //selected field outline
        return colorUIResource0;
    }

    public ColorUIResource getMenuSelectedForeground() {
        //menu text when selected
        return colorUIResource1;
    }

    @Override
    public FontUIResource getControlTextFont() {
        return font;
    }

    @Override
    public FontUIResource getSystemTextFont() {
        return font;
    }

    @Override
    public FontUIResource getUserTextFont() {
        return font;
    }

    @Override
    public FontUIResource getMenuTextFont() {
        return font;
    }

    @Override
    public FontUIResource getWindowTitleFont() {
        return font;
    }

    @Override
    public FontUIResource getSubTextFont() {
        return font;
    }
}