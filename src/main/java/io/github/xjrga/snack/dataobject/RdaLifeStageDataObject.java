package io.github.xjrga.snack.dataobject;

public class RdaLifeStageDataObject {
    private Integer LifeStageId = -1;
    private String Label;
    public RdaLifeStageDataObject( Integer LifeStageId, String Label ) {
        this.LifeStageId = LifeStageId;
        this.Label = Label;
    }
    public Integer getLifeStageId() {
        return LifeStageId;
    }
    public void setLifeStageId( Integer LifeStageId ) {
        this.LifeStageId = LifeStageId;
    }
    public String getLabel() {
        return Label;
    }
    public void setLabel( String Label ) {
        this.Label = Label;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( Label );
        return sb.toString();
    }
}
