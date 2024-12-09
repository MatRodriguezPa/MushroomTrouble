package Controller;

import Controller.GameGenerator;
import View.Settings;
import View.Selection;
import View.Start;
import java.awt.event.*;

public class MenuSelectionController implements ActionListener {

    Start start;
    Selection selection = new Selection();
    Settings settings;
    GameGenerator inGameController;
    short lives;
    short deck;
    short players;
    short gamemode;

    public MenuSelectionController(Start start) {
        this.start = start;
        start.jButton1.addActionListener(PlayActionListener);
        start.jButton2.addActionListener(SettingsActionListener);
        start.jButton3.addActionListener(StartGameActionListener);

        selection.jRadioButton1.addActionListener(jRadioButton1Listener);
        selection.jRadioButton2.addActionListener(jRadioButton2Listener);
        selection.jRadioButton3.addActionListener(jRadioButton3Listener);

        selection.jComboBox1.addActionListener(jComboBOx1Listener);
        selection.jComboBox2.addActionListener(jComboBOx2Listener);
        selection.jComboBox3.addActionListener(jComboBOx3Listener);
    }

    public void play() {
        start.setVisible(true);
    }

    private final ActionListener PlayActionListener = e -> {
        start.jButton1.setText("Start Game");
        selection.setVisible(true);
        start.add(selection);
    };

    private final ActionListener StartGameActionListener = e -> {
        start.setVisible(false);

        inGameController = new GameGenerator(lives, deck, players, gamemode);
        inGameController.GenerateField();

        System.out.println("Lives: " + lives);
        System.out.println("Desk: " + deck);
        System.out.println("Players: " + players);
        System.out.println("Game mode: " + gamemode);
    };

    //Establecer modo de juego
    private final ActionListener jRadioButton1Listener = e -> {
        gamemode = 0;
    };
    private final ActionListener jRadioButton2Listener = e -> {
        gamemode = 1;
    };
    private final ActionListener jRadioButton3Listener = e -> {
        gamemode = 2;
    };

    //Establecer vidas de los jugadores
    private final ActionListener jComboBOx1Listener = e -> {
        switch (selection.jComboBox1.getSelectedIndex()) {
            case 0:
                lives = 3;
                break;
            case 1:
                lives = 5;
                break;
            case 2:
                lives = 7;
                break;
        }
    };

    private final ActionListener jComboBOx2Listener = e -> {
        switch (selection.jComboBox1.getSelectedIndex()) {
            case 0:
                deck = 5;
                break;
            case 1:
                deck = 7;
                break;
            case 2:
                deck = 10;
                break;
        }
    };

    private final ActionListener jComboBOx3Listener = e -> {
        switch (selection.jComboBox1.getSelectedIndex()) {
            case 0:
                players = 2;
                break;
            case 1:
                players = 3;
                break;
            case 2:
                players = 4;
                break;
        }
    };

    private final ActionListener SettingsActionListener = e -> {
        settings = new Settings();
        settings.setVisible(true);
    };

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
