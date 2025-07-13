/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.CountryController.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {

    @NotNull
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    private String name;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
