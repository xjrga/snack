package org.xjrga.snack2.gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JStatusBar extends JPanel
{
    private FormLayout layout;
    private CellConstraints cc;
    private int x = 1;
    private int y = 1;

    public JStatusBar()
    {
        cc = new CellConstraints();
        layout = new FormLayout("min:grow", //columns
                "min" //rows
        );

        this.setLayout(layout);
        this.setBorder(new TitledBorder(""));
    }

    public void addMessageLabel(JLabel leftLabel)
    {
        this.add(leftLabel, cc.xy(1, 1));
    }

    public void addLabel(JLabel label)
    {
        //
        layout.appendColumn(ColumnSpec.decode("2dlu"));
        x++;
        //
        layout.appendColumn(ColumnSpec.decode("min"));
        x++;
        this.add(new SeparatorPanel(Color.GRAY, Color.WHITE), cc.xy(x, y));
        //
        layout.appendColumn(ColumnSpec.decode("2dlu"));
        x++;
        //
        layout.appendColumn(ColumnSpec.decode("min"));
        x++;
        this.add(label, cc.xy(x, y));
    }

}

