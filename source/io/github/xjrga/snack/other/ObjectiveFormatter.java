package io.github.xjrga.snack.other;

import java.text.ParseException;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class ObjectiveFormatter extends AbstractFormatter {

    private Object value;


    @Override
    public String valueToString( Object value ) throws ParseException {
        this.value = value;
        return value.toString();
    }


    @Override
    public Object stringToValue( String text ) throws ParseException {
        return value;
    }
}
