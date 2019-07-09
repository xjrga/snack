package org.xjrga.snack2.gui;

import javax.swing.*;
import java.awt.*;

public class SeparatorPanel extends JPanel
{
    private Color leftColor;
    private Color rightColor;

    public SeparatorPanel(Color left, Color right)
    {
        this.leftColor = left;
        this.rightColor = right;
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor(leftColor);
        g.drawLine(0, 0, 0, getHeight());
        g.setColor(rightColor);
        g.drawLine(1, 0, 1, getHeight());
    }
}
