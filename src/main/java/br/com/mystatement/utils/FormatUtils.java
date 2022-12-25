package br.com.mystatement.utils;

public class FormatUtils {

    public static String formatCredentials(String credential) {
        int pos = credential.indexOf(":");
        return credential.substring(pos + 1);
    }
}
