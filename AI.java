package com.kasatyvitali.tic_tac_toe_ai;

import static com.kasatyvitali.tic_tac_toe_ai.Board.*;
import java.util.List;

public class AI {
	/*
	 * Поиск хода, который принесёт большее кол-во очков
	 * @param board - игровое поле
	 * @return - позиция лучшего хода
	*/
	public int findBestMove(Board board) {

		int bestPoints = -1000;
		int bestMove = 0;

		for (int pos : board.emptyPositions()) {
			board.setMove(pos, AIPlayer);
			int moveVal = minimax(board, humanPlayer);
			board.setMove(pos, ' ');

			if (moveVal > bestPoints) {
				bestMove = pos;
				bestPoints = moveVal;
			}
		}
		return bestMove;
	}
	
	/*
	 * Алгоритм минимакс для получения оценки игрового поля рекурсивно 
	 * перебирая все возможные ходы	  
	 * @param board - игровое поле	 * 
	 * @param player - ход текущего игрока	 * 
	 * @return - оценка игровому после хода игрока
	 */	
	public int minimax(Board board, char player) {

		char[] newBoard = board.getBoard();
		List<Integer> availableSpots = board.emptyPositions();

		if (board.isWinning(humanPlayer)) {
			return -10;
		} else if (board.isWinning(AIPlayer)) {
			return 10;
		} else if (availableSpots.isEmpty()) {
			return 0;
		}

		if (player == AIPlayer) {
			int bestPoints = -1000;

			for (int pos : availableSpots) {
				newBoard[pos] = AIPlayer;
				int score = minimax(board, humanPlayer);
				bestPoints = Math.max(bestPoints, score);
				newBoard[pos] = ' ';
			}			
			return bestPoints;			
		} else {
			int bestPoints = 1000;
			
			for (int pos : availableSpots) {
				newBoard[pos] = humanPlayer;
				int score = minimax(board, AIPlayer);
				bestPoints = Math.min(bestPoints, score);
				newBoard[pos] = ' ';
			}
			return bestPoints;
		}
	}

}
