/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.observerpattern;

public interface Stock {
    void registerObserver(String stockName, Observer o);
    void removeObserver(String stockName, Observer o);
    void notifyObservers(String stockName, double price);
}

