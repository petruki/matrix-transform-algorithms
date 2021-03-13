package com.github.petruki.algorithms;

import com.github.petruki.model.Directions;
import com.github.petruki.model.Position;

public class Column<T> extends AbstractAlgorithm<T> {
	
	public Column() {
		pos = new Position();
		pos.row = -1;
		pos.col = 0;
		pos.direction = Directions.DOWN;
	}
	
	@Override
	public void fillDown(T[][] matrix, T value) {
		if (pos.row < matrix.length - 1 && 
				matrix[pos.row + 1][pos.col] == null) {
			pos.row++;
		} else {
			pos.direction = Directions.UP;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillUp(T[][] matrix, T value) {
		if (pos.row > 0 && matrix[pos.row - 1][pos.col] == null) {
			pos.row--;
		} else {
			pos.direction = Directions.DOWN;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
