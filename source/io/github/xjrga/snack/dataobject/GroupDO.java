package io.github.xjrga.snack.dataobject;

import java.util.Objects;

/**
 * @author jr
 */
public final class GroupDO {

    private String groupid;
    private String groupname;


    public GroupDO() {
        groupid = "";
        groupname = "";
    }


    public GroupDO( String groupid, String groupname ) {
        setGroupid( groupid );
        setGroupname( groupname );
    }


    public String getGroupid() {
        return groupid;
    }


    public void setGroupid( String groupid ) {
        this.groupid = groupid;
    }


    public String getGroupname() {
        return groupname;
    }


    public void setGroupname( String groupname ) {
        this.groupname = groupname;
    }


    @Override
    public String toString() {
        return groupname;
    }


    public boolean isNull() {
        return false;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode( this.groupid );
        return hash;
    }


    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final GroupDO other = ( GroupDO ) obj;
        return Objects.equals( this.groupid, other.groupid );
    }
}
