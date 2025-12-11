package io.github.xjrga.snack.dataobject;

/**
 *
 * @author jr
 */
public class O_group {

    private String mixid;
    private String groupid;
    private String name;

    public O_group() {}

    public String getMixid() {
        return mixid;
    }

    public void setMixid(String mixid) {
        this.mixid = mixid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "O_group{" + "mixid=" + mixid + ", groupid=" + groupid + ", name=" + name + '}';
    }
}
