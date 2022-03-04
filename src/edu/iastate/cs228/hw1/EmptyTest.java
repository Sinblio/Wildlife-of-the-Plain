package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

public class EmptyTest {
	public static void main(String[] args) throws FileNotFoundException
	{
		Plain p = new Plain("public1-3x3.txt");
		Living b = p.grid[2][1];
		
		assertEquals(State.EMPTY, b.who());
		Fox f = new Fox(p, 0, 1, 0);
		Living bf = b.next(p);
		assertEquals(f.who(),(bf.who()));
	}
}
