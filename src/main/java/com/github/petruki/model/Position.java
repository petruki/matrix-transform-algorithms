package com.github.petruki.model;

public class Position {
	public int row = 0;
	public int col = 0;
	public Directions direction = Directions.RIGHT;
	
	public Position(int row, int col, Directions direction) {
		this.row = row;
		this.col = col;
		this.direction = direction;
	}
}
