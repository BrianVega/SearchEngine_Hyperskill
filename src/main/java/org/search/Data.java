package org.search;

import org.search.Enums.Strategies;

public class Data {
    private String firstParameter = "";
    private String secondParameter = "";
    private String thirdParameter = "";
    private String lastRegister;

    public Data(String[] parameters) {
        String prev = parameters[0];
        for(int idx = 0; idx < parameters.length; idx++) {
            if(parameters[idx].isEmpty()) {
                lastRegister = prev;
                break;
            }
            prev = parameters[idx];
        }

        lastRegister = lastRegister == null ? parameters[2] : lastRegister;
        this.firstParameter = parameters[0];
        this.secondParameter = parameters[1];
        this.thirdParameter = parameters[2];
    }

    public String[] containsData(String search, Strategies strategy) {
        String[] results = new String[3];
        boolean found = false;
        if(strategy.equals(Strategies.ALL)) {
            search = search.toLowerCase();
            if(firstParameter.toLowerCase().contains(search) ||
                    secondParameter.toLowerCase().contains(search) ||
                    thirdParameter.toLowerCase().contains(search)){
                results[0] = firstParameter;
                results[1] = secondParameter;
                results[2] = thirdParameter;
                found = true;
            }
            if(found){
                return results;
            }else{
                return new String[0];
            }
        }else{
            return getAllParameters();
        }
    }

    public String containsDataStrategy(String[] searchTokens, Strategies strategy){
        return switch (strategy) {
            case ALL -> allStrategy(searchTokens);
            case ANY -> anyStrategy(searchTokens);
            case NONE -> noneStrategy(searchTokens);
        };
    }

    private String[] getAllParameters(){
        return new String[]{this.firstParameter, this.secondParameter, this.thirdParameter};
    }

    private String allStrategy(String[] searchTokens) {
        int coindicences = 0;
        for (String search : searchTokens) {
            if(search.toLowerCase().matches(firstParameter.toLowerCase())
                    || search.toLowerCase().matches(secondParameter.toLowerCase())
                    || search.toLowerCase().matches(thirdParameter.toLowerCase())){
                coindicences++;
            }
        }
        if(coindicences == searchTokens.length){
            return toString();
        }
        return null;
    }

    private String anyStrategy(String[] searchTokens) {
        for (String search : searchTokens) {
            if(containsData(search, Strategies.ALL).length > 0){
                return toString();
            }
        }
        return null;
    }

    private String noneStrategy(String[] searchTokens) {
        boolean found = false;
        for(String search : searchTokens){
            if(containsData(search, Strategies.ALL).length > 0){
                found = true;
            }
        }
        if(!found){
            return toString();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!firstParameter.isEmpty()){
            sb.append(firstParameter);
        }
        if(!secondParameter.isEmpty()){
            sb.append(" ").append(secondParameter);
        }
        if(!thirdParameter.isEmpty()){
            sb.append(" ").append(thirdParameter);
        }
        return sb.toString();
    }

    public String getLastRegister(){
        return lastRegister;
    }

}
