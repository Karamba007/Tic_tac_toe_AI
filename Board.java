package com.kasatyvitali.tic_tac_toe_ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	
	public static final char AIPlayer = 'X';
	public static final char humanPlayer = 'O';
	
	private char[] board = {' ', ' ', ' ',
							' ', ' ', ' ',
							' ', ' ', ' '};


	public char[] getBoard() {
		return board;
	}

	public void setMove(int pos, char player) {
		board[pos] = player;
	}
	
	public boolean isWinning(char player) {
		if ((board[0] == player && board[1] == player && board[2] == player) ||
			(board[3] == player && board[4] == player && board[5] == player) ||
			(board[6] == player && board[7] == player && board[8] == player) ||
			(board[0] == player && board[3] == player && board[6] == player) ||
			(board[1] == player && board[4] == player && board[7] == player) ||
			(board[2] == player && board[5] == player && board[8] == player) ||
			(board[0] == player && board[4] == player && board[8] == player) ||
			(board[2] == player && board[4] == player && board[6] == player)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTie() {
		return !Arrays.toString(board).chars().anyMatch(s -> s == ' ');
	}	
	
	
	public List<Integer> emptyPositions() {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			if (board[i] == ' ') {
				list.add(i);
			}
		}
		return list;
	}

	@Override
	public String toString() {
		String viewBoard = "";
		
		for (int i = 0; i < 9; i++) {
			if ((i % 3) < 2) {
				viewBoard += board[i] + " | ";				
			} else {
				viewBoard += board[i] + "\n";				
				if (i != 8) {
					viewBoard += "---------\n";					
				}				
			}
		}
		return viewBoard;
	}	
	
}
