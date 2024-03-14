package com.it.coingameplayscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.it.gamelogic.Game;

public class TurnBasedCoinGamePlayScreen extends JFrame {

	private JLabel coinsLabel;
	private JTextField userInput;
	private JButton pickButton;
	private Game game;

	public TurnBasedCoinGamePlayScreen(int totalCoins) {
        this.game = new Game(totalCoins);

        setTitle("Game Play");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);

        coinsLabel = new JLabel("Coins remaining: " + game.getCoinsRemaining());
        userInput = new JTextField(5);
        pickButton = new JButton("Pick");

        pickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int coinsTaken = Integer.parseInt(userInput.getText());
                game.playerMove(coinsTaken);
                coinsLabel.setText("Coins remaining: " + game.getCoinsRemaining());
            }
        });

        JPanel panel = new JPanel();
        panel.add(coinsLabel);
        panel.add(new JLabel("Pick coins:"));
        panel.add(userInput);
        panel.add(pickButton);

        add(panel);
        setVisible(true);
    }

	public static void main(String[] args) {
		new TurnBasedCoinGamePlayScreen(21);
	}
}
