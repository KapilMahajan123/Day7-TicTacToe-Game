package com.TicTacToe.java;

import java.util.*;

/**
 * 
 * @author Kapil
 *
 */
public class TicTacToe {
	
	static char[] board = new char[10];    //Taking array
	static char turn;

	/**
	 * Creating the game board
	 * Select the index from 1 to 9 to make the movw
	 */
	private static void createBoard() {
		System.out.println("Welcome to Tic Tac Toe");
		for (int i = 1; i < 10; i++) {		//initialize
			board[i] = ' ';
		}
	}

	/**
	 * This game has two player x and o
	 * taking input from user to choose the turn
	 */
	private static void chooseLetter() {
		Scanner scanner = new Scanner(System.in);  // Create an object
		System.out.println("Enter the character X or O to choose the turn:");
		char turn = scanner.next().charAt(0);
		if (turn == 'X' || turn == 'x') {
			System.out.println("Computer's turn to play the game");
			turn = 'O';
		} else if (turn == 'O' || turn == 'o') {
			System.out.println("Player's turn to play the game");
			turn = 'X';
		} else {
			System.out.println("Invalid input");
		}

	}

	/**
	 * Displaying the tictactoe game board
	 */
	private static void showBoard() {
		
		
		 System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
 		 System.out.println("---------");
 		 System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
 		 System.out.println("---------");
 		 System.out.println(board[7] + " | " + board[8] + " | " + board[9]);

	}

	/**
	 * user has already made a move
	 * if it is not in range from 1 to 9
	 * then it will show you an invalid input and then re-entering number
	 */
	private static void madeMove(boolean firstPlayer) {
		Scanner scanner = new Scanner(System.in);
		String winner = null;
		if (firstPlayer == true) {
			turn = 'X';
		} else {
			turn = 'O';
		}
		while (winner == null) {
			System.out.println("Enter your slot number from 1 to 9: ");
			int move = scanner.nextInt();
			if (!(move > 0) && (move < 10)) {
				System.out.println("Invalid move, Re-enter the slot number:");
				continue;
			} else if (board[move] == ' ') {
				board[move] = turn;
				showBoard();
				if (turn == 'X') {
					turn = 'O';
				} else {
					turn = 'X';
				}
				winner = checkWiningCombinations();

			} else {
				System.out.println("Slot is taken already; Re-enter the slot number: ");
				showBoard();
				continue;
			}
		}

		if (winner.equalsIgnoreCase("tie")) {
			System.out.println("It's a tie| Thanks for playing");
		} else {
			System.out.println("Congratulations! " + winner + " has won.");
		}
	}

	/**
	 * Tossing the coin to check who plays first
	 */
	private static boolean tossToStartGame() {
		Random random = new Random();
		return random.nextBoolean();
	}

	/**
	 * Checking after move the winner or the tie or change in turn
	 */
	private static String checkWiningCombinations() {
		for (int a = 1; a < 9; a++) {
			StringBuilder sb = new StringBuilder();
			String line;

			switch (a) {
			case 1:
				line = Character.toString(board[1] + board[2] + board[3]);
				break;
			case 2:
				line = Character.toString(board[4] + board[5] + board[6]);
				break;
			case 3:
				line = Character.toString(board[7] + board[8] + board[9]);
				break;
			case 4:
				line = Character.toString(board[1] + board[4] + board[7]);
				break;
			case 5:
				line = Character.toString(board[2] + board[5] + board[8]);
				break;
			case 6:
				line = Character.toString(board[3] + board[6] + board[9]);
				break;
			case 7:
				line = Character.toString(board[1] + board[5] + board[9]);
				break;
			case 8:
				line = Character.toString(board[3] + board[5] + board[7]);
				System.out.println("String is: " + line);
				break;

			}
			if (sb.equals("XXX")) {
				return "Computer";
			} else if (sb.equals("OOO")) {
				return "Player";
			}
		}
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				break;
			} else if (i == 9)
				return "tie";

		}
		System.out.println(turn + "turn; enter a slot number to place the " + turn + " in: ");
		return null;

	}

	public static void main(String args[]) {

		createBoard();
		chooseLetter();
		showBoard();
		madeMove(true);
	}
}
