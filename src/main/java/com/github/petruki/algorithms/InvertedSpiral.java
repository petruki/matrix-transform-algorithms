package com.github.petruki.algorithms;

import com.github.petruki.model.Directions;
import com.github.petruki.model.Position;

public class InvertedSpiral<T> extends AbstractAlgorithm<T> {
	
	public InvertedSpiral() {
		pos = new Position();
		pos.row = -1;
		pos.col = 0;
		pos.direction = Directions.DOWN;
	}
	
	@Override
	public void fillRight(T[][] matrix, T value) {
		if (pos.col < matrix[pos.row].length - 1 && 
				matrix[pos.row][pos.col + 1] == null) {
			pos.col++;
		} else {
			pos.direction = Directions.UP;
			pos.row--;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillDown(T[][] matrix, T value) {
		if (pos.row < matrix.length - 1 && 
				matrix[pos.row + 1][pos.col] == null) {
			pos.row++;
		} else {
			pos.direction = Directions.RIGHT;
			pos.col++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillLeft(T[][] matrix, T value) {
		if (pos.col > 0 && matrix[pos.row][pos.col - 1] == null) {
			pos.col--;
		} else {
			pos.direction = Directions.DOWN;
			pos.row++;
		}
		
		matrix[pos.row][pos.col] = value;
	}
	
	@Override
	public void fillUp(T[][] matrix, T value) {
		if (pos.row > 0 && matrix[pos.row - 1][pos.col] == null) {
			pos.row--;
		} else {
			pos.direction = Directions.LEFT;
			pos.col--;
		}
		
		matrix[pos.row][pos.col] = value;
	}

}
