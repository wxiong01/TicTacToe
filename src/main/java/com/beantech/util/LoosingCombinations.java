/**
 * 
 */
package com.beantech.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wxiong
 *
 */
public enum LoosingCombinations {
	INSTANCE;
	public String filePath = "c:/loosingcombinations.txt";
	
	/**
	 * load the cache for loosing combinations from files
	 * @return
	 */
	public Set<Integer> getLoosingCombinations() {
		//TODO: use adapter pattern in future to load cache in different way
		
		//sorted set applied for fast search
		Set<Integer> loosCombSet = new TreeSet<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String data = br.readLine();
			while (data != null) {
				String [] squares = data.split("-");
				//loosing combination is converted into 4
				StringBuilder sb = new StringBuilder();
				StringBuilder sb90 = new StringBuilder();
				StringBuilder sb180 = new StringBuilder();
				StringBuilder sb270 = new StringBuilder();
		        //ignore the last one 
				int numberOfSeq = squares.length-1;
				for (int i= 0; i< numberOfSeq; i++) {
					Integer position = BoardMap.mapPositionToIndex.get(squares[i]);
					//for 90 degree Rotaion
					Integer position90 = RotationMap.Rotaion90.get(position);
					//for 180 degree Roation
					Integer position180 = RotationMap.Rotaion180.get(position);
					//for 270 degree Roation
					Integer position270 = RotationMap.Rotaion270.get(position);
					sb.append(position);
					sb90.append(position90);
					sb180.append(position180);
					sb270.append(position270);
				}
				
				if (sb!= null ) {
					Integer loosComb = Integer.valueOf(sb.toString());
					loosCombSet.add(loosComb);
					
					Integer loosComb90 = Integer.valueOf(sb90.toString());
					loosCombSet.add(loosComb90);
					Integer loosComb180 = Integer.valueOf(sb180.toString());
					loosCombSet.add(loosComb180);
					Integer loosComb270 = Integer.valueOf(sb270.toString());
					loosCombSet.add(loosComb270);
					
				}
				data = br.readLine();
			}
		} catch (FileNotFoundException e) {
			//is OK. 
			System.out.println("no loosing combination file " + filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return loosCombSet;
	}

}
