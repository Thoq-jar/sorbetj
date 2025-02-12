package dev.thoq;

public class Utility {
    private static final String PREFIX = "Sorbet =>";

    public static void printError(SorbetError kind, String message) {
        switch (kind) {
            case SYNTAX:
                System.out.println(PREFIX + " Syntax error: " + message);
                break;
            case SYNTAX_EXCEPTION:
                System.out.println(PREFIX + " !EXCEPTION RAISED! Syntax error: " + message);
                break;
        }
    }

    public static boolean checkFileExtension(String sorbetFilePath) {
        return sorbetFilePath.endsWith(".srb") || sorbetFilePath.endsWith(".sorbet");
    }
}
