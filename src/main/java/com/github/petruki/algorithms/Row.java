package com.github.petruki.algorithms;

import com.github.petruki.model.Directions;
import com.github.petruki.model.Position;

public class Row<T> extends AbstractAlgorithm<T> {
	
	public Row() {
		pos = new Position();
		pos.row = 0;
		pos.col = -1;
		pos.direction = Directions.RIGHT;
	}
	
	@Override
	public void fillRight(T[][] matrix, T value) {
		if (pos.col < matrix[pos.row].length - 1 && 
				matrix[pos.row][pos.col + 1] == null) {
			pos.col++;
		} else {
			pos.direction = Directions.LEFT;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillLeft(T[][] matrix, T value) {
		if (pos.col > 0 && matrix[pos.row][pos.col - 1] == null) {
			pos.col--;
		} else {
			pos.direction = Directions.RIGHT;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
