package io.github.xjrga.snack.jcomponents;

import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

/**
 * @author jr
 * @param <T>
 */
public class Spinner<T> extends JSpinner {

    private final SpinnerListModel model;

    public Spinner() {

        model = new SpinnerListModel();
        setModel(model);
    }

    public void setSelectedItem(T item) {

        model.setValue(item);
        repaint();
    }

    public T getSelectedItem() {

        return (T) model.getValue();
    }

    public int getSelectedIndex() {

        int index = 0;
        int size = model.getList().size();

        for (int i = 0; i < size; i++) {

            T o = (T) model.getList().get(i);

            if (o.equals(getSelectedItem())) {

                index = i;
            }
        }

        return index;
    }

    public void reload(List<T> list) {

        model.setList(list);
    }

    @Override
    public Object getPreviousValue() {

        return super.getNextValue();
    }

    @Override
    public Object getNextValue() {

        return super.getPreviousValue();
    }
}
