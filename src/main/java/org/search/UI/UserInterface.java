package org.search.UI;

import org.search.Data;
import org.search.Enums.Strategies;
import org.search.IO.Inputs;
import org.search.IO.Outputs;

import java.util.List;

public class UserInterface {
    private final Inputs KEYBOARD_INPUTS;
    private final Outputs KEYBOARD_OUTPUTS;

    public UserInterface () {
        KEYBOARD_INPUTS = new Inputs();
        KEYBOARD_OUTPUTS = new Outputs();
    }

    public Integer getMainMenuInput() {
        return KEYBOARD_INPUTS
                .getMenuOption()
                .orElse(null);
    }

    public Strategies getSearchStrategy() {
        return KEYBOARD_INPUTS
                .getMatchingStrategy()
                .orElse(null);
    }

    public String getQuery() {
        return KEYBOARD_INPUTS
                .getQuery()
                .orElse(null);
    }

    public void printMainMenu() {
        KEYBOARD_OUTPUTS.displayMenu();
    }

    public void printSearchStrategyMsg() {
        KEYBOARD_OUTPUTS.selectStrategyMsg();
    }

    public void printInsertQueryMsg() {
        KEYBOARD_OUTPUTS.insertQueryMsg();
    }

    public void printFarewell() {
        KEYBOARD_OUTPUTS.farewell();
    }

    public void printWrongInput() {
        KEYBOARD_OUTPUTS.wrongInput();
    }

    public void printNotResultsMsg() {
        KEYBOARD_OUTPUTS.notResultsMsg();
    }

    public void printFindedResults(int quantity) {
        KEYBOARD_OUTPUTS.findedResultsMsg(quantity);
    }

    public void printRecords(List<Data> records) {
        KEYBOARD_OUTPUTS.printRecords(records);
    }

    public void printAny(Object obj) {
        KEYBOARD_OUTPUTS.printAny(obj);
    }
}
