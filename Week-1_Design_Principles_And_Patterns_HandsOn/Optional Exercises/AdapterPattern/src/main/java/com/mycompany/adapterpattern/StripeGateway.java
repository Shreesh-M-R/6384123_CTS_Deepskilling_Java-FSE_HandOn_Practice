
package com.mycompany.adapterpattern;

public class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed via Stripe.");
    }
}

