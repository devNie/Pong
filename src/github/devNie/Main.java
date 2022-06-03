package github.devNie;

import github.devNie.graphics.Window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

// TODO
// make the game work
// add about
// add sfx


public class Main {
    static Scanner debug = new Scanner(System.in);

    public static void main(String[] args) {
        Window.getFrame().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        // LEFT PALLET UP
                    case KeyEvent.VK_S:
                        // LEFT PALLET DOWN
                    case KeyEvent.VK_UP:
                        // RIGHT PALLET UP
                    case KeyEvent.VK_DOWN:
                        // RIGHT PALLET DOWN
                        break;
                    case KeyEvent.VK_ESCAPE:
                        // EXIT PROMPT
                        break;
                    case KeyEvent.VK_SPACE:
                        // GAME START
                        break;
                }
            }
        });
        Window.create();
        Window.setMenu();
    }
}
