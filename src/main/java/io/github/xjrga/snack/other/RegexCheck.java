package io.github.xjrga.snack.other;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author jr
 */
public class RegexCheck {

    private final String regex;


    public RegexCheck( String regex ) {
        this.regex = regex;
    }


    public boolean pass() {
        boolean valid = false;
        try {
            Pattern.compile( regex );
            valid = true;
        } catch ( PatternSyntaxException e ) {
        }
        return valid;
    }
}
