/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factory_method_pattern;

import java.util.Scanner;

/**
 *
 * @author lavan
 */
public class Factory_method_Pattern {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;

        System.out.println("=== Document Creator ===");
        System.out.println("Enter the type of document you want to create (Word / PDF / Excel): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "word":
                factory = new WordDocumentFactory() {};
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid input. Please enter Word, PDF, or Excel.");
                System.exit(0);
        }

        Document document = factory.createDocument();
        document.open();
    }
}
