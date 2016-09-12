package com.beantech.tictactoe;

import java.util.Set;

import com.beantech.tictactoe.domain.Board;
import com.beantech.tictactoe.domain.Cell;
import com.beantech.util.BOARD;
import com.beantech.util.BoardMap;
import com.beantech.util.LoosingCombinations;
import com.beantech.util.Writer;


/**
 * @author wxiong
 *
 */
public class TicTacToeBoardController {
	private Board board;
	AIPlayerStrategy aIPlayerStrategy;
	Set<Integer> looseCombs;
	

	private int vectors[][] = { { 0, 1, 2 }, // Row 1
			{ 3, 4, 5 }, // Row 2
			{ 6, 7, 8 }, // Row 3
			{ 0, 3, 6 }, // Column 1
			{ 1, 4, 7 }, // Column 2
			{ 2, 5, 8 }, // Column 3
			{ 0, 4, 8 }, // Diagonal 1
			{ 2, 4, 6 } // Diagonal 2
	};

	public TicTacToeBoardController() {
		this.reset();
	}

	public void reset() {
		board = new Board();
		looseCombs = LoosingCombinations.INSTANCE.getLoosingCombinations();
		aIPlayerStrategy = new AIPlayerStrategy(looseCombs);
	}

	private int getSquare(int index) {
		if (index < 0 | index > 8)
			throw new IllegalArgumentException("index must be 0-9");

		return board.getCells().get(index).getMarked();
		//return board[index];
	}

	public int getSquare(String square) {
		int index = mapSquareToIndex(square);
		if (index == -1)
			throw new IllegalArgumentException("Invalid square");
		switch (getSquare(index)) {
		case 3:
			return 1;
		case 5:
			return 2;
		default:
			return 0;
		}
	}

	private Integer mapSquareToIndex(String square) {
		return BoardMap.mapSquareToIndex.get(square);
	}

	private String mapIndexToSquare(int index) {
		return BoardMap.mapIndexToSqure.get(index);
	}

	public void playAt(String square, int player) {
		int index = mapSquareToIndex(square);
		if (index == -1)
			throw new IllegalArgumentException("Invalid square");
		this.playAt(index, player);
	}

	private void playAt(int index, int player) {
		Cell cell = board.getCells().get(index);
		if (index < 0 | index > 8)
			throw new IllegalArgumentException("Square must be 0-8");
		if (player < 1 | player > 2)
			throw new IllegalArgumentException("Player must be 1 or 2");
		if (cell.getMarked() != 2)
			throw new IllegalArgumentException("Square is not empty.");
		if (player == 1)
			cell.setMarked(BOARD.CELLMARKED_BY_PLAYER.getValue());
		else
			cell.setMarked(BOARD.CELLMARKED_BY_COMPUTER.getValue());
		
		board.getCombinations().add(cell);
	}

	public int isGameOver() {
		// check for win
		for (int v = 0; v < 8; v++) {
			int p = getVectorProduct(v);
			if (p == 27)
				return 1; // Player 1 has won
			if (p == 125)
				return 2; // Player 2 has won
		}

		// check for draw

		int blankCount = 0;
		for (int i = 0; i < 9; i++)
			if (board.getCells().get(i).getMarked() ==2 )
			//if (board[i] == 2)
				blankCount++;
		if (blankCount == 0)
			return 3; // Game is a draw

		return 0; // Game is not over
	}

	public String canPlayerWin(int player) {
		if (player < 1 | player > 2)
			throw new IllegalArgumentException("player must be 1 or 2");

		boolean playerCanWin = false;

		for (int v = 0; v < 8; v++) {
			int p = getVectorProduct(v);
			if ((player == 1 & p == 18) | (player == 2 & p == 50)) {
				if (board.getCells().get(vectors[v][0]).getMarked() == 2)
					return mapIndexToSquare(vectors[v][0]);
				if (board.getCells().get(vectors[v][1]).getMarked() == 2)
					return mapIndexToSquare(vectors[v][1]);
				if (board.getCells().get(vectors[v][2]).getMarked() == 2)
					return mapIndexToSquare(vectors[v][2]);
			}
		}
		return "";

	}

	private int getVectorProduct(int vector) {
		return board.getCells().get(vectors[vector][0]).getMarked()
		* board.getCells().get(vectors[vector][1]).getMarked()
		* board.getCells().get(vectors[vector][2]).getMarked();
		//return board[vectors[vector][0]] * board[vectors[vector][1]] * board[vectors[vector][2]];
	}

	public String getNextMove() {
		String bestMove;
		
		// Win if possible
		bestMove = this.canPlayerWin(2);
		if (bestMove != "")
			return bestMove;
		Integer nextMovePointer = aIPlayerStrategy.nextMove(board); 
		bestMove = mapIndexToSquare(nextMovePointer);
		// Block if necessary
		//bestMove = this.canPlayerWin(1);
		if (bestMove != "")
			return bestMove;
	
		return ""; // The board is full
	}

	/*
	public String toString() {
		return " " + getMark(board[0]) + " | " + getMark(board[1]) + " | " + getMark(board[2]) + "\n-----------\n" + " "
				+ getMark(board[3]) + " | " + getMark(board[4]) + " | " + getMark(board[5]) + "\n-----------\n" + " "
				+ getMark(board[6]) + " | " + getMark(board[7]) + " | " + getMark(board[8]);
	}
   */
	private String getMark(int status) {
		if (status == BOARD.CELLMARKED_BY_PLAYER.getValue())
			return "X";
		if (status == BOARD.CELLMARKED_BY_COMPUTER.getValue())
			return "O";
		return " ";
	}
	
	public void recordLoosingCombination() {
		Writer writer = new Writer();
		writer.write(board);
	}

}
