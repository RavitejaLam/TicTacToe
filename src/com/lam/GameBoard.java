package com.lam;

import java.util.Scanner;

public class GameBoard {
	private Character[][] board = new Character[3][3];
	private String playerOne;
	private String playerTwo;
	int slotsLeft = 9;

	void initializeBoard() {
		slotsLeft = 9;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	void setPlayers(Scanner sc) {
		System.out.print("Enter player 1 Name : ");
		this.playerOne = sc.next();
		System.out.print("Enter player 2 Name : ");
		this.playerTwo = sc.next();
	}

	public boolean isCompleted() {
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
			return true;
		if (board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][1] == board[0][2])
			return true;
		if (board[1][0] != ' ' && board[1][0] == board[1][1] && board[1][1] == board[1][2])
			return true;
		if (board[2][0] != ' ' && board[2][0] == board[2][1] && board[2][1] == board[2][2])
			return true;
		if (board[0][0] != ' ' && board[0][0] == board[1][0] && board[1][0] == board[2][0])
			return true;
		if (board[0][1] != ' ' && board[0][1] == board[1][1] && board[1][1] == board[2][1])
			return true;
		if (board[0][2] != ' ' && board[0][2] == board[1][2] && board[1][2] == board[2][2])
			return true;
		return board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0];
	}

	boolean setChar(char C, int pos) {
		int i = pos / 3;
		int j = pos % 3;
		if (board[i][j] != ' ')
			return false;
		board[i][j] = C;
		slotsLeft--;
		return true;
	}

	void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
			System.out.println("-------------");
		}
		System.out.println();
	}

	String getPlayerOne() {
		return playerOne;
	}

	String getPlayerTwo() {
		return playerTwo;
	}
}
