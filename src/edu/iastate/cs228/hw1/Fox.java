package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		// TODO
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox. 
		Living res;
		int[] pop = new int[5];
		
		for (int j = 1; j < 5; j++)
			pop[j] = 0;
		
		census(pop);
		age++;
		
		if (age > 6)
			res = new Empty(plain, row, column);
		else if (pop[0] > pop[2])
			res = new Badger(plain, row, column, 0);
		else if (pop[0] + pop[2] > pop[4])
			res = new Empty(plain, row, column);
		else
			res = new Fox(plain, row, column, age + 1);
		
		pNew.grid[row][column] = res;
		return res; 
	}
}
