package com.github.petruki.algorithms;

import com.github.petruki.model.Directions;
import com.github.petruki.model.Position;

public class Spiral<T> extends AbstractAlgorithm<T> {
	
	public Spiral() {
		super(new Position(0, -1, Directions.RIGHT));
	}
	
	@Override
	public void fillRight(T[][] matrix, T value) {
		if (canGoRight(matrix, value)) {
			pos.col++;
		} else {
			pos.direction = Directions.DOWN;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillDown(T[][] matrix, T value) {
		if (canGoDown(matrix, value)) {
			pos.row++;
		} else {
			pos.direction = Directions.LEFT;
			pos.col--;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillLeft(T[][] matrix, T value) {
		if (canGoLeft(matrix, value)) {
			pos.col--;
		} else {
			pos.direction = Directions.UP;
			pos.row--;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillUp(T[][] matrix, T value) {
		if (canGoUp(matrix, value)) {
			pos.row--;
		} else {
			pos.direction = Directions.RIGHT;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
