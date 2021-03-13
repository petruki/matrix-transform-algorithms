package com.github.petruki.algorithms;

import java.security.InvalidAlgorithmParameterException;

import com.github.petruki.model.Position;

public abstract class AbstractAlgorithm<T> {
	
	protected Position pos;
	
	public AbstractAlgorithm(Position pos) {
		this.pos = pos;
	}
	
	public void fill(T[][] matrix, T value) 
			throws InvalidAlgorithmParameterException {
		switch (pos.direction) {
		case RIGHT:
			fillRight(matrix, value);
			break;
		case DOWN:
			fillDown(matrix, value);
			break;
		case LEFT:
			fillLeft(matrix, value);
			break;
		case UP:
			fillUp(matrix, value);
			break;
		}
	}
	
	public boolean canGoRight(T[][] matrix, T value) {
		return pos.col < matrix[pos.row].length - 1 && 
				matrix[pos.row][pos.col + 1] == null;
	}
	
	public boolean canGoLeft(T[][] matrix, T value) {
		return pos.col > 0 && matrix[pos.row][pos.col - 1] == null;
	}
	
	public boolean canGoDown(T[][] matrix, T value) {
		return pos.row < matrix.length - 1 && 
				matrix[pos.row + 1][pos.col] == null;
	}
	
	public boolean canGoUp(T[][] matrix, T value) {
		return pos.row > 0 && matrix[pos.row - 1][pos.col] == null;
	}
	
	public void fillRight(T[][] matrix, T value) 
			throws InvalidAlgorithmParameterException {
		throw new InvalidAlgorithmParameterException("fillRight is not implemented");
	}
	
	public void fillDown(T[][] matrix, T value) 
			throws InvalidAlgorithmParameterException {
		throw new InvalidAlgorithmParameterException("fillDown is not implemented");
	}
	
	public void fillLeft(T[][] matrix, T value) 
			throws InvalidAlgorithmParameterException {
		throw new InvalidAlgorithmParameterException("fillLeft is not implemented");
	}
	
	public void fillUp(T[][] matrix, T value) 
			throws InvalidAlgorithmParameterException {
		throw new InvalidAlgorithmParameterException("fillUp is not implemented");
	}

	public Position getPos() {
		return pos;
	}

}
