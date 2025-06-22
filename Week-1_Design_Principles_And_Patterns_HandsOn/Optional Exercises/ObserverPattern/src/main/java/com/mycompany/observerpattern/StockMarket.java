
package com.mycompany.observerpattern;

import java.util.*;

public class StockMarket implements Stock {
    private Map<String, Double> stockPrices = new HashMap<>();
    private Map<String, List<Observer>> stockObservers = new HashMap<>();

    public void setStockPrice(String stockName, double price) {
        stockPrices.put(stockName, price);
        System.out.println("\n[Update] " + stockName + " = ₹" + price);
        notifyObservers(stockName, price);
    }

    @Override
    public void registerObserver(String stockName, Observer o) {
        stockObservers.putIfAbsent(stockName, new ArrayList<>());
        stockObservers.get(stockName).add(o);
    }

    @Override
    public void removeObserver(String stockName, Observer o) {
        if (stockObservers.containsKey(stockName)) {
            stockObservers.get(stockName).remove(o);
        }
    }

    @Override
    public void notifyObservers(String stockName, double price) {
        if (stockObservers.containsKey(stockName)) {
            for (Observer o : stockObservers.get(stockName)) {
                o.update(stockName, price);
            }
        }
    }
}
