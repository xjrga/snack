package io.github.xjrga.snack.jcomponents;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.MutableComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * @author jr
 * @param <T>
 */
public class ComboBox<T> extends JComboBox {

    private final ListComboBoxModel<T> model;

    public ComboBox() {

        model = new ListComboBoxModel();
        setModel(model);
    }

    public void reload(List<T> list) {

        model.clear();
        model.reload(list);
    }

    public void clear() {

        model.clear();
    }

    public T getElementAt(int i) {

        return model.getElementAt(i);
    }

    @Override
    public T getSelectedItem() {

        return model.getSelectedItem();
    }

    public T find(T obj) {

        return getElementAt(index(obj));
    }

    public int index(T obj) {

        return model.find(obj);
    }

    @Override
    public void setSelectedIndex(int index) {

        model.setSelectedItem(getElementAt(index));
        repaint();
    }

    public boolean isEmpty() {

        return !(model.getSize() > 0);
    }

    public boolean isSelectionEmpty() {

        return !(model.getSelectedIndex() >= 0);
    }

    public void removeElementAt(int index) {

        model.removeElementAt(index);
    }

    public void insertElementAt(T obj, int index) {

        model.insertElementAt(obj, index);
    }

    private class ListComboBoxModel<T> implements MutableComboBoxModel {

        protected List<T> data;
        private final ArrayList listeners;
        private T selected;

        public ListComboBoxModel() {

            this.listeners = new ArrayList();
        }

        public ListComboBoxModel(List<T> list) {

            this.listeners = new ArrayList();
            this.data = list;
        }

        @Override
        public void setSelectedItem(Object item) {

            if (data == null) {

                return;
            }

            this.selected = (T) item;
            fireDataChanged();
        }

        @Override
        public T getSelectedItem() {

            return selected;
        }

        public int getSelectedIndex() {

            return find(selected);
        }

        @Override
        public int getSize() {

            if (data == null) {

                return 0;
            }

            return data.size();
        }

        @Override
        public T getElementAt(int index) {

            if (data == null) {

                return (T) "";
            }

            if (index == -1) {

                return (T) "";
            }

            if (data.isEmpty()) {

                return (T) "";
            }

            return data.get(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {

            listeners.add(l);
        }

        @Override
        public void removeListDataListener(ListDataListener l) {

            listeners.remove(l);
        }

        @Override
        public void addElement(Object obj) {

            data.add((T) obj);
            fireDataChanged();
        }

        @Override
        public void removeElement(Object obj) {

            data.remove((T) obj);
            fireDataChanged();
        }

        @Override
        public void insertElementAt(Object obj, int index) {

            data.add(index, (T) obj);
            fireDataChanged();
        }

        @Override
        public void removeElementAt(int index) {

            data.remove(index);
            fireDataChanged();
        }

        public void reload(List<T> list) {

            this.data = new ArrayList(list);
            fireDataChanged();
        }

        public void clear() {

            if (data == null) {

                return;
            }

            data.clear();
            setSelectedItem("");
            fireDataChanged();
        }

        public void fireDataChanged() {

            ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, data.size());

            for (int i = 0; i < listeners.size(); i++) {

                ListDataListener l = (ListDataListener) listeners.get(i);
                l.contentsChanged(e);
            }
        }

        public int find(T obj) {

            int index = -1;
            int size = getSize();

            for (int i = 0; i < size; i++) {

                T elementAt = getElementAt(i);

                if (elementAt.equals(obj)) {

                    index = i;
                    break;
                }
            }

            return index;
        }
    }
}
