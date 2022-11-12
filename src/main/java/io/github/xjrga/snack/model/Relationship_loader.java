/*
 * Snack: Learning Software for Nutrition
 * Copyright (C) 2018 Jorge R Garcia de Alba
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package io.github.xjrga.snack.model;

import io.github.xjrga.snack.data.DbLink;
import io.github.xjrga.snack.dataobject.RelationshipDataObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Relationship_loader {

    private final DbLink dbLink;
    private Integer precision = 0;
    private ArrayList<RelationshipDataObject> relationship_list;

    public Relationship_loader( DbLink dbLink ) {
        this.dbLink = dbLink;
    }

    public void reload() {
        relationship_list = new ArrayList();
        try {
            LinkedList all = ( LinkedList ) dbLink.Relationship_Select_All();
            Iterator it = all.iterator();
            while( it.hasNext() ) {
                HashMap row = ( HashMap ) it.next();
                int relationshipid = ( int ) row.get( "RELATIONSHIPID" );
                String name = ( String ) row.get( "NAME" );
                RelationshipDataObject relationshipDataObject = new RelationshipDataObject( relationshipid, name );
                relationship_list.add( relationshipDataObject );
            }
        } catch( SQLException e ) {

        }
    }

    public ArrayList<RelationshipDataObject> get_relationship_list() {
        return relationship_list;
    }
}
