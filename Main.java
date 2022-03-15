package com.kasatyvitali.tic_tac_toe_ai;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Board board = new Board();
		AI ai = new AI();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Выиграете за - " + Board.humanPlayer);
		System.out.println(board);

		while (!board.emptyPositions().isEmpty()) {

			boolean correctInput = false;

			while (!correctInput) {
				System.out.println("Введите свой ход!");

				if (sc.hasNextInt()) {
					int pos = sc.nextInt();

					if (board.emptyPositions().contains(pos - 1)) {
						board.setMove(pos - 1, Board.humanPlayer);
						System.out.println(board);
						correctInput = true;
					} else {
						System.out.println("Этот ход невозможен!");
						sc.nextLine();
					}
				} else {
					System.out.println("Некорректный ввод!");
					sc.nextLine();
				}
			}

			if (board.isWinning(Board.humanPlayer)) {
				System.out.println("Вы победили!");
				break;
			} else if (board.emptyPositions().isEmpty()) {
				System.out.println("Ничья!");
				break;
			}

			System.out.println("Ходит компьютер!\n");
			Thread.sleep(1500);
			board.setMove(ai.findBestMove(board), Board.AIPlayer);
			System.out.println(board);

			if (board.isWinning(Board.AIPlayer)) {
				System.out.println("Компьютер победил!");
				break;
			}
		}
	}

}
