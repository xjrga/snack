/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.xjrga.snack.other;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
 */
public class DoubleTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    JComponent component = new JTextField();
    JTextField textfield = ( JTextField ) component;

    @Override
    public Component getTableCellEditorComponent( JTable table, Object value,
                                                  boolean isSelected, int rowIndex, int vColIndex ) {
        //if editing
        textfield.selectAll();
        textfield.setText( "" );
        if( table.isCellEditable( rowIndex, vColIndex ) ) {
            //Message.showMessage("Cell is editable");
        }
        return component;
    }

    @Override
    public Object getCellEditorValue() {
        NumberCheck checkNumber = new NumberCheck();
        Double n = 0.0;
        checkNumber.addToUncheckedList( textfield.getText() );
        if( checkNumber.pass() ) {
            n = Double.valueOf( textfield.getText() );
        }
        else {
            //System.out.println(rowIndex+","+vColIndex+","+editingRow);
            //first click stops editor, second click enters new cell
            //java.lang.IndexOutOfBoundsException: Invalid index when click on next cell
            this.cancelCellEditing();
            //escape key stops editor, click enters new cell
            //java.lang.StackOverflowError when click on next cell
            //this.stopCellEditing();
        }
        return n;
    }
}
