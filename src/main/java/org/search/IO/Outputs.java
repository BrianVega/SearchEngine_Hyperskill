package org.search.IO;

import org.search.Data;
import org.search.Enums.Strategies;

import java.util.List;

public class Outputs {

    public void displayMenu() {
        System.out.println(
                "\n=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit"
        );
    }

    public void farewell() {
        System.out.println("\nBye!");
    }

    public void wrongInput() {
        System.out.println("\nIncorrect option! Try again.");
    }

    public void selectStrategyMsg() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
    }

    public void insertQueryMsg() {
        System.out.println("\nEnter a name or email to search all suitable people.");
    }

    public void notResultsMsg() {
        System.out.println("No matching people found!");
    }

    public void findedResultsMsg(int quantity){
        System.out.println(quantity + " persons found:");
    }

    public void printAny(Object obj) {
        System.out.println(obj.toString());
    }

    public void printRecords(List<Data> records) {
        boolean foundSome = false;

        for(Data record : records){
            String[] dataFound = record.containsData(null, Strategies.ANY);
            if(dataFound.length > 0 && !foundSome){
                System.out.println("\n=== List of people ===");
            }
            if(dataFound.length > 0) {
                for (String s : dataFound) {
                    if (!s.isEmpty()) {
                        foundSome = true;
                        System.out.print(s);
                        if (s != record.getLastRegister() ){
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
        if(!foundSome){
            System.out.println("No matching people found");
        }
    }
}
