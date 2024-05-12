package dev.mike;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        TaskMenu menu = new TaskMenu();
        while (true){
            menu.runMenu();;
        }
    }
}