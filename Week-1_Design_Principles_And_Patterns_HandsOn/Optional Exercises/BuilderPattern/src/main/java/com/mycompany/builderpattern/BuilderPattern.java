/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.builderpattern;
import java.util.Scanner;
/**
 *
 * @author lavan
 */
public class BuilderPattern {
    
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Build Your Own Computer");

        System.out.print("Enter CPU (required): ");
        String cpu = sc.nextLine();

        System.out.print("Enter RAM (required): ");
        String ram = sc.nextLine();

        // Start with required fields
        Computer.Builder builder = new Computer.Builder(cpu, ram);

        // Optional fields
        System.out.print("Enter Storage (optional, press Enter to skip): ");
        String storage = sc.nextLine();
        if (!storage.isEmpty()) {
            builder.storage(storage);
        }

        System.out.print("Enter GPU (optional, press Enter to skip): ");
        String gpu = sc.nextLine();
        if (!gpu.isEmpty()) {
            builder.gpu(gpu);
        }

        System.out.print("Enter OS (optional, press Enter to skip): ");
        String os = sc.nextLine();
        if (!os.isEmpty()) {
            builder.os(os);
        }
        Computer myComputer = builder.build();
        myComputer.showConfig();
    }
}
