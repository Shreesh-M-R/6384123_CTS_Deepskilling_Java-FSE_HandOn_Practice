/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.singleton_patter;
/**
 *
 * @author lavan
 */
public class Singleton_Patter {
    public static void main(String[] args) {
        Instance_1 In_1= Instance_1.getInstance();
        In_1.log("This is the first message");


        Instance_1 In_2 = Instance_1.getInstance();
        In_2.log("This is the second message");   
        
        if (In_1 == In_2) {
            System.out.println("Both Instances_1 and Instances_2 are the same instance");
        } else {
            System.out.println("Different Instances exist! Singleton failed");
        }
    }   
}
