package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		// TODO
		plain = p;
		row = r;
		column = c;
		age = a;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger.
		Living res;
		int[] pop = new int[5];
		
		for (int j = 0; j < 5; j++)
			pop[j] = 0;
		
		census(pop);
		
		if (age >= 4)
			res = new Empty(plain, row, column);
		else if (pop[0] == 1 && pop[2] > 1)
			res = new Fox(plain, row, column, 0);
		else if (pop[0] + pop[2] > pop[4])
			res = new Empty(plain, row, column);
		else
			res = new Badger(plain, row, column, age + 1);
		
		pNew.grid[row][column] = res;
		return res; 
	}
}
