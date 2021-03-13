package com.github.petruki.algorithms;

import java.security.InvalidAlgorithmParameterException;

import com.github.petruki.model.Position;

public abstract class AbstractAlgorithm<T> {
	
	protected Position pos;
	
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
