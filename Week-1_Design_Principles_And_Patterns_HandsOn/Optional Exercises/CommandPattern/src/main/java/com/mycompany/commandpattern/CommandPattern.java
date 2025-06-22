

package com.mycompany.commandpattern;

import java.util.Scanner;
public class CommandPattern {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RemoteControl remote = new RemoteControl();

        Light light = new Light();
        Fan fan = new Fan();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        while (true) {
            System.out.println("\n--- Home Automation ---");
            System.out.println("1. Turn ON Light");
            System.out.println("2. Turn OFF Light");
            System.out.println("3. Turn ON Fan");
            System.out.println("4. Turn OFF Fan");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    remote.setCommand(lightOn);
                    break;
                case 2:
                    remote.setCommand(lightOff);
                    break;
                case 3:
                    remote.setCommand(fanOn);
                    break;
                case 4:
                    remote.setCommand(fanOff);
                    break;
                case 5:
                    System.out.println("System Shut Down.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            remote.pressButton();  
        }
    }
}
