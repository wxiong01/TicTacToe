package com.beantech.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardMap {
	public static final Map<String, Integer> mapSquareToIndex = new HashMap<String, Integer>();
	public static Map<Integer, String> mapIndexToSqure = new HashMap<Integer, String>();
	public static final Map<Integer, String> mapIndexToPositon = new HashMap<Integer, String>();
	public static Map<String, Integer> mapPositionToIndex = new HashMap<String, Integer>();
	static {
		mapSquareToIndex.put("A1", 0);
		mapSquareToIndex.put("A2", 1);
		mapSquareToIndex.put("A3", 2);
		mapSquareToIndex.put("B1", 3);
		mapSquareToIndex.put("B2", 4);
		mapSquareToIndex.put("B3", 5);
		mapSquareToIndex.put("C1", 6);
		mapSquareToIndex.put("C2", 7);
		mapSquareToIndex.put("C3", 8);
		
		//reverse mapSequareToIndex
		mapIndexToSqure = mapSquareToIndex.entrySet()
			.stream()
			.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))
		;
		
		mapIndexToPositon.put(0, "(1,1)");
		mapIndexToPositon.put(1, "(1,2)");
		mapIndexToPositon.put(2, "(1,3)");
		mapIndexToPositon.put(3, "(2,1)");
		mapIndexToPositon.put(4, "(2,2)");
		mapIndexToPositon.put(5, "(2,3)");
		mapIndexToPositon.put(6, "(3,1)");
		mapIndexToPositon.put(7, "(3,2)");
		mapIndexToPositon.put(8, "(3,3)");
		
		mapPositionToIndex = mapIndexToPositon.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))
		;
		
	}

	
}
