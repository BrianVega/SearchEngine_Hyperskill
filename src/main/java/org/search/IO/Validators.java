package org.search.IO;

import org.search.Enums.Strategies;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validators {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public boolean isNumber(String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }

    public boolean isValidStrategy(String strategy) {
        return Arrays.stream(Strategies.values())
                .map(Enum::name)
                .anyMatch(name -> name.equals(strategy.trim().toUpperCase()));
    }

    public boolean isValidInput(String input) {
        input = input.trim();
        return !input.isEmpty() && !input.isBlank();
    }
}
