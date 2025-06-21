/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleton_patter;

/**
 *
 * @author lavan
 */
public class Instance_1 {
    
    private static Instance_1 instance;

    
    private Instance_1() {
        System.out.println("Instance_1 created");
    }

    
    public static Instance_1 getInstance() {
        if (instance == null) {
            instance = new Instance_1(); 
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Instance_1: " + message);
    }
}
