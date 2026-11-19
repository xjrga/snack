package io.github.xjrga.snack.dataobject;

import java.util.Objects;

/**
 * @author jr
 */
public class MixGroupDO {

    private String groupid;
    private String groupname;

    public MixGroupDO() {
        groupid = "";
        groupname = "";
    }

    public MixGroupDO(String foodid, String foodname) {
        this.setGroupId(foodid);
        this.setGroupName(foodname);
    }

    public String getGroupId() {
        return groupid;
    }

    public String getGroupName() {
        return groupname;
    }

    public void setGroupId(String foodid) {
        this.groupid = foodid;
    }

    public void setGroupName(String foodname) {
        this.groupname = foodname;
    }

    @Override
    public String toString() {
        return getGroupName();
    }

    public boolean isNull() {
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.groupid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MixGroupDO other = (MixGroupDO) obj;
        return Objects.equals(this.groupid, other.groupid);
    }
}
