/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finance_forecast;

import java.util.Scanner;

public class Finance_Forecast {

     public static double calculateFutureValue(int years, double initialValue, double growthRate) {
        double currentValue = initialValue;

        for (int i = 1; i <= years; i++) {
            currentValue *= (1 + growthRate);
        }

        return currentValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial investment amount: ");
        double initialValue = scanner.nextDouble();
        System.out.print("Enter the annual growth rate (%): ");
        double growthRatePercent = scanner.nextDouble();
        double growthRate = growthRatePercent / 100.0;
        System.out.print("Enter the number of years to forecast: ");
        int years = scanner.nextInt();
        double futureValue = calculateFutureValue(years, initialValue, growthRate);
        System.out.printf("Future value after %d years = %.2f\n", years, futureValue);
    }
}
