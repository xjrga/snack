package io.github.xjrga.snack.other;

public class FileName {
  private final String reportFileName;
  private final String reportFileNameExp;
  private final String reportDataFileName;
  private final String reportDataFileNameExp;
  private final String glpkFileName;
  private final String glpkFileNameExp;
  private final String cplexFileName;
  private final String lpsolveFileName;

  public FileName() {
    String time = Utilities.getCurrentTimeMillisTxt();
    lpsolveFileName = "models/snack_lpsolve_" + time + ".lp";
    cplexFileName = "models/snack_cplex_" + time + ".lp";
    glpkFileName = "models/snack_glpk_" + time + ".mod";
    glpkFileNameExp = "models/snack_glpk_" + time + "_exp.mod";
    reportFileName = "snack_report_" + time + ".txt";
    reportFileNameExp = "snack_report_" + time + "_exp.txt";
    reportDataFileName = "snack_report_data_" + time + ".csv";
    reportDataFileNameExp = "snack_report_data_" + time + "_exp.csv";
  }

  public String getLpsolveFileName() {
    return lpsolveFileName;
  }

  public String getCplexFileName() {
    return cplexFileName;
  }

  public String getGlpkFileName() {
    return glpkFileName;
  }

  public String getGlpkFileNameExp() {
    return glpkFileNameExp;
  }

  public String getReportFileName() {
    return reportFileName;
  }

  public String getReportFileNameExp() {
    return reportFileNameExp;
  }

  public String getReportDataFileName() {
    return reportDataFileName;
  }

  public String getReportDataFileNameExp() {
    return reportDataFileNameExp;
  }
}
