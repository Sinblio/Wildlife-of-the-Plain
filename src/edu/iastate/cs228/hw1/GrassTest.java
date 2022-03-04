package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

public class GrassTest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Plain p = new Plain("public1-3x3.txt");
		Living b = p.grid[2][2];
		
		assertEquals(State.GRASS, b.who());
		Grass f = new Grass(p, 0, 1);
		Living bf = b.next(p);
		assertEquals(f.who(),(bf.who()));
	}
}
