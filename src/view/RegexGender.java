package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGender {
    private static final String gender = "^[Nn][Aa][Mm]+|[Nn][Uu]$";
    private static final String status = "^[Tt][Rr][Uu][Ee]+|[Ff][Aa][Ll][Ss][Ee]$";

    public RegexGender() {
    }

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile("^[Nn][Aa][Mm]+|[Nn][Uu]$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean valida(String rex) {
        Pattern pattern = Pattern.compile("^[Tt][Rr][Uu][Ee]+|[Ff][Aa][Ll][Ss][Ee]$");
        Matcher matcher = pattern.matcher(rex);
        return matcher.matches();
    }
}