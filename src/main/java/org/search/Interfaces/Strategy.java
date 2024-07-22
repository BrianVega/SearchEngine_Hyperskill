package org.search.Interfaces;

import org.search.Data;
import org.search.SearchEngine;

import java.util.List;

public interface Strategy {
    List<String> search(List<Data> data, String[] searchTokens, SearchEngine searchEngine);
}

