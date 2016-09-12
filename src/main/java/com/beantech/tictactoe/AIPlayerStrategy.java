/**
 * 
 */
package com.beantech.tictactoe;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.beantech.tictactoe.domain.Board;
import com.beantech.tictactoe.domain.Cell;
import com.beantech.util.BOARD;

/**
 * @author wxiong
 *
 */

public class AIPlayerStrategy {
	
	private final Set<Integer> loosingCombinatons;
	
	public AIPlayerStrategy(Set<Integer> loosingCombinatons) {
		super();
		this.loosingCombinatons = loosingCombinatons;
	}


	/**
	 * randomly chose the square from the available cells 
	 */
	public Integer randomChose(Board board)  {
		Cell cell = getAvailableCell(board);
		return cell.getId();
	}

	
	/**
	 * get next an Available cell  
	 * @param board
	 * @return
	 */
	public Cell getAvailableCell (Board board) {
		
		Cell availableCell = null;
		List<Cell> cellList = board.getCells();
		List<Cell> avaliableCells =cellList.stream()
				.filter( x -> x.getMarked() == BOARD.CELLEMPTY.getValue() )
				.collect(Collectors.toList());
		if (avaliableCells != null && !avaliableCells.isEmpty()) {
			int index = ThreadLocalRandom.current().nextInt(avaliableCells.size());
			availableCell = avaliableCells.get(index);
		}
		return availableCell;
	}
	
	/**
	 * Search loosing history first
	 * If find the march one, it continues finding the one was not failed in history
	 * @param board
	 * @return
	 */
	public Integer aiNextMove (Board board) {
		Integer nextMove = null;
		//int currentStep = board.getCombinations().size();
		nextMove = randomChose(board);
		List<Cell> cells = board.getCombinations();
		StringBuilder sb = new StringBuilder();
		for (Cell cell: cells) {
			sb.append(cell.getId());
		}
		sb.append(nextMove);
		Integer loosComb = Integer.valueOf(sb.toString());
		int attempt = 1;
		while (loosingCombinatons.contains(loosComb)) {
			//attemp limit reached
			if (attempt > 99)
				return null;
			
			nextMove = randomChose(board);
			//terminated if no more available cells
			if (nextMove == null) 
				break;
			sb.deleteCharAt(sb.length()-1);
			loosComb = Integer.valueOf(sb.append(nextMove).toString());
			attempt ++;
		}
		return nextMove;
	}
	/**
	 * 
	 * @param board
	 * @return
	 */
	/**
	 * @param board
	 * @return
	 */
	public Integer nextMove(Board board) {
		Integer nextMove = null;
		//can't find any smart solution, just give it a try
		nextMove = aiNextMove(board);
		return nextMove;
	}
}
