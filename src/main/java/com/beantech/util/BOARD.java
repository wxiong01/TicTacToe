/**
 * 
 */
package com.beantech.util;

/**
 * @author wxiong
 *
 */
public enum BOARD {
	CELLEMPTY (2)
	,CELLMARKED_BY_PLAYER(3)
	,CELLMARKED_BY_COMPUTER(5)
	;

	final int value;
	
	public final int getValue() {
		return value;
	}
	BOARD(int v) {
		this.value = v;
		
	}
	
	
}
