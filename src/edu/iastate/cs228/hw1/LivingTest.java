package edu.iastate.cs228.hw1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

public class LivingTest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Plain p = new Plain("public2-6x6.txt");
		Living b = p.grid[0][0];
		
		assertEquals(State.FOX, b.who());
		Empty f = new Empty(p, 0, 0);
		Living bf = b.next(p);
		assertEquals(f.who(),(bf.who()));
	}
}
