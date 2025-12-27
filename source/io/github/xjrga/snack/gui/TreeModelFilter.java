package io.github.xjrga.snack.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

/**
 * @author jr
 */
public final class TreeModelFilter {

    private ArrayList<DefaultMutableTreeNode[]> lst;
    private HashMap<Integer, DefaultMutableTreeNode> hm;
    private final String filter;
    private final DefaultTreeModel oldModel;
    private final DefaultTreeModel newModel;
    private final DefaultMutableTreeNode oldRoot;
    private final DefaultMutableTreeNode newRoot;

    public TreeModelFilter( DefaultTreeModel model, String txt ) {
        oldRoot = ( DefaultMutableTreeNode ) model.getRoot();
        oldModel = model;
        newRoot = new DefaultMutableTreeNode( oldRoot.getUserObject() );
        newModel = new DefaultTreeModel( newRoot );
        filter = txt;
    }

    public TreeModel model() {
        hm = new HashMap<>();
        lst = new ArrayList<>();
        traverseOld( oldRoot, 0 );
        populateNew();
        return newModel;
    }

    private void traverseOld( TreeNode parent, int level ) {
        for ( int i = 0; i < parent.getChildCount(); i++ ) {
            final TreeNode child = parent.getChildAt( i );
            TreeNode[] pathToRoot = oldModel.getPathToRoot( child );
            DefaultMutableTreeNode[] newPathToRoot = convertTreePath( pathToRoot );
            lst.add( newPathToRoot );
            traverseOld( child, level + 1 );
        }
    }

    private DefaultMutableTreeNode[] convertTreePath( TreeNode[] pathToRoot ) {
        DefaultMutableTreeNode[] newPathToRoot = new DefaultMutableTreeNode[ pathToRoot.length ];
        for ( int j = 0; j < pathToRoot.length; j++ ) {
            DefaultMutableTreeNode node = ( DefaultMutableTreeNode ) pathToRoot[ j ];
            newPathToRoot[ j ] = node;
        }
        return newPathToRoot;
    }

    private void populateNew() {
        hm.put( newRoot.hashCode(), newRoot );
        lst.stream()
                .forEach(
                        treePath -> {
                            try {
                                boolean found
                                = Arrays.asList( treePath ).stream()
                                        .anyMatch( ( node -> node.toString().matches( filter ) && node.isLeaf() ) );
                                if ( found ) {
                                    DefaultMutableTreeNode parent = null;
                                    DefaultMutableTreeNode child = null;
                                    for ( int i = 1; i < treePath.length; i++ ) {
                                        if ( i == 1 ) {
                                            parent = hm.get( newRoot.hashCode() );
                                        } else {
                                            parent = hm.get( treePath[ i - 1 ].hashCode() );
                                        }
                                        boolean contains = hm.containsKey( treePath[ i ].hashCode() );
                                        if ( contains ) {
                                            child = hm.get( treePath[ i ].hashCode() );
                                        } else {
                                            child = new DefaultMutableTreeNode( treePath[ i ].getUserObject() );
                                            hm.put( treePath[ i ].hashCode(), child );
                                        }
                                        parent.add( child );
                                    }
                                }
                            } catch ( Exception e ) {
                                e.printStackTrace();
                            }
                        } );
    }
}
