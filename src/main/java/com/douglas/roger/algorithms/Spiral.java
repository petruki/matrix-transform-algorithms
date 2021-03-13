package com.douglas.roger.algorithms;

import com.douglas.roger.model.Directions;
import com.douglas.roger.model.Position;

public class Spiral<T> extends AbstractAlgorithm<T> {
	
	public Spiral() {
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
			pos.direction = Directions.DOWN;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillDown(T[][] matrix, T value) {
		if (pos.row < matrix.length - 1 && 
				matrix[pos.row + 1][pos.col] == null) {
			pos.row++;
		} else {
			pos.direction = Directions.LEFT;
			pos.col--;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillLeft(T[][] matrix, T value) {
		if (pos.col > 0 && matrix[pos.row][pos.col - 1] == null) {
			pos.col--;
		} else {
			pos.direction = Directions.UP;
			pos.row--;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillUp(T[][] matrix, T value) {
		if (pos.row > 0 && matrix[pos.row - 1][pos.col] == null) {
			pos.row--;
		} else {
			pos.direction = Directions.RIGHT;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
