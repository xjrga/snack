package io.github.xjrga.snack.other;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Spacer_panel
        extends JPanel {

    public Spacer_panel( JComponent panel ) {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout(
                "4dlu,p:grow,4dlu", //columns
                "4dlu,fill:p:grow,4dlu" //rows
        );
        setLayout( layout );
        add( panel, cc.xy( 2, 2 ) );
    }
}
