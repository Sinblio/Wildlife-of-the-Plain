package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

public class FoxTest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Plain p = new Plain("public2-6x6.txt");
		Living b = p.grid[0][0];
		
		assertEquals(0, ((Animal)b).myAge());
		assertEquals(State.FOX, b.who());
		Empty f = new Empty(p, 0, 0);
		Living bf = b.next(p);
		assertEquals(f.who(),(bf.who()));
	}
}
