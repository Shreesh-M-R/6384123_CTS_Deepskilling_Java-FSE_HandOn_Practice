
package com.mycompany.observerpattern;

public class ObserverPattern {

    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileAfrin = new MobileApp("Afrin");
        Observer webArun = new WebApp("Arun");
        Observer mobileNeha = new MobileApp("Neha");

        market.registerObserver("TCS", mobileAfrin);
        market.registerObserver("TCS", webArun);
        market.registerObserver("INFY", mobileNeha);
        market.registerObserver("WIPRO", webArun);
        market.registerObserver("WIPRO", mobileAfrin);

        market.setStockPrice("TCS", 3500);
        market.setStockPrice("INFY", 1480.5);
        market.setStockPrice("WIPRO", 410.75);

        market.removeObserver("WIPRO", mobileAfrin);
        market.setStockPrice("WIPRO", 420.00);
    }
}
