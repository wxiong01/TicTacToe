package com.beantech.util;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author wxiong
 *
 */
public class RotationMap {
	
	public final static Map<Integer, Integer> Rotaion90 = new HashMap<Integer, Integer>();
	public final static Map<Integer, Integer> Rotaion180 = new HashMap<Integer, Integer>();
	public final static Map<Integer, Integer> Rotaion270 = new HashMap<Integer, Integer>();

	static {
		Rotaion90.put(0, 6);
		Rotaion90.put(1, 3);
		Rotaion90.put(2, 0);
		Rotaion90.put(3, 7);
		Rotaion90.put(4, 4);
		Rotaion90.put(5, 1);
		Rotaion90.put(6, 8);
		Rotaion90.put(7, 5);
		Rotaion90.put(8, 2);
		
		Rotaion180.put(0, 8);
		Rotaion180.put(1, 7);
		Rotaion180.put(2, 6);
		Rotaion180.put(3, 5);
		Rotaion180.put(4, 4);
		Rotaion180.put(5, 7);
		Rotaion180.put(6, 2);
		Rotaion180.put(7, 1);
		Rotaion180.put(8, 0);
		
		Rotaion270.put(0, 2);
		Rotaion270.put(1, 5);
		Rotaion270.put(2, 8);
		Rotaion270.put(3, 1);
		Rotaion270.put(4, 4);
		Rotaion270.put(5, 7);
		Rotaion270.put(6, 0);
		Rotaion270.put(7, 3);
		Rotaion270.put(8, 6);
	}
}
