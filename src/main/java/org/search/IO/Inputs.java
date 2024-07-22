package org.search.IO;

import org.search.Enums.Strategies;

import java.util.Optional;
import java.util.Scanner;

public class Inputs {
    final Validators VALIDATOR;
    final Scanner SCANNER;

    public Inputs() {
        VALIDATOR = new Validators();
        SCANNER = new Scanner(System.in);
    }

    public Optional<Integer> getMenuOption () {
        String input = SCANNER.nextLine();
        return VALIDATOR.isNumber(input) ? Optional.of(Integer.parseInt(input)) : Optional.empty();
    }

    public Optional<Strategies> getMatchingStrategy () {
        String input = SCANNER.nextLine();
        try {
            return VALIDATOR.isValidStrategy(input) ? Optional.of(Strategies.valueOf(input.toUpperCase())) : Optional.empty();
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public Optional<String> getQuery() {
        String input = SCANNER.nextLine();
        return VALIDATOR.isValidInput(input) ? Optional.of(input) : Optional.empty();
    }
}
