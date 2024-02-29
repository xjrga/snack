package io.github.xjrga.snack.lp.mathprog;

public class MathProgDataObjectSetup {

  private String paramC;
  private String paramF;
  private String paramD;

  public MathProgDataObjectSetup(String mixid) {
    MathProgParamC mathProgParamC = new MathProgParamC(mixid);
    MathProgParamF mathProgParamF = new MathProgParamF(mixid);
    MathProgParamD mathProgParamD = new MathProgParamD();
    paramC = mathProgParamC.get();
    paramF = mathProgParamF.get();
    paramD = mathProgParamD.get();
  }

  public void saveParameters(MathProgDataObject obj) {
    obj.setParamC(paramC);
    obj.setParamF(paramF);
    obj.setParamD(paramD);
  }

  public void saveParameters(MathProgDataObjectE obj) {
    obj.setParamC(paramC);
    obj.setParamF(paramF);
    obj.setParamD(paramD);
  }
}
