/**
 * 
 */
package com.beantech.tictactoe.domain;

import java.util.LinkedList;
import java.util.List;

import com.beantech.util.BOARD;

/**
 * This class is used for Board 
 * @author wxiong
 *
 */
public class Board {
	
	private List<Cell> cells;
	private List<Cell> combinations;
	
	private static final int cellSize = 9;

	public Board() {
		cells = new LinkedList<Cell>();
		for (int i=0; i<cellSize; i++) {
			Cell cell = new Cell(i);
			cell.setMarked(BOARD.CELLEMPTY.getValue());
			cells.add(cell);
		}
		
		combinations = new LinkedList<Cell>();
	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public static int getCellsize() {
		return cellSize;
	}

	public List<Cell> getCombinations() {
		return combinations;
	}

	public void setCombinations(List<Cell> combinations) {
		this.combinations = combinations;
	}
	
}
