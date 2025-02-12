package dev.thoq;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, String> parse(String contents) {
        Map<String, String> map = new HashMap<>();
        String currentKey = null;
        StringBuilder currentValue = new StringBuilder();

        for (String line : contents.split("\n")) {
            if (line.contains("=>")) {
                if (currentKey != null) {
                    map.put(currentKey, currentValue.toString().trim());
                    currentValue.setLength(0);
                }

                String[] parts = line.split("=>");
                if (parts.length == 2) {
                    currentKey = parts[0].trim();
                    currentValue.append(parts[1].trim());
                } else {
                    Utility.printError(SorbetError.SYNTAX,
                            String.format("Syntax error! Expected [key] => [value] at: %s", line));
                }
            } else if (line.trim().startsWith(">")) {
                if (currentKey != null) {
                    currentValue.append("\n")
                            .append(line.trim().replaceFirst(">", "").trim());
                } else {
                    Utility.printError(SorbetError.SYNTAX_EXCEPTION,
                            String.format("Continuation line without a key at: %s", line));
                }
            }
        }

        if (currentKey != null) {
            map.put(currentKey, currentValue.toString().trim());
        }

        return map;
    }
}
