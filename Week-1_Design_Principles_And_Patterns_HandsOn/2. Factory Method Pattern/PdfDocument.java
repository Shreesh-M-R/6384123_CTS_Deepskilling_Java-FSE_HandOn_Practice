/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factory_method_pattern;

/**
 *
 * @author lavan
 */
public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}