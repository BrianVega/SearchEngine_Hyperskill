package org.search.Models.Strategies;

import org.search.Enums.Strategies;
import org.search.Interfaces.Strategy;

public class StrategyFactory {

    public Strategy generateStrategy(Strategies strategy) {
        return switch (strategy) {
            case NONE -> new None();
            case ANY -> new Any();
            case ALL -> new All();
        };
    }
}
