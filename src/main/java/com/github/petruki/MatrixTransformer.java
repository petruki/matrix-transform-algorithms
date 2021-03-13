package com.github.petruki;

import java.lang.reflect.Array;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

import com.github.petruki.algorithms.AbstractAlgorithm;

/**
 * @author Roger Floriano (petruki)
 */
public class MatrixTransformer<T> {
	
	private AbstractAlgorithm<T> algorithm;
	
	public MatrixTransformer(AbstractAlgorithm<T> algorithm) {
		this.algorithm = algorithm;
	}
	
	@SuppressWarnings("unchecked")
	public T[][] transform(T[][] source) throws InvalidAlgorithmParameterException {
		T[][] matrix = (T[][]) Array.newInstance(
				source[0][0].getClass(), source.length, source[0].length);
		Arrays.stream(matrix).forEach(r -> Arrays.fill(r, null));
		
		for (T[] source_row : source) {
			for (T value : source_row) {
				algorithm.fill(matrix, value);
			}
		}
		
		return matrix;
	}
	
	public void printSolution(T[][] source, T[][] transformed) {
		System.out.println("\nSource");
		for (T[] row : source) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println("\nTransformed");
		for (T[] row : transformed) {
			System.out.println(Arrays.toString(row));
		}
	}
}
