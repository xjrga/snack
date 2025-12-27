package io.github.xjrga.snack.other;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCheck {

    List<String> names = new LinkedList();

    public StringCheck() {
    }

    public void addUncheckedList( String s ) {
        names.add( s );
    }

    private boolean checkNames() {
        boolean pass = true;
        for ( String s : names ) {
            if ( s.isEmpty() || !checkStringIsValid( s ) ) {
                pass = false;
                break;
            }
        }
        return pass;
    }

    private boolean checkStringIsValid( String s ) {
        boolean pass = false;
        // String patternStr = "[A-Za-z0-9 .,'%()/&_-]+";
        // xml invalid characters <&>'"
        String patternStr = "[^<&>'\"]+";
        Pattern pattern = Pattern.compile( patternStr );
        Matcher matcher = pattern.matcher( s );
        if ( matcher.matches() ) {
            pass = true;
        }
        return pass;
    }

    public boolean pass() {
        boolean pass = false;
        if ( checkNames() ) {
            pass = true;
        }
        return pass;
    }
}
