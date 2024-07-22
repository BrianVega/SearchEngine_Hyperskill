package org.search.Interfaces;

import org.search.Data;
import org.search.Enums.Strategies;
import org.search.SearchEngine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseSearch {

    protected List<String> findMatches(String[] searchTokens, SearchEngine searchEngine, List<Data> data) {
        List<String> result = new ArrayList<>();
        List<List<Integer>> coincidences = new ArrayList<>();

        for(String token : searchTokens) {
            coincidences.add(searchEngine.getInvertedIndexMap().get(token.toLowerCase()));
        }
        Set<Integer> uniqueRegisters = new HashSet<>();
        fillUniqueRegisters(uniqueRegisters, coincidences);

        for (int register : uniqueRegisters) {
            String current = data.get(register).containsDataStrategy(searchTokens, getStrategy());
            if (current != null && !current.isEmpty()) {
                result.add(current);
            }
        }
        return result;
    }

    protected abstract Strategies getStrategy();

    private void fillUniqueRegisters(Set<Integer> uniqueRegisters, List<List<Integer>> coincidences) {
        uniqueRegisters.clear();
        for(List<Integer> coincidence : coincidences){
            if(coincidence != null && !coincidence.isEmpty()){
                uniqueRegisters.addAll(coincidence);
            }
        }
    }
}
