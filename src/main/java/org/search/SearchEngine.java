package org.search;

import org.search.Enums.Strategies;
import org.search.Interfaces.Strategy;
import org.search.Models.Strategies.StrategyFactory;
import org.search.UI.UserInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SearchEngine {
    private final UserInterface UI;
    private List<Data> data;
    private static Map<String, List<Integer>> invertedIndexMap = new HashMap<>();


    public SearchEngine(String[] records) {
        UI = new UserInterface();
        data = new ArrayList<>();
        loadSearchEngineData(records);
    }

    public void loadSearchEngineData(String[] loadedData) {
        if(loadedData.length == 0) return;

        File file = new File(loadedData[1]);
        int index = 0;
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] tokens = new String[3];
                String[] splittedInput = line.split("\\s+");
                fillInvertedIndexMap(splittedInput, index);
                fillDataWithTokens(tokens, splittedInput);
                data.add(new Data(new String[]{tokens[0], tokens[1], tokens[2]}));
                index += 1;
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found -> " + file);
        }
    }

    public Map<String, List<Integer>> getInvertedIndexMap() {
        return invertedIndexMap;
    }

    public void start() {
        // wrap with a dowhile
        int option;
        do {
            UI.printMainMenu();
            option = UI.getMainMenuInput();
            switch (option) {
                case 1 -> findRecords();
                case 2 -> getAllRecords();
                case 0 -> UI.printFarewell();
                default -> UI.printWrongInput();
            }
        } while (option != 0);
    }

    private void findRecords() {
        StrategyFactory strategyFactory = new StrategyFactory();

        UI.printSearchStrategyMsg();
        Strategies matchingStrategy = UI.getSearchStrategy();
        Strategy strategy = strategyFactory.generateStrategy(matchingStrategy);


        UI.printInsertQueryMsg();
        String query = UI.getQuery();

        String[] searchTokens = generateTokens(query);


        List<String> result = strategy.search(data, searchTokens, this);

        if(result.isEmpty()){
            UI.printNotResultsMsg();
            return;
        }
        UI.printFindedResults(result.size());
        for(String register : result){
            UI.printAny(register);
        }
    }

    private void getAllRecords() {
        UI.printRecords(data);
    }

    private void fillInvertedIndexMap(String[] splittedInput, int index) {
        Arrays.stream(splittedInput).forEach(token -> {
            token = token.toLowerCase();
            if(!invertedIndexMap.containsKey(token)){
                invertedIndexMap.put(token, new ArrayList<>());
            }
            invertedIndexMap.get(token).add(index);

        });
    }

    private void fillDataWithTokens(String[] tokens, String[] splittedInput) {
        int lineSize = splittedInput.length;
        for(int idx = 0; idx < tokens.length; idx++){
            if(idx < lineSize){
                tokens[idx] = splittedInput[idx];
            }else{
                tokens[idx] = "";
            }
        }
    }

    private String[] generateTokens(String input) {
        return input.split("\\s+");
    }
}
