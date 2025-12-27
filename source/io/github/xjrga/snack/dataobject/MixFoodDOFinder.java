package io.github.xjrga.snack.dataobject;

import io.github.xjrga.snack.jcomponents.ComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @author jr
 */
public class MixFoodDOFinder {

    private MixFoodDOFinder() {
    }

    public static int find( String foodid, DefaultComboBoxModel model ) {
        int index = 0;
        int size = model.getSize();
        for ( int i = 0; i < size; i++ ) {
            MixFoodDO elementAt = ( MixFoodDO ) model.getElementAt( i );
            if ( elementAt.getFoodId().equals( foodid ) ) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int find( String foodid, ComboBox<MixFoodDO> cmb ) {
        int index = 0;
        int size = cmb.getItemCount();
        for ( int i = 0; i < size; i++ ) {
            MixFoodDO elementAt = ( MixFoodDO ) cmb.getElementAt( i );
            if ( elementAt.getFoodId().equals( foodid ) ) {
                index = i;
                break;
            }
        }
        return index;
    }
}
