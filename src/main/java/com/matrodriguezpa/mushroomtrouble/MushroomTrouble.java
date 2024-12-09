
package main.java.com.matrodriguezpa.mushroomtrouble;

import Controller.MenuSelectionController;
import View.Start;

public class MushroomTrouble {

    public static void main(String[] args) {
        Start start = new Start();
        MenuSelectionController controller = new MenuSelectionController(start);
        
        controller.play();
    }
    
}
