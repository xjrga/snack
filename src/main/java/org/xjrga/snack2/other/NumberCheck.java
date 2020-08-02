package org.xjrga.snack2.other;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberCheck {
    List<String> numbers = new LinkedList();

    public NumberCheck() {
    }

    public void addToUncheckedList(String s) {
        numbers.add(s);
    }

    public boolean pass() {
        boolean pass = false;
        if (checkNumbers()) {
            pass = true;
        }
        return pass;
    }

    private boolean checkNumbers() {
        boolean pass = true;
        for (String s : numbers) {
            if (s.isEmpty()) {
                pass = false;
                break;
            } else {
                if (!checkStringIsNumber(s)) {
                    pass = false;
                    break;
                }
            }
        }
        return pass;
    }

    private boolean checkStringIsNumber(String s) {
        boolean pass = false;
        String patternStr = "^([0-9]+(\\.[0-9]+)?|\\.[0-9]+)$";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            pass = true;
        }
        return pass;
    }
}
