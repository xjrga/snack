package io.github.xjrga.snack.other;

public class FileName {

    private String vtxt;

    public FileName() {
    }

    public void setVariableText(String vtxt) {
        this.vtxt = vtxt;
    }

    public String commons_math() {
        return "models/snack_java_" + vtxt + ".java";
    }

    public String lpsolve_cplex() {
        return "models/snack_cplex_" + vtxt + ".lp";
    }

    public String lpsolve_cplex_exp() {
        return "models/snack_cplex_exp_" + vtxt + ".lp";
    }

    public String lpsolve_rust() {
        return "models/snack_rust_" + vtxt + ".rs";
    }

    public String lpsolve_c() {
        return "models/snack_c_" + vtxt + ".c";
    }

    public String lpsolve_r() {
        return "models/snack_r_" + vtxt + ".R";
    }

    public String getReportDataFileName() {
        return "snack_report_data_" + vtxt + ".csv";
    }

    public String getReportDataFileNameExp() {
        return "snack_report_data_" + vtxt + "_exp.csv";
    }

    public String getReportFileName() {
        return "snack_report_" + vtxt + ".txt";
    }
}
