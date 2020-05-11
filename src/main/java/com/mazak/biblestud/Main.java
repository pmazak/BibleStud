package com.mazak.biblestud;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
    public static void main(String[] args) {
        App form = new App();
        form.setSize(400, 350);
        form.setVisible(true);
        form.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }
}
