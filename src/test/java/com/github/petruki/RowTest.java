package com.github.petruki;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.security.InvalidAlgorithmParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.petruki.MatrixTransformer;
import com.github.petruki.algorithms.Row;

public class RowTest {

	private MatrixTransformer<Integer> instance;

	@BeforeEach
	void init() {
		instance = new MatrixTransformer<>(new Row<>());
	}

	static Stream<Arguments> matrixFixtures() {
		return Stream.of(
				Arguments.of(
						new Integer[][] {
							{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}
						}, new Integer[][] {
							{1, 2, 3},
							{6, 5, 4},
							{7, 8, 9}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2, 3, 4},
							{1, 2, 3, 4}
						}, new Integer[][] {
							{1, 2, 3, 4},
							{4, 3, 2, 1}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2},
							{3, 4}
						}, new Integer[][] {
							{1, 2},
							{4, 3}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2},
							{3, 4},
							{5, 6},
							{7, 8},
							{9, 10}
						}, new Integer[][] {
							{1, 2},
							{4, 3},
							{5, 6},
							{8, 7},
							{9, 10}
						})
				);
	}

	@ParameterizedTest()
	@MethodSource("matrixFixtures")
	void testConvertion(Integer [][] source, Integer[][] expected) 
			throws InvalidAlgorithmParameterException {
		Integer[][] actual = instance.transform(source);
		assertArrayEquals(expected, actual);
	}

}
