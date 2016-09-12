/**
 * 
 */
package com.beantech.tictactoe.domain;

/**
 * @author wxiong
 *
 */
public class Cell {
	
	private int id;
	private int marked;
	
	public int getMarked() {
		return marked;
	}
	public void setMarked(int marked) {
		this.marked = marked;
	}
	
	public int getId() {
		return id;
	}
	
	public Cell(int id) {
		this.id = id;
    }
	@Override
	public String toString() {
		return "Cell [id=" + id + ", marked=" + marked + "]";
	}
	
}
