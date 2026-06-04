package io.github.xjrga.snack.lp;

public class LpText {

    public static String getCplexRelationship(int rel) {
        return switch (rel) {
            case 1 ->
                ">=";
            case 2 ->
                "<=";
            case 3 ->
                "=";
            default ->
                "fix";
        };
    }

    public static String getRustRelationship(Integer rel) {
        return switch (rel) {
            case 1 ->
                "\">=\"";
            case 2 ->
                "\"<=\"";
            case 3 ->
                "\"=\"";
            default ->
                "fix";
        };
    }
}
