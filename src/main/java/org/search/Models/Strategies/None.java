package org.search.Models.Strategies;

import org.search.Data;
import org.search.Enums.Strategies;
import org.search.Interfaces.Strategy;
import org.search.SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class None implements Strategy {

    @Override
    public List<String> search(List<Data> dataList, String[] searchTokens, SearchEngine searchEngine) {
        List<String> results = new ArrayList<>();
        for(Data d : dataList){
               String current = d.containsDataStrategy(searchTokens, Strategies.NONE);
               if(current != null && !current.isEmpty()) {
                   results.add(current);
               }
            }
        return results;
    }

}
