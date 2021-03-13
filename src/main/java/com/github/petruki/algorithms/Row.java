package com.github.petruki.algorithms;

import com.github.petruki.model.Directions;
import com.github.petruki.model.Position;

public class Row<T> extends AbstractAlgorithm<T> {
	
	public Row() {
		super(new Position(0, -1, Directions.RIGHT));
	}
	
	@Override
	public void fillRight(T[][] matrix, T value) {
		if (canGoRight(matrix, value)) {
			pos.col++;
		} else {
			pos.direction = Directions.LEFT;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillLeft(T[][] matrix, T value) {
		if (canGoLeft(matrix, value)) {
			pos.col--;
		} else {
			pos.direction = Directions.RIGHT;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
