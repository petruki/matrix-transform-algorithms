package com.douglas.roger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.security.InvalidAlgorithmParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.douglas.roger.algorithms.Column;

public class ColumnTest {

	private MatrixTransformer<Integer> instance;

	@BeforeEach
	void init() {
		instance = new MatrixTransformer<>(new Column<>());
	}

	static Stream<Arguments> matrixFixtures() {
		return Stream.of(
				Arguments.of(
						new Integer[][] {
							{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}
						}, new Integer[][] {
							{1, 6, 7},
							{2, 5, 8},
							{3, 4, 9}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2, 3, 4},
							{1, 2, 3, 4}
						}, new Integer[][] {
							{1, 4, 1, 4},
							{2, 3, 2, 3}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2},
							{3, 4}
						}, new Integer[][] {
							{1, 4},
							{2, 3}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2},
							{3, 4},
							{5, 6},
							{7, 8},
							{9, 10}
						}, new Integer[][] {
							{1, 10},
							{2, 9},
							{3, 8},
							{4, 7},
							{5, 6}
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
