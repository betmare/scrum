package main.validator;

import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern matcher = Pattern.compile("^(.+)@(.+)$");

    public static boolean isValidEmail(final String email) {
        return matcher.matcher(email).matches();
    }

}
