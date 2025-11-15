package io.github.xjrga.snack.renderers;

import java.awt.Dimension;
import javax.swing.DefaultListCellRenderer;

public class ComboMixRenderer extends DefaultListCellRenderer {

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(0, 28);
    }
}
