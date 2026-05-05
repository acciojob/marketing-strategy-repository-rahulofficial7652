package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingStrategyManager {
    private List<MarketingStrategy> strategies;

    public MarketingStrategyManager() {
        this.strategies = new ArrayList<>();
    }

    public void createStrategy(MarketingStrategy strategy) {
    	//your code goes here
        strategies.add(strategy);

    }

    public MarketingStrategy getStrategyByName(String name) {
    	//your code goes here
        return strategies.stream()
                .filter(strategy -> strategy.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void updateStrategy(MarketingStrategy updatedStrategy) {
    	//your code goes here
        for (MarketingStrategy s : strategies){
            if(s.getName().equalsIgnoreCase(updatedStrategy.getName())){
                s.setDescription(updatedStrategy.getDescription());
                s.setTargetAudience(updatedStrategy.getTargetAudience());
                s.setBudget(updatedStrategy.getBudget());
                s.setPotentialROI(updatedStrategy.getPotentialROI());
                break;
            }
        }
    }

    public void deleteStrategy(String name) {
    	//your code goes here
        strategies.removeIf(s ->s.getName().equalsIgnoreCase(name));
    }

    public List<MarketingStrategy> getStrategiesInBudgetRange(double minBudget, double maxBudget) {
    	//your code goes here
        return strategies.stream()
                .filter(strategy -> strategy.getBudget() >= minBudget && strategy.getBudget() <= maxBudget)
                .collect(Collectors.toList());
    }

    public List<MarketingStrategy> getAllStrategies() {
    	//your code goes here
        return new ArrayList<>(strategies);
    }
}

