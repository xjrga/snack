package io.github.xjrga.snack.other;

public class FileName {

    private final String cplexFileName;
    private final String glpkFileName;
    private final String glpkFileNameExp;
    private final String printLpLongFileName;
    private final String printLpShortFileName;
    private final String reportDataFileName;
    private final String reportDataFileNameExp;
    private final String reportFileName;
    private final String reportFileNameExp;
    private final String latexFileName;


    public FileName() {
        String time = Utilities.getCurrentTimeMillisTxt();
        printLpLongFileName = "models/snack_lpsolve_long_" + time + ".lp";
        printLpShortFileName = "models/snack_lpsolve_short_" + time + ".lp";
        cplexFileName = "models/snack_cplex_" + time + ".lp";
        glpkFileName = "models/snack_glpk_" + time + ".mod";
        glpkFileNameExp = "models/snack_glpk_" + time + "_exp.mod";
        reportFileName = "snack_report_" + time + ".txt";
        reportFileNameExp = "snack_report_" + time + "_exp.txt";
        reportDataFileName = "snack_report_data_" + time + ".csv";
        reportDataFileNameExp = "snack_report_data_" + time + "_exp.csv";
        latexFileName = "models/snack_latex_" + time + ".tex";
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


    public String PrintLpLongFileName() {
        return printLpLongFileName;
    }


    public String PrintLpShortFileName() {
        return printLpShortFileName;
    }


    public String getReportDataFileName() {
        return reportDataFileName;
    }


    public String getReportDataFileNameExp() {
        return reportDataFileNameExp;
    }


    public String getReportFileName() {
        return reportFileName;
    }


    public String getReportFileNameExp() {
        return reportFileNameExp;
    }


    public String getLatexFileName() {
        return latexFileName;
    }
}
