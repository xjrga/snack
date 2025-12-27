package io.github.xjrga.snack.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public final class TreeModelRegexHighlighter extends DefaultTreeCellRenderer {

    private final TreeCellRenderer renderer;
    private final String txt;
    private final String regex;

    public TreeModelRegexHighlighter( TreeCellRenderer renderer, String txt ) {
        this.renderer = renderer;
        this.txt = txt;
        this.regex = getRegex( txt );
    }

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus ) {
        JComponent c = ( JComponent ) renderer.getTreeCellRendererComponent( tree, value, isSelected, expanded, leaf, row, hasFocus );
        c.setForeground( new Color( 190, 198, 204 ) );
        if ( !txt.isEmpty() && leaf && value.toString().matches( regex ) ) {
            //Mint
            c.setForeground( new Color( 152, 251, 152 ) );
        }
        return c;
    }

    private String getRegex( String txt ) {
        StringBuilder sb = new StringBuilder();
        // sb.append("(?i)");
        sb.append( ".*" );
        sb.append( txt );
        sb.append( ".*" );
        return sb.toString();
    }
}
