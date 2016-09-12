/**
 * 
 */
package com.beantech.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.beantech.tictactoe.domain.Board;
import com.beantech.tictactoe.domain.Cell;

/**
 * @author wxiong
 *
 */
public class Writer {

	public void write(Board board) {
		// Get the file reference
		Path path = Paths.get(LoosingCombinations.INSTANCE.filePath);

		// Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE,
				StandardOpenOption.APPEND)) {
			List<Cell> combinations = board.getCombinations();
			StringBuilder sb = new StringBuilder();
			for (Cell cell : combinations) {
				sb.append(BoardMap.mapIndexToPositon.get(cell.getId()))
					.append("-");
			}
			
			writer.write(sb.toString());
			writer.newLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}