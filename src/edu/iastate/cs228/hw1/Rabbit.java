package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		// TODO
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		// TODO  
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 
		Living res;
		int[] pop = new int[5];
		
		for (int j = 1; j < 5; j++)
			pop[j] = 0;
		
		census(pop);
		age++;
		
		if (age > 3)
			res = new Empty(plain, row, column);
		else if (pop[3] == 0)
			res = new Empty(plain, row, column);
		else if (pop[0] + pop[2] > pop[3])
			res = new Fox(plain, row, column, 0);
		else if (pop[0] > pop[4])
			res = new Badger(plain, row, column, 0);
		else
			res = new Rabbit(plain, row, column, age + 1);
		
		pNew.grid[row][column] = res;
		return res; 
	}
}
