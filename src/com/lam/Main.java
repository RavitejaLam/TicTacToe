package com.lam;

import java.util.Scanner;

public class Main {

	private static boolean resumeMenu(Scanner sc) {
		while (true) {
			System.out.print("1. Resume\n0. Back to Menu\n");
			switch (sc.nextInt()) {
				case 1:
					return false;
				case 0:
					return true;
				default:
					System.out.println("Invalid Input. Try another input...");
			}
		}
	}

	private static boolean restartGameMenu(GameBoard game, Scanner sc) {
		while (true) {
			System.out.println("1. Rematch\n2. Change Players\n3. Back to Menu");
			int input = sc.nextInt();
			switch (input) {
				case 1:
					return true;
				case 2:
					game.setPlayers(sc);
					return true;
				case 3:
					return false;
				default:
					System.out.println("Invalid Input. Try another input...");
			}
		}
	}

	private static void startNewGame(Scanner sc) {
		boolean OisStarting = true;
		GameBoard game = new GameBoard();
		game.initializeBoard();
		game.setPlayers(sc);
		char currentTrun = 'O';
		System.out.println("0 -> Back\n1-9 -> Valid Inputs\n");
		while (true) {
			int option;
			game.printBoard();
			switch (currentTrun) {
				case 'O':
					System.out.print(game.getPlayerOne() + "'s Turn Option : ");
					option = sc.nextInt();
					if (option == 0)
						if (resumeMenu(sc))
							return;
						else
							continue;
					if (game.setChar('O', option - 1))
						currentTrun = 'X';
					else
						System.out.println("Invalid Input " + game.getPlayerOne() + ". Try another input...");
					break;
				case 'X':
					System.out.print(game.getPlayerTwo() + "'s Turn Option : ");
					option = sc.nextInt();
					if (option == 0)
						if (resumeMenu(sc))
							return;
						else
							continue;
					if (game.setChar('X', option - 1))
						currentTrun = 'O';
					else
						System.out.println("Invalid Input " + game.getPlayerTwo() + ". Try another input...");
					break;
			}
			if (game.isCompleted()) {
				game.printBoard();
				if (currentTrun == 'O')
					System.out.println("Winner is " + game.getPlayerTwo());
				else
					System.out.println("Winner is " + game.getPlayerOne());
				game.initializeBoard();
				if (OisStarting) {
					OisStarting = false;
					currentTrun = 'X';
				} else {
					OisStarting = true;
					currentTrun = 'O';
				}
				if (!restartGameMenu(game, sc))
					break;
			} else if (game.slotsLeft == 0) {
				System.out.println("This game is a Draw");
				game.initializeBoard();
				if (OisStarting) {
					OisStarting = false;
					currentTrun = 'X';
				} else {
					OisStarting = true;
					currentTrun = 'O';
				}
				if (!restartGameMenu(game, sc))
					break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("\n\nTic Tac Toe\n\n");
		while (true) {
			System.out.print("1. New Game\n2. Leader Board\n3. Quit\nOption : ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {
				case 1:
					startNewGame(sc);
					break;
				case 2:
					System.out.println("Yet to Develop\n");
					break;
				case 3:
					System.out.println("\n\nThank You\n\n");
					System.exit(0);
					break;
				default:
					System.out.println("InValid input option...\n");
			}
		}
	}
}
