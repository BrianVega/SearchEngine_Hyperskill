package org.search.Models.Strategies;

import org.search.Data;
import org.search.Enums.Strategies;
import org.search.Interfaces.BaseSearch;
import org.search.Interfaces.Strategy;
import org.search.SearchEngine;

import java.util.List;

public class Any extends BaseSearch implements Strategy {

    @Override
    public List<String> search(List<Data> data, String[] searchTokens, SearchEngine searchEngine) {
        return findMatches(searchTokens, searchEngine, data);
    }

    @Override
    public Strategies getStrategy() {
        return Strategies.ANY;
    }

}
