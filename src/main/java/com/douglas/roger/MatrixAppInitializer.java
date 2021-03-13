package com.douglas.roger;

import java.security.InvalidAlgorithmParameterException;

import com.douglas.roger.algorithms.Spiral;

public class MatrixAppInitializer {
	
	public static void main(String[] args) {
		numberMatrix();
		charMatrix();
	}
	
	private static void numberMatrix() {
		Integer[][] sourceInteger = {
				{7, 5, 1, 4, 6},
				{3, 2, 9, 1, 8},
				{8, 3, 2, 4, 1},
				{10, 11, 15, 19, 14}
		};
		
		MatrixTransformer<Integer> transform = new MatrixTransformer<>(new Spiral<>());
		try {
			transform.printSolution(sourceInteger, transform.transform(sourceInteger));
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}
	
	private static void charMatrix() {
		Character[][] sourceChar = {
				{'A', 'B', 'C', 'D', 'E'},
				{'F', 'G', 'H', 'I', 'J'},
				{'K', 'L', 'M', 'N', 'O'},
				{'P', 'Q', 'R', 'S', 'T'}
		};
		
		MatrixTransformer<Character> transform = new MatrixTransformer<>(new Spiral<>());
		try {
			transform.printSolution(sourceChar, transform.transform(sourceChar));
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	}

}
