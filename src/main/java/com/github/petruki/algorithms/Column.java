package com.github.petruki.algorithms;

import com.github.petruki.model.Directions;
import com.github.petruki.model.Position;

public class Column<T> extends AbstractAlgorithm<T> {
	
	public Column() {
		super(new Position(-1, 0, Directions.DOWN));
	}
	
	@Override
	public void fillDown(T[][] matrix, T value) {
		if (canGoDown(matrix, value)) {
			pos.row++;
		} else {
			pos.direction = Directions.UP;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillUp(T[][] matrix, T value) {
		if (canGoUp(matrix, value)) {
			pos.row--;
		} else {
			pos.direction = Directions.DOWN;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
