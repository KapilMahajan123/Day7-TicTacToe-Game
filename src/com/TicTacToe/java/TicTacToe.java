package com.TicTacToe.java;

import java.util.*;

/**
 * 
 * @author Kapil
 *
 */
public class TicTacToe {

		public TicTacToe() {
			System.out.println("Welcome to Tic Tac Toe Game !!!");
		}

		/*
		 *  Declaring variables
		 *  taking array of the board
		 *  This game has two player x and o
		 */
		static char[] board = new char[10];
		static char player, computer;       
		static int playerLocation, computerLocation;   
		static int toss;
		static boolean computerFlag = false, playerFlag = false;
		static Scanner scanner = new Scanner(System.in);
		static Random random = new Random();

		public static void main(String[] args) {

			// Initialize the object
			TicTacToe object = new TicTacToe();

			initialize();
			showBoard();
			chooseOption();
			toss();
			if (computerFlag == true) {
				System.out.println("Now Player's Turn");
				playerMove();
				computerFlag = false;
				playerFlag = true;
			} else if (playerFlag == true) {
				System.out.println("Now Computer's Turn");
				computerMove();
				playerFlag = false;
				computerFlag = true;
			}
			checkGame();
			System.out.println("Turn Changed");

		}

		// Initialize
		public static void initialize() {
			for (int i = 1; i < 10; i++) {
				board[i] = ' ';
			}
		}

		/*
		 * Doing a toss for playing first
		 */
		public static void toss() {
			toss = random.nextInt(2);
			switch (toss) {
			case 0:
				System.out.println("Flipping Tail.\nComputer starts first.");
				computerMove();// Computer move
				computerFlag = true;
				break;
			case 1:
				System.out.println("Flipping Head.\nPlayer starts first.");
				playerMove();// Player move
				playerFlag = true;
				break;
			}
		}

		/*
		 *  Allow player to choose X or O
		 */
		public static void chooseOption() {
			System.out.println("Please Select Your Choice Letter : \nProvide 'X' or 'O'");
			player = check();
			System.out.println("Player choosing option : " + player);
		}

		public static char check()
		{
			char choice = scanner.next().charAt(0);
			if (choice == 'X' || choice == 'x') {
				player = 'X';
				computer = 'O';
			} else if (choice == 'O' || choice == 'o') {
				player = 'O';
				computer = 'X';
			} else {
				System.out.println("Invalid option.\nProvide the valid one");
				check();
			}
			return player;
		}

		/*
		 * To displaying tic tac toe board
		 */
		public static void showBoard() {
			System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
			System.out.println("---------");
			System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
			System.out.println("---------");
			System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
		}

		/*
		 * player is going to make a move to the desired location
		 * if it is not in range from 1 to 9
		 * then it will show you an invalid input
		 */
		public static void playerMove() {
			checkFreeSpace();
			System.out.println("Enter the position between (1-9) you want to make your move :");
			playerLocation = scanner.nextInt();
			if (playerLocation > 0 && playerLocation < 10) {
				if (board[playerLocation] == ' ') {
					board[playerLocation] = player;
					showBoard();
				} else if (board[playerLocation] != ' ') {
					System.err.println("Sorry! Position is already choosen. Enter a valid position");
					showBoard();
					playerMove();
					showBoard();
				}
			} else {
				System.err.println("Invalid choice. Provide a valid position between (1-9)");
				playerMove();
			}
		}

		// To make the computer move
		public static void computerMove() {
			computerLocation = random.nextInt(8) + 1;
			if (computerLocation > 0 && computerLocation < 10) {
				if (board[computerLocation] == ' ') {
					board[computerLocation] = computer;
					showBoard();
				} else if (board[computerLocation] != ' ') {
					computerMove();
				}
			}
		}

		// To check free space
		public static void checkFreeSpace() {
			boolean isSpaceAvailable = false;
			int numOfFreeSpaces = 0;
			for (int index = 1; index < board.length; index++) {
				if ((board[index] == ' ')) {
					isSpaceAvailable = true;
					numOfFreeSpaces++;
				}
			}
			if (isSpaceAvailable == false) {
				System.err.println("Board is full! You can't make another move");
			} else {
				System.out.println("Free space is available! you have " + numOfFreeSpaces + " moves left");
			}
		}
		
		//To check 
	    public static void checkGame()
	    {
	        if ((board[1] == player && board[2] == player || board[2] == player && board[3] == player || board[1] == player && board[3] == player) ||
	           (board[4] == player && board[5] == player || board[5] == player && board[6] == player || board[4] == player && board[6] == player) ||
	           (board[7] == player && board[8] == player || board[8] == player && board[9] == player || board[7] == player && board[9] == player) ||
	           (board[1] == player && board[5] == player || board[5] == player && board[9] == player || board[1] == player && board[9] == player) ||
	           (board[3] == player && board[5] == player || board[5] == player && board[7] == player || board[3] == player && board[7] == player) ||
	           (board[1] == player && board[4] == player || board[4] == player && board[7] == player || board[1] == player && board[7] == player) ||
	           (board[2] == player && board[5] == player || board[5] == player && board[8] == player || board[2] == player && board[8] == player) ||
	           (board[3] == player && board[6] == player || board[6] == player && board[9] == player || board[3] == player && board[9] == player))
	        {
	            System.out.println("Player going to win");
	        }
	        else if ((board[1] == computer && board[2] == computer || board[2] == computer && board[3] == computer || board[1] == computer && board[3] == computer) ||
	                (board[4] == computer && board[5] == computer || board[5] == computer && board[6] == computer || board[4] == computer && board[6] == computer) ||
	                (board[7] == computer && board[8] == computer || board[8] == computer && board[9] == computer || board[7] == computer && board[9] == computer) ||
	                (board[1] == computer && board[5] == computer || board[5] == computer && board[9] == computer || board[1] == computer && board[9] == computer) ||
	                (board[3] == computer && board[5] == computer || board[5] == computer && board[7] == computer || board[3] == computer && board[7] == computer) ||
	                (board[1] == computer && board[4] == computer || board[4] == computer && board[7] == computer || board[1] == computer && board[7] == computer) ||
	                (board[2] == computer && board[5] == computer || board[5] == computer && board[8] == computer || board[2] == computer && board[8] == computer) ||
	                (board[3] == computer && board[6] == computer || board[6] == computer && board[9] == computer || board[3] == computer && board[9] == computer))
	        {
				System.out.println("Computer going to win");
			} else
				System.out.println("It may be a tie.");
		}

}