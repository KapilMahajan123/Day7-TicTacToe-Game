package com.TicTacToe.java;

/**
 * 
 * @author Kapil
 *
 */
public class TicTacToe {
	
	private static char[] board = new char[10];
	
	/**
	 * Description of the board
	 * check condition
	 * crate a board of size 10
	 */
	static void startGame() {
		for (int i =1; i<=9; i++) {  
			board[i] = 1;
			System.out.println(board);   //printed 
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");  //Print the massage
		startGame(); 
	}

}
