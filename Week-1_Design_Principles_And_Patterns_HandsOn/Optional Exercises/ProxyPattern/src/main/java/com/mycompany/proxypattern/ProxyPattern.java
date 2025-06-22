/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proxypattern;

public class ProxyPattern { 
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");
        Image img2 = new ProxyImage("cityscape.png");

        img1.display();
        System.out.println();

        img1.display();
        System.out.println();

        img2.display();
        System.out.println();

        img2.display();
    }
}
