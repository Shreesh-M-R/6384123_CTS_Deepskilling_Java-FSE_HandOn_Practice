
package com.mycompany.adapterpattern;

public class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed via PayPal.");
    }
}

