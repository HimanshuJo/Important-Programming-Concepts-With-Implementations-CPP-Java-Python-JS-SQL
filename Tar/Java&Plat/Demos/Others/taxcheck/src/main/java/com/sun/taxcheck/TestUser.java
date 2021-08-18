/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sun.taxcheck;

/**
 *
 * @author hjoshi
 */
public class TestUser {

    /**
     * Creates a new instance of TestUser
     */
    private String name;
    private String profession;
    private double amount;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double myAmount() {
        if (amount <= 9168) {
            return 0;
        } else if (amount > 9168 && amount <= 14254) {
            double y = 1 / 10000 * (10000 - 9168);
            return (980.14 * y + 1400) * y;
        } else if (amount > 14254 && amount <= 55960) {
            double z = (1.0 / 10000.0) * (45000 - 14254);
            return (216.16 * z + 2397) * z + 965.58;
        } else if (amount > 55961 && amount <= 265326) {
            int m = 100000;
            return ((0.42 * m) - 8780.90);
        } else
            return 0.45 * amount  - 16740.68;
    }
}
