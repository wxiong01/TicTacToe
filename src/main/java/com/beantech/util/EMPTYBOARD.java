/**
 * 
 */
package com.beantech.util;

/**
 * @author wxiong
 *
 */
public enum EMPTYBOARD {
	CELLS(new int[] {
			BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			,BOARD.CELLEMPTY.getValue()
			}
	);
	
	private final int[] value;
	
	public int[] getValue() {
		return value;
	}

	EMPTYBOARD(int[] value) {
		this.value = value;
	}

}
