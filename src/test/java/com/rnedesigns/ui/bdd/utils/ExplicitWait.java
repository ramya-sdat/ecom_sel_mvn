package com.rnedesigns.ui.bdd.utils;

public class ExplicitWait {

    public void explicitlyWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
