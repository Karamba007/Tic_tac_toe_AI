package com.kasatyvitali.tic_tac_toe_ai;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Board board = new Board();
		AI ai = new AI();

		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println(board);
			System.out.println("Введите свой ход!");
			int pos = sc.nextInt();
			board.setMove(pos - 1, 'O');
			if (board.isWinning('O')) {
				System.out.println("Вы победили!");
				break;
			} else if (board.isTie()) {
				System.out.println("Ничья!");
				break;
			}
			System.out.println("Ходит компьютер!");
			board.setMove(ai.findBest(board), 'X');
			System.out.println(board);
			if (board.isWinning('X')) {
				System.out.println("Компьютер победил!");
				break;
			} else if (board.isTie()) {
				System.out.println("Ничья!");
				break;
			}
		}

	}

}
