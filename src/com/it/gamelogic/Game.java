package com.it.gamelogic;

public class Game {

	private int coinsRemaining;

	public Game(int totalCoins) {
		this.coinsRemaining = totalCoins;
	}

	public int getCoinsRemaining() {
		return coinsRemaining;
	}

	public void playerMove(int coinsTaken) {
		coinsRemaining -= coinsTaken;
		if (coinsRemaining <= 0) {
			System.out.println("You lost!");

		} else {
			aiMove();
		}
	}

	private void aiMove() {
		int aiCoins = (coinsRemaining - 1) % 5;
		if (aiCoins == 0) {
			aiCoins = (int) (Math.random() * 4) + 1; // AI randomly picks between 1 to 4 coins
		}
		coinsRemaining -= aiCoins;
		System.out.println("AI takes " + aiCoins + " coins.");
		if (coinsRemaining <= 0) {
			System.out.println("You win!");

		}
	}
}
