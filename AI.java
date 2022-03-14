package com.kasatyvitali.tic_tac_toe_ai;
import static com.kasatyvitali.tic_tac_toe_ai.Board.*;

import java.util.ArrayList;
import java.util.List;

public class AI {
	
	
	
 	public int findBest(Board board) {
 		int bestVal = -1000;
 		int bestMove = 0;
 		
 		for (int pos : board.emptyPositions()) {
 			board.setMove(pos, AIPlayer);
 			
 			int moveVal = minimax(board, humanPlayer);
 			board.setMove(pos, ' ');
 			
 			if (moveVal > bestVal) {
 				bestMove = pos;
 				bestVal = moveVal;
 			}
 			
 		}
 
 		return bestMove;
 	}
	
	
	
 	public int minimax(Board board, char player) {
 		char[] newBoard = board.getBoard();
 		if(board.isWinning(humanPlayer)) {			
 			return -10;
 		}  
 		if (board.isWinning(AIPlayer)) {
 			return 10;
 		}		
 		
 		List<Integer> availableSpots = board.emptyPositions();
 		
 		if (availableSpots.isEmpty()) {
 			return 0;
 		}
 		
 		if (player == AIPlayer) {
 			int best = -1000;
 			
 			for (int pos : availableSpots) {
 				newBoard[pos] = AIPlayer;
 				int score = minimax(board, humanPlayer);
 				best = Math.max(best, score);
 				newBoard[pos] = ' ';
 			}
 			return best;
 		} else {
 			int best = 1000;
 			for (int pos : availableSpots) {
 				newBoard[pos] = humanPlayer;
 				int score = minimax(board, AIPlayer);
 				best = Math.min(best, score);
 				newBoard[pos] = ' ';
 			}
 			return best;
 		}
 		
 	} 	


}
