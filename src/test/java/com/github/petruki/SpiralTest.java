package com.github.petruki;

import java.security.InvalidAlgorithmParameterException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.petruki.MatrixTransformer;
import com.github.petruki.algorithms.Spiral;

public class SpiralTest {

	private MatrixTransformer<Integer> instance;

	@BeforeEach
	void init() {
		instance = new MatrixTransformer<>(new Spiral<>());
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
							{8, 9, 4},
							{7, 6, 5}
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
							{10, 3},
							{9, 4},
							{8, 5},
							{7, 6}
						}),
				Arguments.of(
						new Integer[][] {
							{7, 5, 1, 4, 6},
							{3, 2, 9, 1, 8},
							{8, 3, 2, 4, 1},
							{10, 11, 15, 19, 14}
						}, new Integer[][] {
							{7, 5, 1, 4, 6},
							{4, 1, 10, 11, 3},
							{2, 14, 19, 15, 2},
							{3, 8, 8, 1, 9}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2, 3, 4},
							{1, 2, 3, 4},
							{1, 2, 3, 4},
							{1, 2, 3, 4},
							{1, 2, 3, 4},
							{1, 2, 3, 4}
						}, new Integer[][] {
							{1, 2, 3, 4},
							{4, 1, 2, 1},
							{3, 4, 3, 2},
							{2, 3, 4, 3},
							{1, 2, 1, 4},
							{4, 3, 2, 1}
						}),
				Arguments.of(
						new Integer[][] {
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{1, 2, 3, 4, 5, 6, 7, 8, 9}
						}, new Integer[][] {
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{8, 9, 1, 2, 3, 4, 5, 6, 1},
							{7, 8, 9, 1, 2, 3, 4, 7, 2},
							{6, 7, 9, 8, 7, 6, 5, 8, 3},
							{5, 6, 5, 4, 3, 2, 1, 9, 4},
							{4, 3, 2, 1, 9, 8, 7, 6, 5}
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
