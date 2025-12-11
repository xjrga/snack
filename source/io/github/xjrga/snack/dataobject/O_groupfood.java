package io.github.xjrga.snack.dataobject;

/**
 *
 * @author jr
 */
public class O_groupfood {

    private String mixid;
    private String groupid;
    private String foodid;

    public O_groupfood() {}

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

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    @Override
    public String toString() {
        return "O_groupfood{" + "mixid=" + mixid + ", groupid=" + groupid + ", foodid=" + foodid + '}';
    }
}
